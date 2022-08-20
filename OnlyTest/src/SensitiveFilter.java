
import com.sun.xml.internal.ws.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SensitiveFilter {
    public static void main(String[] args) {

    }


    //替换符
    private static final String REPLANCEMENT = "***";

    //根节点
    private TrieNode rootNode = new TrieNode();

    //初始化方法，当容器实例化这个bean，调用构造器的时候执行这个函数。因此在服务启动的时候，就会调用
    @PostConstruct
    public void init() {
        try (
                //找到当前的类加载器，从加载器路径读取目录下的敏感词文件
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        ) {
            String keyword;
            while ((keyword = reader.readLine()) != null) {
                // 添加到前缀树
                this.addKeyWord(keyword);
            }
        } catch (IOException e) {
            //logger.error("加载敏感词文件失败: " + e.getMessage());
        }
    }

/*    //将敏感词添加到前缀树中去
    private void addKeyWord(String keyWord) {
        TrieNode tempNode = rootNode;
        for(int i = 0; i < keyWord.length(); i++) {
            char c = keyWord.charAt(i);
            TrieNode subNode = tempNode.getSubNode(c);

            if(subNode == null) {
                //初始化节点
                subNode = new TrieNode();
                tempNode.addSubNode(c,subNode);

            }
            //指向子节点
            tempNode = subNode;
            //设置结束标识
            if(i == keyWord.length()-1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }*/

    /**
     *过滤敏感词
     * @param text 待过滤的文本
     * @return 过滤后的文本
     */
    public String filter(String text) {
        if(StringUtils.isBlank(text)) {
            return null;
        }
        //指针1,表示当前敏感词走到哪一步了
        TrieNode tempNode = rootNode;
        //指针2,表示正在遍历的词语开头
        int begin = 0;
        //指针3，表示正在遍历的词语末尾
        int position = 0;
        //结果
        StringBuilder sb  = new StringBuilder();

        while(position < text.length()) {
            char c = text.charAt(position);
            //是跳过符号则
            if(isSymbol(c)) {
                //若指针1 处于根节点，说明还没有疑似的敏感词，该字符正常，begin遍历下一个字符
                if(tempNode == rootNode) {
                    sb.append(c);
                    begin++;
                }
                //无论符号在开头还是中间，指针3 都向下走一步。但是如果当前已经处于意思敏感词了，则跳过奇怪字符
                //但是第三个遍历指针往下看看
                position++;
                continue;
            }
            //如果该字符不是奇怪字符。看看这个字符是不是顺下来的敏感词。
            // 也就是查看当前节点的下一个节点有没有这个字符
            tempNode = tempNode.getSubNode(c);
            if(tempNode == null) {
                //以begin为开头的字符串不是敏感词
                sb.append(text.charAt(begin));
                position = ++begin;
                //重新指向根节点
                tempNode = rootNode;
            } else if (tempNode.isKeyWordEnd()) {
                sb.append(REPLANCEMENT);
                //进入下一个位置
                begin = ++position;
                //重新指向根节点
                tempNode = rootNode;
            } else {
                //继续检查下一个字符，tempNode已经改为当前的节点的了
                position++;
            }
        }
        //将剩下的都加入
        sb.append(text.substring(begin));
        return sb.toString();

    }

    //判断是否为符号
/*    private boolean isSymbol(Character c) {
        // 0x2E80~0x9FFF 是东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (c < 0x2E80 || c > 0x9FFF);
    }*/













    //前缀树
    private class TrieNode {
        //关键词结束标识
        private boolean isKeyWordEnd = false;
        //当前节点的子节点(key是下级字符，value是下级的节点)
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        //添加子节点
        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        //获取子节点
        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }
    }


}
