package com.jru.mlmsstudent.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jru.mlmsstudent.R;
import com.jru.mlmsstudent.apioriginal.QuizData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {

    private Context mContext;
    private List<QuizData> mList;

    public QuizListAdapter(Context context, List<QuizData> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_quiz_data, parent, false);
        return new QuizListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {
        QuizData item = mList.get(position);
        holder.lblTitle.setText(item.getTitle());

        holder.quizDataItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, QuizActivity.class);
                mContext.startActivity(intent);
            }
        });
    }


    public int getItemCount() {
        return mList.size();
    }

    public class QuizListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_quiz_data)
        LinearLayout quizDataItem;

        @BindView(R.id.lbl_title)
        TextView lblTitle;

        public QuizListViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
