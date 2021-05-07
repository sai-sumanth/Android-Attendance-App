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

public class DeleteStudentActivity extends Activity {

    EditText edittextid;
    Button btnSubmit;
    TextView tv,tv1;
    Button btnno;
    Button btnyes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        edittextid=findViewById(R.id.edittextid);
        btnSubmit=findViewById(R.id.btnSubmit1);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        btnno=findViewById(R.id.btnno);
        btnyes=findViewById(R.id.btnyes);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edittextid.getText().toString().isEmpty()) {
                    Toast.makeText(DeleteStudentActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                    String id=edittextid.getText().toString();
                    DBAdapter dbAdapter = new DBAdapter(DeleteStudentActivity.this);
                    StudentBean studentBean = dbAdapter.getStudentById(id);
                    tv.setText("ID                        "+studentBean.getStudent_id()+"\n"+"FIRSTNAME       "+studentBean.getStudent_firstname()+"\n"+
                            "SECONDNAME  "+studentBean.getStudent_lastname()+"\n"+"PHONE               "+studentBean.getStudent_mobilenumber()+"\n"+
                            "ADDRESS           "+studentBean.getStudent_address()+"\n"+"DEPARTMENT      "+studentBean.getStudent_department()+"\n");

                    tv1.setText("ARE YOU SURE TO DELETE "+studentBean.getStudent_id());

                }

            }
        });





        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edittextid.getText().toString().isEmpty()) {
                    Toast.makeText(DeleteStudentActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                    String Student_id=edittextid.getText().toString();
                    DBAdapter dbAdapter= new DBAdapter(DeleteStudentActivity.this);
                    dbAdapter.deleteStudent(Student_id);

                    Intent intent =new Intent(DeleteStudentActivity.this,menustudent.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "student deleted successfully", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DeleteStudentActivity.this,menustudent.class);
                startActivity(intent);
            }
        });






    }
}