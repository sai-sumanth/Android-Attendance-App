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

public class updatefacultyphone extends Activity {

    EditText edittextid;
    Button btnsubmit;
    TextView tv;
    Button submit;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatefacultyphone);

        edittextid=(EditText)findViewById(R.id.edittextid);
        btnsubmit=(Button)findViewById(R.id.btnSubmit1);
        tv=(TextView) findViewById(R.id.tv);
        edittext=(EditText) findViewById(R.id.edittext1);
        submit=(Button)findViewById(R.id.submit);



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextid.getText().toString().isEmpty()) {
                    Toast.makeText(updatefacultyphone.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id=edittextid.getText().toString();
                    DBAdapter dbAdapter = new DBAdapter(updatefacultyphone.this);
                    FacultyBean facultyBean = dbAdapter.getFacultyById(id);
                    tv.setText("ID                        "+facultyBean.getFaculty_id()+"\n"+"FIRSTNAME       "+facultyBean.getFaculty_firstname()+"\n"+
                            "SECONDNAME  "+facultyBean.getFaculty_lastname()+"\n"+"PHONE               "+facultyBean.getFaculty_mobilenumber()+"\n"+
                            "ADDRESS           "+facultyBean.getFaculty_address()+"\n"+"USERNAME      "+facultyBean.getFaculty_username()+"\n"+
                            "PASSWORD         "+facultyBean.getFaculty_password()+"\n");

                }

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittext.getText().toString().isEmpty()) {
                    Toast.makeText(updatefacultyphone.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String studentId=edittextid.getText().toString();
                    String phone=edittext.getText().toString();
                    DBAdapter dbAdapter=new DBAdapter(updatefacultyphone.this);
                    dbAdapter.updatefacultyphone(studentId,phone);

                    Intent intent=new Intent(updatefacultyphone.this,menufaculty.class);
                    startActivity(intent);
                    Toast.makeText(updatefacultyphone.this,"Update mobile number successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}