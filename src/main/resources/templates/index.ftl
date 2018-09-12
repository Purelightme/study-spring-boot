<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>${name}</h3>
<#list userList as user>
  <p>${user.name}</p>
</#list>
</body>
</html>