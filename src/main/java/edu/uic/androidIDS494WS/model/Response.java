package edu.uic.androidIDS494WS.model;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private String tag;
	private boolean status;
	
	@XmlElementWrapper(nillable = true)
	private String error_message;
	
	public Response() {
	}
	
	public Response(String tag, boolean status, String error_message) {
		super();
		this.tag = tag;
		this.status = status;
		this.error_message = error_message;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
}