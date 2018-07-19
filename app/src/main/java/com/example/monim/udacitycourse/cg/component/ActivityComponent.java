package com.example.monim.udacitycourse.cg.component;


import com.example.monim.udacitycourse.cg.PerActivity;
import com.example.monim.udacitycourse.cg.module.ActivityModule;
import com.example.monim.udacitycourse.ui.course_details.DetailsActivity;
import com.example.monim.udacitycourse.ui.main.MainActivity;
import dagger.Component;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(DetailsActivity activity);
}
