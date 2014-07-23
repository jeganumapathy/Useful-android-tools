package com.lang;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LangTextView extends TextView {

    private static Language lang;
    private Context context;

    public LangTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public LangTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LangTextView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        // By default the language will be others
        if (LangTextView.lang != null)
            setLanguage(LangTextView.lang);
    }

    public static enum Language {
        TAMIL, TELGU, MALAYALAM, KANNADAM, HINDI, BENGALI, OTHERS
    }

    /*
    * Used to set the default language as static from setting
    * or from other view
    * */
    public static void setDefaultLang(Language lang) {
        LangTextView.lang = lang;
    }

    public void setLanguage(Language lang) {
        Typeface tf = null;
        switch (lang) {
            case TAMIL:
                tf = getLangTypeFace("fonts/tamil/Bamini.ttf");
                break;
            case TELGU:
                tf = getLangTypeFace("fonts/telgu/akshar.ttf");
                break;
            case MALAYALAM:
                tf = getLangTypeFace("fonts/malayalam/AnjaliOldLipi.ttf");
                break;
            case KANNADAM:
                tf = getLangTypeFace("fonts/telgu/akshar.ttf");
                break;
            case HINDI:
                tf = getLangTypeFace("fonts/hindi/Mangal.ttf");
                break;
            case BENGALI:
                tf = getLangTypeFace("fonts/bengali/kalpurush.ttf");
                break;
            default:
                break;
        }
        if (tf != null) {
            setTypeface(tf);
        }

    }

    private Typeface getLangTypeFace(String typeFacePath) {

        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(context.getAssets(), typeFacePath);
        } catch (Exception e) {
        }
        return tf;
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        if (lang == Language.TAMIL) {
            text = TamilUtil.convertToTamil(TamilUtil.BAMINI, text.toString());
            super.setText(text, type);
        } else {
            super.setText(text, type);
        }

    }

}
