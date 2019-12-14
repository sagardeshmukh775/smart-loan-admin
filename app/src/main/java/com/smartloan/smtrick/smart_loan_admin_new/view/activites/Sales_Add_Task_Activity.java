package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

public class Sales_Add_Task_Activity extends AppCompatActivity {

    LeedsModel leedsModel;
    ImageView imgReminder,imgTeskDesc;
    TextView inputUserName;
    EditText edtDescription;
    LinearLayout layoutDescription;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__add__task_);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        imgReminder = (ImageView) findViewById(R.id.reminder);
        imgTeskDesc = (ImageView) findViewById(R.id.desc);
        inputUserName = (TextView) findViewById(R.id.user_name);
        inputUserName.setText(leedsModel.getAgentName());
        edtDescription = (EditText) findViewById(R.id.edtDesc);
        layoutDescription = (LinearLayout) findViewById(R.id.layout_Desc);

        layoutDescription.setVisibility(View.GONE);
        imgTeskDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDescription.setVisibility(View.VISIBLE);
            }
        });
    }
}
