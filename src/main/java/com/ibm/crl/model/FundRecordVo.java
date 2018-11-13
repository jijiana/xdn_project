package com.ibm.crl.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FundRecordVo {
	private String id;
	private Double r1Amount;
	private Double r2Amount;
	private Double r3Amount;
	private Double r4Amount;
	private Double r5Amount;
	private Date sendTime;
	private String sendTimeStr;
	private Double total;
	private String status;
	private String investCode;
	private String fundTimeStart;
	private String fundTimeEnd;
	private String sord;
	private String sidx;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getR1Amount() {
		return r1Amount;
	}
	public void setR1Amount(Double r1Amount) {
		this.r1Amount = r1Amount;
	}
	public Double getR2Amount() {
		return r2Amount;
	}
	public void setR2Amount(Double r2Amount) {
		this.r2Amount = r2Amount;
	}
	public Double getR3Amount() {
		return r3Amount;
	}
	public void setR3Amount(Double r3Amount) {
		this.r3Amount = r3Amount;
	}
	public Double getR4Amount() {
		return r4Amount;
	}
	public void setR4Amount(Double r4Amount) {
		this.r4Amount = r4Amount;
	}
	public Double getR5Amount() {
		return r5Amount;
	}
	public void setR5Amount(Double r5Amount) {
		this.r5Amount = r5Amount;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		if(sendTime!=null){
			String dateString = formatter.format(sendTime);
			this.sendTimeStr=dateString;
			return ;
		}
		this.sendTime = sendTime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvestCode() {
		return investCode;
	}
	public void setInvestCode(String investCode) {
		this.investCode = investCode;
	}
	public String getFundTimeStart() {
		return fundTimeStart;
	}
	public void setFundTimeStart(String fundTimeStart) {
		this.fundTimeStart = fundTimeStart;
	}
	public String getFundTimeEnd() {
		return fundTimeEnd;
	}
	public void setFundTimeEnd(String fundTimeEnd) {
		this.fundTimeEnd = fundTimeEnd;
	}
	public String getSendTimeStr() {
		return sendTimeStr;
	}
	public void setSendTimeStr(String sendTimeStr) {
		this.sendTimeStr = sendTimeStr;
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
		if(sidx.equals("sendTimeStr")){
			sidx = "sendTime";
		}
		this.sidx = sidx;
	}
	
}
