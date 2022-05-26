package com.farazzz.visitease;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList name, destination, comments;

    Animation translate;


    CustomAdapter(Context context
            ,ArrayList name
            ,ArrayList destination
            ,ArrayList comments ) {
        this.context = context;
        this.name = name;
        this.destination = destination;
        this.comments = comments;



    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.details_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameViewT.setText("Name: "+String.valueOf(name.get(position)));
        holder.destinationViewT.setText("Destination: "+String.valueOf(destination.get(position)));
        holder.commentsViewT.setText("Comments: "+String.valueOf(comments.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameViewT, destinationViewT, commentsViewT;
        LinearLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameViewT = itemView.findViewById(R.id.nameTextView);
            destinationViewT = itemView.findViewById(R.id.destinationTextView);
            commentsViewT = itemView.findViewById(R.id.commentsTextView);
            mainLayout = itemView.findViewById(R.id.linearLayout);
            //Animate recycler view
            translate = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate);

        }
    }
}
