package com.cloud.other.threaddemo.controller;

import com.cloud.other.threaddemo.service.AsyncServiceImpl;
import com.cloud.other.threaddemo.service.TaskExecutorDemoService;
import com.cloud.other.threaddemo.service.TaskExecutorDemoService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping("/")
@RestController
public class ThreadController {

    private static List<String> list;

    static {
        list = new ArrayList<>();
        for (int i = 0; i <= 10000000; i++) {
            list.add(i + "");
        }
    }

    @Autowired
    private TaskExecutorDemoService1 taskExecutorDemoService1;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private AsyncServiceImpl asyncService;

    @RequestMapping("/thread")
    public String handlerList() throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();
        List<String> strings = /*changeAnother(list)*/taskExecutorDemoService1.handlerHaveReturn(list);
        long i = System.currentTimeMillis() - time;
        System.out.println(i);
        return i + "";
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

    @RequestMapping("/thread1")
    public String handlerList1() {
        /*Future<String> submit = taskExecutor.submit(new Runnable() {
            @Override
            public String run() {
                return "11";
            }
        });*/
        return "11";
    }
}
