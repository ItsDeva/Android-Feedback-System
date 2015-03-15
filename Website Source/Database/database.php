<?php
$db_host     = "";
$db_user     = "";
$db_password = "";
$db_name     = "";

$Name    = htmlspecialchars($_POST['Name']);
$Mail    = htmlspecialchars($_POST['Mail']);
$Comment = htmlspecialchars($_POST['Comment']);

mysql_connect($db_host, $db_user, $db_password) or die("Database Error");
mysql_select_db($db_name) or die("Database Error");

mysql_query("INSERT INTO comments (name, mail, msg, send) VALUES('{$Name}', '{$Mail}', '{$Comment}', NOW())");	
?>