<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="body_bg">

    <h3>register here</h3>
    <c:if test="${not empty successMsg}">
    <h4>${successMsg}</h4>
    </c:if>
    <c:if test="${not empty errorMsg}">
    <h4>${errorMsg}</h4>
    </c:if>

    <form action="regForm" method="POST">

        name: <input type="text" name="name">
        email: <input type="email" name="email">
        password: <input type="password" name="password">
        <input type="submit" value="Register">


    </form>


<!--<script src="scripts.js"></script>-->
</body>
</html>