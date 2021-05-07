package com.android.attendance.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.db.DBAdapter;
import com.example.student_information_system.R;

import java.util.ArrayList;

public class viewfaculty extends Activity {

    ArrayList<FacultyBean> facultyBeanList;
    private ListView listView ;
    private ArrayAdapter<String> listAdapter;

    DBAdapter dbAdapter = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.__listview_main);

        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> facultyList = new ArrayList<String>();

        facultyBeanList=dbAdapter.getAllFaculty();

        for(FacultyBean facultyBean : facultyBeanList)
        {
            String users ="Faculty_id:     "+facultyBean.getFaculty_id()+ "\nFaculty_FirstName: " + facultyBean.getFaculty_firstname()+"\nFaculty_Lastname:"+facultyBean.getFaculty_lastname()+
                    "\nFaculty_Mobile: "+facultyBean.getFaculty_mobilenumber()+
                    "\nFaculty_Address: "+facultyBean.getFaculty_address()+
                    "\n";

            facultyList.add(users);
            Log.d("users: ", users);

        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.activity_viewfaculty, R.id.labelF, facultyList);
        listView.setAdapter( listAdapter );
    }
}