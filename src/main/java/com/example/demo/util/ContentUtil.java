package com.example.demo.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ContentUtil {
    private static final Logger logger = LoggerFactory.getLogger(ContentUtil.class);

    //替换符号
    private static final String REPLACEMENT = "***";
    //前缀树结构
    private class TrieNode {

        //标记是否是敏感词
        private boolean isKeywordEnd = false;

        //key是下级字符，value是下级节点
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public boolean isKeywordEnd() {
            return isKeywordEnd;
        }

        public void setKeywordEnd(boolean keywordEnd) {
            isKeywordEnd = keywordEnd;
        }

        //添加子节点
        public void addSubNode(Character c, TrieNode node){
            subNodes.put(c, node);
        }
        //获取子节点
        public TrieNode getSubnode(Character c){
            return subNodes.get(c);
        }
    }

    private TrieNode rootNode = new TrieNode();

    /**
     * 依赖注入比如a注入b必须是a和b都初始化（执行构造方法）完成后
     * 执行顺序： constructor --> AutoWired --> PostConstruct
     * 如果想在生成对象时完成某些初始化操作，而这些初始化操作又依赖于依赖注入，那么就无法在构造函数中实现，就可使用此注解来完成初始化
     */
    @PostConstruct
    public void init(){
        try(
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                ){
            String keyword;
            //赋值语句的返回值是赋的值
            while ((keyword = reader.readLine()) != null){
                this.addKeyWord(keyword);
            }

        }catch (IOException e){
            logger.error("cant load the sensitive words" + e.getMessage());
        }
    }

    /**
     * 给前缀树添加一个keyword
     * @param keyword
     */
    private void addKeyWord(String keyword) {
        TrieNode tempNode = rootNode;
        for (int i = 0; i < keyword.length(); i++){
            char c = keyword.charAt(i);
            TrieNode subNode = tempNode.getSubnode(c);//判断当前字符是否已经被添加
            if(subNode == null){
                subNode = new TrieNode();
                tempNode.addSubNode(c, subNode);
            }
            tempNode = subNode;

            //为添加的最后一个节点添加标记
            if (i == keyword.length() -1){
                tempNode.setKeywordEnd(true);
            }
        }
    }

    /**
     * 过滤文本，替换敏感词
     */
    public String filter(String text){
        if (StringUtils.isBlank(text)){
            return null;
        }
        TrieNode tempNode = rootNode;
        StringBuffer sb = new StringBuffer();
        int begin = 0;
        //记录读取文本位置的指针
        int position = 0;

        while (position < text.length()){
            char c = text.charAt(position);

            //该字符是否为特殊符号，去除敏感词特殊符号混淆干扰
            if (isSymbol(c)){
                if (tempNode == rootNode){
                    sb.append(c);
                    begin++;//还未进入句柄，直接跳过特殊符号
                }
                //不管特殊符号是否在句柄中都要更新position
                position++;
                continue;
            }

            if (!tempNode.subNodes.containsKey(c)){
                //以begin开头的字符串不是敏感词，begin后移并初始化position
                position = ++begin;
                sb.append(c);
                tempNode = rootNode;
            }else{
                tempNode = tempNode.getSubnode(c);
                if (tempNode.isKeywordEnd){
                    //发现敏感词，替换begin到position之间的字符
                    sb.append(REPLACEMENT);
                    begin = ++position;
                    tempNode = rootNode;
                }else{
                    position++;//检查下一个字符
                }

            }
        }//循环结束，position先到达尾部并跳出循环
        sb.append(text.substring(begin));

        return sb.toString();
    }


    // 判断是否为符号
    private boolean isSymbol(Character c) {
        // 0x2E80~0x9FFF 是东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (c < 0x2E80 || c > 0x9FFF);
    }
}
