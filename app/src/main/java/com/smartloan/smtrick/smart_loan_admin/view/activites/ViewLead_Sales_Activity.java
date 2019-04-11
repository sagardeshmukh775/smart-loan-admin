package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin.view.dialog.ProgressDialogClass;
import java.util.Map;

public class ViewLead_Sales_Activity extends AppCompatActivity implements OnItemSelectedListener {
    AppSharedPreference appSharedPreference;
    Button btcancel;
    Button btupdate;
    Button btverify;
    String cAdharno;
    String cAdress;
    String cAltcontatct;
    String cBank;
    String cBdate;
    String cContatct;
    String cDescreption;
    String cExamount;
    String cIncome;
    String cNmae;
    String cOffaddress;
    String cPadress;
    String cPanno;
    EditText etaddress;
    EditText etadharno;
    EditText etalternatecontact;
    EditText etbank;
    EditText etbirthdate;
    EditText etcname;
    EditText etcontatct;
    EditText etdescription;
    EditText etexammount;
    EditText etgenerated;
    EditText etincome;
    EditText etoccupation;
    EditText etoffaddress;
    EditText etpanno;
    EditText etpropaddress;
    String lGenby;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner spinemptype;
    Spinner spinincome;
    Spinner spinloantype;
    String sploantype;
    String spoccupation;
    TextView txtldate;
    TextView txtleadid;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.ViewLead_Sales_Activity$1 */
    class C08491 implements OnClickListener {
        C08491() {
        }

        public void onClick(View v) {
            ViewLead_Sales_Activity viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cNmae = viewLead_Sales_Activity.etcname.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cAdress = viewLead_Sales_Activity.etaddress.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cPadress = viewLead_Sales_Activity.etpropaddress.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cOffaddress = viewLead_Sales_Activity.etoffaddress.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cContatct = viewLead_Sales_Activity.etcontatct.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cAltcontatct = viewLead_Sales_Activity.etalternatecontact.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cBdate = viewLead_Sales_Activity.etbirthdate.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cPanno = viewLead_Sales_Activity.etpanno.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cAdharno = viewLead_Sales_Activity.etadharno.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cIncome = viewLead_Sales_Activity.etincome.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cExamount = viewLead_Sales_Activity.etexammount.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cDescreption = viewLead_Sales_Activity.etdescription.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.cBank = viewLead_Sales_Activity.etbank.getText().toString();
            viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.updateLeadDetails(viewLead_Sales_Activity.leedsModel);
            Toast.makeText(ViewLead_Sales_Activity.this, "Lead Update Successfully", 0).show();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.ViewLead_Sales_Activity$2 */
    class C08502 implements OnClickListener {
        C08502() {
        }

        public void onClick(View v) {
            ViewLead_Sales_Activity viewLead_Sales_Activity = ViewLead_Sales_Activity.this;
            viewLead_Sales_Activity.setLeedStatus(viewLead_Sales_Activity.leedsModel);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.ViewLead_Sales_Activity$3 */
    class C08513 implements OnClickListener {
        C08513() {
        }

        public void onClick(View v) {
            ViewLead_Sales_Activity.this.startActivity(new Intent(ViewLead_Sales_Activity.this, MainActivity_sales.class));
            ViewLead_Sales_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.ViewLead_Sales_Activity$4 */
    class C09334 extends CallBack {
        C09334() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(ViewLead_Sales_Activity.this, "Lead Successfully Submited to Bank", 0).show();
            ViewLead_Sales_Activity.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            ViewLead_Sales_Activity.this.progressDialogClass.dismissDialog();
            Context context = ViewLead_Sales_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewleadsalesperson);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        this.progressDialogClass = new ProgressDialogClass(this);
        this.leedRepository = new LeedRepositoryImpl();
        this.appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        this.spinloantype = (Spinner) findViewById(R.id.sploantype1);
        this.spinemptype = (Spinner) findViewById(R.id.spoccupation1);
        this.btupdate = (Button) findViewById(R.id.buttonupdate);
        this.btverify = (Button) findViewById(R.id.buttonverify);
        this.btcancel = (Button) findViewById(R.id.buttoncancel);
        this.etcname = (EditText) findViewById(R.id.txtcname1);
        this.etaddress = (EditText) findViewById(R.id.txtcaddress1);
        this.etpropaddress = (EditText) findViewById(R.id.txtcpaddress1);
        this.etoffaddress = (EditText) findViewById(R.id.txtcofficeaddress1);
        this.etcontatct = (EditText) findViewById(R.id.txtcontatct1);
        this.etalternatecontact = (EditText) findViewById(R.id.txtcontatctalt1);
        this.etbirthdate = (EditText) findViewById(R.id.txtbirthdate1);
        this.etpanno = (EditText) findViewById(R.id.txtpan1);
        this.etadharno = (EditText) findViewById(R.id.txtadhar1);
        this.etincome = (EditText) findViewById(R.id.txtincome1);
        this.etexammount = (EditText) findViewById(R.id.txtloanammount1);
        this.etdescription = (EditText) findViewById(R.id.txtdescription1);
        this.txtldate = (TextView) findViewById(R.id.txtdate1);
        this.txtleadid = (TextView) findViewById(R.id.textheader);
        this.etbank = (EditText) findViewById(R.id.txtbankd1);
        this.spinloantype.setOnItemSelectedListener(this);
        this.spinemptype.setOnItemSelectedListener(this);
        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinloantype.setAdapter(spinnerArrayAdapterloantype);
        ArrayAdapter<String> spinnerArrayAdapteremptype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, empType);
        spinnerArrayAdapteremptype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinemptype.setAdapter(spinnerArrayAdapteremptype);
        getdata();
        this.btupdate.setOnClickListener(new C08491());
        this.btverify.setOnClickListener(new C08502());
        this.btcancel.setOnClickListener(new C08513());
    }

    private void getdata() {
        try {
            String adhaar;
            String leedid = this.leedsModel.getLeedId();
            String cname = leedsModel.getCustomerName();
            String caddress = leedsModel.getAddress();
            String contact = leedsModel.getMobileNumber();
            String loantype = leedsModel.getLoanType();
            String occupation = leedsModel.getOccupation();
            String loanamount = leedsModel.getExpectedLoanAmount();
            String agentid = leedsModel.getAgentId();
            String leednumber = leedsModel.getLeedNumber();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            String sdatetime = Long.toString(ldatetime.longValue());
            String income = leedsModel.getincome();
            String description = leedsModel.getdescription();
            String panno = leedsModel.getPanCardNumber();
            String birthdate = leedsModel.getDateOfBirth();
            leedid = leedsModel.getofficeAdderess();
            String propertyaddress = leedsModel.getpropertyAddress();
            String altmobileno = leedsModel.getAlternetMobileNumber();
            sdatetime = leedsModel.getadharNo();
            if (leednumber != null) {
                adhaar = sdatetime;
                txtleadid.setText(leednumber);
            } else {
                adhaar = sdatetime;
            }
            if (cname != null) {
                etcname.setText(cname);
            }
            if (caddress != null) {
                etaddress.setText(caddress);
            }
            if (contact != null) {
                etcontatct.setText(contact);
            }
            if (loantype != null) {
                etcname.setText(cname);
            }
            if (occupation != null) {
                etcname.setText(cname);
            }
            if (income != null) {
                etincome.setText(income);
            }
            if (loanamount != null) {
                etexammount.setText(loanamount);
            }
            if (agentid != null) {
                etgenerated.setText(agentid);
            }
            if (description != null) {
                etdescription.setText(description);
            }
            if (panno != null) {
                etpanno.setText(panno);
            }
            if (birthdate != null) {
                etbirthdate.setText(birthdate);
            }
            if (leedid != null) {
                etoffaddress.setText(leedid);
            }
            if (propertyaddress != null) {
                etpropaddress.setText(propertyaddress);
            }
            if (altmobileno != null) {
                etalternatecontact.setText(altmobileno);
            } else {
                altmobileno = altmobileno;
                etadharno.setText(adhaar);
            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_BANK_SUBMITED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setCustomerName(this.cNmae);
        leedsModel.setAddress(this.cAdress);
        leedsModel.setMobileNumber(this.cContatct);
        leedsModel.setDateOfBirth(this.cBdate);
        leedsModel.setPanCardNumber(this.cPanno);
        leedsModel.setLoanType(this.sploantype);
        leedsModel.setOccupation(this.spoccupation);
        leedsModel.setExpectedLoanAmount(this.cExamount);
        leedsModel.setLoanType(this.cAdress);
        leedsModel.setBankName(this.cBank);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.updateLeed(leedId, leedsMap, new C09334());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        this.sploantype = this.spinloantype.getSelectedItem().toString();
        this.spoccupation = this.spinemptype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
