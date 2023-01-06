package com.demo.web.utils;


import com.bean.User;
import com.common.ServiceResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt
 */
@Component
public class JwtUtil {
    //key最好为40位
    @Value("${JWT_WEB_KEY}")
    public String JWT_WEB_KEY;
    private static final String JWT_THRID_KEY = "eyJzdWIiOiJ7aWQ9MTIzMTMxfSIsImlkIjoiMTIzMTMxIiwiZXhwIjoxNjYyNDMyMzkxfQ";

    /**
     * 生成jwt 用HS256加密
     */
    public String JWTBuild(Map<String, Object> params) {
        String jwt = Jwts.builder().setClaims(params).setSubject(params.toString()).setExpiration(new Date(System.currentTimeMillis() + 600000L)).signWith(SignatureAlgorithm.HS256, JWT_THRID_KEY).compact();
        System.out.println(jwt);
        return jwt;
    }

    /**
     * 解析jwt
     *
     * @param token
     */
    public ServiceResult parserJwt(String token) {
        Claims body = null;
        ServiceResult serviceResult = new ServiceResult();
        try {
//            SignatureAlgorithm.RS256
            body = Jwts.parser().setSigningKey(JWT_THRID_KEY).parseClaimsJws(token).getBody();
            serviceResult.setCode("000000");
            serviceResult.setMsg("success");
            serviceResult.setData(body);
        } catch (Exception e) {
            serviceResult.setCode("888888");
            serviceResult.setMsg(e.getMessage());
            serviceResult.setData(e);
        } finally {
            return serviceResult;
        }
    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, Object> objectMap = new HashMap<>();
        User user = new User();
        user.setUsername("ming");
        user.setPokid("0");
        user.setPassword("jfkjs");
        objectMap.put("user", user);
//        objectMap.put("id", "12313hfjkshfkhfuksjfh1");
//        objectMap.put("name", "会黑科技和复活甲看");
//        objectMap.put("sfz", "1231421321423889747326478");
//        objectMap.put("dz", "会黑科技和复活甲看会黑科技和复活甲看会黑科技和复活甲看会黑科技和复活甲看会黑科技和复活甲看会黑科技和复活甲看会黑科技和复活甲看");
//        objectMap.put("sjh", "124213412314213");
//        objectMap.put("mz", "发接口返回好喝哦好好考试");
        String s = jwtUtil.JWTBuild(objectMap);
        System.out.println("s=>>" + s);
        ServiceResult webResponse = jwtUtil.parserJwt(s);

        System.out.println(webResponse.toString());
    }

}
