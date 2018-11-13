package com.ibm.crl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.crl.model.InfoRevealVo;
import com.ibm.crl.model.PageResult;

public interface InfoRevealDao {
	public int getRevealDataCont(@Param("vo")InfoRevealVo vo,@Param("pc")PageResult<InfoRevealVo> pc);
	public List<InfoRevealVo> getRevealData(@Param("vo")InfoRevealVo vo,@Param("pc")PageResult<InfoRevealVo> pc);
}
