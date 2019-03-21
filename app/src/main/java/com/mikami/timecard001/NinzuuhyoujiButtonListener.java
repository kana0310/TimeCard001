package com.mikami.timecard001;

import android.content.Intent;
import android.view.View;

public class NinzuuhyoujiButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), Ninzuuhyouji1Activity.class);
        view.getContext().startActivity(intent);
    }
}
