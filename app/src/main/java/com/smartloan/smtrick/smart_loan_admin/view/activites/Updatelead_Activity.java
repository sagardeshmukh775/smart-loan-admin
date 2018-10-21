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
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin.view.dialog.ProgressDialogClass;

import java.util.HashMap;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.STATUS_VERIFIED;

public class Updatelead_Activity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    Spinner spinloantype, spinemptype, spinincome;
    Button btupdate, btverify, btcancel;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;

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
        String[] empType = new String[]{"Salaried", "Businessman"};

        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        spinemptype = (Spinner) findViewById(R.id.spoccupation1);

        btupdate = (Button) findViewById(R.id.buttonupdate);
        btverify = (Button) findViewById(R.id.buttonverify);
        btcancel = (Button) findViewById(R.id.buttoncancel);

        spinloantype.setOnItemSelectedListener(this);
        spinemptype.setOnItemSelectedListener(this);


        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        ArrayAdapter<String> spinnerArrayAdapteremptype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, empType);
        spinnerArrayAdapteremptype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinemptype.setAdapter(spinnerArrayAdapteremptype);


        btupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(Updatelead_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Updatelead_Activity.this, MainActivity_telecaller.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

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


    }//end of oncreate

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(Updatelead_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
