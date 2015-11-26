package com.footoss.basic.exception;

public class ParameterException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3467702562099265504L;

	public ParameterException() {
		super();
	}
	
	public ParameterException(String message){
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "错误参数:  " + super.getMessage();
	}
	
	

}
