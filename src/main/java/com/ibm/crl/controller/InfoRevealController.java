package com.ibm.crl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.crl.model.InfoRevealVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.IInfoRevealService;

@Controller
public class InfoRevealController {
	
	@Autowired
	public IInfoRevealService infoRevealService; 
	
	@RequestMapping("/info_reveal")
    public String second( Model m){
        return "infoReveal";        
    }
	
	@RequestMapping(value="/infoRevealData",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> fundAllocationData(InfoRevealVo vo,Integer page,Integer rows){
		Map<String,Object> map = new HashMap<String,Object>();
		//设置分页 
		PageResult<InfoRevealVo> pc=new PageResult<InfoRevealVo>();
		if(page!=0&&page!=null){
			pc.setPage(page);
		}
		if(rows!=0&&rows!=null){
			pc.setRecords(rows);
			pc.setRows(rows);
		}
		List<InfoRevealVo> list = infoRevealService.getRevealData(vo,pc); 
		int totalPage = pc.getTotal() % rows == 0 ? pc.getTotal()/rows : pc.getTotal() / rows+ 1;
		//返回分页
		map.put("total",totalPage);
		map.put("page",pc.getPage());
		map.put("records",pc.getTotal());
		map.put("rows", list);
        return map;
    }
}
