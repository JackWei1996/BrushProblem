package com.jackwei.leetcode;
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0009 {
    public static void main(String[] args) {
        int[] nums = {12, 12291, 123321, 1233321, -123321, 10011, 12321, 1001};

        for (int num : nums){
            System.out.println(num +"====="+isPalindrome(num));
        }
    }

    private static boolean isPalindrome(int x) {
        //LinkedList<Integer> queue = new LinkedList<>();
        //如果是负数直接返回false
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == y;
        /* 以下速度为16ms
        if (x < 0){
            return false;
        }
        //加入双向链表
        while (x != 0){
            queue.offer(x%10);
            x /= 10;
        }

        while (!queue.isEmpty()){
            //首位判断
            if (!queue.getFirst().equals(queue.getLast())){
                return false;
            }
            queue.removeFirst();
            if (!queue.isEmpty()){
                queue.removeLast();
            }
        }
        return true;*/
    }
}
