<?php
$Name    = htmlspecialchars($_POST['Name']);
$Mail    = htmlspecialchars($_POST['Mail']);
$Comment = htmlspecialchars($_POST['Comment']);

$FILE    = "comments/" . date('d-m-Y'). "-" . md5(rand(10000, 99999) . rand(10000, 99999)) . ".txt";
$String  = "Name: " . $Name . "\r\n" . "Mail: " . $Mail. "\r\n" . "Comment: " . $Comment . "\r\n";
$Write   = fopen($FILE, "w+");
$wrote   = fwrite($Write, $String);

fclose($Write);

echo "Ok";
?>