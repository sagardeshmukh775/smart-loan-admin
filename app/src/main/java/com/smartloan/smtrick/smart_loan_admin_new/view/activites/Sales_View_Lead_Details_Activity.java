package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class Sales_View_Lead_Details_Activity extends AppCompatActivity {



    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__view__lead__details_);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
