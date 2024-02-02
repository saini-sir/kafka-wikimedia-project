package com.rajCode.springboot;

import com.rajCode.springboot.Entity.WikimediaChanges;
import com.rajCode.springboot.Repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaRepository wikimediaRepo;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepo) {

        this.wikimediaRepo = wikimediaRepo;
    }

    @KafkaListener(topics="Wikimedia_Recent_changes", groupId="group-1")
    public void KafkaConsumer(String enMessage) throws  Exception{

        logger.info(String.format("eventMessage_received->%s", enMessage));

    WikimediaChanges wikimedia = new WikimediaChanges();
    wikimedia.setWiki_events(enMessage);

    wikimediaRepo.save(wikimedia);
    }

}
