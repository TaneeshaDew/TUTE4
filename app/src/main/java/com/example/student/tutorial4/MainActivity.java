package com.example.student.tutorial4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBhelper;

public class MainActivity extends AppCompatActivity {
    EditText txt_UserName,txt_Password;
    String username,password;
    DBhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_UserName=findViewById(R.id.txtUserName);
        txt_Password=findViewById(R.id.txtPassword);
        db=new DBhelper(this);
    }
    public void addInfo(View view){
        username = txt_UserName.getText().toString();
        password= txt_Password.getText().toString();

        boolean result=db.addUser(username,password);
        if(result == true){
            Toast.makeText(getApplicationContext(),"User added to DB",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(),"Fror in user adding",Toast.LENGTH_LONG).show();
        }
    }
}
