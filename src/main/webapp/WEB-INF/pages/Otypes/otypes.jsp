<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Object types</title>
</head>
<body>
<a href="adminMain"> <-Back </a>
<div>
    <h2>
        Object types list:
    </h2>
</div>

<c:if test="${empty listOtypes}">
    There are no object types yet.
</c:if>
<c:if test="${!empty listOtypes}">
    <br/>
    <c:url var="searchOtype" value="/searchOtype"/>
    <form:form action="${searchOtype}" commandName="otype">
        <table width="30%">
            <tr>
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

    <c:if test="${empty otype.name}">
        <h1>Add a new object type</h1>
    </c:if>
    <c:if test="${!empty otype.name}">
        <h1> Edit object type</h1>
    </c:if>

    <c:url var="addAction" value="/otypes/add"/>

    <form:form action="${addAction}" commandName="otype">
        <table>
            <c:if test="${!empty otype.name}">
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
                    <form:label path="parent">
                        <spring:message text="Parent"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="parent"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty otype.name}">
                        <input type="submit"
                               value="<spring:message text="Edit object type"/>"/>
                    </c:if>
                    <c:if test="${empty otype.name}">
                        <input type="submit"
                               value="<spring:message text="Add object type"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>


    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="100">Name</th>
            <th width="60">Parent</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOtypes}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/otype/${otype.id}" target="_blank">${otype.name}</a></td>
                <td>${otype.parent}</td>
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
            <li><a href="<c:url value="/otypes"/>">Back</a></li>
            <li><a href="<c:url value="/otypes"><c:param name="page" value="${page - 1}"/>${page - 1}</c:url>">Previous</a></li>
        </c:if>
        <li><spring:message text="${page}"/></li>
        <c:if test="${!empty listUsers}">
            <li><a href="<c:url value="/otypes"><c:param name="page" value="${page + 1}"/>${page + 1}</c:url>">Next</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>
