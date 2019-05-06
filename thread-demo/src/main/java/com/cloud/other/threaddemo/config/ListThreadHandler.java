package com.cloud.other.threaddemo.config;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class ListThreadHandler implements Callable {

    /**当前是属于第几段线程**/
    private int pageIndex;

    private List<String> list;

    public ListThreadHandler(int pageIndex,List<String> list){
        this.pageIndex = pageIndex;
        this.list = list;
    }

    @Override
    public List<String> call() throws Exception {
        List<String> returnList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            for(String s:list){
                if(s.contains("3")){
                    returnList.add(s);
                }
            }
        }
        return returnList;
    }
}
