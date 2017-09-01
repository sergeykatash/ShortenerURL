<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShortenerURL</title>
</head>
<body>
<div>
  <h1>ShortenerURL</h1>
    <a href="signup">Sign up</a>
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
           <td><a href="http://${url1.url}">
               <label>${url1.shortUrl}</label>   </a></td>
           <td><a href="/getUrl${url1.idLink}">more</a> </td>
         </tr>
       </c:forEach>
     </table>
  </c:if>
  </div>
</body>
</html>
