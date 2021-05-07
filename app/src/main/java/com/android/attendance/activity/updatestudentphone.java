package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.StudentBean;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

public class updatestudentphone extends Activity {


    EditText edittextid;
    Button btnsubmit;
    TextView tv;
    Button submit;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatestudentphone);

        edittextid=(EditText)findViewById(R.id.edittextid);
        btnsubmit=(Button)findViewById(R.id.btnSubmit1);
        tv=(TextView) findViewById(R.id.tv);
        edittext=(EditText) findViewById(R.id.edittext1);
        submit=(Button)findViewById(R.id.submit);



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextid.getText().toString().isEmpty()) {
                    Toast.makeText(updatestudentphone.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id=edittextid.getText().toString();
                    DBAdapter dbAdapter = new DBAdapter(updatestudentphone.this);
                    StudentBean studentBean = dbAdapter.getStudentById(id);
                    tv.setText("ID                        "+studentBean.getStudent_id()+"\n"+"FIRSTNAME       "+studentBean.getStudent_firstname()+"\n"+
                            "SECONDNAME  "+studentBean.getStudent_lastname()+"\n"+"PHONE               "+studentBean.getStudent_mobilenumber()+"\n"+
                            "ADDRESS           "+studentBean.getStudent_address()+"\n"+"DEPARTMENT      "+studentBean.getStudent_department()+"\n");

                }

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittext.getText().toString().isEmpty()) {
                    Toast.makeText(updatestudentphone.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String studentId=edittextid.getText().toString();
                    String phone=edittext.getText().toString();
                    DBAdapter dbAdapter=new DBAdapter(updatestudentphone.this);
                    dbAdapter.updatestudentphone(studentId,phone);

                    Intent intent=new Intent(updatestudentphone.this,menustudent.class);
                    startActivity(intent);
                    Toast.makeText(updatestudentphone.this,"Update mobile number successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}