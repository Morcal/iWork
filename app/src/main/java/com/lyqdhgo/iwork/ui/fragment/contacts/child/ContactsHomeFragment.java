package com.lyqdhgo.iwork.ui.fragment.contacts.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyqdhgo.iwork.R;
import com.lyqdhgo.iwork.base.BaseFragment;
import com.lyqdhgo.iwork.bean.Contact;
import com.lyqdhgo.iwork.ui.adapter.ContactAdapter;
import com.lyqdhgo.iwork.ui.adapter.ContactScrollerAdapter;

import java.util.List;

import cdflynn.android.library.scroller.BubbleScroller;
import cdflynn.android.library.scroller.ScrollerListener;

/**
 * Created by QiDeHong on 2017/5/20.
 */

public class ContactsHomeFragment extends BaseFragment {
    BubbleScroller scroller;
    RecyclerView recycler;

    private ContactScrollerAdapter mContactScrollerAdapter;
    private ContactAdapter mContactAdapter;
    private LinearLayoutManager mLayoutManager;
    private boolean mProgrammaticScroll = true;

    public static ContactsHomeFragment newInstance() {

        Bundle args = new Bundle();

        ContactsHomeFragment fragment = new ContactsHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_home, container, false);
//        EventBus.getDefault().register(this);
        scroller = (BubbleScroller) view.findViewById(R.id.bubble_scroller);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        initView(view);
        return view;
    }

    private void initView(View view) {
        List<Contact> contactList = Contact.mocks(getActivity());
        mContactScrollerAdapter = new ContactScrollerAdapter(contactList);
        mContactAdapter = new ContactAdapter(getActivity(), contactList, mContactScrollerAdapter);
        mLayoutManager = new LinearLayoutManager(getActivity());
        scroller.setScrollerListener(mScrollerListener);
        scroller.setSectionScrollAdapter(mContactScrollerAdapter);
        recycler.setLayoutManager(mLayoutManager);
        recycler.setAdapter(mContactAdapter);
        scroller.showSectionHighlight(0);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (mProgrammaticScroll) {
                    mProgrammaticScroll = false;
                    return;
                }
                final int firstVisibleItemPosition = mLayoutManager.findFirstCompletelyVisibleItemPosition();
                scroller.showSectionHighlight(
                        mContactScrollerAdapter.sectionFromPosition(firstVisibleItemPosition));
            }
        });
    }

    private final ScrollerListener mScrollerListener = new ScrollerListener() {
        @Override
        public void onSectionClicked(int sectionPosition) {
            recycler.smoothScrollToPosition(
                    mContactScrollerAdapter.positionFromSection(sectionPosition));
            mProgrammaticScroll = true;
        }

        @Override
        public void onScrollPositionChanged(float percentage, int sectionPosition) {
            recycler.smoothScrollToPosition(
                    mContactScrollerAdapter.positionFromSection(sectionPosition));
            mProgrammaticScroll = true;
        }
    };

}
