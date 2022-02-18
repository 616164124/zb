package com.service;

import com.response.ServiceResult;

import java.util.HashMap;

public interface AdminService {
    ServiceResult getAdmin(String uuid);
    ServiceResult setAdmin(HashMap<String, Object> paramsMap);
}
