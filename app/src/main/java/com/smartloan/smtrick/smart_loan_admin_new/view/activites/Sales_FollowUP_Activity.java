package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

public class Sales_FollowUP_Activity extends AppCompatActivity {

    TextView title;
    ImageView AdTask;
    LeedsModel leedsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__follow_up_);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);

        title = (TextView) findViewById(R.id.title);
        title.setText(leedsModel.getCustomerName());
        AdTask = (ImageView) findViewById(R.id.add_task);
    }
}
