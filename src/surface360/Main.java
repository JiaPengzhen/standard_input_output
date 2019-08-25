package surface360;

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
            int [][] matrix = new int[N][M];
            for (int i = 0; i< N; i++) {
                String[] l2 = in.nextLine().split("\\s");
                //字符串数组转成int数组
                for(int j =0;j<M;j++){
                    matrix[i][j] = Integer.parseInt(l2[j]);
                }
            }
            // 矩阵准备就绪，开始处理
            // 先算顶面
            int s_ding = 2*N*M;
            // 再算侧面
            int s_ce =0;
            // 辅助矩阵
            int [][] matrix_max = new int[N+2][M+2];
            for (int i = 0; i< N; i++) {
                for(int j =0;j<M;j++){
                    matrix_max[i+1][j+1] = matrix[i][j];
                }
            }
            // 计算面积
            for (int i = 1; i< N+1; i++) {
                for(int j =1;j<M+1;j++){
                    s_ce += Math.max(matrix_max[i][j]- matrix_max[i-1][j],0)
                            +Math.max(matrix_max[i][j]- matrix_max[i+1][j],0)
                            +Math.max(matrix_max[i][j]- matrix_max[i][j-1],0)
                            + Math.max(matrix_max[i][j]- matrix_max[i][j+1],0);
                }
            }
            int res = 0;
            res = s_ding + s_ce;

            System.out.println(res);


        }




    }
}