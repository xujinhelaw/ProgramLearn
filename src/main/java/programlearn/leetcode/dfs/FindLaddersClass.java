/**
 * https://leetcode-cn.com/problems/word-transformer-lcci
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 */
package programlearn.leetcode.dfs;

import programlearn.leetcode.common.CommonUtils;

import java.util.*;

public class FindLaddersClass {
    private final List<String> resList = new ArrayList<>();
    private final Set<String> seenSet = new HashSet<>();
    private boolean isFindResult;

    private Map<String, List<String>> constructAdjacentMap(List<String> wordList) {
        Map<String, List<String>> adjacentMap = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String modifyWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> words = adjacentMap.getOrDefault(modifyWord, new ArrayList<>());
                if (!words.contains(word)) {
                    words.add(word);
                    adjacentMap.put(modifyWord, words);
                }
            }
        });
        return adjacentMap;
    }

    private void dfs(String word, String endWord, Map<String, List<String>> adjacentMap) {
        //递归结束条件
        seenSet.add(word);
        if (endWord.equals(word)) {
            isFindResult = true;
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            String modifyWord = word.substring(0, i) + "*" + word.substring(i + 1);
            List<String> adjacentWords = adjacentMap.getOrDefault(modifyWord, new ArrayList<>());
            adjacentWords.forEach(adjacentWord -> {
                //递归结束条件
                if (!seenSet.contains(adjacentWord) && !isFindResult) {
                    //根到叶的方向
                    resList.add(adjacentWord);
                    dfs(adjacentWord, endWord, adjacentMap);
                    //回溯，去掉不正确的路径（需要回溯，使用递归更为方便）
                    if (!isFindResult) {
                        resList.remove(resList.size() - 1);
                    }
                }
            });
        }
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjacentMap = constructAdjacentMap(wordList);
        isFindResult = false;
        resList.add(beginWord);
        dfs(beginWord, endWord, adjacentMap);
        //边界情况
        // 1、wordList中既包含beginWord也包含endWord，但是，无法只变换一个字母从beginWord到endWord
        // 2、wordList中不包含beginWord
        if (!isFindResult) {
            resList.remove(resList.size() - 1);
        }
        return resList;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        FindLaddersClass findLaddersClass = new FindLaddersClass();
        List<String> resultList = findLaddersClass.findLadders(beginWord, endWord, wordList);
        CommonUtils.printArrayList(resultList);
    }
}
