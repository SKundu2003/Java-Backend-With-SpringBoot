package com.jpabeans.jpabeans_class;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorld {
    private String msg;
    private String data;

    public HelloWorld(String msg, String data) {
        this.msg = msg;
        this.data = data;
    }

    public HelloWorld() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
//    @Override
//    public String toString(){
//        return "msg = "+getMsg()+" data= "+getData();
//    }
}