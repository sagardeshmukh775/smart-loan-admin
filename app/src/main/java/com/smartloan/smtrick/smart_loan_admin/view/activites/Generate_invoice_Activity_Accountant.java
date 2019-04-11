package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin.view.dialog.ProgressDialogClass;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.INVOICE_TABLE_REF;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;

public class Generate_invoice_Activity_Accountant extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

  EditText etleadid,etloantype,etdate,etcname,etbank,etloanammount,etdiss,etgst,etcom,etapploan,etagentid,etagentname,etinvoiceid,txtleadid;
    String sleadid,sdate,scname,sbank,sloanammount,sdiss,sgst,scomm,said,saname,sapamt,sinvoice;

    Button btnsend;

    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generateinvoice_accountant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);

        txtleadid = (EditText) findViewById(R.id.txtleadid1);
        etdate = (EditText) findViewById(R.id.txtdate1);
        etcname = (EditText) findViewById(R.id.txtcname1);
        etbank = (EditText) findViewById(R.id.txtbank1);
        etloanammount = (EditText) findViewById(R.id.txtloanammount1);
        etdiss = (EditText) findViewById(R.id.txtdiss1);
        etgst = (EditText) findViewById(R.id.txtgst1);
        etcom = (EditText) findViewById(R.id.txtcomm1);
        btnsend = (Button) findViewById(R.id.buttonupdate);


        etloantype = (EditText) findViewById(R.id.txtloantype1);
        etapploan = (EditText) findViewById(R.id.txtapprovedloanvalue);
        etagentid = (EditText) findViewById(R.id.txtagentidvalue);
        etagentname = (EditText) findViewById(R.id.txtagentnamevalue);
        etinvoiceid = (EditText) findViewById(R.id.txtinvoiceidvalue);

        getdata();


        btnsend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                sleadid = txtleadid.getText().toString();
                sdate = etdate.getText().toString();
                scname = etcname.getText().toString();
                sbank = etbank.getText().toString();
                sloanammount = etloanammount.getText().toString();
                sdiss = etdiss.getText().toString();
                sgst = etgst.getText().toString();
                scomm = etcom.getText().toString();
                said = etagentid.getText().toString();
                saname = etagentname.getText().toString();
                sapamt = etapploan.getText().toString();
                sinvoice = etinvoiceid.getText().toString();
                updateLeadDetails(leedsModel);
                Toast.makeText(Generate_invoice_Activity_Accountant.this, "send invoice Successfully", Toast.LENGTH_SHORT).show();


            }
        });


    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        generateinvoice(leedsModel.getLeedId());
    }

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
            String agentname = leedsModel.getAgentName();
            String bank = leedsModel.getBankName();


            if(leednumber != null)
            {
                txtleadid.setText(leednumber);

            } if(cname != null)
            {
                etcname.setText(cname);

            } if(caddress != null)
            {
                etbank.setText(bank);
            } if(contact != null)
            {
                etloanammount.setText(loanamount);
            } if(loantype != null)
            {
                etagentid.setText(agentid);
            }  if(income != null)
            {
                etloantype.setText(loantype);
            } if(loanamount != null)
            {
                etagentname.setText(agentname);

            }if(loanamount != null)
            {
                etdate.setText(sdatetime);
            }





        }catch (Exception e){}


    }




    private void generateinvoice(String leedId) {
        LeedsModel leedsModel = fillUserModel();
        if (validate(leedsModel)) {
            progressDialogClass.showDialog(this.getString(R.string.leed_In_loading), this.getString(R.string.PLEASE_WAIT));
            leedRepository.createInvoice(leedsModel, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Generate_invoice_Activity_Accountant.this, "Send Invoice Successfully", Toast.LENGTH_SHORT).show();
                    progressDialogClass.dismissDialog();
                }

                @Override
                public void onError(Object object) {
                    progressDialogClass.dismissDialog();
                    Toast.makeText(Generate_invoice_Activity_Accountant.this, "invoice fail", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    private LeedsModel fillUserModel() {
        LeedsModel leedsModel = new LeedsModel();
        leedsModel.setLeedId(INVOICE_TABLE_REF.push().getKey());
        leedsModel.setCustomerName(scname);
        leedsModel.setBankName(sbank);
        leedsModel.setApprovedLoan(sloanammount);
        leedsModel.setdissbussloan(sdiss);
        leedsModel.setPayout(scomm);
        leedsModel.setgst(sgst);
        leedsModel.setdissbussloan(sdiss);
        leedsModel.setPayout(scomm);
        leedsModel.setAgentId(said);
        leedsModel.setAgentName(saname);
        leedsModel.setApprovedLoan(sapamt);

        return leedsModel;
    }



    private boolean validate(LeedsModel leedsModel) {
        String validationMessage;
        boolean isValid = true;
        try {


        } catch (Exception e) {
            isValid = false;
            ExceptionUtil.logException(e);
        }
        return isValid;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
