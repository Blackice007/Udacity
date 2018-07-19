package com.example.monim.udacitycourse.ui.course_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.monim.udacitycourse.R;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;
import com.example.monim.udacitycourse.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity implements IDetailsView {

    @Inject
    IDetailsPresenter<IDetailsView> mPresenter;
    @Inject
    InstructorAdapter mInstructorAdapter;

    @BindView(R.id.img_banner)
    ImageView mIvBanner;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCtb;
    @BindView(R.id.tv_subtitle)
    TextView mTvSubtitle;
    @BindView(R.id.tv_expected_learning)
    TextView mTvExpectedLearning;
    @BindView(R.id.tv_featured)
    TextView mTvFratured;
    @BindView(R.id.tv_required_knowledge)
    TextView mTvRequiredKnowledge;
    @BindView(R.id.rv_instractor)
    RecyclerView mRvInstructor;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
        mPresenter.onAttach(this);
    }

    @Override
    protected void setUp() {
        Intent i = getIntent();
        Course course = (Course) i.getParcelableExtra("course");
        setData(course);
        setAdapterData(course.getInstructors());

    }

    @Override
    public void setData(Course course) {

        mTvSubtitle.setText(course.getSubtitle());
        mTvExpectedLearning.setText(course.getExpected_learning());
        mTvFratured.setText(course.getFeatured());
        mTvRequiredKnowledge.setText(course.getRequired_knowledge());
        Glide.with(getApplicationContext()).load(course.getBanner_image()).apply(new RequestOptions().placeholder(R.drawable.image_placeholder).error(R.drawable.image_placeholder)).into(mIvBanner);
        mCtb.setTitle(course.getTitle());


        mRvInstructor.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        mRvInstructor.setAdapter(mInstructorAdapter);
    }

    @Override
    public void setAdapterData(List<Instructor> instructors) {
        mInstructorAdapter.addAll(instructors);
    }
}
