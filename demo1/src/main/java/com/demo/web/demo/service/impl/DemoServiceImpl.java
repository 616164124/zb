package com.demo.web.demo.service.impl;

import com.demo.web.demo.dao.DemoDao;
import com.demo.web.demo.dao.DemoMapper;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.handler.Handler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

    @Resource
    private DemoMapper demoMapper;

//    @Resource
//    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public ServiceResult getDemo(String id) {
        Map<String, String> demoById = demoDao.getDemoById("1");
        ServiceResult serviceResult = new ServiceResult(demoById);
        return serviceResult;
    }

    @Override
    public ServiceResult findDemoByName(String username) {
//        threadPoolExecutor.execute(()->{
//            System.out.println("1233");
//        });

        return null;
    }

    @Override
    public ServiceResult findByid(String id) {

        return null;
    }

    /**
     * ip，time存储和select
     * @param paramsMap1
     * @return
     */
    @Override
    public ServiceResult insertIP(Map<String, String> paramsMap1)
    {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("pokid", new Random().nextInt(1000));
        paramsMap.put("ip", "192.168.1.10");
        paramsMap.put("datetime", LocalDateTime.now().toString());
        paramsMap.put("date", LocalDateTime.now().toString());
        paramsMap.put("date_time", LocalDateTime.now().toString());
        demoDao.insetDemo(paramsMap);
        List<Map<String, Object>> objectMap = demoDao.selectIP();
        objectMap.stream().forEach((a)->{

            System.out.println(a.toString());
        });
        return null;
    }
}
