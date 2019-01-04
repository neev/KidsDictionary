package com.neerajavimal.kidsdictionary;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class CustomView1 extends LinearLayout {
  
    TextView textView;
    ImageView imageView;
    TypedArray attributes;
    //private OnClickListener onClickListener;
    private OnClickListener onClickListener = new OnClickListener() {
        public void onClick(View v)
        {
            //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}
            Log.d(TAG, "onClick: CLICKED CLICKED ");
            switch (textView.getText().toString()){
                case "MICROPHONE":
                    {
                        Intent intent = new Intent(getContext(), WordTypingActivity.class);
                        getContext().startActivity(intent);
                    }
                    break;
                
                case "Please type the word":
                    {
                        Intent intent = new Intent(getContext(), WordTypingActivity.class);
                        getContext().startActivity(intent);
                    }
                    break;
    
                case "Search for the word":
                    Toast.makeText(getContext(), "Search for the word", Toast.LENGTH_SHORT).show();
                    break;
                
                
            }
            
        }
    };
    
    public CustomView1(Context context) {
        this(context,null);
        this.setClickable(true);
    }
    
    public CustomView1(Context context,AttributeSet attrs) {
        this(context, attrs,0);
        this.setClickable(true);
    }
    
    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        attributes = this.getContext().obtainStyledAttributes(attrs, R.styleable.CustomView1,0,0);
        this.setClickable(true);
        init();
    }
    
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        attributes = this.getContext().obtainStyledAttributes(attrs, R.styleable.CustomView1,0,0);
        this.setClickable(true);
        init();
    }
    
    //////////////initial view//////////////
    private void init() {
        
            inflate(getContext(), R.layout.custom_view1, this);
        
             imageView  = (ImageView) findViewById(R.id.image);
             textView  = (TextView) findViewById(R.id.caption);
             
             
            imageView.setImageDrawable(attributes.getDrawable(R.styleable.CustomView1_image));
            imageView.setOnClickListener(onClickListener);
            textView.setText(attributes.getText(R.styleable.CustomView1_text));
     
            attributes.recycle();
        
        
    }
    
    ///////////onclick Listener///////////
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_UP &&
                   (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER || event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
            if(onClickListener != null) onClickListener.onClick(this);
        }
        return super.dispatchKeyEvent(event);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setPressed(true);
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            if(onClickListener != null) onClickListener.onClick(this);
            setPressed(false);
        }
        else {
            setPressed(false);
        }
        return super.dispatchTouchEvent(event);
    }
    
    
   
    
    
    
    
}
