package com.example.a123.startanimation.TransitionAnim;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.a123.startanimation.BaseActivity;
import com.example.a123.startanimation.R;

public class TweenAnimAcitvity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim_acitvity);
        setupToolbar("补间动画");
        ImageView imageView=findViewById(R.id.circle);
        findViewById(R.id.bt_alpha).setOnClickListener(v->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
            imageView.startAnimation(animation);
        });
        findViewById(R.id.bt_scale).setOnClickListener(v->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
            imageView.startAnimation(animation);
        });
        findViewById(R.id.bt_translate).setOnClickListener(v->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
            imageView.startAnimation(animation);
        });
        findViewById(R.id.bt_rotate).setOnClickListener(v->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
            imageView.startAnimation(animation);
        });
        findViewById(R.id.bt_combination).setOnClickListener(v->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.combination_anim);
            imageView.startAnimation(animation);
        });
        findViewById(R.id.bt_java).setOnClickListener(v->{
            Animation animation=new ScaleAnimation(0,1,0,1,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            animation.setDuration(1000);
            imageView.startAnimation(animation);
        });
    }
}
