package com.example.folding_cell_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private ItemAdapter itemAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));

        recyclerView = findViewById(R.id.folding_cell_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);

        itemAdapter = new ItemAdapter(this);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.setData(getDataItem());
    }

    private ArrayList<Item> getDataItem () {
        ArrayList<Item> mItemList = new ArrayList<>();

        mItemList.add(new Item("HELLO WORLD 1","CONTENT WORLD 1"));
        mItemList.add(new Item("HELLO WORLD 2","CONTENT WORLD 2"));
        mItemList.add(new Item("HELLO WORLD 3","CONTENT WORLD 3"));
        mItemList.add(new Item("HELLO WORLD 4","CONTENT WORLD 4"));
        mItemList.add(new Item("HELLO WORLD 5","CONTENT WORLD 5"));
        mItemList.add(new Item("HELLO WORLD 6","CONTENT WORLD 6"));

        mItemList.add(new Item("HELLO WORLD 1","CONTENT WORLD 1"));
        mItemList.add(new Item("HELLO WORLD 2","CONTENT WORLD 2"));
        mItemList.add(new Item("HELLO WORLD 3","CONTENT WORLD 3"));
        mItemList.add(new Item("HELLO WORLD 4","CONTENT WORLD 4"));
        mItemList.add(new Item("HELLO WORLD 5","CONTENT WORLD 5"));
        mItemList.add(new Item("HELLO WORLD 6","CONTENT WORLD 6"));

        return mItemList;
    }
}