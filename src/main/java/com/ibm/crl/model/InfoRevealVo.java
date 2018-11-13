package com.ibm.crl.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoRevealVo {
	private String product;
	private String productCode;
	private String reportType;
	private String company;
	private Date investTime;
	private Date reportTime;
	private String investTimeStr;
	private String reportTimeStr;
	
	private String investTimeStart;
	private String investTimeEnd;
	private String reportTimeStart;
	private String reportTimeEnd;
	
	private String sord;
	private String sidx;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Date getInvestTime() {
		return investTime;
	}
	public void setInvestTime(Date investTime) {
		if(investTime!=null){
			String dateString = formatter.format(investTime);
			this.investTimeStr=dateString;
			return ;
		}
		this.investTime = investTime;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		if(reportTime!=null){
			String dateString = formatter.format(reportTime);
			this.reportTimeStr=dateString;
			return ;
		}
		this.reportTime = reportTime;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getInvestTimeStr() {
		return investTimeStr;
	}
	public void setInvestTimeStr(String investTimeStr) {
		this.investTimeStr = investTimeStr;
	}
	public String getReportTimeStr() {
		return reportTimeStr;
	}
	public void setReportTimeStr(String reportTimeStr) {
		this.reportTimeStr = reportTimeStr;
	}
	public String getInvestTimeStart() {
		return investTimeStart;
	}
	public void setInvestTimeStart(String investTimeStart) {
		this.investTimeStart = investTimeStart;
	}
	public String getInvestTimeEnd() {
		return investTimeEnd;
	}
	public void setInvestTimeEnd(String investTimeEnd) {
		this.investTimeEnd = investTimeEnd;
	}
	public String getReportTimeStart() {
		return reportTimeStart;
	}
	public void setReportTimeStart(String reportTimeStart) {
		this.reportTimeStart = reportTimeStart;
	}
	public String getReportTimeEnd() {
		return reportTimeEnd;
	}
	public void setReportTimeEnd(String reportTimeEnd) {
		this.reportTimeEnd = reportTimeEnd;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		if(sidx.equals("investTimeStr")){
			sidx = "investTime";
		}
		if(sidx.equals("reportTimeStr")){
			sidx = "reportTime";
		}
		this.sidx = sidx;
	}
	
}
