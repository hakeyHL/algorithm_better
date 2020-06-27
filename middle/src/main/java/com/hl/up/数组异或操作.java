package com.hl.up;

/**
 * @author huli04
 * @date 2020-06-25 14:06
 * @for desc
 * ----------------------
 * <p>
 * ----------------------
 */
public class 数组异或操作 {


    /*

    给你两个整数，n 和 start 。

    数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。

    请返回 nums 中所有元素按位异或（XOR）后得到的结果。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    static class Solution {
        public int xorOperation(int n, int start) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = result ^ (start + (2 * i));
            }
            return result;
        }
    }

    public static void main(String[] args) {

        //n=5,start=1;

        //0=1+2*0
        //1=1+2*1
        //2=1+2*2
        //3=1+2*3
        //4=1+2*4

        //==0000 1101
        //==1101 1010
        //==1101 0111

        //笨
        Solution solution = new Solution();
        int i = solution.xorOperation(5, 0);
        System.out.println(i);

        //0=1+0
        //1=1+2
        //0001
        //0011



        /*执行结果：https://leetcode-cn.com/problems/xor-operation-in-an-array/submissions/
        通过
                显示详情
        执行用时：
        0 ms
                , 在所有 Java 提交中击败了
        100.00%
                的用户
        内存消耗：
        36.5 MB
                , 在所有 Java 提交中击败了
        100.00%
                的用户*/
        //笨的就OK了.
    }

}
