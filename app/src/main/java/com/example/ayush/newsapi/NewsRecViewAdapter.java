package com.example.ayush.newsapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import com.example.ayush.newsapi.discarded.NewsModel;

public class NewsRecViewAdapter extends RecyclerView.Adapter<NewsRecViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Article> articles;

    public NewsRecViewAdapter(Context mContext, List<Article> res) {
        this.mContext = mContext;
        this.articles = res;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView avatarUrl;
        TextView author;
        TextView tvDescription;
        TextView title;
        TextView publishedDate;
        //TextView comments;

        public ViewHolder(final View itemView) {
            super(itemView);

            avatarUrl = itemView.findViewById(R.id.cv_news_avatar);
            author = itemView.findViewById(R.id.tv_news_author);
            tvDescription = itemView.findViewById(R.id.tv_issue_desc);
            title = itemView.findViewById(R.id.tv_news_title);
            publishedDate = itemView.findViewById(R.id.tv_news_published_at);
            //comments = itemView.findViewById(R.id.tv_issue_no_comments);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();

                    int pos = getAdapterPosition();
                    NewsModel tempNews = list.get(pos);
                    bundle.putSerializable("News", tempNews);

                    Intent intent = new Intent(mContext, MainActivity.class);
                    //intent.putExtra("payload", bundle);
                    mContext.startActivity(intent);
                }
            });
            */

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article tempObj = articles.get(position);

        Picasso.with(mContext)
                .load(tempObj.getUrlToImage())
                .fit()
                .into(holder.avatarUrl);

        holder.title.setText(tempObj.getTitle());

        holder.author.setText(tempObj.getAuthor());

        holder.tvDescription.setText(tempObj.getDescription());

        //holder.comments.setText(String.valueOf(tempObj.getComments()));

        holder.publishedDate.setText(tempObj.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setData(List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }

}
