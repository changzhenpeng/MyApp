package com.example.adminsec.myapp.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adminsec.myapp.R;
import com.example.adminsec.myapp.demo.bitmapmatrix.BitmapMatrixActivity;
import com.example.adminsec.myapp.demo.ratingbar.RatingBarActivity;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

	private Button ratingBarBtn;
	private Button bitmap_matrix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		initView();
		setListener();
	}

	private void setListener() {
		ratingBarBtn.setOnClickListener(this);
		bitmap_matrix.setOnClickListener(this);
	}

	private void initView() {
		ratingBarBtn = (Button) findViewById(R.id.ratingbar);
		bitmap_matrix = (Button) findViewById(R.id.bitmap_matrix);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()){
			case R.id.ratingbar:
				intent.setClass(DemoActivity.this,RatingBarActivity.class);
				startActivity(intent);
				break;
			case R.id.bitmap_matrix:
				intent.setClass(DemoActivity.this,BitmapMatrixActivity.class);
				startActivity(intent);
				break;
			default:
				Toast.makeText(DemoActivity.this,"未能正常获取控件",Toast.LENGTH_SHORT).show();
				break;
		}
	}
}
