package com.neerajavimal.kidsdictionary;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView1 extends LinearLayout {
  
    TextView textView;
    ImageView imageView;
    TypedArray attributes;
    
    public CustomView1(Context context) {
        this(context,null);
    }
    
    public CustomView1(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }
    
    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        attributes = this.getContext().obtainStyledAttributes(attrs, R.styleable.CustomView1,0,0);
        init();
    }
    
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        attributes = this.getContext().obtainStyledAttributes(attrs, R.styleable.CustomView1,0,0);
        init();
    }
    
    //////////////initial view//////////////
    private void init() {
        
            inflate(getContext(), R.layout.custom_view1, this);
        
             imageView  = (ImageView) findViewById(R.id.image);
             textView  = (TextView) findViewById(R.id.caption);
             
             
            imageView.setImageDrawable(attributes.getDrawable(R.styleable.CustomView1_image));
            textView.setText(attributes.getText(R.styleable.CustomView1_text));
            attributes.recycle();
        
        
    }
}
