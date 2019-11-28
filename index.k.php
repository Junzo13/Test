<!doctype html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>掲示板</title>
        <link rel="stylesheet" type="text/css" href="style.k.css">
    </head>
    <body link="white" vlink="white">
        <?php
            mb_internal_encoding("utf8");

            $pdo = new PDO("mysql:dbname=lesson01;host=localhost;","root","mysql");

            $stmt = $pdo->query("select * from keijiban");
        
        ?>
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
        <div class="left">
        <h2>掲示板</h2>
        <form method="post" action="insert.k.php">
            <h1>入力画面</h1>
            <div>
                <label>ハンドルネーム</label>
                <br>
                <input type="text" class="text" size="35" name="handlename">
            </div>
            
            <div>
                <label>タイトル</label>
                <br>
                <input type="text" class="text" size="35" name="title">
            </div>
            
            <div>
                <label>コメント</label>
                <br>
                <textarea cols="80" rows="10" name="comments"></textarea>
            </div>
            
            <div>
                <input type="submit" class="submit" value="投稿する">
            </div>
        </form>
        <?php
        
        while($row=$stmt->fetch()){
        
        echo "<div class='kiji'>";
        echo "<h3>".$row['title']."</h3>";
        echo "<div class='contents'>";
        echo $row['comments'];
        echo "<div class='handlename'>posted by".$row['handlename']."</div>";
        echo "</div>";
        echo "</div>";
        }
        
        ?>
        </div>
        <div class="right">
                    <h4>人気の記事</h4>
                    <div class="list">
                        <ul>
                            <li>PHPオススメの本</li>
                            <li>PHP MyAdminの使い方</li>
                            <li>今人気のエディタ&nbsp;TOP5</li>
                            <li>HTMLの基礎</li>
                        </ul><br>
                    <h4>オススメリンク</h4>    
                        <ul>
                            <li>インターノウス株式会社</li>
                            <li>XAMPPダウンロード</li>
                            <li>Edispseのダウンロード</li>
                            <li>Bracketsのダウンロード</li>
                        </ul><br>
                    <h4>カテゴリ</h4>    
                        <ul>
                            <li>HTML</li>
                            <li>PHP</li>
                            <li>MySQL</li>
                            <li>JavaScript</li>
                        </ul>
                    </div>
                </div> 
    </body>
    <footer>
            coryright(c) all right reserved photto 2015-2019
    </footer>
</html>