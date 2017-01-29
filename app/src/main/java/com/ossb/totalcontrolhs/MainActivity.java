package com.ossb.totalcontrolhs;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ossb.totalcontrolhs.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        Context context = null;
        int duration;
        Toast toast = null;
        CharSequence text;

        switch (item.getItemId()) {
            case R.id.action_settings:
                context = getApplicationContext();
                text = "Hello Setting!";
                duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.show();
                break;

            case R.id.action_users:
                intent = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(intent);;
                break;

            case R.id.action_customer:
                intent = new Intent(MainActivity.this, CustomerActivity.class);
                startActivity(intent);
                break;

            case R.id.action_product:
                context = getApplicationContext();
                text = "Hello Products!";
                duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.show();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
