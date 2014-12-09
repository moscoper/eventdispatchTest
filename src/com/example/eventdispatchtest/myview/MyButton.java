package com.example.eventdispatchtest.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {

	/*
	 * 1.验证dispatchTouchEvent和onTouchEvent的关系，在dispatchTouchEvent()
	 * 里会调用onTouch和onTouchEvent ，他们执行的顺序是dispatchTouchEvent--->touchEvent-->onTouchEvent;
	 * 2. MotionEvent.ACTION_DOWN返回false时其他ACTION还执行吗？
	 * 3.dispatchTouchEvent负责对onTouch和onTouchEvent进行分发；
	 * 4.在某个状态返回true将会拦截这个状态，比如在onTouch的ACTION_DOWN状态返回true
	 * ,将不会执行onTouchEvent的ACTION_DAOWN,但后续状态还是会执行
	 * 5.在dispatchTouchEvent的action_down状态返回false时
	 * ，后继状态都不在触发，但是在move状态返回true时up依然能触发，这就回答了第二个问题
	 * 
	 * 关于android的事件分发，很凌乱。。。验证的结果和网上说的有些不一样，哎。。。明天继续看viewgroup的事件分发。
	 */
	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("====onTouchEvent======");
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			System.out.println("==onTouchEvent======ACTION_DOWN");
			break;
		case MotionEvent.ACTION_MOVE:
			System.out.println("==onTouchEvent======ACTION_MOVE");
			break;
		case MotionEvent.ACTION_UP:
			System.out.println("==onTouchEvent======ACTION_UP");
			break;

		default:
			break;
		}
		return super.onTouchEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("======dispatchTouchEvent=======");
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			System.out.println("==dispatchTouchEvent======ACTION_DOWN");

			break;
		case MotionEvent.ACTION_MOVE:
			System.out.println("==dispatchTouchEvent======ACTION_MOVE");
			return false;
			// break;
		case MotionEvent.ACTION_UP:
			System.out.println("==dispatchTouchEvent======ACTION_UP");
			break;

		default:
			break;
		}

		return super.dispatchTouchEvent(event);
	}

}
