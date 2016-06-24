package com.example.benidictdulce.httpurlconnection_crud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benidictdulce.httpurlconnection_crud.adapter.RecyclerViewAdapter;
import com.example.benidictdulce.httpurlconnection_crud.config.Config;
import com.example.benidictdulce.httpurlconnection_crud.pojo.User;
import com.example.benidictdulce.httpurlconnection_crud.request.RequestHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benidict Dulce on 6/23/2016.
 */
public class View_All_User extends Activity{

    RecyclerViewAdapter adapter;
    List<User> userList;
    RecyclerView recyclerView;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_user);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getJson();
    }

    public void getJson(){
        class GetJson extends AsyncTask<Void, Void, String>{
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(View_All_User.this, "Retrieving Data...", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendgetRequest(Config.URL_Display);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                JSON_STRING = s;
                showUser();
            }
        }
        GetJson gj = new GetJson();
        gj.execute();
    }

    private void showUser(){
        JSONObject jsonObject;
        try{
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.optJSONArray(Config.TAG_ARRAY);
            userList = new ArrayList<>();
            for (int i = 0 ;i<result.length(); i++){
                JSONObject j  = result.optJSONObject(i);
                User user = new User();
                user.setId(j.optString(Config.TAG_ID));
                user.setName(j.optString(Config.TAG_NAME));
                user.setUname(j.optString(Config.TAG_UNAME));
                user.setPass(j.optString(Config.TAG_PASS));

                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        adapter = new RecyclerViewAdapter(this, userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
