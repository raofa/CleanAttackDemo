package com.sunyard.util;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
/**
 * 画板视图
 * @author Administrator
 *
 */
public class WrittingView  extends View{
	private Canvas mCanvas;
	private Bitmap mBitmap;
    private Paint paint = null;
	public WrittingView(Context context, AttributeSet attrs) {
		super(context, attrs);

		inite();

	}

	/**
	 * 初始化
	 */
	private void inite(){
		xlist=new ArrayList<Integer>();
		ylist=new ArrayList<Integer>();
		paint = new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(1);
		mCanvas = new Canvas();
		mCanvas.drawColor(Color.TRANSPARENT,Mode.CLEAR); // 清屏幕

	}

	/**
	 * 设置颜色
	 * @param color 颜色
	 */
//	public void setcolor(int color){
//		if(paint!=null){
//			paint.setColor(color);
//		}
//	}
	/**
	 * 设置笔刷大小
	 * @param size 笔刷大小值
	 */
//	public void setPenSize(float size){
//		if(paint!=null){
//			paint.setStrokeWidth(size);
//		}
//	}
	/**
	 * 清屏
	 */
	public void clearall(){
		if(mCanvas!=null){
			startX=0;
			startY=0;
			stopX=0;
			stopY=0;
			mCanvas.drawColor(Color.TRANSPARENT,Mode.CLEAR); // 清屏幕
		invalidate();
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		mCanvas.setBitmap(mBitmap);
		super.onSizeChanged(w, h, oldw, oldh);
	}

	public Canvas getmCanvas() {
		return mCanvas;
	}

	public void setmCanvas(Canvas mCanvas) {
		this.mCanvas = mCanvas;
	}

	private float startX ;
	private float startY ;
	private float stopX ;
	private float stopY;
	List <Integer> xlist;
	List <Integer> ylist;

	public List<Integer> getXlist() {
		return xlist;
	}

	public void setXlist(List<Integer> xlist2) {
		this.xlist = xlist2;
	}

	public List<Integer> getYlist() {
		return ylist;
	}

	public void setYlist(List<Integer> ylist) {
		this.ylist = ylist;
	}

	public float getStartX() {
		return startX;
	}

	public void setStartX(float startX) {
		this.startX = startX;
	}

	public float getStartY() {
		return startY;
	}

	public void setStartY(float startY) {
		this.startY = startY;
	}

	public float getStopX() {
		return stopX;
	}

	public void setStopX(float stopX) {
		this.stopX = stopX;
	}

	public float getStopY() {
		return stopY;
	}

	public void setStopY(float stopY) {
		this.stopY = stopY;
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		int action=event.getAction();
//		switch(action){
//		case MotionEvent.ACTION_DOWN://点击
//			//在这里获取起始点坐标
//			mCanvas.drawPoint(startX, startY, paint);
//			break;
//
//		case MotionEvent.ACTION_MOVE://移动
//			//在这里获取移动点坐标
//			stopX = 100;
//			stopY = 100;
//			LinearGradient lg=new LinearGradient(70,80,200,200, Color.BLACK,Color.WHITE, Shader.TileMode.MIRROR);
//			paint.setShader(lg);
//			mCanvas.drawLine(70 ,80, 200, 200, paint);//绘图
//			//把末点赋值给始点
//			startX = stopX;
//			startY = stopY;
//			invalidate();
//			break;
//		case MotionEvent.ACTION_UP://收笔
//			stopX = event.getX();
//			stopY = event.getY();
//			invalidate();
//			break;
//		default:
//				break;
//		}
//		return true;
//	}

	@Override
	public void onDraw(Canvas canvas) {

//		mCanvas.drawPoint(startX, startY, paint);
		mCanvas.drawLine(startX/12, startY/12, stopX/12, stopY/12, paint);

		super.onDraw(canvas);


		canvas.drawBitmap(mBitmap,0 , 0, null);
	}


}
