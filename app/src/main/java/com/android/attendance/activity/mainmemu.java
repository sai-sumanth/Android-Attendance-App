package com.android.attendance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student_information_system.R;

public class mainmemu extends Activity {

    Button studentactivities;
    Button facultyactivities;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmemu);

        studentactivities=(Button)findViewById(R.id.btn1);
        facultyactivities=(Button)findViewById(R.id.btn2);
        logout=(Button)findViewById(R.id.btnout);

        studentactivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mainmemu.this,menustudent.class);
                startActivity(intent);

            }
        });
        facultyactivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mainmemu.this,menufaculty.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(mainmemu.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}