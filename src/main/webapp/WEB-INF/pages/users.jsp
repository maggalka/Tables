<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Users Page</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #00f070;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }

    ul.paging {
      display: inline-block;
      margin:0 auto;
      padding: 0;
    }
    ul.paging li {
      display: inline;
      border: 1px solid #ccc;
      border-radius: 10%;
      color: #333;
      background: #00f070;
      float: left;
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 8px 16px;
      text-decoration: none;
    }
  </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>User List</h1>
<c:if test="${empty listUsers}">
  There are no users
</c:if>
<c:if test="${!empty listUsers}">

  <br/>
  <c:url var="searchuser" value="/searchresults"/>
  <form:form action="${searchuser}" commandName="user">
    <table width="30%">
        <td><input class="tg-4eph" type="submit" name="action" value="<spring:message text="Search"/>"/></td>
        <td>
          <form:label path="name">
            <spring:message text="Name"/>
          </form:label>
        </td>
        <td>
          <form:input path="name"/>
        </td>
      </tr>
    </table>
  </form:form>

  <c:if test="${empty user.name}">
    <h1>Add a new User</h1>
  </c:if>
  <c:if test="${!empty user.name}">
    <h1> Edit the user</h1>
  </c:if>

  <c:url var="addAction" value="/users/add"/>

  <form:form action="${addAction}" commandName="user">
    <table>
      <c:if test="${!empty user.name}">
        <tr>
          <td>
            <form:label path="id">
              <spring:message text="ID"/>
            </form:label>
          </td>
          <td>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
          </td>
        </tr>
      </c:if>
      <tr>
        <td>
          <form:label path="name">
            <spring:message text="Name"/>
          </form:label>
        </td>
        <td>
          <form:input path="name"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="age">
            <spring:message text="Age"/>
          </form:label>
        </td>
        <td>
          <form:input path="age"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="isAdmin">
            <spring:message text="Admin"/>
          </form:label>
        </td>
        <td>
          <!--form:input path="isAdmin"/-->
          <form:checkbox path="isAdmin" value="true"/>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <c:if test="${!empty user.name}">
            <input type="submit"
                   value="<spring:message text="Edit user"/>"/>
          </c:if>
          <c:if test="${empty user.name}">
            <input type="submit"
                   value="<spring:message text="Add user"/>"/>
          </c:if>
        </td>
      </tr>
    </table>
  </form:form>


  <table class="tg">
    <tr>
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
        <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<br/>
<br/>


<div style="align-content: center">
  <ul class="paging">
    <c:if test="${page > 1}">
      <li><a href="<c:url value="/users"/>">Back</a></li>
      <li><a href="<c:url value="/users"><c:param name="page" value="${page - 1}"/>${page - 1}</c:url>">Previous</a></li>
    </c:if>
    <li><spring:message text="${page}"/></li>
    <c:if test="${!empty listUsers}">
      <li><a href="<c:url value="/users"><c:param name="page" value="${page + 1}"/>${page + 1}</c:url>">Next</a></li>
    </c:if>
  </ul>
</div>



</body>
</html>

