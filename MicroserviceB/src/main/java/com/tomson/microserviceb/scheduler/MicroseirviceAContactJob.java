package com.tomson.microserviceb.scheduler;

import com.tomson.microserviceb.client.MicroserviceAClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MicroseirviceAContactJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(MicroseirviceAContactJob.class);

    private MicroserviceAClient microserviceAClient;

    public MicroseirviceAContactJob(MicroserviceAClient microserviceAClient) {
        this.microserviceAClient = microserviceAClient;
    }

    @Scheduled(fixedRate = 30000)  //cron expression = znacznik czasowy co ile gdzie  i jak http://www.cronmaker.com/
    public void userTask() {
        LOGGER.info("dzwonie do micro A");

        List<Long> idList = Arrays.asList(1L, 2L, 7L, 12L);

        idList.forEach(id ->  microserviceAClient.getUser(id));
    }
}
