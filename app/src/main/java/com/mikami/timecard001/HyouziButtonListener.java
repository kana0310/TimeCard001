package com.mikami.timecard001;

import android.content.Intent;
import android.view.View;

class HyouziButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View view){
        Intent intent = new Intent(view.getContext(),SinnpuruhyouziActivtiy.class);
        view.getContext().startActivity(intent);
    }

}
