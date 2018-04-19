package com.github.sawied.microservice.oauth2.client.service;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class UserServiceHystrixCommand extends HystrixCommand<String> {

	protected UserServiceHystrixCommand() {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("UserCommand"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("userThread"))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10))// 服务线程数量
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter().withCircuitBreakerErrorThresholdPercentage(60)// 错误请求超过60%，就将打开
								.withCircuitBreakerSleepWindowInMilliseconds(2000)// 熔断器打开到关闭的时间窗长度
								.withExecutionTimeoutInMilliseconds(2000)// 超时时间
		));
	}

	@Override
	protected String run() throws Exception {
		return new RestTemplate().getForObject(URI.create("http://www.baidu.com"), String.class);
	}

	@Override
	protected String getFallback() {
		return "fail";
	}

}
