package com.ossb.totalcontrolhs.dao.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ossb.totalcontrolhs.R;
import com.ossb.totalcontrolhs.db.UsersDataSource;
import com.ossb.totalcontrolhs.model.User;
import com.ossb.totalcontrolhs.util.Security;

import java.util.List;


public class Register extends AppCompatActivity implements View.OnClickListener{
    public static final String LOGTAG = "Register";
    Security sec;
    Button btRegister;
    EditText etName, etEmail, etUsername, etAge, etPassword;
    public static final String STRING_KEY = "1234567891234567";
    private List<User> list_users;

    UsersDataSource user_dts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName    = (EditText) findViewById(R.id.etName);
        etEmail   = (EditText) findViewById(R.id.etEmail);
        etUsername= (EditText) findViewById(R.id.etUsername);
        etAge     = (EditText) findViewById(R.id.etAge);
        etPassword= (EditText) findViewById(R.id.etPassword);

        btRegister = (Button) findViewById(R.id.btRegister);
        btRegister.setOnClickListener(this);
        //Go back to main.
        //To go back
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_dts = new UsersDataSource(this);
        user_dts.open();
        //list_users = user_dts.findAll();
        //
        /**
         * If doesn't has nothing in (tours), enter to add
         * content to database in table tours
         */
       // if (list_users.size() != 0) {
           // refreshDisplay();
        //}

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Log.i("Register", "Item home selected in (Register)!!!!");
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btRegister:
                sec = new Security();
                //
                String name = sec.encrypt(etName.getText().toString(), STRING_KEY);
                String email = sec.encrypt(etEmail.getText().toString(), STRING_KEY);
                String username = sec.encrypt(etUsername.getText().toString(), STRING_KEY);
                String password = sec.encrypt(etPassword.getText().toString(), STRING_KEY);

                String status  = "A";

                User user = new User(name, email, username, password, 0, status);

                //Register in Local Database
                registerLocalUser(user);

                //Register in Outside WebServer
               // registerWebServerUser(user);

                list_users = user_dts.findAll();
                //refreshDisplay();

                break;
        }
    }



    private void registerLocalUser(User user){
                 createData(user);
    }

    private void createData(User user){
        user = user_dts.create(user);
        if(user.getId() > 0) {
            etName.setText("");
            etAge.setText("");
            etEmail.setText("");
            etUsername.setText("");
            etPassword.setText("");
            //
            Log.i(LOGTAG, "User Saved Sucesfully..." + user.getId());
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        user_dts.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        user_dts.close();
    }
}