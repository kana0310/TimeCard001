package com.mikami.timecard001;

import android.content.Intent;
import android.view.View;

class Ninzuuhyouji2ButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), Ninzuuhyouzi2Activtiy.class);
        view.getContext().startActivity(intent);
    }
}
