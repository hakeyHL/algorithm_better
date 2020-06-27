package com.hl.up;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huli04
 * @date 2020-06-26 00:33
 * @for desc
 * ----------------------
 * <p>
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * <p>
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * <p>
 * <p>
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * <p>
 * <p>
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * <p>
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 * <p>
 * <p>¡
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduce-array-size-to-the-half
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * ----------------------
 */
public class 数组大小减半_2 {
    static class Solution {
        public int minSetSize(int[] arr) {
            int halfOfLength = arr.length / 2;
            Map<Integer, Integer> resultMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                resultMap.compute(arr[i], (k, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        return v + 1;
                    }
                });
            }

            List<Map.Entry<Integer, Integer>> resultEntryList = new ArrayList<>(resultMap.entrySet());

            resultEntryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            int sum = 0;
            for (int i = 0; i < resultEntryList.size(); i++) {
                sum += resultEntryList.get(i).getValue();
                if (sum >= halfOfLength) {
                    return i + 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        //解法2,空间换时间
        //
        Solution solution = new Solution();
        solution.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});

    }

}
