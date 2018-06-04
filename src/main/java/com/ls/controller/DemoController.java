package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ls.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

	@RequestMapping(value="/toPage",method=RequestMethod.GET)
	public String toPage(){
		System.out.println("111");
//		System.out.println(1/0);
		return "test1";
	}
	
	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
//	@ApiImplicitParams({
//	    @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
//	    @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
//	    @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
//	})
	@ResponseBody
	@RequestMapping(value="/dataJson",method=RequestMethod.POST)
	public User dataJson(User user){
		System.out.println("==="+user.getUuid());
//		System.out.println(1/0);
		return user;
	}
}
