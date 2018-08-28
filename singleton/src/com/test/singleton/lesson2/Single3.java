package com.test.singleton.lesson2;

/**
 * Created by ThinkPad on 2017/3/21.
 *���̣߳�ֻ�е�һ�δ���ʱ������˫���жϣ�������߳�ʱ��ͨ����һ���ж�
 */
public class Single3 {
    private Single3() {
        System.out.println("once time��");
    }
    private static Single3 single;
    public static Single3 getInstance(){
            if (single == null) {
                synchronized (Single3.class) {
                    if(single==null) {
                        single = new Single3();
                    }
                }
            }
        return single;
    }
}
