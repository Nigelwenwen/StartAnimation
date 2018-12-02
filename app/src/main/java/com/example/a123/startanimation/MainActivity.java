package com.example.a123.startanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.a123.startanimation.PropertyAnim.PropertyAnimAcitvity;
import com.example.a123.startanimation.TransitionAnim.FrameAnimActivity;
import com.example.a123.startanimation.TransitionAnim.TransitionAnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        TextView textView=findViewById(R.id.title);
        textView.setText("StartAnimation");
        findViewById(R.id.bt_transition_anim).setOnClickListener(v->{
            Intent intent=new Intent(this,TransitionAnimActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt_property_anim).setOnClickListener(v->{
            Intent intent=new Intent(this,PropertyAnimAcitvity.class);
            startActivity(intent);
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
