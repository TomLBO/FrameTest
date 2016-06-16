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

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bob on 2016/5/11.
 */
public class SecondFragment extends Fragment {

    @BindView(R.id.next)
    Button next;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        next.setText("second");
        return view;
    }

    @OnClick(R.id.next)
    public void onClick() {
        EventBus.getDefault().post(new MessageEvent(FragmentActivity.GOTO_FIRST));
    }
}
