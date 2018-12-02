package com.example.a123.startanimation.PropertyAnim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.a123.startanimation.BaseActivity;
import com.example.a123.startanimation.R;

public class PropertyAnimAcitvity extends BaseActivity {
    private static final String TAG = "PropertyAnimAcitvity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_acitvity);
        setupToolbar("基本属性动画");
        ImageView imageView=findViewById(R.id.circle);
        findViewById(R.id.bt_alpha).setOnClickListener(v->{
            ValueAnimator animator=ValueAnimator.ofFloat(1f,0f);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value=(float)animation.getAnimatedValue();
                    imageView.setAlpha(value);
                }
            });
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ObjectAnimator animator1=ObjectAnimator.ofFloat(imageView,"alpha",
                            1f);
                    //延迟1秒启动动画
                    animator1.setStartDelay(1000);
                    animator1.setDuration(1000);
                    animator1.start();
                }
            });
            animator.start();
        });
        findViewById(R.id.bt_scale).setOnClickListener(v->{
            //可以设多个值，在两秒内从1到0.5再到1再到0
            AnimatorSet set=new AnimatorSet();
            ObjectAnimator scaleX=ObjectAnimator.ofFloat(imageView,"scaleX",
                    1f,0.5f,1f,0f);
            //循环一次
            scaleX.setRepeatCount(1);
            //循环模式为：倒放
            scaleX.setRepeatMode(ObjectAnimator.REVERSE);
            ObjectAnimator scaleY=ObjectAnimator.ofFloat(imageView,"scaleY",
                    1f,0.5f,1f,0f);
            scaleY.setRepeatCount(1);
            scaleY.setRepeatMode(ObjectAnimator.REVERSE);
            set.setDuration(5000);
            set.playTogether(scaleX,scaleY);
            set.start();
        });
        findViewById(R.id.bt_translate).setOnClickListener(v->{
            imageView.animate().translationX(300f).translationY(300f).setDuration(2000);
        });
        findViewById(R.id.bt_rotate).setOnClickListener(v->{
            Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
            Keyframe kf1 = Keyframe.ofFloat(.5f, 180f);
            Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
            PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotationX", kf0, kf1, kf2);
            ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(imageView, pvhRotation);
            rotationAnim.setDuration(5000);
            rotationAnim.start();
        });
        findViewById(R.id.bt_combination).setOnClickListener(v->{
            AnimatorSet set=new AnimatorSet();
            ObjectAnimator scale=ObjectAnimator.ofFloat(imageView,"scaleX",1f,0.5f,1f).setDuration(2000);
            ObjectAnimator alpha=ObjectAnimator.ofFloat(imageView,"alpha",1f,0f,1f).setDuration(2000);
            ObjectAnimator translateX=ObjectAnimator.ofFloat(imageView,"translationX",0f,300f,0f).setDuration(2000);
            set.play(scale).before(translateX);
            set.play(translateX).with(alpha);
            set.start();
        });
        findViewById(R.id.bt_xml).setOnClickListener(v->{
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.combination);
            animator.setTarget(imageView);
            animator.start();
        });
    }
}
