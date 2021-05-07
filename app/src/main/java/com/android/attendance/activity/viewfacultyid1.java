package com.android.attendance.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

public class viewfacultyid1 extends Activity {

    EditText edittextid;
    Button submit;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty_i_d);

        edittextid=(EditText) findViewById(R.id.edittextid);
        submit=(Button)findViewById(R.id.btnSubmit1);
        tv=(TextView)findViewById(R.id.tv);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextid.getText().toString().isEmpty()) {
                    Toast.makeText(viewfacultyid1.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id=edittextid.getText().toString();
                    DBAdapter dbAdapter = new DBAdapter(viewfacultyid1.this);
                    FacultyBean facultyBean = dbAdapter.getFacultyById(id);
                    tv.setText("ID                        "+facultyBean.getFaculty_id()+"\n"+"FIRSTNAME       "+facultyBean.getFaculty_firstname()+"\n"+
                            "SECONDNAME  "+facultyBean.getFaculty_lastname()+"\n"+"PHONE               "+facultyBean.getFaculty_mobilenumber()+"\n"+
                            "ADDRESS           "+facultyBean.getFaculty_address()+"\n"+"\n");

                }

            }
        });
    }
}