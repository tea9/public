package com.demo.dingsheng.task.utils;

import android.util.Log;

import com.demo.dingsheng.task.task.RankManagerTask;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxTimerUtil {

    private static final String TAG = RankManagerTask.class.getSimpleName();
    private static Disposable mDisposable;

    /**
     * milliseconds分钟后执行next操作
     *
     * @param milliseconds
     * @param next
     */
    public static void reactivexTimer(long milliseconds, final IRxNext next) {
        Observable.timer(milliseconds, TimeUnit.MINUTES)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(Long number) {
                        if (next != null) {
                            next.doNext(number);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //取消订阅
                        cancel();

                        Log.d(TAG, "====onError======");
                    }

                    @Override
                    public void onComplete() {
                        //取消订阅
                        cancel();

                        Log.d(TAG, "====onComplete======");

                        if (next != null) {
                            next.doFinish();
                        }
                    }
                });
    }


    /**
     * 每隔milliseconds秒后执行next操作
     *
     * @param milliseconds
     * @param next
     */
    public static void interval(long milliseconds, final IRxNext next) {
        Observable.interval(milliseconds, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(Long number) {
                        if (next != null) {
                            next.doNext(number);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * 取消订阅
     */
    public static void cancel() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
            mDisposable = null;
        }
    }

    public interface IRxNext {
        void doNext(long number);

        void doFinish();
    }
}