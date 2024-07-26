/**
 * 
 */
package com.app.cabbooking.exception;

/**
 * 
 */
public class ResourceNotfoundException extends RuntimeException{

	private long fieldValue;
	private String fieldName;
	private String resourceName;
	public ResourceNotfoundException(long fieldValue, String fieldName, String resourceName) {
		super(String.format("%s not found with %s : %s", fieldValue, fieldName,resourceName));
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
		this.resourceName = resourceName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	
	
	
}
