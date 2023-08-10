package com.stackroute.consumerRabbitMq;


import com.stackroute.configuration.UserConfiguration;

import com.stackroute.model.UserEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageListener {


	    private List<UserEntity> emailList;

		@RabbitListener(queues = "mail_queue")
		public void listener(List<UserEntity> list) {
			emailList=list;
			System.out.println(emailList);
		}
		public List<UserEntity> getEmailList(){
			return emailList;
		}
}
