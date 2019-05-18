package com.example.android.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private SharedPreferences myPrefs;
private SharedPreferences.Editor editor;
String gnname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final EditText name=(EditText)findViewById(R.id.name);
        final EditText password=(EditText)findViewById(R.id.password);
     final   ArrayList<String> arrPackage = new ArrayList<>();


        TextView login=(TextView)findViewById(R.id.login);

         Button save=findViewById(R.id.save);
        myPrefs = getPreferences(Context.MODE_PRIVATE);
      final  String nam=myPrefs.getString("prefID",null);
      final  String gnname=name.getText().toString();
        arrPackage.add("one");


        Log.v("TAG", "name: "+nam);


        name.setText(nam==null?"Hello":nam);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




            }
        });
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            
                     String gnname=name.getText().toString();
                 password.setText(""+gnname);

                   arrPackage.add(gnname);

                     editor = myPrefs.edit();
                     editor.putString("prefID", arrPackage.toString());
                     Log.v("TAG", "preferences stored " + gnname);
                     editor.apply();
                 }


             });
     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String entername = name.getText().toString();


                 String nam = myPrefs.getString("prefID", null);
                 if (entername.equals(nam)) {
                     Intent intent = new Intent(MainActivity.this, submainactivity.class);
                     startActivity(intent);
                 }


         }});


    }
}
