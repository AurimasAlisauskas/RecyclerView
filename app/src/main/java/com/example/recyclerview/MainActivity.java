package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reciclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reciclerView = findViewById(R.id.reciclerView);
        reciclerView.setHasFixedSize(true);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        //ListItem item1 = new ListItem("Movie 1", "It's about cocaine", "Very good!");
        //ListItem item2 = new ListItem("Movie 2", "Love story", "Boring...");

        for (int i = 0; i < 10; i++) {
            ListItem listItem = new ListItem ("Item " + (i+1),"description ", "Woop woop!");

            listItems.add(listItem);
            //listItems.add(item1);
            //listItems.add(item2);
        }

        adapter = new MyAdapter(this, listItems);
        reciclerView.setAdapter(adapter);
    }
}
