package com.spring.mvc.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.integration.redis.store.RedisMessageStore;
import org.springframework.integration.store.MessageGroupQueue;

@Configuration
@IntegrationComponentScan(basePackages={"com.spring.mvc.redis"})
@EnableIntegration
public class AppRedisConfig {
	
	String rulesQueue = "RulesQueue_Redis";
	String actionsQueue = "ActionsQueue_Redis";
	String dbQueue = "DBQueue_Redis";
	String replyQueue = "ReplyQueue_Redis";
	String mailQueue = "MailQueue_Redis";
	String auditLogQueue = "AuditLogg_Redis";
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory () {
		return new JedisConnectionFactory();
	}
	
	@Bean
    RedisTemplate< String, Object > redisTemplate() {
        final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
        template.setConnectionFactory( jedisConnectionFactory() );
        return template;
    }
	
	@Bean
	RedisMessageStore redisMessageStore() {
		return new RedisMessageStore(jedisConnectionFactory());
	}
	 
	@Bean
	public MessageChannel rulesQueueChannel () {
		 return new QueueChannel (new MessageGroupQueue(redisMessageStore (), 
				 "rulesMStore", 100));
	}
	
	
	@Bean
	public MessageChannel actionsQueueChannel () {
		 return new QueueChannel (new MessageGroupQueue(redisMessageStore (), 
				 "actionsMStore", 100));
	}
	
	@Bean
	public MessageChannel dbQueueChannel () {
		 return new QueueChannel (new MessageGroupQueue(redisMessageStore (), 
				 "dbMStore", 100));
	}

	
	@Bean
	public MessageChannel mailQueueChannel () {
		return new QueueChannel(new MessageGroupQueue(redisMessageStore (), 
				 "mailMStore", 100));
	}
	
	@Bean
	public MessageChannel errorChannel () {
		 return new QueueChannel (new MessageGroupQueue(redisMessageStore (), 
				 "errorChannel", 50));
	}
	
	
	@Bean
	RedisQueueOutboundChannelAdapter rulesRQOutboundChannelAdapter () {
		RedisQueueOutboundChannelAdapter redisPublisher = new RedisQueueOutboundChannelAdapter(
				rulesQueue, jedisConnectionFactory ());
//		redisPublisher.setSerializer(new GenericToStringSerializer<Object>(
//				Object.class));
		
		return redisPublisher;
	}
	
	@Bean
    RedisQueueMessageDrivenEndpoint rulesRQMessageDrivenEndpoint() {
		RedisQueueMessageDrivenEndpoint redisEndPoint = new RedisQueueMessageDrivenEndpoint(
				rulesQueue, jedisConnectionFactory());
        redisEndPoint.setOutputChannel(rulesQueueChannel());
        redisEndPoint.setErrorChannel(errorChannel());
//		redisEndPoint.setSerializer(new GenericToStringSerializer<Object>(
//				Object.class));
		return redisEndPoint;
	}
	@Bean
	RedisQueueOutboundChannelAdapter actionRQOutbounChannelAdapter () {
		RedisQueueOutboundChannelAdapter redisActionPub = new RedisQueueOutboundChannelAdapter(
				actionsQueue, jedisConnectionFactory());
//		redisActionPub.setSerializer(new GenericToStringSerializer<Object>(Object.class));
		
		return redisActionPub;
	}
	
	@Bean
    RedisQueueMessageDrivenEndpoint  actionRQMessageDrEndpoint() {
		RedisQueueMessageDrivenEndpoint redisEndPoint = new RedisQueueMessageDrivenEndpoint(
				actionsQueue, jedisConnectionFactory());
        redisEndPoint.setOutputChannel(actionsQueueChannel());
        redisEndPoint.setErrorChannel(errorChannel());
//		redisEndPoint.setSerializer(new GenericToStringSerializer<Object>(
//				Object.class));
		return redisEndPoint;
	}
	@Bean
	RedisQueueOutboundChannelAdapter dbOptsRQOutboundChannelAdapter () {
		RedisQueueOutboundChannelAdapter redisDBPublisher = new RedisQueueOutboundChannelAdapter(
				dbQueue, jedisConnectionFactory());
//		redisDBPublisher.setSerializer(new GenericToStringSerializer<Object>(Object.class));
		return redisDBPublisher;
	}
	
	@Bean
	RedisQueueMessageDrivenEndpoint dbOptsRQMessageDrEndPoint () {
		RedisQueueMessageDrivenEndpoint redisDBEndPoint = new RedisQueueMessageDrivenEndpoint(
				dbQueue, jedisConnectionFactory());
		redisDBEndPoint.setOutputChannel(dbQueueChannel());
		redisDBEndPoint.setErrorChannel(errorChannel());
//		redisDBEndPoint.setSerializer(new GenericToStringSerializer<Object>(
//				Object.class));
		return redisDBEndPoint;
	}
	@Bean
	RedisQueueOutboundChannelAdapter mailRQOutboundChannelAdapter () {
		RedisQueueOutboundChannelAdapter redisDBPublisher = new RedisQueueOutboundChannelAdapter(
				mailQueue, jedisConnectionFactory());
//		redisDBPublisher.setSerializer(new GenericToStringSerializer<Object>(Object.class));
		return redisDBPublisher;
	}
	
	@Bean
	RedisQueueMessageDrivenEndpoint mailRQMessageDrEndPoint () {
		RedisQueueMessageDrivenEndpoint redisDBEndPoint = new RedisQueueMessageDrivenEndpoint(
				mailQueue, jedisConnectionFactory());
		redisDBEndPoint.setOutputChannel(mailQueueChannel());
		redisDBEndPoint.setErrorChannel(errorChannel());
//		redisDBEndPoint.setSerializer(new GenericToStringSerializer<Object>(
//				Object.class));
		return redisDBEndPoint;
	}
	@Bean
    public Executor rulesExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(25);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("rulesExecutor-");
        executor.initialize();
        return executor;
    }
	
	@Bean
    public Executor actionExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(25);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("actionExecutor-");
        executor.initialize();
        return executor;
    }
	
	@Bean
    public Executor dbServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(25);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("dbServiceExecutor-");
        executor.initialize();
        return executor;
    }
	
	@Bean
    public Executor mailingServExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(25);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("mailingServExecutor-");
        executor.initialize();
        return executor;
    }
	 
}
