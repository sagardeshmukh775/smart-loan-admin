package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.GLOBAL_DATE_FORMATE;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.GLOBAL_TIME_FORMATE;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.STATUS_VERIFIED;

public class Updatelead_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinloantype;
    Button btupdate, btverify, btcancel,btnupdatenext;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    SimpleDateFormat sfd;


    String lGenby,sploantype,cPartner;
    TextView txtldate,txtleadid,txtgeneratedby,txtleadidtop,txttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};

        btupdate = (Button) findViewById(R.id.buttonupdate);
        btverify = (Button) findViewById(R.id.buttonverify);
        btcancel = (Button) findViewById(R.id.buttoncancel);
        btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);

        txtldate = (TextView) findViewById(R.id.txtdate1);
        txttime = (TextView) findViewById(R.id.txtleedtime1);
        txtleadid = (TextView) findViewById(R.id.txtleadidvalue);
        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        txtgeneratedby = (TextView) findViewById(R.id.txtagentid1);
        txtleadidtop = (TextView) findViewById(R.id.textheader);
       // txtpartner = (TextView) findViewById(R.id.txtchannelpartner1);

        spinloantype.setOnItemSelectedListener(this);


        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        getdata();

        btupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




            }
        });

        btverify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setLeedStatus(leedsModel);
            }
        });


        btcancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(Updatelead_Activity.this, MainActivity_telecaller.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        btnupdatenext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

             //  cPartner =txtpartner.getText().toString();

                updateLeadDetails(leedsModel);
                Toast.makeText(Updatelead_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(Updatelead_Activity.this, TL_Updatelead_C_Details_Activity.class);
                i.putExtra(LEED_MODEL, leedsModel);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });



    }//end of oncreate


    private void getdata() {

       try {



           String leedid = leedsModel.getLeedNumber();
           String agentname = leedsModel.getAgentName();

           Long ldatetime = leedsModel.getCreatedDateTimeLong();
           Long time = leedsModel.getCreatedDateTimeLong();
           String loantype = leedsModel.getLoanType();

           ArrayAdapter myAdap = (ArrayAdapter) spinloantype.getAdapter();
           int spinnerPosition = myAdap.getPosition(loantype);
           spinloantype.setSelection(spinnerPosition);

           // String strdate = Long.toString(ldatetime);

          // String partner = leedsModel.getChannelPartner();

//           if (partner != null){
//               txtpartner.setText(partner);
//           }

            if (ldatetime != null) {


                txtldate.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
            }
            if (time != null){
                txttime.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong(), GLOBAL_TIME_FORMATE));
            }
            if (leedid != null) {
                txtleadid.setText(leedid);
                txtleadidtop.setText(leedid);
            }
           if (agentname != null) {
               txtgeneratedby.setText(agentname);

           }


        }catch (Exception e){}

    }
    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }


    private void updateLeadDetails(LeedsModel leedsModel) {
     //   leedsModel.setChannelPartner(cPartner);
        leedsModel.setLoanType(sploantype);


        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }



    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
             //   Toast.makeText(Updatelead_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(Updatelead_Activity.this, getString(R.string.server_error));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
         sploantype = spinloantype.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
