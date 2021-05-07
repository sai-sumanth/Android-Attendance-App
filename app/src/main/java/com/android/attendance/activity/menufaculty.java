package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student_information_system.R;

public class menufaculty extends Activity {


    Button addFaculty;
    Button viewFaculty;
    Button btndeletefaculty;
    Button btnfacultyid;
    Button btnupdateaddress;
    Button btnupdatephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menufaculty);


        addFaculty =(Button)findViewById(R.id.buttonaddfaculty);
        viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
        btndeletefaculty=(Button)findViewById(R.id.btndeletefaculty);
        btnfacultyid=(Button)findViewById(R.id.btnfacultyid);
        btnupdateaddress=(Button)findViewById(R.id.btnupdateaddress);
        btnupdatephone=(Button)findViewById(R.id.btnupdatephone);

        addFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(menufaculty.this,AddFacultyActivity.class);
                startActivity(intent);
            }
        });


        btndeletefaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(menufaculty.this,DeleteFacultyActivity.class);
                startActivity(intent);
            }
        });

        viewFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(menufaculty.this,ViewFacultyActivity.class);
                startActivity(intent);
            }
        });
        btnfacultyid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menufaculty.this,ViewFacultyID.class);
                startActivity(intent);
            }
        });
        btnupdateaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menufaculty.this,updatefacultyaddress.class);
                startActivity(intent);
            }
        });
        btnupdatephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menufaculty.this,updatefacultyphone.class);
                startActivity(intent);

            }
        });
    }
}