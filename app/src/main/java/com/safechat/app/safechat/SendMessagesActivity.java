package com.safechat.app.safechat;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.widget.ListView;

import java.util.ArrayList;

public class SendMessagesActivity extends Activity {
	ListView listView;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontacts);
		listView = (ListView) findViewById(R.id.contactsView);

		Cursor c = this
				.managedQuery(ContactsContract.Data.CONTENT_URI, null,
						Data.MIMETYPE + "=?", // condition
						// new String[] {
						// ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE},
						// // value
						new String[] { ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE }, // value
						null);

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		while (c.moveToNext()) {
			int type = c.getInt(c.getColumnIndex(Phone.TYPE));
			if (type == Phone.TYPE_MOBILE) {
				Contact con = new Contact(c.getString(c
						.getColumnIndex(Contacts.DISPLAY_NAME)), c.getString(c
						.getColumnIndex(Phone.NUMBER)));
				contacts.add(con);
			}
		}
		listView.setAdapter(new ContactsAdapter(this, contacts));


    }

    /*public void checkBoxExecute()
    {
        CheckBox checkBox=(CheckBox)findViewById(R.id.selected);
        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Intent i = new Intent(SendMessagesActivity.this, HomeActivity.class);
                    startActivity(i);
                }

            }
        });
    }
*/
}