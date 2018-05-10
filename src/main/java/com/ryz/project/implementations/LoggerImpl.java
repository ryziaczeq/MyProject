package com.ryz.project.implementations;

import java.util.Date;

import com.ryz.project.api.Logger;

public class LoggerImpl implements Logger {

	private String name;

	public void log(String message) {
		System.out.println(new Date() + " [ " + name + " ]: " + message);
	}

	public void setName(String name) {
		this.name = name;

	}

}
