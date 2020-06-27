package com.hl.up;

import java.util.Arrays;

/**
 * @author huli04
 * @date 2020-06-27 19:59
 * @for desc
 * ----------------------
 * <p>
 * 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
 * <p>
 * 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 * 示例 2：
 * <p>125 134
 * 输入：s1 = "abe", s2 = "acd"
 * 输出：false
 * 解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == n
 * s2.length == n
 * 1 <= n <= 10^5
 * 所有字符串都只包含小写英文字母。
 * ----------------------
 */
public class 检1433查一个字符串是否可以打破另一个字符串 {

    static class Solution {
        public boolean checkIfCanBreak(String s1, String s2) {
            char[] chars = s1.toCharArray();
            char[] chars1 = s2.toCharArray();

            Arrays.sort(chars);
            Arrays.sort(chars1);

            //两个标签,表示str1元素减去str2元素的结果是正是负,如果即是正又是负就false
            boolean flag1 = false;
            boolean flag2 = false;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] - chars1[i] > 0) {
                    flag1 = true;
                } else if (chars[i] - chars1[i] < 0) {
                    flag2 = true;
                }
                if (flag1 && flag2) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        //题目整理:
        // s1和s2主和客的角色不固定;

        //思路:
        //1. 排序
        //2. 取巧:哪些情况是可以更快给出结果的;
        //3. 排序;字符串转数字


        //第一次运行失败:
       /* "yopumzgd"==dgmopuyz
        "pamntyya"* ==aamnptyy
        */
        Solution solution = new Solution();
        System.out.println(solution.checkIfCanBreak("abc", "xya"));

        //第二次成功
        /*执行用时：
        9 ms
                , 在所有 Java 提交中击败了
        76.93%
                的用户
        内存消耗：
        40.7 MB
                , 在所有 Java 提交中击败了
        100.00%
                的用户*/
    }


}
