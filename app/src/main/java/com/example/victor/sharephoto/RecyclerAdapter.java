package com.example.victor.sharephoto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder>{

    private List<UploadContent> uploadContents;

    public RecyclerAdapter(List<UploadContent> uploadContents) {
        this.uploadContents = uploadContents;
    }

    @NonNull
    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_upload_content,parent,false);
        return new RecyclerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, int position) {

        //Set the image by the URL
        String path = uploadContents.get(position).getImageURL();
        Picasso.get().load(path).into(holder.imageURL);

        holder.imageLocation.setText(uploadContents.get(position).getImageLocation());

        holder.imageComment.setText(uploadContents.get(position).getImageComment());
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return uploadContents.size();
    }

    static class RecyclerItemViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageURL;
        TextView imageLocation;
        TextView imageComment;

        RecyclerItemViewHolder(View itemView){
            super(itemView);
            imageURL = itemView.findViewById(R.id.myImageURL);
            imageLocation = itemView.findViewById(R.id.myImageLocation);
            imageComment = itemView.findViewById(R.id.myImageComment);
        }
    }
}
