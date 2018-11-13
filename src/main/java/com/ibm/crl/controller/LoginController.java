package com.ibm.crl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.crl.interceptor.WebConfig;
import com.ibm.crl.model.LoginVo;

@Controller
public class LoginController {
	@RequestMapping("/login")
    public String second( Model m){
        return "login";        
    }
	
	@RequestMapping(value = "/loginValidate", method=RequestMethod.POST)
    @ResponseBody
    public int loginValidate(@RequestBody LoginVo loginvo,HttpSession session){
		session.setAttribute(WebConfig.SESSION_KEY, "admin");
		if("admin".equals(loginvo.getUsername())&&"admin".equals(loginvo.getPassword())){
			return 0;
		}else{
			return 1;
		}
	}
}
