package com.example.benidictdulce.httpurlconnection_crud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.benidictdulce.httpurlconnection_crud.config.Config;
import com.example.benidictdulce.httpurlconnection_crud.request.RequestHandler;

import java.util.HashMap;

/**
 * Created by Benidict Dulce on 6/23/2016.
 */
public class Insert_User extends Activity implements View.OnClickListener{

        private Button btn_add;
        private EditText et_name, et_uname, et_pass;
        String name, uname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_user);

        cast();
        register();
    }

    private void cast(){
        btn_add  = (Button) findViewById(R.id.btn_add);

        et_name = (EditText) findViewById(R.id.et_name);
        et_uname = (EditText) findViewById(R.id.et_uname);
        et_pass  = (EditText) findViewById(R.id.et_pass);
    }

    private void register(){
        btn_add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
               if (et_name.getText().toString().length() == 0){
                   et_name.setError("Required Field!");
               }else if(et_uname.getText().toString().length() == 0){
                   et_uname.setError("Required Field!");
               }else if (et_pass.getText().toString().length() == 0){
                   et_pass.setError("Required Field!");
               }else{
                   insert();
               }

                break;
        }
    }

    private void insert(){
        name = et_name.getText().toString().trim();
        uname = et_uname.getText().toString().trim();
        pass = et_pass.getText().toString().trim();
        class Insert extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(Insert_User.this, "Inserting...", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_NAME, name);
                hashMap.put(Config.KEY_UNAME, uname);
                hashMap.put(Config.KEY_PASS, pass);

                RequestHandler requestHandler = new RequestHandler();
                String rh = requestHandler.sendPostRequest(Config.URL_INSERT, hashMap);
                return rh;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Toast.makeText(Insert_User.this, "Add User Successful!!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Insert_User.this, MainActivity.class);
                startActivity(intent);
            }
        }
        Insert in = new Insert();
        in.execute();
    }


}
