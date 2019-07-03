<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8"/>
    <title>update category</title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<h1><spring:message code="update.category"/></h1>
<div align="center" class="update-category">
    <springform:form method="post" action="${contextPath}/updateCategory" enctype="multipart/form-data"
                     modelAttribute="newCategory">
        <br>
        <spring:message code="Enter.categories.id"/>: <springform:input type="text" path="categoryIdDto"/>
        <springform:errors path="categoryIdDto"/>
        <br>
        <spring:message code="Enter.a.category.in.Russian"/>: <springform:input type="text" path="nameCategoryRus"/>
        <springform:errors path="nameCategoryRus"/>
        <br>
        <spring:message code="Enter.a.category.in.English"/>: <springform:input type="text" path="nameCategoryEng"/>
        <springform:errors path="nameCategoryEng"/>
        <br>
        <spring:message code="Upload.logo"/>: <springform:input type="file" path="logo" accept="image/*"/>
        <springform:errors path="logo"/>
        <br>
        <input type="submit" value="<spring:message code="save.category"/>"/>
    </springform:form>
    <p><a href="${contextPath}">[ index ]</a></p>
    <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
</div>
</body>
</html>

