package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class Sales_View_Lead_Details_Activity extends AppCompatActivity {

    CardView cardLabel, cardFolloe_up, cardNotes, cardAppointment, cardDocuments;
    ImageView imgCall, imgMessage, imgEmail, imgNavigate, imgProfile;
    TextView TXTusername;

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

        cardLabel = (CardView) findViewById(R.id.card_view_labels);
        cardFolloe_up = (CardView) findViewById(R.id.card_view_foloup_task);
        cardNotes = (CardView) findViewById(R.id.card_view_notes);
        cardAppointment = (CardView) findViewById(R.id.card_view_appointment);
        cardDocuments = (CardView) findViewById(R.id.card_view_documents);

        imgCall = (ImageView) findViewById(R.id.imgCall);
        imgMessage = (ImageView) findViewById(R.id.imgMessage);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgNavigate = (ImageView) findViewById(R.id.imgNavigate);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        TXTusername = (TextView) findViewById(R.id.txtUsername);

        cardLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
