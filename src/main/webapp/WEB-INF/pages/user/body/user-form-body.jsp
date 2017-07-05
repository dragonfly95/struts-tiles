<div style="padding:16px;background-color:blue;height:200px;">
<h1>This is body content </h1>
</div>
t1
<%
  String message = (String)request.getAttribute("message");
%>

<br/>
<%= message %>