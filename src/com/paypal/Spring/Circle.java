package com.paypal.Spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware{
	private Point center;
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	private DrawEvent drawEvent;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
//		System.out.println("Point Center = " + center.getX() +"," +center.getY());
//		System.out.println(messageSource.getMessage("point.message", new Object[]{center.getX(), center.getY()}, null));
//		System.out.println("Message from message source" + messageSource.getMessage("greeting", null, null));
		drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("Initialization of Circle Bean");
	}
	
	public Point getCenter() {
		return center;
	}

//	@Autowired
//	@Qualifier("circleRelated")
	@Resource(name="centre")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Cleanup of Circle Bean");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}
	
}
