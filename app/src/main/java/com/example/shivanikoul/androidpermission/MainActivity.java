package com.example.shivanikoul.androidpermission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText phoneEditText, messageEditText;
    private Button send;
    private static final int REQUEST_CODE_SMS = 101;

//    @SuppressLint("WrongViewCast"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneEditText = findViewById(R.id.num);
        messageEditText = findViewById(R.id.messageET);
        send = findViewById(R.id.sendBtn);
        String[] permission = {
                Manifest.permission.SEND_SMS
//                Manifest.permission.CAMERA
        };

//        Check yhe platform

        if (ActivityCompat.checkSelfPermission(this, permission[0]) != PackageManager.PERMISSION_GRANTED) {
//         if Permission is not granted

            ActivityCompat.requestPermissions(MainActivity.this, permission, REQUEST_CODE_SMS);
        }
         send.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String phoneNo =phoneEditText.getText().toString().trim();
                 String message =messageEditText.getText().toString().trim();
                 SmsManager sms =SmsManager.getDefault();
                 Random r =new Random();
                 int i1 =r.nextInt(9999 - 1111) +1111;
                 String messageNumber=i1+"";

                 sms.sendTextMessage(phoneNo,null,messageNumber,null,null);

//                 otp put
                 Intent intent =new Intent(MainActivity.this,secondActivity.class);
                 intent.putExtra("message",messageNumber);
                 startActivity(intent);
             }
         });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permission granted ", Toast.LENGTH_LONG).show();

            }else
                Toast.makeText(MainActivity.this,"Not guranted",Toast.LENGTH_SHORT).show();
        }
    }
}
