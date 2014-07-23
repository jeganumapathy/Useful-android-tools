package com.lang;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by 771407 on 7/18/2014.
 */
public class AwesomeProgress {

    private Context context;
    private Handler handler = new Handler();
    final AwesomeProgressDot awesomeDot1, awesomeDot2, awesomeDot3;
    private ContDot contDot1, contDot2, contDot3;
    private LinearLayout linearLayout;

    public AwesomeProgress(Context context) {
        this.context = context;
        this.awesomeDot1 = new AwesomeProgressDot(context);
        this.awesomeDot2 = new AwesomeProgressDot(context);
        this.awesomeDot3 = new AwesomeProgressDot(context);
        contDot1 = new ContDot(awesomeDot1);
        contDot2 = new ContDot(awesomeDot2);
        contDot3 = new ContDot(awesomeDot3);
        this.awesomeDot1.setVisibility(View.INVISIBLE);
        this.awesomeDot2.setVisibility(View.INVISIBLE);
        this.awesomeDot3.setVisibility(View.INVISIBLE);
    }

    private LinearLayout getContainer() {
        return linearLayout;
    }

    public LinearLayout initLayout() {
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams aslp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        aslp.addRule(RelativeLayout.CENTER_IN_PARENT);
        linearLayout.setLayoutParams(aslp);
        LinearLayout.LayoutParams a = new LinearLayout.LayoutParams(AwesomeProgressDot.RADIUS, AwesomeProgressDot.RADIUS);
        awesomeDot1.setLayoutParams(a);
        linearLayout.addView(awesomeDot1);
        awesomeDot2.setLayoutParams(a);
        linearLayout.addView(awesomeDot2);
        awesomeDot3.setLayoutParams(a);
        linearLayout.addView(awesomeDot3);
        handler.postDelayed(contDot1, 0);
        handler.postDelayed(contDot2, 700);
        handler.postDelayed(contDot3, 1100);
        return linearLayout;
    }

    public void dimiss() {
        if (linearLayout != null)
            linearLayout.removeAllViews();
    }


    public class ContDot implements Runnable {
        private AwesomeProgressDot awesomeProgressDot;

        public ContDot(AwesomeProgressDot awesomeProgressDot) {
            this.awesomeProgressDot = awesomeProgressDot;
        }

        @Override
        public void run() {
            awesomeProgressDot.startAnime();
            awesomeProgressDot.setVisibility(View.VISIBLE);

        }
    }


}
