package com.diplom.project.atmsickleave;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FilterView {
	
	ImageView waitingImg;
	boolean waitingChecked = true;
	
	ImageView inProgerssImg;
	boolean inProcessingChecked = true;
	
	ImageView doneImg;
	boolean doneChecked = true;

	@SuppressLint("InflateParams") public FilterView(Activity context, LinearLayout parentLayout) {
		
		LinearLayout layout = (LinearLayout)context.getLayoutInflater().inflate(R.layout.header_layout, null);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setGravity(Gravity.CENTER);
		
		OnClickListener imgClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView imgView = (ImageView)v;
				boolean enabled = false;
				
				if (imgView == waitingImg)
				{
					waitingChecked = !waitingChecked;
					enabled = waitingChecked;
				}
				else if (imgView == inProgerssImg)
				{
					inProcessingChecked = !inProcessingChecked;
					enabled = inProcessingChecked;
				}
				else if (imgView == doneImg)
				{
					doneChecked = !doneChecked;
					enabled = doneChecked;
				}
				else
				{
					return;
				}
				
				ColorMatrix matrix = new ColorMatrix();
				if (!enabled)
				{
					matrix.setSaturation(0);
				}
				else
				{
					matrix.setSaturation(1);
				}

			    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
			    imgView.setColorFilter(filter);
			}
		};
		LayoutParams params = new LinearLayout.LayoutParams(72, 72, (float) 1.0 / 3);
		
		waitingImg = new ImageView(context);
		waitingImg.setImageResource(R.drawable.waiting);
		waitingImg.setLayoutParams(params);
		waitingImg.setClickable(true);
		waitingImg.setOnClickListener(imgClickListener);
		layout.addView(waitingImg);
		
		inProgerssImg = new ImageView(context);
		inProgerssImg.setImageResource(R.drawable.in_progress);
		inProgerssImg.setLayoutParams(params);
		inProgerssImg.setClickable(true);
		inProgerssImg.setOnClickListener(imgClickListener);
		layout.addView(inProgerssImg);
		
		doneImg = new ImageView(context);
		doneImg.setImageResource(R.drawable.done);
		doneImg.setLayoutParams(params);
		doneImg.setClickable(true);
		doneImg.setOnClickListener(imgClickListener);
		layout.addView(doneImg);
		
		parentLayout.addView(layout);
		
		
	}
}
