<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
        var req=false;
       function initialize()
       {
         if(window.XMLHttpRequest)
          {
           req=new XMLHttpRequest();
           }
           else if(window.ActiveXObject)
           {
            req=new ActiveXObject("Microsoft.XMLHTTP");
            }
         
           }
         function saveData()
         {
        	 
             initialize();
             var id=document.f1.id.value;
             
             var nm=document.f1.nm.value;
             
             var add=document.f1.add.value;
             
             var em=document.f1.em.value;
             
             
             var url="TestSave.jsp?id="+id+"&nm="+nm+"&add="+add+"&em="+em;
             if(req!=null)
             {
                 req.open("GET",url,true);
                 req.onreadystatechange=process1;
                 req.send(null);
             }
            
             else
             {
               //document.getElementById("test").innerHTML="";  
             }
          }
          function process1()
          {
           if(req.readyState==4)
           {
             if(req.status==200)
             {
            	 alert(req.responseText);
            	 document.getElementById("test").innerHTML="Data Inserted:" + req.responseText;
            	 document.f1.id.value="";
            	 document.f1.nm.value="";
            	 document.f1.add.value="";
            	 document.f1.em.value="";
              //alert(req.responseText);
             }
          }
             
      }     
  
    	
    	
    	</script>
<BODY>
    	<h1>Registration using Ajax </h1>
	<form name="f1">
	<table>
	<tr>
		<td>Id</td>
		<td>
		<input type="text" name="id"/>
		</td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="nm"/>
		</td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="add"/>
		</td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="em"/>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="button" value="Submit" onclick="saveData()"/></td>
	</tr>
	</table>
	 <div id="test"></div>
	</form>
</BODY>

 </html>