package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student_information_system.R;

public class Facultydetails extends Activity {

    Button viewFaculty;
    Button btnfacultyid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultydetails);

        viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
        btnfacultyid=(Button)findViewById(R.id.btnfacultyid);



        viewFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Facultydetails.this,viewfaculty.class);
                startActivity(intent);
            }
        });
        btnfacultyid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Facultydetails.this,viewfacultyid1.class);
                startActivity(intent);
            }
        });
    }
}