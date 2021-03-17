package com.hsbc.mastergroupservice.MastergroupMapping.bean;

import com.opencsv.bean.CsvBindByName;

public class MastergroupBean {
	@CsvBindByName(column = "cin")
	private String cin;
	@CsvBindByName(column = "siteCustomerName")
	private String siteCustomerName;
	@CsvBindByName(column = "mastergroupid")
	private String mastergroupid;
	
	
	public MastergroupBean() {
		super();
	}


	public MastergroupBean(String cin, String siteCustomerName, String mastergroupid) {
		super();
		this.cin = cin;
		this.siteCustomerName = siteCustomerName;
		this.mastergroupid = mastergroupid;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getSiteCustomerName() {
		return siteCustomerName;
	}


	public void setSiteCustomerName(String siteCustomerName) {
		this.siteCustomerName = siteCustomerName;
	}


	public String getMastergroupid() {
		return mastergroupid;
	}


	public void setMastergroupid(String mastergroupid) {
		this.mastergroupid = mastergroupid;
	}
	
	
	

}
