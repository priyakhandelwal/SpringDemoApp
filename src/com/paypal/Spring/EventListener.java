package com.paypal.Spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class EventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		System.out.println("applicationEvent=" + applicationEvent.toString());
		
	}
}
