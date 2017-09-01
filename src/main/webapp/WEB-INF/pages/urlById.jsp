
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
        <td><a href="/tagByName/${urlById.tag.nameTag}">${urlById.tag.nameTag}</a> </td>
      </tr>

  </table>
  <a href="/">home page</a>
</body>
</html>
