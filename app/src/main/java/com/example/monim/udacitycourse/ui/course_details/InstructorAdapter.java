package com.example.monim.udacitycourse.ui.course_details;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.monim.udacitycourse.R;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;
import com.example.monim.udacitycourse.ui.base.BaseViewHolder;
import com.example.monim.udacitycourse.ui.main.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstructorAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private List<Instructor> mInstructors = new ArrayList<>();
    private Context mContext;
    private ICallback mICallback;

    public InstructorAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instructor, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new LoadingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mInstructors.size() > 0 ? mInstructors.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return mInstructors.size() > 0 && mInstructors != null ? VIEW_TYPE_NORMAL : VIEW_TYPE_EMPTY;
    }

    public void addAll(List<Instructor> instructors) {
        mInstructors.addAll(instructors);
        notifyDataSetChanged();
    }

    public void setCallback(ICallback iCallback) {
        mICallback = iCallback;
    }

    public class ViewHolder extends BaseViewHolder {


        @BindView(R.id.tv_instructor_name)
        TextView mTvInstructorName;

        @BindView(R.id.tv_bio)
        TextView mTvBio;

        @BindView(R.id.iv_instructor)
        ImageView mIvInstractor;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void onBind(final int position) {
            super.onBind(position);

            final Instructor instructor = mInstructors.get(position);

            mTvInstructorName.setText(instructor.getName());
            mTvBio.setText(instructor.getBio());
            Glide.with(mContext).load(instructor.getImage()).apply(new RequestOptions().circleCropTransform()).into(mIvInstractor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mICallback.onItemClickListener(instructor);
                }
            });

        }

    }

    public class LoadingViewHolder extends BaseViewHolder {

        public LoadingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void onBind(int position) {
            super.onBind(position);

        }

    }

    public interface ICallback {
        void onItemClickListener(Instructor instructor);
    }
}
