<!--课程搜索页面-->
<!DOCTYPE html>
<html>
    <head>
        <title>搜索页面</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="../js/jquery.min.js"></script>
    </head>
    <script>
//  异步请求方法1  保存（request？session）一个list数据 包含一组实体类对象

//  异步请求方法2 含参数  保存（request？session）一个list数据 包含一组已排序的实体类对象
    
    </script>
    <body>
    	<div class="container">
    		<!--搜索参数设置-->
    		<div>
	    		<!--搜索栏-->
	    		<div>
	    			<form>
	    				<input type="text" name="searchin" id="searchin" value="<%$search%>"/>
	    				<!--保存（request？session）一个字符串（搜索内容）数据-->
	    				<!--提交异步请求1-->
	    				<button value="搜索" accesskey="Enter" onclick=""></button>
	    			</form>
	    		</div>
	    		<!--排序方式-->
	    		<div>
	    			时间：
	    			<!--异步请求2参数1-->
	    			<a onclick="">
	    				<font>
	    					升序
	    				</font>
	    			</a>
	    			<!--异步请求2参数2-->
	    			<a onclick="">
	    				<font>
	    					降序
	    				</font>
	    			</a>
	    		</div>
    		</div>
    		<!--搜索结果显示-->
    		<div>
    			<!--循环提取list中的实体类并在div中显示-->
    		</div>
    	</div>	
 	</body>
</html>