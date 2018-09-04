package io.github.antoniovizuete.pojospreadsheet.utils.reflection;

import java.lang.reflect.Method;

public class Field {

	private String name;
	private Method getter;
	private Method setter;
	
	public Field(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMethod(Method method){
		if(MethodUtils.isGetter(method)){
			setGetter(method);
		}
		
		if(MethodUtils.isSetter(method)){
			setSetter(method);
		}
	}
	
	public Method getGetter() {
		return getter;
	}
	
	public void setGetter(Method getter) {
		this.getter = getter;
	}
	
	public Method getSetter() {
		return setter;
	}
	
	public void setSetter(Method setter) {
		this.setter = setter;
	}
	
	
}
