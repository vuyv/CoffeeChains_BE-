package com.enclave.backend.service;

import com.enclave.backend.entity.Branch;
import com.enclave.backend.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Service
public class OrderIdGenerator {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    private EmployeeServiceImpl employeeService;

    private StringBuilder generateKey(Branch branch, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String strDate = formatter.format(date);
        StringBuilder key = new StringBuilder(String.valueOf(branch.getId()));
        key.append(strDate);
        return key;
    }

    private Long generateOrdinalNumber(String key) {
        return redisTemplate.boundValueOps(key).increment();
    }

    public String createOrderIdForBranch(Date date) {
        StringBuilder key = generateKey(employeeService.getCurrentEmployee().getBranch(), date);
        Long ordinalNumber = generateOrdinalNumber(String.valueOf(key));
        return String.valueOf(key.append(ordinalNumber));
    }
}
