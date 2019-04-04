package com.example.tpj.myapplication.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by TPJ on 2019/4/1.
 * Describe:
 */
public class NameModel extends ViewModel {
    private MutableLiveData<String> name;

    public MutableLiveData<String> getName() {
        if(name==null)
            name=new MutableLiveData<>();
        return name;
    }
}
