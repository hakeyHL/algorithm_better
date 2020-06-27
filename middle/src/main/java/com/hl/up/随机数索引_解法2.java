package com.hl.up;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huli04
 * @date 2020-06-25 18:38
 * @for desc
 * ----------------------
 * <p>
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ----------------------
 */
public class 随机数索引_解法2 {

    /**
     * 力求时间更短
     */
    static class Solution {
        List<Integer> indexes = new ArrayList<Integer>();
        Random random = new Random();
        int[] myNums;

        public Solution(int[] nums) {
            myNums = nums;
        }

        public int pick(int target) {
            for (int i = 0; i < myNums.length; i++) {
                int myNum = myNums[i];
                if (myNum == target) {
                    indexes.add(i);
                }
            }
            if (indexes.size() == 1) {
                return indexes.get(0);
            }
            return indexes.get(random.nextInt(indexes.size()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3,});
        System.out.println(solution.pick(3));

    }
}
