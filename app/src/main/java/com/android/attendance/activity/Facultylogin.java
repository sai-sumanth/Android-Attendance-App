package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student_information_system.R;

public class Facultylogin extends Activity {


    Button btnstudent;
    Button btnfaculty;
    Button btnattendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultylogin);
        btnstudent=(Button)findViewById(R.id.btnstudent);
        btnfaculty=(Button)findViewById(R.id.btnfaculty);
        btnattendance=(Button)findViewById(R.id.btnattendance);

        btnattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Facultylogin.this,AddAttandanceSessionActivity.class);
                startActivity(intent);
            }
        });
        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Facultylogin.this,Studentdetails.class);
                startActivity(intent);
            }
        });
        btnfaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Facultylogin.this,Facultydetails.class);
                startActivity(intent);
            }
        });

    }
}