package com.stackroute.rabbitMQconfig;

import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

@Configuration
public class UserConfiguration {

    public static final String patQUEUE = "pat_queue";
    public static final String volQUEUE = "vol_queue";
    public static final String docQUEUE = "doc_queue";
    public static final String mailQUEUE = "mail_queue";

    public static final String EXCHANGE = "exchange";


/*    public static final String pROUTING_KEY = "pat_routingKey";
    public static final String vROUTING_KEY = "vol_routingKey";
    public static final String dROUTING_KEY = "doc_routingKey";
    public static final String mROUTING_KEY = "mail_routingKey";*/

    @Bean
    public Queue queuem() {
        return new Queue(mailQUEUE,true);
    }

    @Bean
    public Queue queuep() {
        return new Queue(patQUEUE,true);
    }

    @Bean
    public Queue queuev() {
        return new Queue(volQUEUE,true);
    }

    @Bean
    public Queue queued() {
        return new Queue(docQUEUE,true);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    public Binding pbinding(Queue queuep, FanoutExchange exchange) {

        return BindingBuilder.bind(queuep).to(exchange);
    }
    @Bean
    public Binding vbinding(Queue queuev, FanoutExchange exchange) {
        return BindingBuilder.bind(queuev).to(exchange);
    }@Bean
    public Binding dbinding(Queue queued, FanoutExchange exchange) {

        return BindingBuilder.bind(queued).to(exchange);
    }
    @Bean
    public Binding mbinding(Queue queuem, FanoutExchange exchange) {

        return BindingBuilder.bind(queuem).to(exchange);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}

