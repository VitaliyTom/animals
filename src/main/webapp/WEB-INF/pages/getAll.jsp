<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="image" uri="/WEB-INF/taglib/imageTag.tld" %>
<%@ taglib prefix="adi" uri="http://mycompany.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title>Title</title>

</head>
<body>
<div class="wrapper"  >
    <div align="right">
        <table align="center" class="animal">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>category</td>
                <td>img</td>
                <td>audio</td>
            </tr>
            <c:forEach var="ani" items="${getAllList}">
                <tr>
                    <td><c:out value="${ani.animalId}"/></td>
                    <td><c:out value="${ani.animalName}"/></td>
                    <td><c:out value="${ani.categoryAnimal}"/></td>
                    <td><img src="<image:imageTg imageByte="${ani.animalImage}"/>" height="50px" width="70px"></td>
                    <td>
                        <audio controls="controls" autobuffer="autobuffer">
                            <source src="<adi:audioTg soundByte="${ani.animalAudio}"/>">
                        </audio>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="block">
        <div align="left">
            <table align="center" class="category">
                <tr>
                    <td>id</td>
                    <td>category</td>
                </tr>
                <c:forEach var="cat" items="${getAllCategory}">
                    <tr>
                        <td>
                            <c:out value="${cat.categoryid}"/>
                        </td>
                        <td>
                            <c:out value="${cat.category}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div align="center" class="href__index">
            <a href="/">[ index ]</a>
        </div>
    </div>
</div>
</body>
</html>
