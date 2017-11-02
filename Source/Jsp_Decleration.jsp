<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%! int i= 10;
	String str = "ABCS";
%>

<%! 
	public int sum(int a, int b){
		return a + b;	
	}
%>

<%	
	out.print("I : "+ i +"<br/>");
	out.print("Str : "+str+"<br/>");
	out.print("Sum() : "+sum(10,20)+"<br/>");
%>
</body>
</html>
