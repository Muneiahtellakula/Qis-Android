package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MovieViewHolder> {
    Context ctx;
    String t[];
    String st[];
    int poster[];

    public MyAdapter(Context ctx, String[] t, String[] st, int[] poster) {
        this.ctx = ctx;
        this.t = t;
        this.st = st;
        this.poster = poster;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.row,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.title_t.setText(t[position]);
        holder.subtitle_t.setText(st[position]);
       holder.img.setImageResource(poster[position]);
       holder.img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(ctx, "Clicked "+holder.title_t.getText().toString(), Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    public int getItemCount() {
        return t.length;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title_t,subtitle_t;
        ImageView img;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title_t=itemView.findViewById(R.id.movie_title);
            subtitle_t=itemView.findViewById(R.id.movie_subtitle);
            img=itemView.findViewById(R.id.iv);
        }
    }
}
