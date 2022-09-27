package com.demo.web.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.demo.web.demo.bo.DemoBo1;
import com.demo.web.demo.service.DemoService;
import com.exception.ServiceException;
import com.response.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/web")
@SessionAttributes("user")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${hkey}")
    private String hkey;

    @Resource
    private DemoService demoService;

    @GetMapping("/demo1/{uuid}")
    public String getUUID(@PathVariable("uuid") String UUID, @ModelAttribute("user") User user) {
        logger.info("UUID====>"+UUID);
        ServiceResult serviceResult = new ServiceResult();
        ServiceResult demo = demoService.getDemo("1");

        System.out.println(user.getPassword() + "=====" + hkey);
        System.out.println(demo);
        return UUID;
    }

    @GetMapping("/demo2/{uuid}")
    public ServiceResult getUUID1(@PathVariable("uuid") String UUID) {
        ServiceResult demo = demoService.getDemo("1");
        return demo;
    }

    @GetMapping("fisrtVoid")
    public ServiceResult fisrtVoid(HttpServletRequest request) {
        User user = new User();
        user.setPokid("988");
        user.setUsername("luo");
        user.setPassword("iiii");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return null;
    }

    @GetMapping("secondVoid")
    public ServiceResult getSecondV() {
        System.out.println(hkey);

        return null;
    }

    //简单的使用属性校验
    @PostMapping("/postBo")
    public ServiceResult postBoVoid(@RequestBody @Valid DemoBo1 demo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            allErrors.forEach((item) -> {
                System.out.println(item.getField() + item.getDefaultMessage());
            });
        }
        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setResultObj(allErrors);
        System.out.println(demo.getPokid() + "-------");
        return null;
    }

    @PostMapping("/postBo2")
    public ServiceResult postBoVoid2(@RequestBody @Valid DemoBo1 demo) {

        ServiceResult serviceResult = new ServiceResult();
//        serviceResult.setResultObj(allErrors);
        System.out.println(demo.getPokid() + "-------");
        return null;
    }


    @PostMapping("/postJson")
    public ServiceResult postBoVoid(@RequestBody Object paramsObj) {

        System.out.println(paramsObj.toString());
        return null;
    }

    @PostMapping("exception")
    public ServiceResult postException(@RequestBody DemoBo1 demo) throws ServiceException {

        try {
            int i = 1 / 0;
        } catch (RuntimeException e) {
            throw new ServiceException("错误" + e.getMessage());
        }

        return null;
    }

    @PostMapping("exception2")
    public ServiceResult postException2(@RequestBody DemoBo1 demo) throws ServiceException {
        ServiceResult serviceResult = new ServiceResult();
        int i = 10 / 2;
        return serviceResult.putObject(i);
    }


    @PostMapping("/toJSON")
    public ServiceResult get(@RequestBody JSONObject json) {
//        String name =(String) json.get("name");
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultCode("ifuisfjk");
        System.out.println(json);
        return serviceResult;
    }


}
