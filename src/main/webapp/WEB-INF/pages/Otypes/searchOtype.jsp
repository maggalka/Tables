<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Search results</title>
</head>
<body>
<a href="otypes">Back to oject types list</a>
<br/>
<br/>
<h1>Search results</h1>

<c:if test="${empty listOtypes}">
  There are no users
</c:if>
<c:if test="${!empty listOtypes}">
  <table class="tg">
    <tr class="param">
      <th width="80">ID</th>
      <th width="100">Name</th>
      <th width="60">Age</th>
      <th width="60">Admin</th>
      <th width="150">Create Date</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td><a href="/userdata/${user.id}" target="_blank">${user.name}</a></td>
        <td>${user.age}</td>
        <td>${user.isAdmin}</td>
        <td>${user.createDate}</td>
        <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a> </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
