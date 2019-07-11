package com.example.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to;
    EditText sub;
    EditText msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        to = (EditText) findViewById(R.id.btn_to);
        sub = (EditText) findViewById(R.id.btn_sub);
        msg = (EditText) findViewById(R.id.btn_msg);
        send = (Button)findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }
        });
    }
    public void sendmail()
    {
        String list = to.getText().toString();
        String[] receive = list.split(",");
        String subject = sub.getText().toString();
        String message;
        message = msg.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL,receive);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

       intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent,"Choose an email"));

    }
}