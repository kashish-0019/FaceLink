package com.eschool.model;

public class Wpost {
	private int wid;
	private String sender;
	private String message;
	private String dop;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	public Wpost(int wid, String sender, String message, String dop) {
		
		this.wid = wid;
		this.sender = sender;
		this.message = message;
		this.dop = dop;
	}
	public Wpost() {
		
	}
	
}
