package com.example.tpj.myapplication;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivAnimationDrawList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        ivAnimationDrawList.setOnClickListener(this);
    }

    private void initView() {
        ivAnimationDrawList = findViewById(R.id.animationDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animationDrawable:
                Drawable drawable = ivAnimationDrawList.getBackground();
                ((Animatable) drawable).start();
                break;
        }
    }
}
