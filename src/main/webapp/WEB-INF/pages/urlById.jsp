<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>DETAILS</h1>
  <table>
    <tr>
      <th>URL</th>
      <th>ShortURL</th>
      <th>Description</th>
      <th>UserName</th>
      <th>Tag</th>
    </tr>
      <tr>
        <td>${urlById.url}</td>
        <td>${urlById.shortUrl}</td>
        <td>${urlById.description}</td>
        <td>${urlById.user.userName}</td>
        <td><a href="/tagByName/${urlById.tag.nameTag}">${urlById.tag.nameTag}</a> </td>
      </tr>
  </table>
  <a href="/">home page</a>
</body>
</html>
