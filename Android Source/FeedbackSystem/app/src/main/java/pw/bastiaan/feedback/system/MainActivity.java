package pw.bastiaan.feedback.system;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void ButtonSend(View v) {
        SendDialog(this);
    }

    public void ButtonReset(View v) {
        RESET();
    }

    public void SendDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle(R.string.dialog_title);

        alertDialogBuilder
                .setMessage(R.string.dialog_message)
                .setCancelable(true)
                .setPositiveButton(R.string.dialog_button_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        postData();
                        RESET();
                    }
                })

                .setNegativeButton(R.string.dialog_button_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void postData() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://code.bastiaan.pw/run.php");

        EditText Name = (EditText) findViewById(R.id.editText);
        String NameOut = Name.getText().toString();

        EditText Mail = (EditText) findViewById(R.id.editText2);
        String MailOut = Mail.getText().toString();

        EditText Comment = (EditText) findViewById(R.id.editText3);
        String CommentOut = Comment.getText().toString();

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("Name", NameOut));
            nameValuePairs.add(new BasicNameValuePair("Mail", MailOut));
            nameValuePairs.add(new BasicNameValuePair("Comment", CommentOut));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // Do nothing
        } catch (IOException e) {
            // Do nothing
        }
    }

    public void RESET() {
        EditText editText1 = (EditText) findViewById(R.id.editText);
        editText1.setText("");

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setText("");

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        editText3.setText("");
    }
}
