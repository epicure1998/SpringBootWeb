package com.qiumengke.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    @Scheduled(cron = "*/5 * * * * ?")
    public void testTask(){
        System.out.println("异步执行任务");
    }
}
