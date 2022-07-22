package com.sekolahkripto.codingtest.model;

import java.util.List;

public class Response<T> {

	private int status;
	private List<T> data;
	private String message="Your request has been processed successfully";

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Response(int status, List<T> data) {
		super();
		this.status = status;
		this.data = data;
	}

	public Response() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
