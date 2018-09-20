<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>上传文件：</h1>
<div>
    <form method="POST" enctype="multipart/form-data" action="/upload/do-upload">
        <table>
            <tr>
                <td>上传文件:</td>
                <td><input type="file" name="file"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>