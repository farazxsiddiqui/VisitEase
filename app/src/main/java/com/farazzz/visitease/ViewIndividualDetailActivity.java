package com.farazzz.visitease;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class ViewIndividualDetailActivity extends AppCompatActivity {
    Context context = ViewIndividualDetailActivity.this;
    Button detailsButton;
    AutoCompleteTextView autoText;
    DatabaseHandler handler = new DatabaseHandler(ViewIndividualDetailActivity.this);

    String[] names = new String[MainActivity.registered.size()];
    boolean[] checkedItems = new boolean[MainActivity.registered.size()];
    int i = 0;
    {
        for (Map.Entry<String, SimilarityClassifier.Recognition> entry : MainActivity.registered.entrySet()) {
            //System.out.println("NAME"+entry.getKey());
            names[i] = entry.getKey();
            checkedItems[i] = false;
            i = i + 1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_individual_detail);
        detailsButton = findViewById(R.id.detailsButton);
        autoText =  findViewById(R.id.autoName);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        autoText.setAdapter(adapter);


        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = autoText.getText().toString().trim();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Details of " + name);
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                Cursor res = handler.getVisitor(name);
                if (res.getCount() == 0) {
                    Toast.makeText(ViewIndividualDetailActivity.this, "No Entry found!", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                while (res.moveToNext()) {
                    sb.append("Name: " + res.getString(0) + "\n");
                    sb.append("Destination: " + res.getString(1) + "\n");
                    sb.append("Comments: " + res.getString(2) + "\n\n");
                }
                builder.setMessage(sb.toString());
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });

    }
}