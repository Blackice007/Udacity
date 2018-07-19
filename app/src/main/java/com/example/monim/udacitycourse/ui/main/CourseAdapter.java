package com.example.monim.udacitycourse.ui.main;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_LOADING = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private List<Course> mCourses = new ArrayList<>();
    private Context mContext;
    private ICallback mICallback;

    public CourseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false));
            case VIEW_TYPE_LOADING:
            default:
                return new LoadingViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mCourses.size() > 0 ? mCourses.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return mCourses.size() > 0 && mCourses != null ? VIEW_TYPE_NORMAL : VIEW_TYPE_LOADING;
    }

    public void addAll(List<Course> courses) {
        mCourses.addAll(courses);
        notifyDataSetChanged();
    }

    public void setCallback(ICallback iCallback) {
        mICallback = iCallback;
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_title)
        TextView mTvTitle;

        @BindView(R.id.tv_level)
        TextView mTvLevel;

        @BindView(R.id.tv_duration)
        TextView mTvDuration;

        @BindView(R.id.tv_summary)
        TextView mTvSummary;

        @BindView(R.id.tv_instructor_name)
        TextView mTvInstructorName;

        @BindView(R.id.tv_bio)
        TextView mTvBio;

        @BindView(R.id.iv_course)
        ImageView mIvCourse;

        @BindView(R.id.iv_instructor)
        ImageView mIvInstractor;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void onBind(final int position) {
            super.onBind(position);

            Course course = mCourses.get(position);

            mTvTitle.setText(course.getTitle());
            mTvLevel.setText(course.getLevel());
            mTvDuration.setText(course.getExpected_duration_unit());
            mTvSummary.setText(course.getSummary());


            Glide.with(mContext).load(course.getBanner_image()).apply(new RequestOptions().placeholder(R.drawable.image_placeholder).error(R.drawable.image_placeholder)).into(mIvCourse);

            if(course.getInstructors().size()>0)
            {
                Instructor instructor = course.getInstructors().get(0);
                mTvInstructorName.setText(instructor.getName());
                mTvBio.setText(instructor.getBio());
                Glide.with(mContext).load(instructor.getImage()).apply(new RequestOptions().circleCropTransform()).into(mIvInstractor);
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mICallback.onItemClickListener(mCourses.get(position));
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
        void onItemClickListener(Course course);
    }


}
