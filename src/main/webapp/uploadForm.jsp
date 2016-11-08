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
        <c:forEach items="${files}" var="file">
            <p/>
                <img src="<c:out value="${file}"/>" width="200"/>
            </c:forEach>
</div>

</body>
</html>