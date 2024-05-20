<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 11/03/2024
  Time: 8:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email"  method="post" action="/email/save">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td>Languages</td>
            <td colspan="2"><form:select path="languages" items="${languageList}"/>
        </tr>

        <tr>
            <td>Page size</td>
            <td colspan="2">show <form:select path="pageSize">
                <form:options items="${pageSizeList}"/>
            </form:select>
                emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter</td>
            <td colspan="2"><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td colspan="2"><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
            <td><form:button>Cancel</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>