package com.ossb.totalcontrolhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.util.Log;

import com.ossb.totalcontrolhs.R;

public class CustomerActivity extends AppCompatActivity {

    public static final String LOGTAG = "CUSTOMERActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        //To go back
       //getActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == android.R.id.home) {
           Log.i("Customer", "Go back to home......!!");
           finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
