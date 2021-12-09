package com.jackwei.leetcode.t10dt20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *
 */
public class L0013 {
    private static Map<String, Integer> romanMap = new HashMap<>(16);
    public static void main(String[] args) {
        String[] items = {"MCDLXXVI","IX", "III", "XXVII", "IV",  "LVIII", "MCMXCIV"};
        for (String s : items){
            System.out.println(s +"==="+romanToInt(s));
        }
    }

    /**
     * 本方法采用树和栈进行判断，用时：14ms
     */
    public static int romanToInt(String s) {
        Stack<String> stack = new Stack<>();
        //转换成map，查找更快。看到别人的用case更好
        if (romanMap.size() <=0){
            romanMap.put("I", 1);
            romanMap.put("V", 5);
            romanMap.put("X", 10);
            romanMap.put("L", 50);
            romanMap.put("C", 100);
            romanMap.put("D", 500);
            romanMap.put("M", 1000);
            romanMap.put("IV", 4);
            romanMap.put("IX", 9);
            romanMap.put("XL", 40);
            romanMap.put("XC", 90);
            romanMap.put("CD", 400);
            romanMap.put("CM", 900);
        }

        //转换成栈
        for (int i = s.length(); i>0; i--){
            stack.push(s.substring(i-1, i));
        }
        int romanValue = 0;
        while (!stack.isEmpty()){
            Integer value =null;
            //第一个先出栈
            String first = stack.pop();
            if (stack.isEmpty()){
                value = romanMap.get(first);
                if (null != value){
                    romanValue += value;
                }
                return romanValue;
            }
            //有可能第二个会和后面的组成特殊值，伪出栈
            String tow = stack.peek();
            value = romanMap.get(first + tow);
            if (null != value){
                romanValue += value;
                stack.pop();
            }else {
                value = romanMap.get(first);
                if (null != value){
                    romanValue += value;
                }
            }
        }

        return romanValue;
    }

    /**
     * 解题思路：
     * 1. 依次迭代s,如果前后两个字符不一致，且非subtraction，进行次数累乘。如为subtraction取特别值。
     *这个是别人的用时：3ms
     */
    public int romanToInt2(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0, length = chars.length; i < length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    ret += 1000;
                    break;
                case 'D':
                    ret += 500;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'M') {
                            ret += 900;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'D') {
                            ret += 400;
                            i++;
                            break;
                        }
                    }
                    ret += 100;
                    break;
                case 'L':
                    ret += 50;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'C') {
                            ret += 90;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'L') {
                            ret += 40;
                            i++;
                            break;
                        }
                    }
                    ret += 10;
                    break;
                case 'V':
                    ret += 5;
                    break;
                default:
                    // I
                    if (i < length - 1) {
                        if (chars[i + 1] == 'X') {
                            ret += 9;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'V') {
                            ret += 4;
                            i++;
                            break;
                        }
                    }
                    ret += 1;
                    break;
            }
        }
        return ret;
    }
}
