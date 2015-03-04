package com.safechat.app.safechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends BaseAdapter {
		private Context context;
		private ArrayList<Contact> contacts;
	 
		public ContactsAdapter(Context context, ArrayList<Contact> contacts) {
			this.context = context;
			this.contacts = contacts;
		}
	 
		public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            gridView = inflater.inflate(R.layout.contact, null);

            TextView textName = (TextView) gridView.findViewById(R.id.name);
            textName.setText( contacts.get(position).getName());

            TextView textMobile = (TextView) gridView.findViewById(R.id.mobile);
            textMobile.setText( contacts.get(position).getMobile());

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
		public int getCount() {
			return contacts.size();
		}
	 
		@Override
		public Object getItem(int position) {
			return null;
		}
	 
		@Override
		public long getItemId(int position) {
			return 0;
		}
}
