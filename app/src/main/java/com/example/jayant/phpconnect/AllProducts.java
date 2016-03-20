package com.example.jayant.phpconnect;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class AllProducts extends ActionBarActivity {

    ArrayList<Product> products;
    ProductArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
    /*    ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<10;i++)
        {
            arr.add(i);
        }

        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arr);
    */
        products=new ArrayList<Product>();
        Product prd=new Product(1,"ja",50.00,"ka","la");
        for(int i=0;i<10;i++)
        {
            products.add(prd);
        }
        adapter=new ProductArrayAdapter(this,products);
        ListView v=(ListView)findViewById(R.id.listView);
        v.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_products, menu);
        return true;
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
