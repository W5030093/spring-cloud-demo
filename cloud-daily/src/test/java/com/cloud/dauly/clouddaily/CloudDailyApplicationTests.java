package com.cloud.dauly.clouddaily;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudDailyApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        for(int i=1;i<=20;i++){
            redisTemplate.opsForValue().set("123"+i,"小明");
        }

}

    public static void main(String[] args) {

        //生成map
        Map<String,List<String>> maps = Maps.newHashMap();
        List<String> strings = maps.get("11");

        //生成多个值的map
        ImmutableMap<String, String> of = ImmutableMap.of("key", "value");

        //比较两个值的大小
        Ints.compare(0,1);

        //获取相同的前缀和后缀
        String ourCommonPrefix = Strings.commonPrefix("11","22");
        String ourSuffix = Strings.commonSuffix("121","22");

        //自动补全
        String padEndResult = Strings.padEnd("123", 4, '0');
        String padStartResult = Strings.padStart("1", 2, '0');



    }
}
