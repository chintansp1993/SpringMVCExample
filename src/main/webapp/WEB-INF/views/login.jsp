<%@ include file = "commons/header.jspf" %>
<%@ include file = "commons/navbar.jspf" %>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login" method="POST">
        Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input class="btn btn-success" type="submit" />
    </form>
</body>
</html>