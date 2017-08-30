package com.test.stock;

import java.util.Random;

/**
 * Created by ThinkPad on 2017/1/5.
 */
public class Tes2 {
   /* 作者：郑强
    链接：https://www.zhihu.com/question/19821790/answer/25810523
    来源：知乎
    著作权归作者所有，转载请联系作者获得授权。
*/
    public final static int COUPLES = 10000000; // 夫妇数量

    public static void main(String[] args) {
        int boys = 0, girls = 0; // 男孩总数、女孩总数
        for (int i = 0; i < COUPLES; i++) {
            Couple couple = new Couple();
            // 若生男孩则不再生育。若生女孩则继续生育，直到生出男孩为止
            while (true) {
                Child child = couple.birth();
                if (child == Child.BOY) {
                    boys++; // 累计男孩总数
                    break;
                } else if (child == Child.GIRL) {
                    girls++; // 累计女孩总数
                }
            }
        }
        // 输出男孩、女孩总数
        System.out.println("boys = " + boys + ", girls = " + girls);
    }
}
/** 夫妇 */
 class Couple {

    private Random random = new Random();

    /** 生孩子 */
    public Child birth() {
        int i = random.nextInt(2);
        if (i == 0) {
            return Child.BOY;
        } else {
            return Child.GIRL;
        }
    }

}

/** 孩子 */
 enum Child {
    BOY, GIRL
}

/*
作者：郑强
        链接：https://www.zhihu.com/question/19821790/answer/25810523
        来源：知乎
        著作权归作者所有，转载请联系作者获得授权。*/
