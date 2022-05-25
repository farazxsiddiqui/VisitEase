package com.farazzz.visitease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewEntryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, destination, comments;
    CustomAdapter customAdapter;
    ImageView emptyImage;
    TextView emptyText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entry);


        recyclerView = findViewById(R.id.recyclerView);

        emptyImage = findViewById(R.id.isEmptyImage);
        emptyText = findViewById(R.id.textView3);

        name = new ArrayList<>();
        destination = new ArrayList<>();
        comments = new ArrayList<>();
        storeData();

        customAdapter = new CustomAdapter(ViewEntryActivity.this, name, destination, comments);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewEntryActivity.this));



    }

    void storeData(){
        DatabaseHandler handler = new DatabaseHandler(ViewEntryActivity.this);
        Cursor res = handler.getVisitor();
        if (res.getCount() == 0) {
            //Toast.makeText(ViewEntryActivity.this, "No Entry found!", Toast.LENGTH_SHORT).show();
            emptyText.setVisibility(View.VISIBLE);
            emptyImage.setVisibility(View.VISIBLE);
        }
        StringBuilder sb = new StringBuilder();
        while (res.moveToNext()) {
            name.add(res.getString(0));
            destination.add(res.getString(1));
            comments.add(res.getString(2));
            emptyText.setVisibility(View.GONE);
            emptyImage.setVisibility(View.GONE);
        }

    }
}