package com.example.benidictdulce.httpurlconnection_crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_insert, btn_view_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cast();
        register();
    }

    private void cast(){
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_view_all = (Button) findViewById(R.id.btn_view_all);
    }

    private void register(){
        btn_insert.setOnClickListener(this);
        btn_view_all.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insert:
                Intent insert = new Intent(getApplicationContext(), Insert_User.class);
                startActivity(insert);
                break;
            case R.id.btn_view_all:
                Intent view = new Intent(getApplicationContext(), View_All_User.class);
                startActivity(view);
                break;
        }
    }
}
