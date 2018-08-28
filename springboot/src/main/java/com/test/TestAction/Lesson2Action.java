package com.test.TestAction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yinqianhui
 * @Date Created by ThinkPad on 2017/11/9.
 */
@RestController
public class Lesson2Action {
    @RequestMapping("/lesson2")
    String lesson2(){
        return "wellcome to here!";
    }
}
