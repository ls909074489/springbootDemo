package com.ls.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ls.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired  
    private StringRedisTemplate template;  
//	@Autowired  
//	private RedisTemplate redisTemplate;  
	
	@RequestMapping(value="/reactPage",method=RequestMethod.GET)
	public String reactPage(){
		
		String key="string:username:shabao";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.opsForValue().set(key, "我是ls20081111:"+ sdf.format(new Date()));  
        System.out.println("key已存在:"+template.opsForValue().get(key));  
        
        
        String k1="key1";
        template.opsForValue().set(k1, "0");  
        for(int i=0;i<100;i++){
        	 ThreadTest1 t1=new ThreadTest1();
             t1.start();
        }
        
		return "react";
	}
	
	@RequestMapping(value="/vuePage",method=RequestMethod.GET)
	public String vuePage(){
		
		String key="string:username:shabao";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.opsForValue().set(key, "我是ls20081111:"+ sdf.format(new Date()));  
        System.out.println("key已存在:"+template.opsForValue().get(key));  
        
        
        String k1="key1";
        template.opsForValue().set(k1, "0");  
        for(int i=0;i<100;i++){
        	 ThreadTest1 t1=new ThreadTest1();
             t1.start();
        }
        
		return "vue";
	}
	
	
	
	public class  ThreadTest1 extends Thread{
        String k1="key1";
		@Override
		public void run() {
			System.out.println("aaaaaaaaaaaa");
			String kval=template.opsForValue().get(k1);
			kval=(Integer.parseInt(kval)+1)+"";
        	template.opsForValue().set(k1, kval+"");  
            System.out.println("key已存在:"+template.opsForValue().get(k1));  
			super.run();
		}
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
//		System.out.println("==="+user.getUuid());
//		System.out.println(1/0);
		return user;
	}
}
