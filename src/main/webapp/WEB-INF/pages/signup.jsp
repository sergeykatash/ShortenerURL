<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ShortenerURL</title>
</head>
<body>
<div>
  <h1>PROFILE</h1>
  <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
  <c:if test="${!empty urls}">
    <table>
      <tr>
        <th>URL</th>
        <th>ShortURL</th>
        <th>Description</th>
        <th>Tag</th>
      </tr>
      <c:forEach items="${urls}" var="url1">
        <tr>
          <td>${url1.url}</td>
          <td>${url1.shortUrl}</td>
          <td>${url1.description}</td>
          <td>${url1.tag.nameTag}</td>
          <td><a href="editUrl/${url1.idLink}"/>Edit</a> </td>
          <td><a href="deleteUrl/${url1.idLink}">Delete</a> </td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
<a href="addUrl">GENERATE SHORT_URL</a>
</body>
</html>