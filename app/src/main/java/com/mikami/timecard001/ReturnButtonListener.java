package com.mikami.timecard001;

import android.view.View;

class ReturnButtonListener implements View.OnClickListener {
    private final SabActivity activity;

    public ReturnButtonListener(SabActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        this.activity.finish();
    }
}
