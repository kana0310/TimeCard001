package com.mikami.timecard001;

import android.view.View;

class KyannseruButtonClickListener implements View.OnClickListener {
    private final OtoiawaseActivity actitvity;

    public KyannseruButtonClickListener(OtoiawaseActivity activity) {
        this.actitvity = activity;
    }

    @Override
    public void onClick(View view) {
        this.actitvity.finish();
    }
}
