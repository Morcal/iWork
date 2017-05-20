package com.lyqdhgo.iwork.ui.fragment.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyqdhgo.iwork.R;
import com.lyqdhgo.iwork.base.BaseMainFragment;
import com.lyqdhgo.iwork.ui.fragment.contacts.child.ContactHomeFragment;

/**
 * Created by QiDeHong on 2017/5/20.
 */

public class ContactFragment extends BaseMainFragment {

    public static ContactFragment newInstance() {
        Bundle args = new Bundle();
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.container, ContactHomeFragment.newInstance());
        }
    }
}
