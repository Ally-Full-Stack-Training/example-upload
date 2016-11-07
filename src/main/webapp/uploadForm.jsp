<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<body>

<div>
    <c:out value="${message}"/>
</div>

<div>
    <form method="POST" enctype="multipart/form-data" action="/file/add">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
        </table>
    </form>
</div>

<div>
    <ul>
        <li th:each="file : ${files}">
        <c:forEach items="${files}" var="file">
                <a href="<c:out value="${file}"/>"><c:out value="${file}"/></a>
            </c:forEach>
        </li>

    </ul>
</div>

</body>
</html>