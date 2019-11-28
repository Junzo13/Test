<?php
mb_internal_encoding("utf8");

$pdo = new PDO("mysql:dbname=lesson01;host=localhost;","root","mysql");

$pdo->exec("insert into contactform(name,mail,age,comments)
values('".$_POST['name']."','".$_POST['mail']."','".$_POST['age']."','".$_POST['comments']."');");

?>

<!doctype html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>contact us</title>
        <link rel="stylesheet" type="text/css" href="style2.css">
    </head>
    <body link="white" vlink="white">
        <label><a href="index3.html"><img src="logo.jpg" width="400px" height="110px"></a></label>
        <header>
            <ul>
                <li><a href="index3.html">home</a></li>
                <li><a href="index.html">online shop</a></li>
                <li><a href="index5.html">about us</a></li>
                <li>recruit</li>
                <li><a href="index6.html">contact us</a></li>
                <li><a href="index.k.php">掲示板</a></li>
            </ul>
        </header>
        <h1>お問い合わせを承りました</h1>
        
        <div class="confirm">
            <p>お問い合わせありがとうございました。<br>3営業日以内に担当者よりご連絡差し上げます。
            </p>
        </div>
        <footer>
            coryright(c) all right reserved photto 2015-2019
        </footer>
    </body>
</html>