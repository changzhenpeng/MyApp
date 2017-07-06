package com.example.adminsec.myapp.demo.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.adminsec.myapp.R;

public class RatingBarActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating_bar);


		RatingBar ratingBar= (RatingBar) findViewById(R.id.ratingbar_mybar);
		ratingBar.setClickable(true);//设置可否点击
		ratingBar.setStar(2.5f);//设置显示的星星个数
		ratingBar.setStepSize(RatingBar.StepSize.Half);//设置每次点击增加一颗星还是半颗星
		ratingBar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
			@Override
			public void onRatingChange(float ratingCount) {//点击星星变化后选中的个数
				Log.d("RatingBar","RatingBar-Count="+ratingCount);
			}
		});
	}
}
