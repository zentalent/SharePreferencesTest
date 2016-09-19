package com.android.extremez.sharepreferencestest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button saveData;
    private Button restoreData;
    private EditText reg_account;
    private EditText reg_password;
    private EditText reg_age;
    private RadioButton reg_merried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.signup);

        saveData = (Button)findViewById(R.id.reg_signup);
        reg_account = (EditText)findViewById(R.id.reg_accountText);
        reg_age = (EditText)findViewById(R.id.reg_ageText);
        reg_merried = (RadioButton)findViewById(R.id.merried);
        reg_password = (EditText)findViewById(R.id.reg_passwordText);
        restoreData = (Button)findViewById(R.id.load);


        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("Data",MODE_PRIVATE).edit();
                editor.putString("Account", reg_account.getText().toString());
                editor.putInt("age",Integer.valueOf(reg_age.getText().toString()));
                editor.putBoolean("married", reg_merried.isChecked());
                editor.putString("Password",reg_password.getText().toString());
                editor.commit();
            }
        });

        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("Data",MODE_PRIVATE);
                String name = pref.getString("Account", "");
                int age = pref.getInt("age", 0);
                boolean merried = pref.getBoolean("married", false);
                String psw = pref.getString("Password","");
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,reg_age.getText().toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,psw,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,merried?"Merried":"Single",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
