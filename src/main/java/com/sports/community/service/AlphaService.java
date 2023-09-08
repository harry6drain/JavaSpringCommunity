package com.sports.community.service;

import com.sports.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("Instantiating...");
    }
    @PostConstruct
    public void init() {
        System.out.println("Initializing...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroying...");
    }

    public String find() {
        return alphaDao.select();
    }


}
