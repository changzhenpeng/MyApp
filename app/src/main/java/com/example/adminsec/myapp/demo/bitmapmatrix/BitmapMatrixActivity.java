package com.example.adminsec.myapp.demo.bitmapmatrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminsec.myapp.R;

import java.text.DecimalFormat;

import static com.example.adminsec.myapp.R.id.matrix_btnfour;

public class BitmapMatrixActivity extends AppCompatActivity implements View.OnClickListener {

	private Bitmap bitmap;//bitmap类

	private ImageView matrixImage;//图片控件
	private TextView matrixTxt;//文本控件

	private Button scalBtn;//缩放按钮
	private Button rotateBtn;//旋转按钮
	private Button translationBtn;//平移按钮
	private Button transformationBtn;//变形按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitmap_matrix);

		initView();
		setListener();
	}

	private void setListener() {

		scalBtn.setOnClickListener(this);
		rotateBtn.setOnClickListener(this);
		translationBtn.setOnClickListener(this);
		transformationBtn.setOnClickListener(this);
	}

	private void initView() {

		matrixImage = (ImageView) findViewById(R.id.matrix_image);
		matrixTxt = (TextView) findViewById(R.id.matrix_txt);
		scalBtn = (Button) findViewById(R.id.matrix_btnone);
		rotateBtn = (Button) findViewById(R.id.matrix_btntwo);
		translationBtn = (Button) findViewById(R.id.matrix_btnthree);
		transformationBtn = (Button) findViewById(matrix_btnfour);

		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.matrix);
		setTxt(bitmap);

	}

	@Override
	public void onClick(View v) {

		Bitmap bitmapAfter;//经过处理后的bitmap类
		switch (v.getId()) {
			case R.id.matrix_btnone:
				Matrix matrixOne = new Matrix();
				matrixOne.setScale(0.5f, 0.5f);//缩小为原来一半
				bitmapAfter = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrixOne, true);
				matrixImage.setImageBitmap(bitmapAfter);
				setTxt(bitmapAfter);
				break;
			case R.id.matrix_btntwo:
				Matrix matrixTwo = new Matrix();
				matrixTwo.setScale(0.5f, 0.5f);// 缩小为原来的一半
				matrixTwo.postRotate(45.0f);// 旋转45度 == matrix.setSinCos(0.5f, 0.5f);
				bitmapAfter = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(), matrixTwo, true);
				matrixImage.setImageBitmap(bitmapAfter);
				setTxt(bitmapAfter);
				break;
			case R.id.matrix_btnthree:
				Matrix matrixThree = new Matrix();
				matrixThree.setTranslate(bitmap.getWidth(), bitmap.getHeight());// 向左下平移
				bitmapAfter = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(), matrixThree, true);
				matrixImage.setImageBitmap(bitmapAfter);
				setTxt(bitmapAfter);
				break;
			case R.id.matrix_btnfour:
				Matrix matrixFor = new Matrix();
				matrixFor.setSkew(0.5f, 0.5f);// 斜切
				matrixFor.postScale(0.5f, 0.5f);// 缩小为原来的一半
				bitmapAfter = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(), matrixFor, true);
				matrixImage.setImageBitmap(bitmapAfter);
				setTxt(bitmapAfter);
				break;
			default:
				break;
		}
	}

	private void setTxt(Bitmap bm) {
		float a =bm.getRowBytes() * bm.getHeight();
		float b = bm.getByteCount();

		DecimalFormat df = new DecimalFormat("0.00");
		matrixTxt.setText("图片大小="+df.format(b/1024/1024)+"兆*****图片宽度="+bm.getWidth()+"*****图片高度="+bm.getHeight());
	}

}
