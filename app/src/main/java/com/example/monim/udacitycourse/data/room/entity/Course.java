package com.example.monim.udacitycourse.data.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */
@Entity
public class Course  implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "localId")
    private int localId;

    @ColumnInfo(name = "subtitle")
    private String subtitle;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "key")
    private String key;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "banner_image")
    private String banner_image;

    @ColumnInfo(name = "expected_learning")
    private String expected_learning;

    @ColumnInfo(name = "featured")
    private String featured;

    @ColumnInfo(name = "project_description")
    private String project_description;

    @ColumnInfo(name = "level")
    private String level;

    @ColumnInfo(name = "expected_duration_unit")
    private String expected_duration_unit;

    @ColumnInfo(name = "expected_duration")
    private String expected_duration;

    @ColumnInfo(name = "summary")
    private String summary;

    @ColumnInfo(name = "project_name")
    private String project_name;

    @ColumnInfo(name = "required_knowledge")
    private String required_knowledge;

    @ColumnInfo(name = "syllabus")
    private String syllabus;

    @Ignore
    private List<Instructor> instructors;

    public Course()
    {

    }


    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExpected_learning() {
        return expected_learning;
    }

    public void setExpected_learning(String expected_learning) {
        this.expected_learning = expected_learning;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExpected_duration_unit() {
        return expected_duration_unit;
    }

    public void setExpected_duration_unit(String expected_duration_unit) {
        this.expected_duration_unit = expected_duration_unit;
    }

    public String getExpected_duration() {
        return expected_duration;
    }

    public void setExpected_duration(String expected_duration) {
        this.expected_duration = expected_duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getRequired_knowledge() {
        return required_knowledge;
    }

    public void setRequired_knowledge(String required_knowledge) {
        this.required_knowledge = required_knowledge;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }


    protected Course(Parcel in) {
        localId = in.readInt();
        subtitle = in.readString();
        title = in.readString();
        key = in.readString();
        image = in.readString();
        banner_image = in.readString();
        expected_learning = in.readString();
        featured = in.readString();
        project_description = in.readString();
        level = in.readString();
        expected_duration_unit = in.readString();
        expected_duration = in.readString();
        summary = in.readString();
        project_name = in.readString();
        required_knowledge = in.readString();
        syllabus = in.readString();
        instructors = in.createTypedArrayList(Instructor.CREATOR);
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(localId);
        dest.writeString(subtitle);
        dest.writeString(title);
        dest.writeString(key);
        dest.writeString(image);
        dest.writeString(banner_image);
        dest.writeString(expected_learning);
        dest.writeString(featured);
        dest.writeString(project_description);
        dest.writeString(level);
        dest.writeString(expected_duration_unit);
        dest.writeString(expected_duration);
        dest.writeString(summary);
        dest.writeString(project_name);
        dest.writeString(required_knowledge);
        dest.writeString(syllabus);
        dest.writeTypedList(instructors);
    }
}
