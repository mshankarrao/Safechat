package com.safechat.app.safechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
              Button btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        EditText password=(EditText)findViewById(R.id.password);
        if( password.getText().toString().length() == 0 ) {
            password.setError("Pin is required!");
        }
        else if(password.getText().toString().length()!=4)
        {
            password.setError("Please enter 4 digit pin!");
        }
        else if(!password.getText().toString().equals("0000"))
        {
            password.setError("Please enter correct pin!");
        }
        else {
            //setContentView(R.layout.activity_login);
            Intent i = new Intent(LoginActivity.this, SendMessagesActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
