package com.cloud.other.threaddemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsyncServiceImpl {

    @Async
    public ListenableFuture<List<String>> executeAsync(List<String> lists) {
        System.out.println("start executeAsync");

        List<String> strings = changeAnother(lists);
        System.out.println("end executeAsync");
        return new AsyncResult<>(strings);
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
