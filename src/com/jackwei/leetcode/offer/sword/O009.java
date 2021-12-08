package com.jackwei.leetcode.offer.sword;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jack
 * @date 2021-12-08
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class O009 {
}

class CQueue {

    Stack<Integer> tail = new Stack();
    Stack<Integer> head = new Stack();

    public CQueue() {
    }

    public void appendTail(int value) {
        tail.push(value);
        setHead();
    }

    private void setHead() {
        head.clear();
        int size = tail.size();
        for (int i = size - 1; i >= 0; i--) {
            head.push(tail.elementAt(i));
        }
    }

    public int deleteHead() {
        if (head.isEmpty()) {
            return -1;
        }
        int headSize = head.size();
        tail.remove(0);
        return head.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        inputStr = inputStr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
        String[] commends = inputStr.split(",");

        String valueStr = scanner.next();
        valueStr = valueStr.substring(1, valueStr.length() - 1);
        String[] values = valueStr.split(",");

        CQueue myQueue = null;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < commends.length; i++) {
            String commend = commends[i];
            String value = values[i];
            switch (commend) {
                case "CQueue":
                    myQueue = new CQueue();
                    stringBuilder.append("null,");
                    break;
                case "appendTail":
                    String num = value.substring(1, value.length() - 1);
                    myQueue.appendTail(Integer.parseInt(num));
                    stringBuilder.append("null,");
                    break;
                case "deleteHead":
                    int head = myQueue.deleteHead();
                    stringBuilder.append(head+",");
                    break;
                default:
            }
        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(substring+"]");
    }
}
