package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

public class DeleteFacultyActivity extends Activity {

    EditText etid;
    Button btnsubmit;
    TextView tv,tv1;
    Button btnno;
    Button btnyes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_faculty);

        etid=(EditText)findViewById(R.id.etid);
        btnsubmit=(Button) findViewById(R.id.btnsubmit);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        btnno=findViewById(R.id.btnno);
        btnyes=findViewById(R.id.btnyes);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etid.getText().toString().isEmpty()) {
                    Toast.makeText(DeleteFacultyActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id=etid.getText().toString();
                    DBAdapter dbAdapter = new DBAdapter(DeleteFacultyActivity.this);
                    FacultyBean facultyBean = dbAdapter.getFacultyById(id);
                    tv.setText("ID                        "+facultyBean.getFaculty_id()+"\n"+"FIRSTNAME       "+facultyBean.getFaculty_firstname()+"\n"+
                            "SECONDNAME  "+facultyBean.getFaculty_lastname()+"\n"+"PHONE               "+facultyBean.getFaculty_mobilenumber()+"\n"+
                            "ADDRESS           "+facultyBean.getFaculty_address()+"\n"+"USERNAME      "+facultyBean.getFaculty_username()+"\n"+
                            "PASSWORD         "+facultyBean.getFaculty_password()+"\n");

                    tv1.setText("ARE YOU SURE TO DELETE "+facultyBean.getFaculty_id());

                }

            }
        });


        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etid.getText().toString().isEmpty()) {
                    Toast.makeText(DeleteFacultyActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                    String faculty_id=etid.getText().toString();
                    DBAdapter dbAdapter= new DBAdapter(DeleteFacultyActivity.this);
                    dbAdapter.deleteFaculty(faculty_id);

                    Intent intent =new Intent(DeleteFacultyActivity.this,menufaculty.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Faculty deleted successfully", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DeleteFacultyActivity.this,menufaculty.class);
                startActivity(intent);
            }
        });


    }
}