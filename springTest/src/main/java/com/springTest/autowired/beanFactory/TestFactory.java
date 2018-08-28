package com.springTest.autowired.beanFactory;

import com.springTest.autowired.TestA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by ThinkPad on 2017/6/19.
 */
@Component
public class TestFactory implements BeanFactoryAware {
    private BeanFactory factory;
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory=beanFactory;
    }

    public TestA getTestA(){
       return  (TestA)factory.getBean("testA");
    }
}
