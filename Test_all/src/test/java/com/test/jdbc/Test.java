package com.test.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2018/4/20.
 */
public class Test {
    public static void main(String[] args) {
        try {
            String shpath="/home/felven/word2vec/demo-classes.sh";
            Process ps = Runtime.getRuntime().exec(shpath);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
