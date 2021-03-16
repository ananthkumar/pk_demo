package com.pk.eis.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
	public class JMSConfig {

	
		String borkerUrl = "tcp://localhost:61616"; 
		String brokerUserName = "admin"; 
		String brokerPwd = "admin";
		
		@Bean
		public ActiveMQConnectionFactory connectionFactory(){
		    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		    connectionFactory.setPassword(brokerUserName);
		    connectionFactory.setUserName(brokerPwd);
		    return connectionFactory;
		}

		@Bean
		public JmsTemplate jmsTemplate(){
		    JmsTemplate template = new JmsTemplate();
		    template.setConnectionFactory(connectionFactory());
		    return template;
		}

		@Bean
		public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		    factory.setConnectionFactory(connectionFactory());
		    factory.setConcurrency("1-1");
		    return factory;
		}

	}
