<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>EDIT FORM</h1>
<form:form method="post" action="/edit" commandName="url">
  <table>
    <tr>
      <td>URL</td>
      <td>${url.url}</td>
    </tr>
    <tr>
      <td><form:hidden path="idLink"/></td>
      <td><form:hidden path="url"/></td>
      <td><form:hidden path="tag.idTag"/></td>
      <td><form:hidden path="user.id"/></td>
      <td><form:hidden path="user.userName"/></td>
      <td><form:hidden path="user.password"/></td>
      <td><form:hidden path="user.role"/></td>
    </tr>
    <tr>
      <td><form:label path="description">
        Description
      </form:label></td>
      <td><form:textarea path="description" value="${url.description}"/></td>
    </tr>
    <tr>
      <td><form:label path="tag.nameTag">
        Tag
      </form:label></td>
      <td><form:input path="tag.nameTag" value="${url.tag.nameTag}"/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="EDIT"></td>
    </tr>
  </table>
</form:form>
<a href="/signup">profile</a>
</body>
</html>
