package com.lyqdhgo.iwork.ui.fragment.contacts.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyqdhgo.iwork.R;
import com.lyqdhgo.iwork.base.BaseFragment;

/**
 * Created by QiDeHong on 2017/5/20.
 */

public class ContactHomeFragment extends BaseFragment {

    public static ContactHomeFragment newInstance() {

        Bundle args = new Bundle();

        ContactHomeFragment fragment = new ContactHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_home, container, false);
//        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }

}
