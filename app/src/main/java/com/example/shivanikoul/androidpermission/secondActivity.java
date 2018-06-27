package com.example.shivanikoul.androidpermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
    EditText OTP;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        OTP =findViewById(R.id.otp);
        button=findViewById(R.id.button);

        String message =getIntent().getStringExtra("message");
        final int x =Integer.valueOf(message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserOTP =OTP.getText().toString().trim();
                Integer y =Integer.valueOf(UserOTP);

                if(x==y) {
                    Toast.makeText(secondActivity.this,"successful submitted",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(secondActivity.this,"OTP wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
