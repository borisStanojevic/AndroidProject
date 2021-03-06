package com.example.student.myproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.myproject.R;
import com.example.student.myproject.model.Post;
import com.example.student.myproject.util.Util;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends ArrayAdapter<Post> {

    public PostsAdapter(Context context, List<Post> posts)
    {
        super(context, 0, posts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //Vraca Post objekat koji se nalazi na poziciji 'position'
        Post post = getItem(position);

        if (convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.posts_list_item, parent, false);
        }

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.iv_post_photo);
        TextView tvId = (TextView) convertView.findViewById(R.id.tv_post_id);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_post_title);
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_post_content);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tv_post_author);
        TextView tvDatePosted = (TextView) convertView.findViewById(R.id.tv_date_posted);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tv_post_likes);
        TextView tvDislikes = (TextView) convertView.findViewById(R.id.tv_post_dislikes);

        String url = Util.SERVICE_API_PATH + "images/" + post.getPhoto();
        Picasso.get().load(url).memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE).into(ivPhoto);
        tvId.setText(String.valueOf(post.getId()));
        tvTitle.setText(post.getTitle());
        tvContent.setText(post.getContent());
        tvAuthor.setText(post.getAuthor().getUsername());
        tvDatePosted.setText(post.getDate());
        tvLikes.setText(String.valueOf(post.getLikes()) + " ");
        tvDislikes.setText(" " + String.valueOf(post.getDislikes()));


        return convertView;
    }

}
