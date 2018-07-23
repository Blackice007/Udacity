package com.example.monim.udacitycourse.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.monim.udacitycourse.R;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.ui.base.BaseActivity;
import com.example.monim.udacitycourse.ui.course_details.DetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements IMainView, CourseAdapter.ICallback {

    @Inject
    IMainPresenter<IMainView> mPresenter;
    @Inject
    CourseAdapter mCourseAdapter;


    @BindView(R.id.rv_courses)
    RecyclerView mRvCourses;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public MainActivity context() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        setUp();
        mPresenter.onAttach(this);
    }

    @Override
    protected void setUp() {
        mCourseAdapter.setCallback(this);
        mRvCourses.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRvCourses.setAdapter(mCourseAdapter);
    }

    @Override
    public void setAdapterData(List<Course> courses) {
        mCourseAdapter.addAll(courses);
    }

    @Override
    public void onItemClickListener(Course course) {

        Intent intent = DetailsActivity.getStartIntent(getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putParcelable("course", course);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
