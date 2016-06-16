package com.bob.eventbusdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bob.eventbusdemo.EventBus.MessageEvent;
import com.bob.eventbusdemo.FragmentActivity;
import com.bob.eventbusdemo.R;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FirstFragment extends Fragment {

    @BindView(R.id.next)
    Button next;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
//        ButterKnife.bind(view);
        next.setText("FirstFragment");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @OnClick(R.id.next)
    public void onClick() {
        Logger.i("FirstFragment");
        EventBus.getDefault().post(new MessageEvent(FragmentActivity.GOTO_SECOND));
    }
}
