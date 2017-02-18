package com.rajsuvariya.diffutilsrecyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rajsuvariya.diffutilsrecyclerview.Adapter.MyRecyclerViewAdapter;
import com.rajsuvariya.diffutilsrecyclerview.DataFactory.DataGenerator;
import com.rajsuvariya.diffutilsrecyclerview.Model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> result;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new MyRecyclerViewAdapter(DataGenerator.getData());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.onNewProducts(DataGenerator.getUpdatedData());
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}