<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 31.08.2017
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
  <tr>
    <th>URL</th>
    <th>ShortURL</th>
    <th>Description</th>
    <th>Tag</th>
  </tr>
  <tr>
    <td>${urlById.url}</td>
    <td>${urlById.shortUrl}</td>
    <td>${urlById.description}</td>
    <td>${urlById.tag.nameTag}</td>
  </tr>

</table>
</body>
</html>
