package com.example.a123.startanimation.TransitionAnim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.a123.startanimation.BaseActivity;
import com.example.a123.startanimation.R;

public class TransitionAnimActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_anim);
        setupToolbar("视图动画");
        findViewById(R.id.bt_frame_anim).setOnClickListener(v->{
            Intent intent=new Intent(this,FrameAnimActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt_tween_anim).setOnClickListener(v->{
            Intent intent=new Intent(this,TweenAnimAcitvity.class);
            startActivity(intent);
        });
    }
}
