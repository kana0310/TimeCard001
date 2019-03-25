package com.mikami.timecard001;

        import android.content.Intent;
        import android.view.View;

public class OtoiawaseButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), OtoiawaseActivity.class);
        view.getContext().startActivity(intent);
    }
}
