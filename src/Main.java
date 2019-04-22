import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            //将读进来的一行转成字符串数组
            String[] l1 = in.nextLine().split("\\s"); // \\s 匹配所有空白字符串
            //字符串数组转成int数组
            int[] ints_l1 = new int[l1.length];
            for(int i=0;i<l1.length;i++){
                ints_l1[i] = Integer.parseInt(l1[i]);
            }
            //处理过程
            System.out.println(ints_l1[0]);


        }




    }
}