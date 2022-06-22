package com.web.demo.controller;

import com.bean.User;
import com.exception.ServiceException;
import com.google.gson.JsonObject;
import com.response.ServiceResult;
import com.web.demo.bo.DemoBo;
import com.web.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/web")
@SessionAttributes("user")
public class HelloController {

    @Value("${hkey}")
    private String  hkey;

    @Resource
    private DemoService demoService;

    @GetMapping("/demo1/{uuid}")
    public String getUUID(@PathVariable("uuid") String UUID, @ModelAttribute("user") User user) {
        ServiceResult serviceResult = new ServiceResult();
        ServiceResult demo = demoService.getDemo("1");

        System.out.println(user.getPassword() + "====="+hkey);
        System.out.println(demo);
        return UUID;
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
    public ServiceResult getSecondV(){
        System.out.println(hkey);

        return null;
    }

    //简单的使用属性校验
    @PostMapping("/postBo")
    public ServiceResult postBoVoid(@RequestBody @Valid DemoBo demo, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           List<FieldError> allErrors = bindingResult.getFieldErrors();
           allErrors.forEach((item)->{
               System.out.println(item.getField()+ item.getDefaultMessage());
           });
       }

        System.out.println(demo.getPokid()+"-------");
        return null;
    }


    @PostMapping("/postJson")
    public ServiceResult postBoVoid(@RequestBody Object paramsObj){

        System.out.println(paramsObj.toString());
        return null;
    }

    @PostMapping("exception")
    public ServiceResult postException(@RequestBody DemoBo demo) throws ServiceException {

        try {
            int i =1/0;
        }catch (RuntimeException e){
            throw new ServiceException("错误"+e.getMessage());
        }

        return null;
    }

}
