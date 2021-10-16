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
    OnDiscussionListener onDiscussionListener;

    public DiscussionAdapter (Context context, ArrayList<DiscussionModel> discussionModels, OnDiscussionListener onDiscussionListener){
        this.inflater = LayoutInflater.from(context);
        this.discussionModels = discussionModels;
        this.onDiscussionListener = onDiscussionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_layout, parent, false);
        return new ViewHolder(view, onDiscussionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(discussionModels.get(position).getTitle());
        holder.image.setImageResource(Integer.parseInt(discussionModels.get(position).getAvatar()));

    }

    @Override
    public int getItemCount() {
        return discussionModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnDiscussionListener, View.OnClickListener {
        TextView name;
        ImageView image;
        OnDiscussionListener onDiscussionListener;

        public ViewHolder(@NonNull View itemView, OnDiscussionListener onDiscussionListener) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name_main);
            image = itemView.findViewById(R.id.image);
            this.onDiscussionListener = onDiscussionListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onDiscussionClick(int position) {

        }

        @Override
        public void onClick(View v) {
            onDiscussionListener.onDiscussionClick(getAbsoluteAdapterPosition());
        }
    }
    public interface OnDiscussionListener{
        void onDiscussionClick(int position);
    }
}
