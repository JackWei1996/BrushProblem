package com.jackwei.leetcode;

import java.util.Arrays;

/**
 * 作者：Jack魏
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L0001 {
    public static void main(String[] args) {
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new L0001().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int max = 2047;
        int[] res = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            int ldiff = (target - nums[i]) & max;
            if (res[ldiff] != 0) {
                return new int[]{res[ldiff] - 1, i};
            }
            res[nums[i] & max] = i + 1;
        }
        return new int[2];
    }
}
