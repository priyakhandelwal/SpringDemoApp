package com.paypal.Spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle implements Shape{
	private Point center;

	@Override
	public void draw() {
		System.out.println("Point Center = " + center.getX() +"," +center.getY());
		
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
	
}
