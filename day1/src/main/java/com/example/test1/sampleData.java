package com.example.test1;

import java.util.HashMap;

public class sampleData {
    private HashMap<String,String> data = new HashMap<String,String>();
    sampleData(){
        data.put("hello","hello world");
        data.put("test","this is a test");
    }
    public String getValue(String quary){
        return data.get(quary);
    }
}
