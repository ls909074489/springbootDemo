<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js""></script>
</head>
<body>
	<div id="vue_det">
	    <h1>site : {{site}}</h1>
	    <h1>url : {{url}}</h1>
	    <h1>{{details()}}</h1>
	    
	    <div v-html="htmlMsg"></div>
	    
	  <input v-model="message" placeholder="edit me">
<p>Message is: {{ message }}</p>
	</div>
	<script type="text/javascript">
		var data = { site: "菜鸟教程", url: "www.runoob.com", alexa: 10000,message:"bbb",htmlMsg:"<h1 style='color: red;'>this is html content</h1>"}
	    var vm = new Vue({
	        el: '#vue_det',
	        data: data,
	        methods: {
	            details: function() {
	                return  this.site + " - 学的不仅是技术，更是梦想！";
	            }
	        }
	    })
	</script>
</body>
</html>