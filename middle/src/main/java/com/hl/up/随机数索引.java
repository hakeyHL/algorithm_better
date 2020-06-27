package com.hl.up;

import java.util.*;

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
public class 随机数索引 {

    static class Solution {
        Map<Integer, List<Integer>> resultMap;
        Random random = new Random();

        public Solution(int[] nums) {
            resultMap = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                List<Integer> indexes = resultMap.get(num);
                if (indexes == null) {
                    indexes = new ArrayList<Integer>();
                }
                indexes.add(i);
                resultMap.put(num, indexes);
            }
        }

        public int pick(int target) {
            return resultMap.get(target).get(random.nextInt(resultMap.get(target).size()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution.pick(3));

        /*执行用时：
        97 ms
                , 在所有 Java 提交中击败了
        23.50%
                的用户
        内存消耗：
        49.8 MB
                , 在所有 Java 提交中击败了
        100.00%
                的用户*/


    }
}
