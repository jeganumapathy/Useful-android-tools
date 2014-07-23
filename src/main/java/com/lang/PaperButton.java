package com.lang;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class PaperButton extends RelativeLayout {


    boolean isLayoutDisplayed;
    private Context context;
    private static final int HEADERVIEWID = 1111;
    private final int PRICEVIEWID = 2222;

    public PaperButton(Context context) {
        super(context);
        init(context);
    }

    public PaperButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public PaperButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setBackgroundDrawable(context.getResources().getDrawable(R.drawable.glow_circle));

        isLayoutDisplayed = false;

    }

    public void setHeader(String headerText) {
        LangTextView header = new LangTextView(context);
        header.setId(HEADERVIEWID);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
                , RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.topMargin = this.getHeight() / 6;
        header.setLayoutParams(lp);
        header.setText(headerText, null);
        addView(header);
    }

    public void setPrice(String price) {
        TextView priceText = new TextView(context);
        priceText.setId(PRICEVIEWID);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/symbols/Rupee_Foradian.ttf");
        priceText.setTypeface(face);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
                , RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.addRule(RelativeLayout.BELOW, HEADERVIEWID);
        lp.topMargin = 10;
        priceText.setLayoutParams(lp);
        //TODO need to remove  price sigh should be generic
        priceText.setText("`" + price);
        addView(priceText);
    }
}
