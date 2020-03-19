package com.example.leony.project_leony_rentia_vira;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText input_name;
    private EditText input_username;
    private EditText input_password;

    private Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Inisialisasi dari View
        input_name = (EditText) findViewById(R.id.input_name);
        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);

        button_register = (Button) findViewById(R.id.button_register);

        //Setting listeners to button
        button_register.setOnClickListener(this);
    }

    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addUser(){

        final String name = input_name.getText().toString().trim();
        final String us = input_username.getText().toString().trim();
        final String pw = input_password.getText().toString().trim();

        class AddUsers extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_USER_nama,name);
                params.put(konfigurasi.KEY_USER_us,us);
                params.put(konfigurasi.KEY_USER_pw,pw);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_User, params);
                return res;
            }
        }

        AddUsers ae = new AddUsers();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == button_register){
            addUser();
        }
    }


}