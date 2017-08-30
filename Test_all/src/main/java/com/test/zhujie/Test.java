package com.test.zhujie;

/**
 * Created by ThinkPad on 2016/12/30.
 */
public class Test {
    @FruitColor(fruitColor= FruitColor.Color.RED)
    private String appleColor;

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public static void main(String[] args) {

        System.out.println( new Test().getAppleColor());
    }

}
