package com.example.jayant.phpconnect;

import java.util.Date;

/**
 * Created by JAYANT on 04-03-16.
 */
public class Product {
    int id;
    String name;
    Double price;
    String created_at;
    String updated_at;
    public Product()
    {

    }
    public Product(int a,String b,Double c,String d,String e)
    {
        this.id=a;
        this.name=b;
        this.price=c;
        this.created_at=d;
        this.updated_at=e;

    }
}
