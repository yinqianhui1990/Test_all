package com.test.singleton.lesson2;

/**
 * Created by ThinkPad on 2017/3/21.
 *���̣߳�����ÿ�ζ��������Ӱ��Ч�ʣ�����̫��
 */
public class Single2 {
    private Single2() {
        System.out.println("once time��");
    }
    private static Single2 single;
    public static Single2 getInstance(){
        synchronized (Single2.class) {
            if (single == null) {
                single = new Single2();
            }
        }
        return single;
    }
}
