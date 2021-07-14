package com.cube007.JavaPlus.algorithm;

import com.cube007.JavaPlus.datastructure.ListNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Easy
 * @Description: 简单题
 * @Author: Liu Xiaonan
 * @Date: 2021/4/21 18:40
 */
public class Easy {
    
    
    public int test() {
        return 1;
    }

    /**
     *
     * 功能描述: 7:整数反转
     *
     * @param x:
     * @return int
     * @date 2021/4/21 18:45
     */
    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }

    /**
     *
     * 功能描述: 9. 回文数
     *
     * @param x: 
     * @author Liu Xiaonan
     * @return boolean
     * @date 2021/4/30 10:48
     */
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     *
     * 功能描述: 13. 罗马数字转整数
     *
     * @param s: 
     * @author Liu Xiaonan
     * @return int
     * @date 2021/4/30 11:32
     */
    public int romanToInt(String s) {

        int a = 0;
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int b = map.get(s.charAt(i));
            if (i == s.length() - 1 || b >= map.get(s.charAt(i+1))) {
                a += b;
            } else {
                a -= b;
            }
        }
        return a;
    }


    /**
     *
     * 功能描述: 14. 最长公共前缀
     *
     * @param strs:
     * @author Liu Xiaonan
     * @return java.lang.String
     * @date 2021/6/25 13:52
     */
    public String longestCommonPrefix(String[] strs) {

        StringBuilder str = new StringBuilder();
        int l = strs[0].length();
        for (String s : strs) {
            if (s.length() < l) {
                l = s.length();
            }
        }

        for (int i = 0; i < l; i++) {
            char c = strs[0].charAt(i);
            boolean flag = false;
            for (String s : strs) {
                flag = c == s.charAt(i);
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                str.append(c);
            } else {
                break;
            }
        }

        return str.toString();
    }

    public String longestCommonPrefix1(String[] strs) {

        if(strs.length==0) {
            return "";
        }
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                s=s.substring(0,s.length()-1);
            }
            if (!string.startsWith(s)){
                break;
            }
        }
        return s;
    }

    /**
     *
     * 功能描述: 20. 有效的括号
     *
     * @param s:
     * @author Liu Xiaonan
     * @return boolean
     * @date 2021/6/25 15:59
     */
    public boolean isValid1(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(3){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(a);
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='[') {
                stack.push(']');
            } else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty()||c!=stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {

        int a = s.length() / 2;
        for (int i = 0; i <= a ; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     *
     * 功能描述: 26. 删除有序数组中的重复项
     *
     * @param nums:
     * @author Liu Xiaonan
     * @return int
     * @date 2021/7/1 18:10
     */
    public int removeDuplicates(int[] nums) {
        int a = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[a] != nums[i]) {
                nums[a+1] = nums[i];
                a++;
            }
        }
        return a + 1;
    }

    /**
     *
     * 功能描述: 27. 移除元素
     *
     * @param nums: 
     * @param val: 
     * @author Liu Xiaonan
     * @return int
     * @date 2021/7/1 18:54
     */
    public int removeElement(int[] nums, int val) {

        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[a] = nums[i];
                a++;
            }
        }
        return a;
    }

    /**
     *
     * 功能描述: 28. 实现 strStr()
     *
     * @param haystack:
     * @param needle:
     * @author Liu Xiaonan
     * @return int
     * @date 2021/7/2 13:50
     */
    public int strStr(String haystack, String needle) {

        if (needle == null || needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (needle.equals(haystack.substring(i, i+needle.length()))) {
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


}
