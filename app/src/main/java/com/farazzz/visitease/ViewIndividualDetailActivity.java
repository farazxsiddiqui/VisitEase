package com.farazzz.visitease;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewIndividualDetailActivity extends AppCompatActivity {
    Context context = ViewIndividualDetailActivity.this;
    TextView nameText;
    Button detailsButton;
    DatabaseHandler handler = new DatabaseHandler(ViewIndividualDetailActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_individual_detail);

        nameText = findViewById(R.id.nameTextD);
        detailsButton = findViewById(R.id.detailsButton);


        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString().trim();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Details of "+name);
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