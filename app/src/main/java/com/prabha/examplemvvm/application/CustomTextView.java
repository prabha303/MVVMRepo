package com.prabha.examplemvvm.application;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
	      super(context, attrs, defStyle);
	      init();
	  }

	 public CustomTextView(Context context, AttributeSet attrs) {
	      super(context, attrs);
	      init();
	  }

	 public CustomTextView(Context context) {
	      super(context);
	      init();
	 }


	public void init() {
	    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Medium.ttf");
	    setTypeface(tf);
	}
}