package com.example.jayant.phpconnect;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button viewProducts;
    Button newProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewProducts=(Button)findViewById(R.id.viewproducts);
        newProduct=(Button)findViewById(R.id.createproducts);
        viewProducts.setOnClickListener(this);
        newProduct.setOnClickListener(this);






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View v) {
        if(v==viewProducts)
        {
            Intent i=new Intent();
            i.setClass(this,AllProducts.class);
            startActivity(i);
        }
        else if(v==newProduct)
        {
            Intent i=new Intent();
            i.setClass(this,NewProductActivity.class);
            startActivity(i);

        }
    }
}
