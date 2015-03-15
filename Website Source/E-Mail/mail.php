<?php

$Name    = htmlspecialchars($_POST['Name']);
$Mail    = htmlspecialchars($_POST['Mail']);
$Comment = htmlspecialchars($_POST['Comment']);
$To      = "your@email.ext";
$Subject = "You have a new comment from: " . $Name;

$MSG     = '<html><head></head><body><table>
<tr>
<td>Naam:</td>
<td>'.$Name.'</td>
</tr>
<tr>
<td>E-Mail:</td>
<td>'.$Mail.'</td>
</tr>
<tr>
<td>Opmerking:</td>
<td>'.$Comment.'</td>
</tr>
</table><br>'. date("i:G, d-m-Y") .'</body></html>';


mail($To, $Subject, $MSG, 'Content-type: text/html; charset=iso-8859-1' . "\r\n");

$Headers  = 'MIME-Version: 1.0' . "\r\n";
$Headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";

echo '<b>Message is sent.</b>';
?>