# Android Feedback System #
This is an Android feedback system that all post to a PHP script which, for example, send to an email address or in a MySQL database writes or you can also choose the script all in one text file writes.

# Screenshots #
![Screenshot](https://raw.githubusercontent.com/BastiaanDeHart/Android-Feedback-System/master/Screenshots/screenshot-1.png)

![Screenshot](https://raw.githubusercontent.com/BastiaanDeHart/Android-Feedback-System/master/Screenshots/screenshot-2.png)

# How to use #

There are various PHP scripts included with the package and you can also choose what happens to the feedback that he is sent by the user. The different scripts are:

 - The MySQL database package is a script that if user send via the Android app is written it in a MySQL database.
 - The Email package is a script that if user send a mail via the Android app with all information sent.
 - Writing to a file package is a script that if the user something shipping via the Android app is there on the server a.TXT file with everything the user entered all files are stored in a folder.

# Installing #
Installing actually very easy you just have to install the above mentioned packages a ban and to search for the following line in the Android Source Code:

    HttpPost httppost = new HttpPost("http://code.bastiaan.pw/run.php");

You should of course change my link in your own link and you should also change the script name so that everything is working properly

# Report Issues/Bugs #
[Bugs](https://github.com/bastiaandehart/Android-Feedback-System/issues)

# Credits #
Author: Bastiaan de Hart

- [Github](http://github.com/bastiaandehart)
- [My website](http://bastiaan.pw/)

Email: [me@bastiaan.pw](mailto:me@bastiaan.pw)

 