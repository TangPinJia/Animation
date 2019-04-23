package com.example.tpj.myapplication.activity;

import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;

import com.example.tpj.myapplication.interfaces.RetrofitService;
import com.example.tpj.myapplication.livedata.NameModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    /**
     * 在ui线程观察
     * @param names 被观察数据
     */
    public void queue(String... names){
        Observable.just(names)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(/* Observer */);
    }

    /**
     * 在其他线程观察
     * @param names 被观察数据
     */
    public void thread(final String... names){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Observable.just("1","2","3","4","5")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.from(Objects.requireNonNull(Looper.myLooper())))
                        .subscribe();
                Looper.loop();//只执行loop()之前的代码
            }
        },"thread-1").start();
    }

    /**
     * 创建观察者
     */
    public void createObserver(){
        //TODO 创建方法一
        Observer<String> observer=new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        };

        //TODO 创建方法二 Subscriber继承自observer
        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    /**
     * 加载数据
     */
    public void loadData(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("baseUrl")
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//结合rxjava
                .build();

        RetrofitService service=retrofit.create(RetrofitService.class);

        service.getName().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
