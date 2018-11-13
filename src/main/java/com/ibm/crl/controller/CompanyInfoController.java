package com.ibm.crl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.crl.model.CompanyInfoVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.ICompanyInfoService;

@Controller
public class CompanyInfoController {
	
	@Autowired
	private ICompanyInfoService service;
	
	@RequestMapping("/investment_company")
    public String investmentCompanyIndex(Model m){
        return "companyInfo";
    }
	
	@RequestMapping(value="/companyData",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> companyData(CompanyInfoVo vo,Integer page,Integer rows){
		Map<String,Object> map = new HashMap<String,Object>();
		//设置分页 
		PageResult<CompanyInfoVo> pc=new PageResult<CompanyInfoVo>();
		if(page!=0&&page!=null){
			pc.setPage(page);
		}
		if(rows!=0&&rows!=null){
			pc.setRecords(rows);
			pc.setRows(rows);
		}
		List<CompanyInfoVo> list = service.getCompanyData(vo,pc); 
		int totalPage = pc.getTotal() % rows == 0 ? pc.getTotal()/rows : pc.getTotal() / rows+ 1;
		//返回分页
		map.put("total",totalPage);
		map.put("page",pc.getPage());
		map.put("records",pc.getTotal());
		map.put("rows", list);
        return map;
    }
	
	@ResponseBody
	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public int addCompanyInfo(@RequestBody CompanyInfoVo vo){
		
		vo.setCreateTime(new Date());
		int retflag=service.addCompanyInfo(vo);
		return retflag;
	}
	@ResponseBody
	@RequestMapping(value = "/selectCompanyInfoById", method = RequestMethod.POST)
	public CompanyInfoVo selectCompanyInfo(@RequestBody CompanyInfoVo pm){
		CompanyInfoVo vo =service.selectCompanyInfoById(pm.getId());
		return vo;
	}
	@ResponseBody
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public int editCompanyInfo(@RequestBody CompanyInfoVo vo){
		vo.setUpdateTime(new Date());
		int retflag=service.editCompanyInfo(vo);
		return retflag;
	}
	@ResponseBody
	@RequestMapping(value = "/deleteCompanyInfoById", method = RequestMethod.POST)
	public int deleteCompanyInfo(@RequestBody CompanyInfoVo vo){
		int retflag=service.deleteCompanyInfoById(vo.getId());
		return retflag;
	}
}
