package com.cloud.other.threaddemo.service;

import com.cloud.other.threaddemo.config.ListThreadHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class TaskExecutorDemoService1 {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private AsyncServiceImpl asyncService;

    public List<String> handlerHaveReturn(List<String> lists) throws ExecutionException, InterruptedException {
        Future<List<String>> submit = asyncService.executeAsync(lists);
        submit.get()
        return new ArrayList<>();
    }
    public List<String> changeAnother(List<String> list){
        List<String> returnList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            for(String s:list){
                if(s.contains("3")){
                    if(s.contains("6")){
                        if(s.contains("7")){
                            returnList.add(s);
                        }

                    }

                }
            }
        }
        return returnList;
    }

}
