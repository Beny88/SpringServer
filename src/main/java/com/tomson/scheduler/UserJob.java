package com.tomson.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserJob.class);

    @Scheduled(cron = "0 0/1 * 1/1 * ?")  //cron expression = znacznik czasowy co ile gdzie  i jak http://www.cronmaker.com/
    public void userTask() {
        LOGGER.error("error userTask");
        LOGGER.info("info cos tam");
    }
}