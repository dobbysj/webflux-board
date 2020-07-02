<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title><tiles:insertAttribute name="title" ignore="true" defaultValue="유영 STANDARD"/></title>
    <tiles:insertAttribute name="meta"/>
    <tiles:insertAttribute name="common"/>
	<tiles:insertAttribute name="script" ignore="true"/>
  </head>
   <body>
    <div id="wrapper">
      <tiles:insertAttribute name="header"/>
      <tiles:insertAttribute name="content"/>
      <tiles:insertAttribute name="footer"/>
    </div>
  </body>
</html>