package com.example.adminsec.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adminsec.myapp.app.AppActivity;
import com.example.adminsec.myapp.demo.DemoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button demoBtn,appBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		initView();
		seListener();
    }

	private void seListener() {
		demoBtn.setOnClickListener(this);
		appBtn.setOnClickListener(this);
	}

	private void initView() {

		demoBtn = (Button) findViewById(R.id.btn_demo);
		appBtn = (Button) findViewById(R.id.btn_app);
	}


	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()){
			case R.id.btn_app:
				intent.setClass(MainActivity.this, AppActivity.class);
				startActivity(intent);
				break;
			case R.id.btn_demo:
				intent.setClass(MainActivity.this, DemoActivity.class);
				startActivity(intent);
				break;
			default:
				Toast.makeText(MainActivity.this,"未能正常获取控件",Toast.LENGTH_SHORT).show();
				break;
		}
	}
}
