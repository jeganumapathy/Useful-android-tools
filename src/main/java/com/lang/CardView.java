package com.lang;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardView extends RelativeLayout {

	public static int PADDING = 10;
	private Context context;

	private TextView cardHeader;
	private ImageView headerImageBackground;
	private RelativeLayout.LayoutParams params;
	private RelativeLayout.LayoutParams cardViewParam;

	public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public CardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public CardView(Context context) {
		super(context);
		init(context);
	}

	public void init(Context context) {
		this.context = context;
		this.params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		LayerDrawable lb = (LayerDrawable) context.getResources().getDrawable(R.drawable.glow_rect);
		setLayoutParams(params);
		setBackgroundDrawable(lb);
		setPadding(PADDING, PADDING, PADDING, PADDING);
		initHeader(context);
	}

	/**
	 * INIT the header and add it to the
	 * 
	 * @param context
	 */
	private void initHeader(Context context) {
		cardHeader = new TextView(context);
		cardViewParam = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		this.addView(cardHeader, cardViewParam);
	}

	public void setHeader(String text) {
		cardHeader.setText(text);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
	}

}
