package com.example.jayant.phpconnect;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by JAYANT on 04-03-16.
 */
public class AllProductsAsyncTask extends AsyncTask<String,Void,Product[]> {
    AllProductsInterface listener;
    @Override
    protected Product[] doInBackground(String... params) {
        String urlString=params[0];
        Log.i("st",urlString);
        try {
            Log.i("ch","ch");
            URL url=new URL(urlString);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream data=urlConnection.getInputStream();
            Scanner s=new Scanner(data);
            StringBuffer output=new StringBuffer();
            while(s.hasNext())
            {
                output.append(s.nextLine());
            }
            Log.i("output", output.toString());
            s.close();
            urlConnection.disconnect();
            Log.i("out", "Done");
            return parseProductJson(output.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Product[] parseProductJson(String s) {
        try {
            JSONObject object = new JSONObject(s);
            int x=Integer.parseInt(object.getString("success"));

            if(x==1)
            {
                JSONArray jsArray=object.getJSONArray("products");
                Product[] prd = new Product[jsArray.length()];
                for(int i=0;i<jsArray.length();i++)
                {
                    JSONObject product=jsArray.getJSONObject(i);
                    Product productItem=new Product();
                    productItem.id=Integer.parseInt(product.getString("pid"));
                    productItem.name=product.getString("name");
                    productItem.price=Double.parseDouble(product.getString("price"));
                    productItem.created_at=product.getString("created_at");
                    productItem.updated_at=product.getString("updated_at");

                    prd[i]=productItem;
                }
                return prd;

            }
            else
            {
                int c=0;
                Product[] prd=new Product[c];
                return prd;
            }
        }
        catch (JSONException e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Product[] pr) {
        if(listener!=null)
            listener.ProductsTaskOnComplete(pr);
    }
}
