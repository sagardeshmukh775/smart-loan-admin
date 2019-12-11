package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_View_Lead_Details_Activity extends AppCompatActivity implements View.OnClickListener {

    CardView cardLabel, cardFollow_up, cardNotes, cardAppointment, cardDocuments;
    ImageView imgCall, imgMessage, imgEmail, imgNavigate, imgProfile;
    TextView TXTusername;

    LeedsModel leedsModel;

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

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);

        cardLabel = (CardView) findViewById(R.id.card_view_labels);
        cardFollow_up = (CardView) findViewById(R.id.card_view_foloup_task);
        cardNotes = (CardView) findViewById(R.id.card_view_notes);
        cardAppointment = (CardView) findViewById(R.id.card_view_appointment);
        cardDocuments = (CardView) findViewById(R.id.card_view_documents);

        imgCall = (ImageView) findViewById(R.id.imgCall);
        imgMessage = (ImageView) findViewById(R.id.imgMessage);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgNavigate = (ImageView) findViewById(R.id.imgNavigate);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        TXTusername = (TextView) findViewById(R.id.txtUsername);
        TXTusername.setText(leedsModel.getCustomerName());

        cardLabel.setOnClickListener(this);
        cardFollow_up.setOnClickListener(this);
        cardNotes.setOnClickListener(this);
        cardAppointment.setOnClickListener(this);
        cardDocuments.setOnClickListener(this);
        imgCall.setOnClickListener(this);
        imgMessage.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
        imgNavigate.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == cardLabel){
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this,Sales_Tasks_Activity.class);
            intent.putExtra("Task","Label");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        }else   if (v == cardFollow_up){
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this,Sales_Tasks_Activity.class);
            intent.putExtra("Task","FallowUp");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        }else   if (v == cardNotes){
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this,Sales_Tasks_Activity.class);
            intent.putExtra("Task","Notes");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        }else   if (v == cardAppointment){
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this,Sales_Tasks_Activity.class);
            intent.putExtra("Task","Appointment");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        }else   if (v == cardDocuments){
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this,Sales_Tasks_Activity.class);
            intent.putExtra("Task","Docs");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        }else   if (v == imgCall){

        }
    }
}
