package com.eschool.model;

public class Friend {
	private int fid;
	private String sender;
	private String rec;
	private int stat;
	private String dor;
	
	
	public Friend() {
		
	}
	public Friend(int fid, String sender, String rec, int stat, String dor) {
		
		this.fid = fid;
		this.sender = sender;
		this.rec = rec;
		this.stat = stat;
		this.dor = dor;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRec() {
		return rec;
	}
	public void setRec(String rec) {
		this.rec = rec;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	
	
}
