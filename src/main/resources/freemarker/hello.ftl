<#-- @ftlvariable name="date" type="java.lang.String" -->
<#-- @ftlvariable name="message" type="java.lang.String" -->

<!DOCTYPE HTML>
<html>
<head>
    <title>Spark Java</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<#--<link rel="icon" type="image/png" sizes="32x32" href="../images/favicon-32x32.png"/>-->
    <!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          crossorigin="anonymous"/>
    <!-- JS -->
    <script src="https://code.jquery.com/jquery-1.12.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>${message}</h1>
<h2>The above text is set using a FreeMarkerEngine</h2>
<hr>
${date}
</body>
</html>