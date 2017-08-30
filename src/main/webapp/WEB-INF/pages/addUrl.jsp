<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="addUrl" commandName="url">
  <table>
    <tr>
      <td><form:label path="url">
           Url
      </form:label></td>
      <td><form:input path="url" /></td>
    </tr>
    <tr>
      <td><form:label path="shortUrl">
        ShortURL
      </form:label></td>
      <td><form:input path="shortUrl" /></td>
    </tr>
    <tr>
      <td><form:label path="description">
        Description
      </form:label></td>
      <td><form:textarea path="description" /></td>
    </tr>
    <tr>
      <td><form:label path="tag.nameTag">
        Tag
      </form:label></td>
      <td><form:textarea path="tag.nameTag" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="addUrl"></td>
    </tr>
  </table>

</form:form>

</body>
</html>
