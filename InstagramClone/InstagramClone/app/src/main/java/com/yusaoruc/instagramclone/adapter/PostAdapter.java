package com.yusaoruc.instagramclone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yusaoruc.instagramclone.databinding.RecyclerRowBinding;
import com.yusaoruc.instagramclone.model.Post;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;
    public PostAdapter(ArrayList<Post> postArrayList){
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        RecyclerRowBinding reyRecyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
                return new PostHolder(reyRecyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostAdapter.PostHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewUserEmailText.setText(postArrayList.get(position).email);
        holder.recyclerRowBinding.recyclerViewCommentView.setText(postArrayList.get(position).comment);
        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.recyclerRowBinding.recyclerViewImageView);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding recyclerRowBinding;

        public PostHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
