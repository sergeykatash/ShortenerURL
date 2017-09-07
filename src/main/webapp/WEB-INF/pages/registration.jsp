<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>REGISTRATION</h1>
<form:form method="post" action="addUser" commandName="user">
  <table>
    <tr>
      <td><form:label path="userName">
        UserName
      </form:label></td>
      <td><form:input path="userName" />
        <form:errors path="userName" ></form:errors></td>
    </tr>
    <tr>
      <td><form:label path="password">
        Password
      </form:label></td>
      <td><form:input path="password" />
      <form:errors path="password"></form:errors></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Registre"></td>
    </tr>
  </table>
</form:form>
<a href="/">back</a>
</body>
</html>
