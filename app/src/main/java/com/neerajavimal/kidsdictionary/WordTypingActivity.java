package com.neerajavimal.kidsdictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class WordTypingActivity extends AppCompatActivity {
    
    String word_entered = null;
    // Store reference to the progress bar later
    ProgressBar progressBarFooter;
    Button btn_meaning;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_typing);
    
        final EditText text_entry = (EditText) findViewById(R.id.text_entry);
        btn_meaning = (Button) findViewById(R.id.button_meaning);
        
        text_entry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                text_entry.setHint("");
                return false;
            }
        });
        setupProgressBar();
        word_entered = text_entry.getText().toString();
        btn_meaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show custom progress bar & call API service
                showProgressBar();
        
            }
        });
        
    
    }
    
    private void setupProgressBar() {
    
        // Inflate the footer
        View footer = getLayoutInflater().inflate(
                R.layout.cutsom_progressbar, null);
        // Find the progressbar within footer
        progressBarFooter = (ProgressBar)
                                    footer.findViewById(R.id.pbFooterLoading);
        
        
    }
    
    // Show progress
    public void showProgressBar() {
        progressBarFooter.setVisibility(View.VISIBLE);
    }
    
    // Hide progress
    public void hideProgressBar() {
        progressBarFooter.setVisibility(View.GONE);
    }
    
}
