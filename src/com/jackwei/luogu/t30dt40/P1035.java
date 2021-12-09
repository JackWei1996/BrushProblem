package com.jackwei.luogu.t30dt40;

import java.util.Scanner;

/**
 * 题目描述
 * 已知：S_n= 1+1/2+1/3+…+1/nS
 * n
 * ​	 =1+1/2+1/3+…+1/n。显然对于任意一个整数KK，当nn足够大的时候，S_nS
 * n
 * ​	 大于KK。
 *
 * 现给出一个整数KK（1 \le k \le 151≤k≤15），要求计算出一个最小的nn；使得S_n>KS
 * n
 * ​	 >K。
 *
 * 输入格式
 * 一个正整数KK
 *
 * 输出格式
 * 一个正整数NN
 *
 * 输入输出样例
 * 输入
 * 1
 * 输出
 * 2
 */
public class P1035 {
    public static void main(String[] args) {
        //查表法，已知就这些数，先算出来对应查表即可。
         int i = 1;
         int j = 2;

         double k = 1;

         while (i<16){
              for (; j<100000000; j++){
                 k += 1.0/j;
                 if (i < k){
                      System.out.println(i+"========"+j +"========"+k);
                      i++;
                      j++;
                      break;
                  }
              }
          }

        /*int[] table = {2, 4, 11, 31, 83, 227, 616, 1674, 4550, 12367, 33617, 91380, 248397, 675214, 1835421};

        int i = new Scanner(System.in).nextInt();
        System.out.println(table[i-1]);*/
    }


}
