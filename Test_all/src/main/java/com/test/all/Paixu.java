package com.test.all;

/**
 * Created by ThinkPad on 2016/6/27.
 */
public class Paixu {

    public static void main( String[] args ){
        int array[]={2,3,1,5,4};
        int temp;

        //选择排序
      /*  for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){

                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }

            }
            for(int x:array) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
*/

       for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){

                if(array[j]<array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }

            }
            for(int x:array) {
                System.out.print(x + ",");
            }
            System.out.println("===");
        }
        System.out.print("最终结果：====");
        for(int x:array) {
            System.out.print(x + ",");
        }


        int score[] = {67, 69, 75, 87, 89, 90, 99, 100};
        for (int i = 0; i < score.length -1; i++){    //最多做n-1趟排序
            for(int j = 0 ;j < score.length - i - 1; j++){    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if(score[j] < score[j + 1]){    //把小的值交换到后面
                    int temp2 = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp2;
                }
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for(int a = 0; a < score.length; a++){
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
        System.out.print("最终排序结果：");
        for(int a = 0; a < score.length; a++){
            System.out.print(score[a] + "\t");
        }
    }

}
