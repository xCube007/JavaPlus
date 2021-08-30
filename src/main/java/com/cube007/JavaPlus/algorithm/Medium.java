package com.cube007.JavaPlus.algorithm;

import java.util.*;

/**
 * @ClassName: Medium
 * @Description: 中等难度
 * @Author: Liu Xiaonan
 * @Date: 2021/7/2 14:09
 */
public class Medium {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asddsdasd"));
    }

    /**
     *
     * 功能描述: 最长子串的长度
     *
     * @param s:
     * @author Liu Xiaonan
     * @return int
     * @date 2021/7/5 18:32
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int a = 1;
        int b = 0;
        Map<Character,Object> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.clear();
                i = b;
                b++;
            } else {
                map.put(s.charAt(i), i);
            }
            if (map.size() > a) {
                a = map.size();
            }
        }
//        return b == 0 ? map.size() : a;
        return a;
    }

    /**
     * 最长回文数字串
     * @param s:
     * @return java.lang.String
     * @author Cube007
     * @date 2021/7/20 16:38
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * N字变换
     * @param s:
     * @param numRows:
     * @return java.lang.String
     * @author Cube007
     * @date 2021/7/20 16:39
     */
    public String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();
        if (numRows == 1 || s.length() <= 1) {
            return s;
        }
        int len;
        int b = s.length()%(numRows+numRows-2);
        if (b > numRows) {
            len = s.length() / (numRows + numRows - 2) * (numRows - 1) + 1 +  b - numRows;
        } else if (b == 0) {
            len = s.length() / (numRows + numRows - 2) * (numRows - 1);
        } else {
            len = s.length() / (numRows + numRows - 2) * (numRows - 1) + 1;
        }
        char[][] a = new char[numRows][len];
        int x = 0;
        int y = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            a[x][y] = s.charAt(i);
            if (x == 0) {
                flag = true;
            } else if (x == numRows - 1) {
                flag = false;
            }
            if (flag) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        System.out.println(Arrays.deepToString(a));
        for (char[] chars : a) {
            for (char c : chars) {
                if (c=='\u0000') {
                    continue;
                }
                str.append(c);
            }

        }
        return str.toString();
    }

    /**
     * 8. 字符串转换整数 (atoi)
     * @param s: 
     * @return int
     * @author Cube007
     * @date 2021/7/20 16:40
     */
    public int myAtoi(String s) {

        return 0;
    }



    Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res;

    /**
     * 17. 电话号码的字母组合
     * @param digits: 
     * @return java.util.List<java.lang.String>
     * @author Cube007
     * @date 2021/7/20 17:01
     */
    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, int index, StringBuilder stringBuilder) {
        if(index == digits.length()){
            res.add(stringBuilder.toString());
            return;
        }

        char c = digits.charAt(index);
        String letters = map.get(c);
        for(int i = 0 ; i < letters.length() ; i ++){
            backtrack(digits, index+1, stringBuilder.append(letters.charAt(i)));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }


    }

}
