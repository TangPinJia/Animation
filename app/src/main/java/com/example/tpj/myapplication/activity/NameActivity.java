package com.example.tpj.myapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tpj.myapplication.livedata.NameModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by TPJ on 2019/4/1.
 * Describe:
 */
public class NameActivity extends AppCompatActivity {

    private NameModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModel();
    }

    private void initModel() {
        model=ViewModelProviders.of(this).get(NameModel.class);
        final Observer<String> nameObserver=new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //textView.setText(s);
            }
        };
        model.getName().observe(this,nameObserver);
    }

}
