package com.placeManage.Place_Manage_Service.rabbitmq;


import com.placeManage.Place_Manage_Service.model.Visitors;
import com.placeManage.Place_Manage_Service.service.placeFind.PlaceFindService;
import com.placeManage.Place_Manage_Service.service.placeFree.PlaceFreeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {


    @Autowired
    PlaceFreeService placeFreeService;

    @Autowired
    PlaceFindService placeFindService;


    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Visitors visitors) {
        placeFindService.addVisitors(visitors);
    }
}