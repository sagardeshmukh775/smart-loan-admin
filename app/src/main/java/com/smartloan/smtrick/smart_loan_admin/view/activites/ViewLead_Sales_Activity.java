package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.STATUS_BANK_SUBMITED;

public class ViewLead_Sales_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinloantype, spinemptype, spinincome;
    Button btupdate, btverify, btcancel;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;
    EditText etcname,etbank,etaddress,etpropaddress,etoffaddress,etcontatct,etalternatecontact,etbirthdate,etpanno,etadharno,etoccupation,etincome,etexammount,etgenerated,etdescription;
    String cNmae,cAdress,cBank,cPadress,cOffaddress,cContatct,cAltcontatct,cBdate,cPanno,cAdharno,cIncome,cExamount,lGenby,cDescreption,sploantype,spoccupation;
    TextView txtldate,txtleadid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewleadsalesperson);
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

        etcname = (EditText) findViewById(R.id.txtcname1);
        etaddress = (EditText) findViewById(R.id.txtcaddress1);
        etpropaddress = (EditText) findViewById(R.id.txtcpaddress1);
        etoffaddress = (EditText) findViewById(R.id.txtcofficeaddress1);
        etcontatct = (EditText) findViewById(R.id.txtcontatct1);
        etalternatecontact = (EditText) findViewById(R.id.txtcontatctalt1);
        etbirthdate = (EditText) findViewById(R.id.txtbirthdate1);
        etpanno = (EditText) findViewById(R.id.txtpan1);
        etadharno = (EditText) findViewById(R.id.txtadhar1);
        etincome = (EditText) findViewById(R.id.txtincome1);
        etexammount = (EditText) findViewById(R.id.txtloanammount1);
        etdescription = (EditText) findViewById(R.id.txtdescription1);
        txtldate = (TextView) findViewById(R.id.txtdate1);
        txtleadid = (TextView) findViewById(R.id.textheader);
        etbank = (EditText) findViewById(R.id.txtbankd1);



        spinloantype.setOnItemSelectedListener(this);
        spinemptype.setOnItemSelectedListener(this);


        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        ArrayAdapter<String> spinnerArrayAdapteremptype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, empType);
        spinnerArrayAdapteremptype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinemptype.setAdapter(spinnerArrayAdapteremptype);

        getdata();






        btupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                cNmae=etcname.getText().toString();
                cAdress=etaddress.getText().toString();
                cPadress=etpropaddress.getText().toString();
                cOffaddress=etoffaddress.getText().toString();
                cContatct=etcontatct.getText().toString();
                cAltcontatct=etalternatecontact.getText().toString();
                cBdate=etbirthdate.getText().toString();
                cPanno=etpanno.getText().toString();
                cAdharno=etadharno.getText().toString();
                cIncome=etincome.getText().toString();
                cExamount=etexammount.getText().toString();
                cDescreption=etdescription.getText().toString();
                cBank=etbank.getText().toString();


                updateLeadDetails(leedsModel);
                Toast.makeText(ViewLead_Sales_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();


            }
        });

        btverify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setLeedStatus(leedsModel);
            }
        });


        btcancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(ViewLead_Sales_Activity.this, MainActivity_sales.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });


    }//end of oncreate


    private void getdata() {

        try {

            String leedid = leedsModel.getLeedId();
            String cname = leedsModel.getCustomerName();
            String caddress = leedsModel.getAddress();
            String contact = leedsModel.getMobileNumber();
            String loantype = leedsModel.getLoanType();
            String occupation = leedsModel.getOccupation();
            String loanamount = leedsModel.getExpectedLoanAmount();
            String agentid = leedsModel.getAgentId();
            String leednumber=leedsModel.getLeedNumber();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            String sdatetime=Long.toString(ldatetime);
            String income = leedsModel.getincome();
            String description = leedsModel.getdescription();
            String panno = leedsModel.getPanCardNumber();
            String birthdate = leedsModel.getDateOfBirth();
            String officeaddress = leedsModel.getofficeAdderess();
            String propertyaddress = leedsModel.getpropertyAddress();
            String altmobileno = leedsModel.getAlternetMobileNumber();
            String adhaar = leedsModel.getadharNo();


            if(leednumber != null)
            {
                txtleadid.setText(leednumber);

            } if(cname != null)
            {
                etcname.setText(cname);

            } if(caddress != null)
            {
                etaddress.setText(caddress);
            } if(contact != null)
            {
                etcontatct.setText(contact);
            } if(loantype != null)
            {
                etcname.setText(cname);
            } if(occupation != null)
            {
                etcname.setText(cname);
            } if(income != null)
            {
                etincome.setText(income);
            } if(loanamount != null)
            {
                etexammount.setText(loanamount);
            } if(agentid != null)
            {
                etgenerated.setText(agentid);

            }  if(description != null)
            {
                etdescription.setText(description);
            } if(panno != null)
            {
                etpanno.setText(panno);
            } if(birthdate != null)
            {
                etbirthdate.setText(birthdate);
            }
            if(officeaddress != null)
            {
                etoffaddress.setText(officeaddress);
            }
            if(propertyaddress != null)
            {
                etpropaddress.setText(propertyaddress);
            }
            if(altmobileno != null)
            {
                etalternatecontact.setText(altmobileno);
            }
            else
            {
                etadharno.setText(adhaar);
            }

        }catch (Exception e){}

    }
    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(STATUS_BANK_SUBMITED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }


    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setCustomerName(cNmae);
        leedsModel.setAddress(cAdress);
        leedsModel.setMobileNumber(cContatct);
        leedsModel.setDateOfBirth(cBdate);
        leedsModel.setPanCardNumber(cPanno);
        leedsModel.setLoanType(sploantype);
        leedsModel.setOccupation(spoccupation);
        leedsModel.setExpectedLoanAmount(cExamount);
        leedsModel.setLoanType(cAdress);
        leedsModel.setBankName(cBank);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }



    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(ViewLead_Sales_Activity.this, "Lead Successfully Submited to Bank", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(ViewLead_Sales_Activity.this, getString(R.string.server_error));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        sploantype = spinloantype.getSelectedItem().toString();
        spoccupation = spinemptype.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
