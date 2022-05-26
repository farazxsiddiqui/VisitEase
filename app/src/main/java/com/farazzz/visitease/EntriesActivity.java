package com.farazzz.visitease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class EntriesActivity extends AppCompatActivity {

    EditText destinationText, commentsText;
    AutoCompleteTextView nameText;
    Button buttonUpdate,buttonDelete;

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
        setContentView(R.layout.activity_entries);

        nameText = findViewById(R.id.autoNameI);
        destinationText = findViewById(R.id.destinationText);
        commentsText = findViewById(R.id.commentsText);

        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        nameText.setAdapter(adapter);

        DatabaseHandler handler = new DatabaseHandler(EntriesActivity.this);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString().trim();
                String destination = destinationText.getText().toString().trim();
                String comments = commentsText.getText().toString().trim();
                if (!MainActivity.registered.containsKey(name)){
                    Toast.makeText(EntriesActivity.this, "Visitor does not exists!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkEntry = handler.addVisitor(name, destination, comments);
                    if (checkEntry == true) {
                        Toast.makeText(EntriesActivity.this, "Entry added!", Toast.LENGTH_SHORT).show();
                    } else {
                        checkEntry = handler.updateVisitor(name, destination, comments);
                        if (checkEntry == true) {
                            Toast.makeText(EntriesActivity.this, "Entry updated!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EntriesActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString().trim();

                boolean checkDeletion = handler.deleteVisitor(name);
                if (checkDeletion == true) {
                    Toast.makeText(EntriesActivity.this, "Entry deleted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EntriesActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}