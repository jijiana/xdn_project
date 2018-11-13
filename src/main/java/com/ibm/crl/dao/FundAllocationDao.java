package com.ibm.crl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.crl.model.FundAllocationVo;
import com.ibm.crl.model.PageResult;

public interface FundAllocationDao {
	public int getAllocationDataCont(@Param("vo")FundAllocationVo vo,@Param("pc")PageResult<FundAllocationVo> pc);
	public List<FundAllocationVo> getAllocationData(@Param("vo")FundAllocationVo vo,@Param("pc")PageResult<FundAllocationVo> pc);
	public double getAllocationTotal();

}
