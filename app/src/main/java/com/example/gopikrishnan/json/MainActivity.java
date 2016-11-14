package com.example.gopikrishnan.json;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onclick();
    }

public void onclick(){
    Button button = (Button) findViewById(R.id.button);
    String ind;
    button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        URL url = new URL("https://date.jsontest.com/");//initializing url
                        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                        conn.setRequestMethod(GET);
                        InputStream in = new BufferedInputStream(conn.getInputStream());
                        ind = in.toString(); //Converting the input to a String

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    );

}
}
