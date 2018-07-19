package com.example.monim.udacitycourse.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int mCurrentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void onBind(int position) {
        mCurrentPosition = position;
    }
    public int getCurrentPosition() {
        return mCurrentPosition;
    }

}
