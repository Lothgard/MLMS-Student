package com.jru.mlmsstudent.lecture;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jru.mlmsstudent.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LectureListAdapter extends RecyclerView.Adapter<LectureListAdapter.LectureListViewHolder> {

    private Context mContext;
    private List<Lecture> mLstLecture;

    public LectureListAdapter(Context context, List<Lecture> lstLecture) {
        this.mContext = context;
        this.mLstLecture = lstLecture;
    }

    @NonNull
    @Override
    public LectureListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_lecture, parent, false);
        return new LectureListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureListViewHolder holder, int position) {
        final Lecture item = mLstLecture.get(position);

        holder.itemLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LectureActivity.class);
                intent.putExtra("lecture", item);
                mContext.startActivity(intent);
            }
        });

        holder.lblTitle.setText(item.getTitle());
        holder.lblDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mLstLecture.size();
    }

    class LectureListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_lecture)
        RelativeLayout itemLecture;

        @BindView(R.id.lbl_title)
        TextView lblTitle;

        @BindView(R.id.lbl_description)
        TextView lblDescription;

        public LectureListViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
