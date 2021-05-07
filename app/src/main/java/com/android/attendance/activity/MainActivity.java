package com.android.attendance.activity;

import com.example.student_information_system.R;

import android.media.midi.MidiDeviceService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;
	Button btndev;
	Button btnabt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		start =(Button)findViewById(R.id.buttonstart);
		btndev=(Button)findViewById(R.id.btndev);
		btnabt=(Button)findViewById(R.id.btnabt);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});

		btndev.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(MainActivity.this,developers.class);
				startActivity(intent);
			}
		});

		btnabt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(MainActivity.this,about.class);
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
