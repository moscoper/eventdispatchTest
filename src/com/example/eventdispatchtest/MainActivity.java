package com.example.eventdispatchtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

import com.example.eventdispatchtest.myview.MyButton;

public class MainActivity extends Activity {

	private MyButton button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (MyButton) findViewById(R.id.button);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Log.i("====onClick======", "onClick");
				System.out.println("=======onClick======");
			}
		});

		button.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					System.out.println("==onTouch======ACTION_DOWN");
					break;
//					return true;
				case MotionEvent.ACTION_MOVE:
					System.out.println("==onTouch======ACTION_MOVE");
					break;
				case MotionEvent.ACTION_UP:
					System.out.println("==onTouch======ACTION_UP");
					break;

				default:
					break;
				}
				return false;
			}
		});

	}


}
