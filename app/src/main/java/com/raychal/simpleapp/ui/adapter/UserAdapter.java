package com.raychal.simpleapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.raychal.simpleapp.R;
import com.raychal.simpleapp.model.UserModel;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<UserModel> userModels;
    OnUsersListener onUsersListener;

    public UserAdapter (Context context, ArrayList<UserModel> userModels, OnUsersListener onUsersListener){
        this.inflater = LayoutInflater.from(context);
        this.userModels = userModels;
        this.onUsersListener = onUsersListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_layout, parent, false);
        return new ViewHolder(view, onUsersListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.name.setText(userModels.get(position).getUsername());
        holder.image.setImageResource(Integer.parseInt(userModels.get(position).getAvatar()));
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnUsersListener, View.OnClickListener {
        TextView name;
        ImageView image;
        OnUsersListener onUsersListener;

        public ViewHolder(@NonNull View itemView, OnUsersListener onUsersListener) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name_main);
            image = itemView.findViewById(R.id.image);
            this.onUsersListener = onUsersListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onUsersClick(int position) {

        }

        @Override
        public void onClick(View v) {
            onUsersListener.onUsersClick(getAbsoluteAdapterPosition());
        }
    }

    public interface OnUsersListener{
        void onUsersClick(int position);
    }
}
