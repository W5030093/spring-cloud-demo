package com.cloud.other.threaddemo.service;

import com.cloud.other.threaddemo.config.ListThreadHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class TaskExecutorDemoService {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    public List<String> handlerHaveReturn(List<String> lists) throws ExecutionException, InterruptedException {
        /**接收集合各段的 执行的返回结果**/
        List<Future<List<String>>> futureList = new ArrayList<>();

        /**集合总条数**/
        int size = lists.size();
        /**将集合切分的段数**/
        int sunSum = 10;
        int listStart, listEnd;
        /***当总条数不足10条时 用总条数 当做线程切分值**/
        if (sunSum > size) {
            sunSum = size;
        }
        /**定义子线程**/
        ListThreadHandler listThreadHandler;
        /**将list 切分10份 多线程执行**/
        for (int i = 0; i < sunSum; i++) {
            //***计算切割  开始和结束**//*
            listStart = size / sunSum * i;
            listEnd = size / sunSum * (i + 1);
            //**最后一段线程会 出现与其他线程不等的情况**//*
            if (i == sunSum - 1) {
                listEnd = size;
            }
            //**线程切断**//*
            List<String> sunList = lists.subList(listStart, listEnd);
            //**子线程初始化**//*
            listThreadHandler = new ListThreadHandler(i, sunList);
            //***多线程执行***//*
            Future<List<String>> submit = taskExecutor.submit(listThreadHandler);
            futureList.add(submit);
        }
        for (Future<List<String>> future : futureList) {
            while (true) {
                if (future.isDone() && !future.isCancelled()) {

                }
            }
        }
        return new ArrayList<>();
    }

    public List<String> changeAnother(List<String> list) {
        List<String> returnList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (String s : list) {
                if (s.contains("3")) {
                    if (s.contains("6")) {
                        if (s.contains("7")) {
                            returnList.add(s);
                        }

                    }

                }
            }
        }
        return returnList;
    }

}
