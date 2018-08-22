package com.jru.mlmsstudent.lecture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jru.mlmsstudent.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscussionListAdapter extends RecyclerView.Adapter<DiscussionListAdapter.DiscussionViewHolder> {

    private Context mContext;
    private List<DiscussionItem> mLstDiscussions;

    public DiscussionListAdapter(Context context, List<DiscussionItem> lstDiscussions) {
        this.mContext = context;
        this.mLstDiscussions = lstDiscussions;
    }

    @NonNull
    @Override
    public DiscussionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_discussion, parent, false);
        return new DiscussionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionViewHolder holder, int position) {
        DiscussionItem item = mLstDiscussions.get(position);
        holder.lblStudentName.setText("By:" + item.getStudentName());
        holder.lblQuestion.setText("Q: " + item.getQuestion());
        holder.lblAnswer.setText("A: " + item.getAnswer());
    }

    @Override
    public int getItemCount() {
        return mLstDiscussions.size();
    }

    class DiscussionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.lbl_student_name)
        TextView lblStudentName;

        @BindView(R.id.lbl_question)
        TextView lblQuestion;

        @BindView(R.id.lbl_answer)
        TextView lblAnswer;

        DiscussionViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
