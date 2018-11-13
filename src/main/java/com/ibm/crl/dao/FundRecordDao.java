package com.ibm.crl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.crl.model.FundRecordVo;
import com.ibm.crl.model.PageResult;

public interface FundRecordDao {
	public int getRecordDataCont(@Param("vo")FundRecordVo vo,@Param("pc")PageResult<FundRecordVo> pc);
	public List<FundRecordVo> getRecordData(@Param("vo")FundRecordVo vo,@Param("pc")PageResult<FundRecordVo> pc);

}
