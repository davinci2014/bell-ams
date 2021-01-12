<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
timestamp: ${timestamp?datetime}<br>
status: ${status}<br>
error: ${error}<br>
exception: ${exception}<br>
message: ${message}<br>
path: ${path}<br>
<textarea readonly style="display: none">${trace}</textarea>
</body>
</html>