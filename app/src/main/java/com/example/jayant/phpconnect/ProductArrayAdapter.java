package com.example.jayant.phpconnect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAYANT on 04-03-16.
 */
public class ProductArrayAdapter extends ArrayAdapter<Product> {
    Context context;
    public ProductArrayAdapter(Context context,List<Product> objects) {
        super(context,0,objects);
        this.context=context;
    }

    public static class ProductViewHolder
    {
        TextView pid;
        TextView name;
        TextView rate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=View.inflate(context,R.layout.list_view_item,null);
            ProductViewHolder vh=new ProductViewHolder();
            vh.name=(TextView)convertView.findViewById(R.id.name);
            vh.pid=(TextView)convertView.findViewById(R.id.pid);
            vh.rate=(TextView)convertView.findViewById(R.id.price);
            convertView.setTag(vh);
        }
        Product p=getItem(position);
        ProductViewHolder h=(ProductViewHolder)convertView.getTag();
        h.name.setText(p.name);
        h.pid.setText(p.id+" ");
        h.rate.setText(p.price+" ");
        return convertView;
    }
}
