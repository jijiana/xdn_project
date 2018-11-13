package com.ibm.crl.model;

import java.math.BigDecimal;

public class FundAllocationVo {
	private String id;
	private String capitalAllocationOverviewId;
	private String levelName;
	private String amount;
	private Double  percentum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCapitalAllocationOverviewId() {
		return capitalAllocationOverviewId;
	}
	public void setCapitalAllocationOverviewId(String capitalAllocationOverviewId) {
		this.capitalAllocationOverviewId = capitalAllocationOverviewId;
	}
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Double getPercentum() {
		return percentum;
	}
	public void setPercentum(Double percentum) {
		percentum = percentum *100;
        BigDecimal bg = new BigDecimal(percentum);
        double d3 = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
		this.percentum = d3;
	}
	
}
