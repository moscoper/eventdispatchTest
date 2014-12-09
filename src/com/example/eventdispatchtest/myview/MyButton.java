package com.example.eventdispatchtest.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {

	/*
	 * 1.��֤dispatchTouchEvent��onTouchEvent�Ĺ�ϵ����dispatchTouchEvent()
	 * ������onTouch��onTouchEvent ������ִ�е�˳����dispatchTouchEvent--->touchEvent-->onTouchEvent;
	 * 2. MotionEvent.ACTION_DOWN����falseʱ����ACTION��ִ����
	 * 3.dispatchTouchEvent�����onTouch��onTouchEvent���зַ���
	 * 4.��ĳ��״̬����true�����������״̬��������onTouch��ACTION_DOWN״̬����true
	 * ,������ִ��onTouchEvent��ACTION_DAOWN,������״̬���ǻ�ִ��
	 * 5.��dispatchTouchEvent��action_down״̬����falseʱ
	 * �����״̬�����ڴ�����������move״̬����trueʱup��Ȼ�ܴ�������ͻش��˵ڶ�������
	 * 
	 * ����android���¼��ַ��������ҡ�������֤�Ľ��������˵����Щ��һ���������������������viewgroup���¼��ַ���
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
