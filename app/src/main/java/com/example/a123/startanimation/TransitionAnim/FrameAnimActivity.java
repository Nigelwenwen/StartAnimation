package com.example.a123.startanimation.TransitionAnim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.a123.startanimation.BaseActivity;
import com.example.a123.startanimation.R;

public class FrameAnimActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        setupToolbar("帧动画");
        ImageView imageView=findViewById(R.id.img_frame_anim);
        imageView.setImageResource(R.drawable.frame_anim);
        AnimationDrawable drawable=(AnimationDrawable)imageView.getDrawable();
        drawable.start();
    }
}
