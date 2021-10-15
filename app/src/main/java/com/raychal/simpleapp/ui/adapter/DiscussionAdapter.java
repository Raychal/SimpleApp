package com.raychal.simpleapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raychal.simpleapp.R;
import com.raychal.simpleapp.model.DiscussionModel;

import java.util.ArrayList;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<DiscussionModel> discussionModels;

    public DiscussionAdapter (Context context, ArrayList<DiscussionModel> discussionModels){
        this.inflater = LayoutInflater.from(context);
        this.discussionModels = discussionModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_user_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(discussionModels.get(position).getTitle());
        holder.image.setImageResource(Integer.parseInt(discussionModels.get(position).getAvatar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(inflater.getContext(), "Hai",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return discussionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name_main);
            image = itemView.findViewById(R.id.image);
        }
    }
}
