package com.example.benidictdulce.httpurlconnection_crud;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benidictdulce.httpurlconnection_crud.config.Config;
import com.example.benidictdulce.httpurlconnection_crud.request.RequestHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Benidict Dulce on 6/23/2016.
 */
public class View_User extends Activity implements View.OnClickListener{

     String id, hold_name;

    EditText et_id, et_name, et_username, et_password;
    TextView tv_id, tv_name, tv_username, tv_passowrd;

    Button btn_up, btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_user);


        Intent intent = getIntent();
        id = intent.getStringExtra(Config.BASE_ID);

        et_id  = (EditText)findViewById(R.id.et_id);
        tv_id = (TextView) findViewById(R.id.tv_id);

        et_id.setText(id);
        tv_id.setText(id);
        et_id.setEnabled(false);

        cast();
        register();
        getUser();
    }

    private void cast(){
        et_name = (EditText)findViewById(R.id.et_name);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_username = (TextView)findViewById(R.id.tv_username);
        tv_passowrd = (TextView) findViewById(R.id.tv_password);

        btn_up = (Button) findViewById(R.id.btn_up);
        btn_delete = (Button) findViewById(R.id.btn_delete);
    }

    private void register(){
        btn_up.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    private void getUser(){
        class GetUser extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(View_User.this, "Retrieving Data...", "Please wait...",false,false);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GetUser, id);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                showUser(s);
            }
        }
        GetUser gu = new GetUser();
        gu.execute();
    }

    private void showUser(String json){
        JSONObject jsonObject;
        try{
            jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_ARRAY);
            JSONObject js = result.getJSONObject(0);
            String name = js.getString(Config.TAG_NAME);
            String username = js.getString(Config.TAG_UNAME);
            String password = js.getString(Config.TAG_PASS);

            tv_name.setText(name);
            tv_username.setText(username);
            tv_passowrd.setText(password);
            hold_name = tv_name.getText().toString();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateUser(){
        final String name, username, password;
        name = et_name.getText().toString().trim();
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();

        class UpdateUser extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(View_User.this, "Updating Data...", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Config.TAG_ID, id);
                hashMap.put(Config.KEY_NAME, name);
                hashMap.put(Config.KEY_UNAME, username);
                hashMap.put(Config.KEY_PASS, password);

                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(Config.URL_UpdateUser, hashMap);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Updating Successfully...",Toast.LENGTH_LONG).show();
            }
        }
        UpdateUser uu = new UpdateUser();
        uu.execute();
    }

    private void deleteUser(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure you want to remove" + hold_name + " from the User List?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                delUser();
                startActivity(new Intent(View_User.this, View_All_User.class));
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void delUser(){
        class DelUser extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(View_User.this, "Deleting Data...", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_DeleteUser, id);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Delete Successfully!!...",Toast.LENGTH_LONG).show();
            }
        }
        DelUser du = new DelUser();
        du.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_up:
                updateUser();
                break;
            case R.id.btn_delete:
                deleteUser();
                break;
        }
    }
}
