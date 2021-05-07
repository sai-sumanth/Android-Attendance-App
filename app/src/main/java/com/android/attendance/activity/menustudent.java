package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

import java.util.ArrayList;

public class menustudent extends Activity {

    Button addStudent;
    Button viewStudent;
    Button logout;
    Button attendancePerStudent;
    Button btndeletestudent;
    Button btnstudentview;
    Button btnupdateaddress;
    Button btnupdatephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menustudent);

        addStudent =(Button)findViewById(R.id.buttonaddstudent);
        viewStudent =(Button)findViewById(R.id.buttonViewstudent);
        logout =(Button)findViewById(R.id.btnout);
        btndeletestudent=(Button)findViewById(R.id.btndeletestudent);
        btnstudentview=(Button)findViewById(R.id.btnviewstudentid);
        btnupdateaddress=(Button)findViewById(R.id.btnupdateaddress);
        btnupdatephone=(Button)findViewById(R.id.btnupdatephone);

        addStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(menustudent.this,AddStudentActivity.class);
                startActivity(intent);
            }
        });

        btndeletestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menustudent.this,DeleteStudentActivity.class);
                startActivity(intent);

            }
        });
        viewStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(menustudent.this,ViewStudentActivity.class);
                startActivity(intent);
            }
        });
        btnstudentview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menustudent.this,ViewStudentID.class);
                startActivity(intent);
            }
        });
        btnupdateaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menustudent.this,updatestudentaddress.class);
                startActivity(intent);
            }
        });
        btnupdatephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(menustudent.this,updatestudentphone.class);
                startActivity(intent);
            }
        });
        attendancePerStudent=(Button)findViewById(R.id.attendancePerStudentButton);
        attendancePerStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DBAdapter dbAdapter = new DBAdapter(menustudent.this);
                ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
                ((ApplicationContext)menustudent.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);

                Intent intent = new Intent(menustudent.this,ViewAttendancePerStudentActivity.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}