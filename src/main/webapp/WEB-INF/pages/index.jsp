<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShortenerURL</title>
</head>
<body>
<div>
  <h1>ShortenerURL</h1>
  <c:if test="${!empty urls}">
     <table>
       <tr>
           <th>URL</th>
           <th>ShortURL</th>
           <th>Description</th>
       </tr>
       <c:forEach items="${urls}" var="url1">
         <tr>
           <td>${url1.url}</td>
           <td>${url1.shortUrl}</td>
           <td>${url1.description}</td>
         </tr>
       </c:forEach>
     </table>
  </c:if>
  </div>
</body>
</html>
