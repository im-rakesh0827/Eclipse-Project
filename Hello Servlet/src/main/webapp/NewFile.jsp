<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- The symbol < %@ is the directive element it gives some information to browser 
that what kind of data is there in the webpage, basically it's a kind of meta data
 -->
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red">Hello Servlet</h1>
	
	<h1 style="color:blue">JSP Expression : </h1>
	<h2>
		<%="Hello" %><br>  <!-- Expression -->
		
		
		<%!public int x=37; %><br> <!-- Declaration -->
		<%= x %> <br> 
		
		 <!-- Two line above it, is compressed into single line -->
		<%=new Integer(37)%><br>  
		
		
		<!-- Two line below can be compressed into a single line -->
		<%! public String s = "Hello India"; %>
		<%=s %><br>
		
		<!-- Here we have compressed two line above it in a single line :  -->
		<%=new String("Hello India") %> <br>
		
		<%=new java.util.Date() %><br>
		<%=25*4+5-4/2 %><br>
		<%=20>3 %><br>
		<%=34<7 %><br>
	</h2>
	
	
	
	
	
	
	<h1 style="color:green">JSP Scriplet : </h1>
	<h2>
		<%
		int x = 78;
		out.println(x);
		out.print("<br/>");
		if(x>50) out.println("\nNumber is greater than 50 : \n");
		else out.println("\nNumber is less than 50 : ");
		%>
		
		<%
		for(int i=0; i<5; i++){
			out.print("<br>");
			out.print(i);
		}
		
		out.print("<br>");
		out.print("Elements of array : ");
		int arr[] = {3, 4, 5, 1, 0, -3, 0, 12, 90};
		for(int i:arr) out.print(i+" ");
		
		
		for(int i=1; i<arr.length; i++){
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>temp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		out.print("<br>");
		out.print("After sorting");
		
		for(int i:arr) out.print(i+" ");
		
		
		%>
	
	</h2>
	
	
	
	
	
	<h1 style="color:red">JSP Declaration : </h1>
	<h2>
	<!-- This is JSP declaration and we can declare so many method inside it -->
	<%!
	String greet(){
		return "Good Morning !";
	}
	
	boolean checkEven(int n){
		if(n%2==0) return true;
		return false;
	}
	boolean checkPrime(int n){
		if(n<=1) return false;
		else if(n==2) return true;
		for(int i=2; i<n/2; i++){
			if(n%i==0) return false;
		}
		return true;
	}
	%>
	<%=greet()%> <br>
	<%=checkEven(4)%> <br>
	<%=checkPrime(9) %><br>
	</h2>
	
	
	
	
	<h1 style="color:blue">JSP Comments : </h1>
	<h2>
	
	
	<%
	int y = 90;
	//out.print("Value of y : "+y);
	out.print(y/2);
	
	/* Here also commenting either single line or multiple line 
	work as same as java 
	*/
	%>
	
	<!--Line below, will throw an error because comment like this works in JSP Scriplet only -->
	<%=y%>
	
	
	
	<br>

	<!--Html comment can prevent only printable statement to be printed : -->
	<!--
	<%
	int z = 89;
	out.print("Value of z : "+z);
	%>
	-->
	
	
	
	<!-- Html comment can not prevent method or method call like this :   -->
	<!-- 
		<%
		//response.sendRedirect("https://google.com");
		%>
	-->
	
	
	<!-- To prevent such method to be exectuted or called we need JSP comment -->
	<%--
	response.sendRedirect("https://google.com");
	--%>
	
	</h2>
	
	
	
</body>
</html>