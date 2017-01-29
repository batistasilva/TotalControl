package com.ossb.totalcontrolhs.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ossb.totalcontrolhs.model.Customer;
import com.ossb.totalcontrolhs.util.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by batista on 08/11/16.
 */

public class CustomerDataSource {
    public static final String LOGTAG = "CUSTOMER";
    public static final String STRING_KEY = "1234567891234567";
    String vname, vemail, vphone, vmobil, vwhatsup;
    Security sec;
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            CustomerDBOpenHelper.COLUMN_ID,
            CustomerDBOpenHelper.COLUMN_NAME,
            CustomerDBOpenHelper.COLUMN_EMAIL,
            CustomerDBOpenHelper.COLUMN_PHONE,
            CustomerDBOpenHelper.COLUMN_MOBIL,
            CustomerDBOpenHelper.COLUMN_WHATSUP,
            CustomerDBOpenHelper.COLUMN_CREAT,
            CustomerDBOpenHelper.COLUMN_UPDATE};

    public CustomerDataSource(Context context) {
        dbhelper = new CustomerDBOpenHelper(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database opened");
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database closed");
        dbhelper.close();
    }

    /***
     * Method to add new Customer to table Customer
     * @param Customer
     * @return customer with ID
     */
    public Customer create(Customer customer) {
        ContentValues values = new ContentValues();
        //
        values.put(CustomerDBOpenHelper.COLUMN_NAME, customer.getName());
        values.put(CustomerDBOpenHelper.COLUMN_EMAIL, customer.getEmail());
        values.put(CustomerDBOpenHelper.COLUMN_PHONE, customer.getTelphone());
        values.put(CustomerDBOpenHelper.COLUMN_MOBIL, customer.getMobilphone());
        values.put(CustomerDBOpenHelper.COLUMN_WHATSUP, customer.getWhatsup());
        values.put(CustomerDBOpenHelper.COLUMN_CREAT, customer.getDatecreat());
        //
        long insertid = database.insert(CustomerDBOpenHelper.TABLE_CUSTOMER, null, values);
        customer.setId(insertid);
        //
        return customer;
    }

    public List<Customer> findAll() {
        //
        Cursor cursor = database.query(CustomerDBOpenHelper.TABLE_CUSTOMER, allColumns,
                null, null, null, null, null);

        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows");
        List<Customer> custs = cursorToList(cursor);
        //
        return custs;
    }

    public List<Customer> findFiltered(String selection, String orderBy) {
        //
        Cursor cursor = database.query(CustomerDBOpenHelper.TABLE_CUSTOMER, allColumns,
                selection, null, null, null, orderBy);

        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows");
        List<Customer> custs = cursorToList(cursor);
        //
        return custs;
    }

    private List<Customer> cursorToList(Cursor cursor) {
        List<Customer> custs = new ArrayList<Customer>();

        if (cursor.getCount() > 0) {
            sec = new Security();
            //
            while (cursor.moveToNext()) {
                Customer cust = new Customer();
                //
                cust.setId(cursor.getLong(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_ID)));
                vname = cursor.getString(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_NAME));
                //
                cust.setName(sec.decrypt(vname, STRING_KEY));
                //
                vemail = cursor.getString(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_EMAIL));
                cust.setEmail(sec.decrypt(vemail, STRING_KEY));
                //
                vphone = cursor.getString(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_PHONE));
                cust.setTelphone(sec.decrypt(vphone, STRING_KEY));
                //
                vmobil = cursor.getString(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_MOBIL));
                cust.setMobilphone(sec.decrypt(vmobil, STRING_KEY));
                //
                vwhatsup = cursor.getString(cursor.getColumnIndex(CustomerDBOpenHelper.COLUMN_WHATSUP));
                cust.setWhatsup(sec.decrypt(vwhatsup, STRING_KEY));

                custs.add(cust);
            }
        }
        return custs;
    }
}
