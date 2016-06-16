package com.bob.eventbusdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.bob.eventbusdemo.EventBus.MessageEvent;
import com.bob.eventbusdemo.fragment.FirstFragment;
import com.bob.eventbusdemo.fragment.SecondFragment;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bob on 2016/5/11.
 */
public class FragmentActivity extends AppCompatActivity {
    public static final String GOTO_FIRST = "goto_first";
    public static final String GOTO_SECOND = "goto_second";

    private FirstFragment first;
    private SecondFragment second;

    @BindView(R.id.container)
    FrameLayout container;
    private FragmentManager manager;

    public FragmentActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        Logger.init("haha");
        EventBus.getDefault().register(this);
        first = new FirstFragment();
//        second = new SecondFragment();

        manager = getFragmentManager();
        manager.beginTransaction().add(R.id.container, first, "first").commit();

    }

    @Subscribe
    public void gotoFragment(MessageEvent event){
        Logger.i(event.message);
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (event.message) {
            case GOTO_SECOND:
                if(second == null) {
                    second = new SecondFragment();
                    transaction.add(R.id.container, second, "second");
                }
                transaction.show(second);

                break;
            case GOTO_FIRST:
                transaction.show(first);
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if(manager.findFragmentByTag("first") != null){
            transaction.hide(first);
        }
        if(manager.findFragmentByTag("second") != null){
            transaction.hide(second);
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
