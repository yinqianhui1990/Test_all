package com.test.proxy.dynamic2;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/13.
 */
public class FlightManagerImpl implements FlightManager{
    /**
     * @Author: yinqianhui
     * @Description:购票
     * @param:
       * @param monney
     *  @param des
     * @Date Created by 13:48 on 2017/11/13.
     */
    public int buyFlight(double monney,String des) {
        System.out.println("购买一张去"+des+"的机票,票价为："+monney);
        //如果在这个方法里面直接调用sendMessage(),则sendMesage不会被代理，因为执行这个方法时this(FlightManagerImpl)
       // sendMessage();
        //所以在有代理是尽量不在同一个类调用本身的一些方法
        return 0;
    }

    public void sendMessage() {
        System.out.println("发送消息成功！");
    }
}
