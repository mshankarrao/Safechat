package com.safechat.app.safechat;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SendMessagesActivity extends Activity implements View.OnClickListener {
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
        Button btnChat= (Button)findViewById(R.id.btn_chat);
        btnChat.setOnClickListener(this);

    }



    @Override
    public void onClick(View v)
    {
            //setContentView(R.layout.activity_login);
            CheckBox checkBox=(CheckBox)findViewById(R.id.selected);
        if(checkBox.isChecked())
        {
            Intent i= new Intent(SendMessagesActivity.this,ChatActivity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Please Select for chat!", Toast.LENGTH_LONG)
                    .show();
        }


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