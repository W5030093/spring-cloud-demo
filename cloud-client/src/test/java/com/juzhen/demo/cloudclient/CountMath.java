package com.juzhen.demo.cloudclient;

import java.util.concurrent.ConcurrentHashMap;

public class CountMath {

    public static ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static int initial = 1;

    public void add(String id){
        if(concurrentHashMap.contains(id)){
            concurrentHashMap.put(id,concurrentHashMap.get(id)+1);
        }else{
            concurrentHashMap.put(id,initial);
        }
    }
}
