package com.example.victor.sharephoto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder>{

    private List<UploadContent> uploadContents;
    private Context mContext;

    public RecyclerAdapter(List<UploadContent> uploadContents, Context context) {
        this.uploadContents = uploadContents;
        this.mContext = context;
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
        Glide.with(mContext).load(path)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageURL);

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

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        // This will force all models to be unbound and their views recycled once the RecyclerView is no longer in use. We need this so resources
        // are properly released, listeners are detached, and views can be returned to view pools (if applicable).
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            ((LinearLayoutManager) recyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
        }
    }
}
