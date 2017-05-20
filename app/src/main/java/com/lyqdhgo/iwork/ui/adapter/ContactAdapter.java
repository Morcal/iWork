package com.lyqdhgo.iwork.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.lyqdhgo.iwork.R;
import com.lyqdhgo.iwork.bean.Contact;
import com.lyqdhgo.iwork.bean.Section;

import java.util.List;
import java.util.Locale;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private static final String NAME_FORMAT = "%s %s";

    private List<Contact> mContacts;
    private LayoutInflater mInflater;
    private ContactScrollerAdapter mContactScrollerAdapter;

    public ContactAdapter(Context c, List<Contact> contacts, ContactScrollerAdapter contactScrollerAdapter) {
        mContacts = contacts;
        mInflater = LayoutInflater.from(c);
        mContactScrollerAdapter = contactScrollerAdapter;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contact = mInflater.inflate(R.layout.view_contact, parent, false);
        return new ContactViewHolder(contact);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.pic.setImageDrawable(contact.getProfileImage());
        holder.mName.setText(String.format(Locale.US, NAME_FORMAT, contact.getFirstName(), contact.getLastName()));
        Section s = mContactScrollerAdapter.fromItemIndex(position);
        if (s.getIndex() == position) {
            holder.title.setText(s.getTitle());
        } else {
            holder.title.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView pic;
        private TextView mName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_index);
            pic = (ImageView) itemView.findViewById(R.id.contact_img);
            mName = (TextView) itemView.findViewById(R.id.contact_name);
        }
    }
}
