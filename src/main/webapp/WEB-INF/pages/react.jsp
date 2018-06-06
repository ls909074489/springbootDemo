<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Hello React!</title>
    <script src="https://cdn.bootcss.com/react/15.4.2/react.min.js"></script>
    <script src="https://cdn.bootcss.com/react/15.4.2/react-dom.min.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.22.1/babel.min.js"></script>
    
     <script src="../js/jquery.min.js"></script>
  </head>
  <body>
    <div id="example"></div>
    
    <hr>
    	注意，原生 HTML 元素名以小写字母开头，而自定义的 React 类名以大写字母开头，比如 HelloMessage 不能写成 helloMessage。除此之外还需要注意组件类只能包含一个顶层标签，否则也会报错。<br>
    	如果我们需要向组件传递参数，可以使用 this.props 对象,实例如下：
    <div id="example2"></div>
    
    
     <hr>
    	复合组件<br>
    	实例中 WebSite 组件使用了 Name 和 Link 组件来输出对应的信息，也就是说 WebSite 拥有 Name 和 Link 的实例。
    <div id="example3"></div>
    
    
       <hr>
    	 React State(状态)<br>
    	
    <div id="example4"></div>
   
    
    
    <script type="text/babel">
		$.ajax({
				type : "POST",
				data :{},
				url : "http://localhost:8081/spring-boot/demo/dataJson",
				async : true,
				dataType : "json",
				success : function(data) {
					console.info(data);
				},
				error : function(data) {
					console.info(data);
				}
			});


		var myStyle = {
    		fontSize: 100,
    		color: '#FF0000'
		};
		var arr = [
  			<h1>菜鸟教程</h1>,
  			<h2>学的不仅是技术，更是梦想！</h2>,
		];

      ReactDOM.render(
        <span>使用样式：<h1 style = {myStyle}>菜鸟教程</h1>使用数据：{arr}</span>,
        document.getElementById('example')
      );


	 /*使用组件*/
	var HelloMessage = React.createClass({
  		render: function() {
    		return <h1>使用组件React.createClass！===>{this.props.name}</h1>;
  		}
	});

	ReactDOM.render(
 	 	<HelloMessage  name="Runoob"/>,
  		document.getElementById('example2')
	);

	/*使用复合组件，实例中 WebSite 组件使用了 Name 和 Link 组件来输出对应的信息，也就是说 WebSite 拥有 Name 和 Link 的实例。*/
	var WebSite = React.createClass({
  render: function() {
    return (
      <div>
        <Name name={this.props.name} />
        <Link site={this.props.site} />
      </div>
    );
  }
});
 
var Name = React.createClass({
  render: function() {
    return (
      <h1>{this.props.name}</h1>
    );
  }
});
 
var Link = React.createClass({
  render: function() {
    return (
      <a href={this.props.site}>
        {this.props.site}
      </a>
    );
  }
});
 
ReactDOM.render(
  <WebSite name="菜鸟教程" site=" http://www.runoob.com" />,
  document.getElementById('example3')
);


/*React State(状态)*/
 var LikeButton = React.createClass({
		/*这个方法名称是已经定义好的，不能改名称。用于定义初始状态*/
        getInitialState: function() {
          return {liked: false};
        },
        handleClick: function(event) {
		  /*state的值发生变化，自动调用this.render方法渲染*/
          this.setState({liked: !this.state.liked});
        },
        render: function() {
          var text = this.state.liked ? '喜欢' : '不喜欢';
          return (
            <p onClick={this.handleClick}>
            	  你<b>{text}</b>我。点我切换状态。
            </p>
          );
        }
      });

      ReactDOM.render(
        <LikeButton />,
        document.getElementById('example4')
      );
    </script>
  </body>
</html>