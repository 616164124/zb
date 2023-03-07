package com.demo.web.demo.controller;

import com.bean.User;
import com.demo.web.demo.dao.DemoDao;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @Resource
    private DemoService demoService;

    @RequestMapping(value = "insertDdmin", method = RequestMethod.GET)
    public ServiceResult insertDemo() {
        HashMap<String, String> hashMap = new HashMap<>();
        demoService.insertIP(hashMap);
        return null;
    }

    //http://localhost:8081/demo/test?txtNum=1234jkfs&name=lkfs
    //可以不用指定method的get还是post方法，但是参数的名字必须跟url中参数一致
    @RequestMapping(value = "/test")
    public String getWf(String txtNum, String name) {

        logger.info("name====>" + txtNum);
        logger.info("name====>" + name);
        return txtNum + "=======" + name;

    }

    @RequestMapping(value = "insterLogs",method = RequestMethod.GET)
    public void insertLogs(){
        demoService.insertLogs();
    }


    @RequestMapping(value = "insterTest02",method = RequestMethod.GET)
    public void insertTest02(){
        demoService.insertTest02();

    }

}
