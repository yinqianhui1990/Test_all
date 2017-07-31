package com.test.all;

import java.text.DecimalFormat;

/**
 * Created by ThinkPad on 2017/3/7.
 */
public class TestS {
    public static void main(String[] args) {
        String res="lachesis002[0060]cl_event_ladrip_cur_weight@c6:be:84:00:";
        DecimalFormat df = new DecimalFormat("0.0");
        int btAddressIndex = res.indexOf(',');
        int wtIndex = res.lastIndexOf(",");
       // res.setDateTime(DateUtil.hmsToTimemillis(res.getData().substring(wtIndex + 1)));
        double weight_temp = Integer.parseInt(res.substring(btAddressIndex+1,wtIndex));
        double weight_total = Double.parseDouble(df.format(weight_temp/10));
    }
}
