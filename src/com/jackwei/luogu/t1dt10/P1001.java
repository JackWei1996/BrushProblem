package com.jackwei.luogu.t1dt10;

import java.util.Scanner;

/**
 * 作者：Jack魏
 *
 * 题目描述
 * 输入两个整数a,b，输出它们的和(|a|,|b|<=10^9)。
 *
 * 输入格式
 * 两个整数以空格分开
 *
 * 输出格式
 * 一个数
 *
 * 输入输出样例
 * 输入            输出
 * 20 30           50
 */
public class P1001 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        long a = cin.nextLong();
        long b = cin.nextLong();
        System.out.println(a + b);
    }
}
