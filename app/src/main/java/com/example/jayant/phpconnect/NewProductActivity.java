package com.example.jayant.phpconnect;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class NewProductActivity extends ActionBarActivity implements AllProductsInterface{

    private static String url_all_products="http://192.168.56.1/android_connect/get_all_products.php";
    ProductArrayAdapter adapter;
    ArrayList<Product> prdcts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        prdcts=new ArrayList<Product>();
        Product prd=new Product(1,"ja",50.00,"ka","la");
        for(int i=0;i<10;i++)
        {
            prdcts.add(prd);
        }
        adapter=new ProductArrayAdapter(this,prdcts);
        Log.i("hello","");


        ListView lv=(ListView)findViewById(R.id.listView);
        //adapter=new ProductArrayAdapter(this,prdcts);
        lv.setAdapter(adapter);
        AllProductsAsyncTask task=new AllProductsAsyncTask();
        task.listener=this;
        task.execute(url_all_products);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_product, menu);
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

    @Override
    public void ProductsTaskOnComplete(Product[] prd) {
        prdcts.clear();
        for(Product s:prd)
        {
            prdcts.add(s);
        }
        adapter.notifyDataSetChanged();
    }
}
