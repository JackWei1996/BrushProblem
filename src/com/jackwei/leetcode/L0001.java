package com.jackwei.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int nums[] = new int[]{3,3,4};
        int target = 6;
        System.out.println(Arrays.toString(new L0001().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            //当两个数相同，并且和为target时返回下标
            if (map.containsKey(nums[i]) && target-nums[i] == nums[i]){
                return new int[]{map.get(nums[i]), i};
            }
            //不满足条件，继续添加到map中，去重
            map.put(nums[i], i);
            //判断是否有map里面正好是target的差，并且当前下标没出现在map里面
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i]) ){
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
}
