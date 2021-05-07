package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

import java.util.ArrayList;

public class Studentdetails extends Activity {

    Button viewStudent;
    Button attendancePerStudent;
    Button btnstudentview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdetails);

        viewStudent=(Button)findViewById(R.id.buttonViewstudent);
        attendancePerStudent=(Button)findViewById(R.id.buttonviewfaculty);
        btnstudentview=(Button)findViewById(R.id.btnviewstudentid);

        viewStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Studentdetails.this,ViewStudentActivity.class);
                startActivity(intent);
            }
        });
        btnstudentview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Studentdetails.this,ViewStudentID.class);
                startActivity(intent);
            }
        });
        attendancePerStudent=(Button)findViewById(R.id.attendancePerStudentButton);
        attendancePerStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DBAdapter dbAdapter = new DBAdapter(Studentdetails.this);
                ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
                ((ApplicationContext)Studentdetails.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);

                Intent intent = new Intent(Studentdetails.this,ViewAttendancePerStudentActivity.class);
                startActivity(intent);

            }
        });
    }
}