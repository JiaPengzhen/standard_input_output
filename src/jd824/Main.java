package jd824;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            //将读进来的一行转成字符串数组
            // \\s 匹配所有空白字符串
            String[] l1 = in.nextLine().split("\\s");
            //字符串数组转成int数组
            int[] ints_l1 = new int[l1.length];
            for(int i=0;i<l1.length;i++){
                ints_l1[i] = Integer.parseInt(l1[i]);
            }
            //处理过程
            int N = ints_l1[0];
            int M = ints_l1[1];

            // 统计一下出现了多少次
            int[] count = new int [2*N+1];

            //每行2个数,m行,关系
            int [][] matrix = new int[M][2];

            for (int i = 0; i< M; i++) {
                String[] l2 = in.nextLine().split("\\s");
                //字符串数组转成int数组
                for(int j =0;j<2;j++){
                    matrix[i][j] = Integer.parseInt(l2[j]);
                }
            }
            // 矩阵准备就绪，开始处理
            // 统计
            for (int i = 0; i< M; i++) {
                for (int j =0;j<2;j++) {
                   count[matrix[i][j]] ++;
                }
            }
            // 结果
            int res1 = 0;
            ArrayList<Integer> res2 = new ArrayList<>();

            int max = -1;
            while (true) {
                // 找最大值对应的下标

                int index = 0;
                for (int i = 1; i< 2*N+1; i++) {
                    if (max < count[i]) {
                        max = count[i];
                    }
                }


                for (int i = 1; i< 2*N+1; i++) {
                    if (max == count[i]) {
                        index = i;
                    }
                }
                if (index == 0) {
                    break;
                }
                // 最大值的下标就是我们要搞定的
                int another = 0;
                for (int i = 0; i< M; i++) {
                    if(matrix[i][0] == index ) {
                        another = matrix[i][1];
                        count[index]--;
                        count[another]--;
                        res1++;
                        res2.add(index);

                    } else if (matrix[i][1] == index) {
                        another = matrix[i][0];
                        count[index]--;
                        count[another]--;
                        res1++;
                        res2.add(index);
                    }
                }

            }

            System.out.println(res1);
            System.out.println(res2.toString());


        }




    }
}