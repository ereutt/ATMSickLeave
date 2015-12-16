package com.diplom.project.atmsickleave;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HeaderListView extends LinearLayout {

	private TextView text;
	private ImageView leftImg;
	private ImageView rightImg;
	public LinearLayout layout;
	
	private String[] menu = {"Все заявки", "Мои заявки"};
	private int currMenuId = 0;
	
	@SuppressLint("InflateParams") public HeaderListView(Activity context, LinearLayout parentLayout) {
		super(context);
		


		DisplayMetrics displaymetrics = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		 
		
		layout = (LinearLayout)context.getLayoutInflater().inflate(R.layout.header_layout, null);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setGravity(Gravity.CENTER);
	
		leftImg = new ImageView(context);
		leftImg.setLayoutParams(new LinearLayout.LayoutParams(72, 72, (float) 0.25));
		leftImg.setImageResource(R.drawable.left);
		leftImg.setClickable(true);
		leftImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				currMenuId = 1 - currMenuId;
				text.setText(menu[currMenuId]);
			}
		});
		layout.addView(leftImg);
		
		// TODO Auto-generated constructor stub
		text = new TextView(context);
		
		text.setText(menu[currMenuId]);
		LayoutParams textParams = new LinearLayout.LayoutParams((int) (width * 0.5), LayoutParams.WRAP_CONTENT);
		textParams.gravity = Gravity.CENTER;
		text.setLayoutParams(new LinearLayout.LayoutParams((int) (width * 0.5), LayoutParams.WRAP_CONTENT, (float) 0.5));
		text.setTextColor(0xFF0000FF);
		text.setTypeface(text.getTypeface(), Typeface.BOLD_ITALIC);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		layout.addView(text);
		
		rightImg = new ImageView(context);
		rightImg.setLayoutParams(new LinearLayout.LayoutParams(72, 72, (float) 0.25));
		rightImg.setImageResource(R.drawable.right);
		rightImg.setClickable(true);
		rightImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				currMenuId = 1 - currMenuId;
				text.setText(menu[currMenuId]);
			}
		});
		layout.addView(rightImg);
		
		parentLayout.addView(layout);
	}
	
}
