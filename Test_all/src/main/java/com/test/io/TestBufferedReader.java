package com.test.io;

import java.io.*;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/10/12.
 */
public class TestBufferedReader {
    public static void main(String[] args) {
        String filePath="F:\\image\\test.txt";
        File file;
        BufferedReader bufferedReader=null;
        String read;
        try {
            file = new File(filePath);
             bufferedReader= new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            while((read=bufferedReader.readLine())!=null){
                System.out.println(read);
            }
        }catch (FileNotFoundException e2){
            e2.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
