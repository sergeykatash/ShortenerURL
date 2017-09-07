<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>URLS BY TAG</h1>
<c:if test="${!empty urls}">
  <table>
    <tr>
      <th>URL</th>
      <th>ShortURL</th>
      <th>More</th>
    </tr>
    <c:forEach items="${urls}" var="url1">
      <tr>
        <td>${url1.url}</td>
        <td>${url1.shortUrl}</td>
        <td><a href="/getUrl${url1.idLink}">details</a> </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/">home page</a>
</body>
</html>
