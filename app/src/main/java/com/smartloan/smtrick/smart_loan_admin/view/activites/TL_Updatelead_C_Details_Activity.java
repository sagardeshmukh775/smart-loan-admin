package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
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
import java.util.ArrayList;
import java.util.Map;

public class TL_Updatelead_C_Details_Activity extends AppCompatActivity implements OnItemSelectedListener {
    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
    RadioButton Rcoapplicant;
    RadioButton RcoapplicantNO;
    RadioButton RcoapplicantYES;
    Spinner Recidential;
    RadioButton Rfemale;
    RadioButton Rg;
    RadioButton Rgender;
    RadioButton Rmale;
    RadioButton Rno;
    RadioButton Rother;
    RadioButton Rpg;
    RadioButton Rpro;
    RadioButton Rug;
    RadioButton Ryes;
    AppSharedPreference appSharedPreference;
    EditText area;
    TextView area1;
    Button btcancel;
    Button btnnext;
    Button btnsave;
    Button btupdate;
    Button btverify;
    String cAdhar;
    String cAdress;
    String cAltcontatct;
    String cBdate;
    String cContatct;
    String cCurrentPIN;
    String cCurrentarea;
    String cCurrentlandmark;
    String cCurrentstreet;
    String cDL;
    String cEducation;
    String cEmail;
    String cGender;
    String cNmae;
    String cOffaddress;
    String cOther;
    String cPAN;
    String cPANnumber;
    String cPIN;
    String cPadress;
    String cPassport;
    String cProofDL;
    String cProofadhar;
    String cProofcurrentacctstmt;
    String cProofelectricitybill;
    String cProofgovtid;
    String cProofgumasta;
    String cProofpassport;
    String cProofrentagmt;
    String cProofvoterid;
    String cVoterid;
    String cYesNo;
    String carea;
    CheckBox chAdhar;
    CheckBox chDL;
    CheckBox chPAN;
    CheckBox chPassport;
    CheckBox chProofAdhar;
    CheckBox chProofCurrentacctStmt;
    CheckBox chProofElectricitybill;
    CheckBox chProofGovtEmpid;
    CheckBox chProofGumasta;
    CheckBox chProofPassport;
    CheckBox chProofRntagmt;
    CheckBox chProofVoterid;
    CheckBox chProofdl;
    CheckBox chVoterID;
    String clandmark;
    String cparents;
    String cresidencial;
    String cstreet;
    EditText currentarea;
    EditText currentlandmark;
    EditText currentpin;
    EditText currentstreet;
    EditText edtotherrelationship;
    EditText edtreferenceaddress;
    EditText edtreferenceaddress2;
    EditText edtreferencecontactno;
    EditText edtreferencecontactno2;
    EditText edtreferencename;
    EditText edtreferencename2;
    EditText edtreferencerelationship;
    EditText edtreferencerelationship2;
    EditText eparents;
    EditText eresidencial;
    EditText etaddress;
    EditText etalternatecontact;
    EditText etbirthdate;
    EditText etcEmail;
    EditText etcname;
    EditText etcontatct;
    EditText etoffaddress;
    EditText etother;
    EditText etpermanantaddress;
    RadioGroup groupRadio;
    RadioGroup groupRadioEducation;
    RadioGroup groupRadioGender;
    RadioGroup groupRadiocoapplicant;
    EditText landmark;
    TextView landmark1;
    RelativeLayout layoutarea;
    RelativeLayout layoutlandmark;
    RelativeLayout layoutotherrelationship;
    RelativeLayout layoutothervalue;
    RelativeLayout layoutpin;
    RelativeLayout layoutref1address;
    RelativeLayout layoutref1contact;
    RelativeLayout layoutref1name;
    RelativeLayout layoutref1relationship;
    RelativeLayout layoutref2address;
    RelativeLayout layoutref2contact;
    RelativeLayout layoutref2name;
    RelativeLayout layoutref2relationship;
    RelativeLayout layoutrelationship;
    RelativeLayout layoutsavebutton;
    RelativeLayout layoutstreet;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ArrayList<LeedsModel> leedsModelArrayList;
    String padress;
    EditText pin;
    TextView pin1;
    ProgressDialogClass progressDialogClass;
    String sapplicantrelation;
    String scoapplicantYN;
    String sotherrelationship;
    Spinner spinemptype;
    Spinner spinincome;
    Spinner spinloantype;
    String sreference1address;
    String sreference1name;
    String sreference2address;
    String sreference2contactno;
    String sreference2name;
    String sreference2relationship;
    String sreferencecontactno;
    String sreferencerelationship;
    EditText street;
    TextView street1;
    TextView txtldate;
    TextView txtleadid;
    EditText txtpannumber;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$1 */
    class C08161 implements OnCheckedChangeListener {
        C08161() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                TL_Updatelead_C_Details_Activity.this.txtpannumber.setVisibility(0);
            } else {
                TL_Updatelead_C_Details_Activity.this.txtpannumber.setVisibility(4);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$2 */
    class C08172 implements RadioGroup.OnCheckedChangeListener {
        C08172() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.Rcoapplicant = (RadioButton) tL_Updatelead_C_Details_Activity.findViewById(checkedId);
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.scoapplicantYN = tL_Updatelead_C_Details_Activity.Rcoapplicant.getText().toString();
            if (TL_Updatelead_C_Details_Activity.this.Rcoapplicant.getText().toString().equalsIgnoreCase("Yes")) {
                TL_Updatelead_C_Details_Activity.this.ShowApplicant();
            } else {
                TL_Updatelead_C_Details_Activity.this.HideApplicant();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$3 */
    class C08183 implements RadioGroup.OnCheckedChangeListener {
        C08183() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.REducation = (RadioButton) tL_Updatelead_C_Details_Activity.findViewById(checkedId);
            if (TL_Updatelead_C_Details_Activity.this.REducation.getText().toString().equalsIgnoreCase("Other")) {
                TL_Updatelead_C_Details_Activity.this.Showother();
            } else {
                TL_Updatelead_C_Details_Activity.this.hideother();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$4 */
    class C08194 implements RadioGroup.OnCheckedChangeListener {
        C08194() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.Rgender = (RadioButton) tL_Updatelead_C_Details_Activity.findViewById(checkedId);
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cGender = tL_Updatelead_C_Details_Activity.Rgender.getText().toString();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$5 */
    class C08205 implements RadioGroup.OnCheckedChangeListener {
        C08205() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.RYN = (RadioButton) tL_Updatelead_C_Details_Activity.findViewById(checkedId);
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cYesNo = tL_Updatelead_C_Details_Activity.RYN.getText().toString();
            if (TL_Updatelead_C_Details_Activity.this.RYN.getText().toString().equalsIgnoreCase("No")) {
                TL_Updatelead_C_Details_Activity.this.fieldVisibility();
            } else {
                TL_Updatelead_C_Details_Activity.this.FieldInvisible();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$6 */
    class C08216 implements OnClickListener {
        C08216() {
        }

        public void onClick(View v) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cNmae = tL_Updatelead_C_Details_Activity.etcname.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cAdress = tL_Updatelead_C_Details_Activity.etaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentPIN = tL_Updatelead_C_Details_Activity.currentpin.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentlandmark = tL_Updatelead_C_Details_Activity.currentlandmark.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentarea = tL_Updatelead_C_Details_Activity.currentarea.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentstreet = tL_Updatelead_C_Details_Activity.currentstreet.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPadress = tL_Updatelead_C_Details_Activity.etpermanantaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPIN = tL_Updatelead_C_Details_Activity.pin.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.clandmark = tL_Updatelead_C_Details_Activity.landmark.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.carea = tL_Updatelead_C_Details_Activity.area.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cstreet = tL_Updatelead_C_Details_Activity.street.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cOffaddress = tL_Updatelead_C_Details_Activity.etoffaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cBdate = tL_Updatelead_C_Details_Activity.etbirthdate.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cContatct = tL_Updatelead_C_Details_Activity.etcontatct.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cAltcontatct = tL_Updatelead_C_Details_Activity.etalternatecontact.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cEmail = tL_Updatelead_C_Details_Activity.etcEmail.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPANnumber = tL_Updatelead_C_Details_Activity.txtpannumber.getText().toString();
            if (!TL_Updatelead_C_Details_Activity.this.cEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                TL_Updatelead_C_Details_Activity.this.etcEmail.setError("Invalid Email");
            }
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity2.cresidencial = tL_Updatelead_C_Details_Activity2.Recidential.getSelectedItem().toString();
            tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity2.sapplicantrelation = tL_Updatelead_C_Details_Activity2.CoapplicantRalationship.getSelectedItem().toString();
            tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity2.sotherrelationship = tL_Updatelead_C_Details_Activity2.edtotherrelationship.getText().toString();
            tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity2.cOther = tL_Updatelead_C_Details_Activity2.etother.getText().toString();
            if (TL_Updatelead_C_Details_Activity.this.chAdhar.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cAdhar = tL_Updatelead_C_Details_Activity2.chAdhar.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chPAN.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cPAN = tL_Updatelead_C_Details_Activity2.chPAN.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chVoterID.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cVoterid = tL_Updatelead_C_Details_Activity2.chVoterID.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chDL.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cDL = tL_Updatelead_C_Details_Activity2.chDL.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chPassport.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cPassport = tL_Updatelead_C_Details_Activity2.chPassport.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofAdhar.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofadhar = tL_Updatelead_C_Details_Activity2.chProofAdhar.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofVoterid.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofvoterid = tL_Updatelead_C_Details_Activity2.chProofVoterid.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofdl.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofDL = tL_Updatelead_C_Details_Activity2.chProofdl.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofElectricitybill.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofelectricitybill = tL_Updatelead_C_Details_Activity2.chProofElectricitybill.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofRntagmt.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofrentagmt = tL_Updatelead_C_Details_Activity2.chProofRntagmt.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofPassport.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofpassport = tL_Updatelead_C_Details_Activity2.chProofPassport.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofGovtEmpid.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofgovtid = tL_Updatelead_C_Details_Activity2.chProofGovtEmpid.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofGumasta.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofgumasta = tL_Updatelead_C_Details_Activity2.chProofGumasta.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofCurrentacctStmt.isChecked()) {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.cProofcurrentacctstmt = tL_Updatelead_C_Details_Activity2.chProofCurrentacctStmt.getText().toString();
            }
            if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cNmae)) {
                TL_Updatelead_C_Details_Activity.this.etcname.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cBdate)) {
                TL_Updatelead_C_Details_Activity.this.etbirthdate.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cContatct)) {
                TL_Updatelead_C_Details_Activity.this.etcontatct.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cAltcontatct)) {
                TL_Updatelead_C_Details_Activity.this.etalternatecontact.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cEmail)) {
                TL_Updatelead_C_Details_Activity.this.etcEmail.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cOffaddress)) {
                TL_Updatelead_C_Details_Activity.this.etoffaddress.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cAdhar)) {
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cPAN)) {
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
            } else {
                tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity2.updateLeadDetails(tL_Updatelead_C_Details_Activity2.leedsModel);
                Intent i = new Intent(TL_Updatelead_C_Details_Activity.this, TL_Updatelead_Coapplicant_Detail_Activity.class);
                i.putExtra(Constant.LEED_MODEL, TL_Updatelead_C_Details_Activity.this.leedsModel);
                TL_Updatelead_C_Details_Activity.this.startActivity(i);
                TL_Updatelead_C_Details_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$7 */
    class C08227 implements OnClickListener {
        C08227() {
        }

        public void onClick(View v) {
            TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cNmae = tL_Updatelead_C_Details_Activity.etcname.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cAdress = tL_Updatelead_C_Details_Activity.etaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentPIN = tL_Updatelead_C_Details_Activity.currentpin.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentlandmark = tL_Updatelead_C_Details_Activity.currentlandmark.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentarea = tL_Updatelead_C_Details_Activity.currentarea.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cCurrentstreet = tL_Updatelead_C_Details_Activity.currentstreet.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPadress = tL_Updatelead_C_Details_Activity.etpermanantaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPIN = tL_Updatelead_C_Details_Activity.pin.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.clandmark = tL_Updatelead_C_Details_Activity.landmark.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.carea = tL_Updatelead_C_Details_Activity.area.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cstreet = tL_Updatelead_C_Details_Activity.street.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cOffaddress = tL_Updatelead_C_Details_Activity.etoffaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cBdate = tL_Updatelead_C_Details_Activity.etbirthdate.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cPANnumber = tL_Updatelead_C_Details_Activity.txtpannumber.getText().toString();

            if (groupRadioGender.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) TL_Updatelead_C_Details_Activity.this.groupRadioGender.getChildAt(TL_Updatelead_C_Details_Activity.this.groupRadioGender.indexOfChild(TL_Updatelead_C_Details_Activity.this.groupRadioGender.findViewById(TL_Updatelead_C_Details_Activity.this.groupRadioGender.getCheckedRadioButtonId())));
                TL_Updatelead_C_Details_Activity.this.cGender = btn.getText().toString();
            }
            if (groupRadio.getCheckedRadioButtonId() != -1) {
                RadioButton  btn = (RadioButton) TL_Updatelead_C_Details_Activity.this.groupRadio.getChildAt(TL_Updatelead_C_Details_Activity.this.groupRadio.indexOfChild(TL_Updatelead_C_Details_Activity.this.groupRadio.findViewById(TL_Updatelead_C_Details_Activity.this.groupRadio.getCheckedRadioButtonId())));
                TL_Updatelead_C_Details_Activity.this.cYesNo = btn.getText().toString();
            }
            if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
                RadioButton  btn = (RadioButton) TL_Updatelead_C_Details_Activity.this.groupRadioEducation.getChildAt(TL_Updatelead_C_Details_Activity.this.groupRadioEducation.indexOfChild(TL_Updatelead_C_Details_Activity.this.groupRadioEducation.findViewById(TL_Updatelead_C_Details_Activity.this.groupRadioEducation.getCheckedRadioButtonId())));
                TL_Updatelead_C_Details_Activity.this.cEducation = btn.getText().toString();
            }
            if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
                RadioButton btn2 = (RadioButton) TL_Updatelead_C_Details_Activity.this.groupRadiocoapplicant.getChildAt(TL_Updatelead_C_Details_Activity.this.groupRadiocoapplicant.indexOfChild(TL_Updatelead_C_Details_Activity.this.groupRadiocoapplicant.findViewById(TL_Updatelead_C_Details_Activity.this.groupRadiocoapplicant.getCheckedRadioButtonId())));
                TL_Updatelead_C_Details_Activity.this.scoapplicantYN = btn2.getText().toString();
            }
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cContatct = tL_Updatelead_C_Details_Activity.etcontatct.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cAltcontatct = tL_Updatelead_C_Details_Activity.etalternatecontact.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cEmail = tL_Updatelead_C_Details_Activity.etcEmail.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cresidencial = tL_Updatelead_C_Details_Activity.Recidential.getSelectedItem().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.cOther = tL_Updatelead_C_Details_Activity.etother.getText().toString();
            if (TL_Updatelead_C_Details_Activity.this.chAdhar.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cAdhar = tL_Updatelead_C_Details_Activity.chAdhar.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chPAN.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cPAN = tL_Updatelead_C_Details_Activity.chPAN.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chVoterID.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cVoterid = tL_Updatelead_C_Details_Activity.chVoterID.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chDL.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cDL = tL_Updatelead_C_Details_Activity.chDL.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chPassport.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cPassport = tL_Updatelead_C_Details_Activity.chPassport.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofAdhar.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofadhar = tL_Updatelead_C_Details_Activity.chProofAdhar.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofVoterid.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofvoterid = tL_Updatelead_C_Details_Activity.chProofVoterid.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofdl.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofDL = tL_Updatelead_C_Details_Activity.chProofdl.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofElectricitybill.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofelectricitybill = tL_Updatelead_C_Details_Activity.chProofElectricitybill.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofRntagmt.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofrentagmt = tL_Updatelead_C_Details_Activity.chProofRntagmt.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofPassport.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofpassport = tL_Updatelead_C_Details_Activity.chProofPassport.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofGovtEmpid.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofgovtid = tL_Updatelead_C_Details_Activity.chProofGovtEmpid.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofGumasta.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofgumasta = tL_Updatelead_C_Details_Activity.chProofGumasta.getText().toString();
            }
            if (TL_Updatelead_C_Details_Activity.this.chProofCurrentacctStmt.isChecked()) {
                tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
                tL_Updatelead_C_Details_Activity.cProofcurrentacctstmt = tL_Updatelead_C_Details_Activity.chProofCurrentacctStmt.getText().toString();
            }
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sapplicantrelation = tL_Updatelead_C_Details_Activity.CoapplicantRalationship.getSelectedItem().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sotherrelationship = tL_Updatelead_C_Details_Activity.edtotherrelationship.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference1name = tL_Updatelead_C_Details_Activity.edtreferencename.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference1address = tL_Updatelead_C_Details_Activity.edtreferenceaddress.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreferencecontactno = tL_Updatelead_C_Details_Activity.edtreferencecontactno.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreferencerelationship = tL_Updatelead_C_Details_Activity.edtreferencerelationship.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference2name = tL_Updatelead_C_Details_Activity.edtreferencename2.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference2address = tL_Updatelead_C_Details_Activity.edtreferenceaddress2.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference2contactno = tL_Updatelead_C_Details_Activity.edtreferencecontactno2.getText().toString();
            tL_Updatelead_C_Details_Activity = TL_Updatelead_C_Details_Activity.this;
            tL_Updatelead_C_Details_Activity.sreference2relationship = tL_Updatelead_C_Details_Activity.edtreferencerelationship2.getText().toString();
            if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cNmae)) {
                TL_Updatelead_C_Details_Activity.this.etcname.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cBdate)) {
                TL_Updatelead_C_Details_Activity.this.etbirthdate.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cContatct)) {
                TL_Updatelead_C_Details_Activity.this.etcontatct.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cAltcontatct)) {
                TL_Updatelead_C_Details_Activity.this.etalternatecontact.setError("Required");
                Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Alternete Contact!", Toast.LENGTH_SHORT).show();
            } else {
                String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cEmail)) {
                    TL_Updatelead_C_Details_Activity.this.etcEmail.setError("Required");
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Email Address!", Toast.LENGTH_SHORT).show();
                } else if (!TL_Updatelead_C_Details_Activity.this.cEmail.matches(emialpattern)) {
                    TL_Updatelead_C_Details_Activity.this.etcEmail.setError("Invalid Email");
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cOffaddress)) {
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Enter Office Address!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cAdhar)) {
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(TL_Updatelead_C_Details_Activity.this.cPAN)) {
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this.getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                } else {
                    TL_Updatelead_C_Details_Activity tL_Updatelead_C_Details_Activity2 = TL_Updatelead_C_Details_Activity.this;
                    tL_Updatelead_C_Details_Activity2.updateLeadDetails(tL_Updatelead_C_Details_Activity2.leedsModel);
                    Intent i = new Intent(TL_Updatelead_C_Details_Activity.this, Tl_Updatelead_incomedetails_Activity.class);
                    i.putExtra(Constant.LEED_MODEL, TL_Updatelead_C_Details_Activity.this.leedsModel);
                    TL_Updatelead_C_Details_Activity.this.startActivity(i);
                    TL_Updatelead_C_Details_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.TL_Updatelead_C_Details_Activity$8 */
    class C09288 extends CallBack {
        C09288() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
            TL_Updatelead_C_Details_Activity.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Context context = TL_Updatelead_C_Details_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tl_updatelead_cdetails_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.layoutpin = (RelativeLayout) findViewById(R.id.layoutpin);
        this.layoutlandmark = (RelativeLayout) findViewById(R.id.layoutland);
        this.layoutarea = (RelativeLayout) findViewById(R.id.layoutArea);
        this.layoutstreet = (RelativeLayout) findViewById(R.id.layoutstreet);
        this.layoutothervalue = (RelativeLayout) findViewById(R.id.layoutothervalue);
        this.layoutrelationship = (RelativeLayout) findViewById(R.id.layoutcoapplicantrelation);
        this.layoutotherrelationship = (RelativeLayout) findViewById(R.id.layoutotherrelationship);
        this.layoutsavebutton = (RelativeLayout) findViewById(R.id.layoutbuttonsave);
        this.layoutref1name = (RelativeLayout) findViewById(R.id.layoutreferencefullname);
        this.layoutref1address = (RelativeLayout) findViewById(R.id.layoutreferenceaddress);
        this.layoutref1contact = (RelativeLayout) findViewById(R.id.layoutreferencecontactno);
        this.layoutref1relationship = (RelativeLayout) findViewById(R.id.layoutreferencerelationhsip);
        this.layoutref2name = (RelativeLayout) findViewById(R.id.layoutreference2fullname);
        this.layoutref2address = (RelativeLayout) findViewById(R.id.layoutreference2address);
        this.layoutref2contact = (RelativeLayout) findViewById(R.id.layoutreference2contactno);
        this.layoutref2relationship = (RelativeLayout) findViewById(R.id.layoutreference2relationhsip);
        setSupportActionBar(toolbar);
        this.leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        this.progressDialogClass = new ProgressDialogClass(this);
        this.leedRepository = new LeedRepositoryImpl();
        this.appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
        this.btnnext = (Button) findViewById(R.id.buttonupdatenext);
        this.btnsave = (Button) findViewById(R.id.buttonsave);
        this.etcname = (EditText) findViewById(R.id.txtcamevalue);
        this.etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        this.etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        this.groupRadio = (RadioGroup) findViewById(R.id.radioGYN);
        this.currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        this.currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        this.currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        this.currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);
        this.pin = (EditText) findViewById(R.id.txtpin1);
        this.landmark = (EditText) findViewById(R.id.txtlandmark1);
        this.area = (EditText) findViewById(R.id.txtarea1);
        this.street = (EditText) findViewById(R.id.txtstreet1);
        this.etoffaddress = (EditText) findViewById(R.id.txtofficeaddressvalue);
        this.etbirthdate = (EditText) findViewById(R.id.txtbirthdatevalue);
        this.groupRadioEducation = (RadioGroup) findViewById(R.id.radioeducation);
        this.groupRadioGender = (RadioGroup) findViewById(R.id.radioSex);
        this.etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        this.etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        this.etcEmail = (EditText) findViewById(R.id.txtemail1);
        this.Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);
        this.CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
        this.CoapplicantRalationship.setOnItemSelectedListener(this);
        this.edtotherrelationship = (EditText) findViewById(R.id.txtotherrelationship1);
        this.edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
        this.edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
        this.edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
        this.edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
        this.edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
        this.edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
        this.edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
        this.edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);
        this.txtpannumber = (EditText) findViewById(R.id.txtpannumber);
        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.Recidential.setAdapter(spinnerArrayAdapterRecidential);
        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);
        this.etother = (EditText) findViewById(R.id.txtOthervalue);
        this.chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        this.chPAN = (CheckBox) findViewById(R.id.checkboxpan);
        if (this.chPAN.isChecked()) {
            this.txtpannumber.setVisibility(View.VISIBLE);
        } else {
            this.txtpannumber.setVisibility(View.INVISIBLE);
        }
        this.chPAN.setOnCheckedChangeListener(new C08161());
        this.chVoterID = (CheckBox) findViewById(R.id.checkboxvoterid);
        this.chDL = (CheckBox) findViewById(R.id.checkboxdrivinglicence);
        this.chPassport = (CheckBox) findViewById(R.id.checkboxpassport);
        this.chProofAdhar = (CheckBox) findViewById(R.id.checkboxproofAdhar);
        this.chProofVoterid = (CheckBox) findViewById(R.id.checkboxproofVoterid);
        this.chProofdl = (CheckBox) findViewById(R.id.checkboxproofDL);
        this.chProofElectricitybill = (CheckBox) findViewById(R.id.checkboxproofElectricitybill);
        this.chProofRntagmt = (CheckBox) findViewById(R.id.checkboxpeoofRentAgmt);
        this.chProofPassport = (CheckBox) findViewById(R.id.checkboxproofPassport);
        this.chProofGovtEmpid = (CheckBox) findViewById(R.id.checkboxproofGevtEmpID);
        this.chProofGumasta = (CheckBox) findViewById(R.id.checkboxproofGumasta);
        this.chProofCurrentacctStmt = (CheckBox) findViewById(R.id.checkboxproofCurrentAcctStmt);
        this.txtleadid = (TextView) findViewById(R.id.textheader);
        this.RcoapplicantYES = (RadioButton) findViewById(R.id.radioapplicantYes);
        this.RcoapplicantNO = (RadioButton) findViewById(R.id.radioapplicantNo);
        this.groupRadiocoapplicant = (RadioGroup) findViewById(R.id.radiocoapplicantYN);
        this.groupRadiocoapplicant.setOnCheckedChangeListener(new C08172());
        this.groupRadioEducation.setOnCheckedChangeListener(new C08183());
        this.groupRadioGender.setOnCheckedChangeListener(new C08194());
        this.groupRadio.setOnCheckedChangeListener(new C08205());
        if (this.groupRadioGender.getCheckedRadioButtonId() != -1) {
            this.cGender = ((RadioButton) this.groupRadioGender.getChildAt(this.groupRadioGender.indexOfChild(this.groupRadioGender.findViewById(this.groupRadioGender.getCheckedRadioButtonId())))).getText().toString();
        }
        if (this.groupRadio.getCheckedRadioButtonId() != -1) {
            this.cYesNo = ((RadioButton) this.groupRadio.getChildAt(this.groupRadio.indexOfChild(this.groupRadio.findViewById(this.groupRadio.getCheckedRadioButtonId())))).getText().toString();
            if (this.cYesNo.equalsIgnoreCase("No")) {
                fieldVisibility();
            } else {
                FieldInvisible();
            }
        }
        if (this.groupRadioEducation.getCheckedRadioButtonId() != -1) {
            this.cEducation = ((RadioButton) this.groupRadioEducation.getChildAt(this.groupRadioEducation.indexOfChild(this.groupRadioEducation.findViewById(this.groupRadioEducation.getCheckedRadioButtonId())))).getText().toString();
            if (this.cEducation.equalsIgnoreCase("Other")) {
                Showother();
            } else {
                hideother();
            }
        }
        if (this.groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
            this.scoapplicantYN = ((RadioButton) this.groupRadiocoapplicant.getChildAt(this.groupRadiocoapplicant.indexOfChild(this.groupRadiocoapplicant.findViewById(this.groupRadiocoapplicant.getCheckedRadioButtonId())))).getText().toString();
            if (this.scoapplicantYN.equalsIgnoreCase("Yes")) {
                ShowApplicant();
            } else {
                HideApplicant();
            }
        }
        Ryes = (RadioButton) findViewById(R.id.radioYes);
        this.Rno = (RadioButton) findViewById(R.id.radioNo);
        this.Rug = (RadioButton) findViewById(R.id.radioUG);
        this.Rg = (RadioButton) findViewById(R.id.radioGraguate);
        this.Rpg = (RadioButton) findViewById(R.id.radioPG);
        this.Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        this.Rother = (RadioButton) findViewById(R.id.radioother);
        this.Rmale = (RadioButton) findViewById(R.id.radioMale);
        this.Rfemale = (RadioButton) findViewById(R.id.radioFemale);
        this.btnsave.setOnClickListener(new C08216());
        this.btnnext.setOnClickListener(new C08227());
        getdata();
    }

    private void getdata() {
        try {
            String currentPIN;
            String leednumber = this.leedsModel.getLeedNumber();
            String cname = leedsModel.getCustomerName();
            String caddress = leedsModel.getAddress();
            String officeaddress = leedsModel.getofficeAdderess();
            String contact = leedsModel.getMobileNumber();
            String altcontact = leedsModel.getAlternetMobileNumber();
            String birthdate = leedsModel.getDateOfBirth();
            String residencial = leedsModel.getRecidential();
            String permanataddress = leedsModel.getPeraddress();
            String addressYN = leedsModel.getAddressYesNo();
            String otherEdu = leedsModel.getOtherEducation();
            String education = leedsModel.getEducation();
            String gender = leedsModel.getGender();
            String applicantYN = leedsModel.getCoApplicantYN();
            String currentPIN2 = leedsModel.getCurrentpin();
            String birthdate2 = birthdate;
            birthdate = leedsModel.getCurrentlandmark();
            String residencial2 = residencial;
            residencial = leedsModel.getCurrentarea();
            String altcontact2 = altcontact;
            altcontact = leedsModel.getCurrentstreet();
            String contact2 = contact;
            contact = leedsModel.getPincode();
            String officeaddress2 = officeaddress;
            officeaddress = leedsModel.getLandmark();
            String permanataddress2 = permanataddress;
            permanataddress = leedsModel.getArea();
            String caddress2 = caddress;
            caddress = leedsModel.getStreet();
            String cname2 = cname;
            cname = leedsModel.getEmail();
            String leednumber2 = leednumber;
            String adhar = leedsModel.getadharNo();
            String pan = leedsModel.getCheckpanCardNumber();
            String pannumber = leedsModel.getPanCardNumber();
            leednumber = leedsModel.getApvoterid();
            String email = cname;
            cname = leedsModel.getApdrivinglicence();
            String otherEdu2 = otherEdu;
            String passport = leedsModel.getAppassport();
            otherEdu = leedsModel.getProofadhar();
            String driverlicence = cname;
            cname = leedsModel.getProofvoterid();
            String voterid = leednumber;
            String dlproof = leedsModel.getProofdl();
            String electricitybillproof = leedsModel.getProofelectricitybill();
            String rentagmtproof = leedsModel.getProofrentagmt();
            String passportproof = leedsModel.getProofpassport();
            String gevtidproof = leedsModel.getProofgevtid();
            String gumastaproof = leedsModel.getProofgumasta();
            String currentacctprrof = leedsModel.getProofcurrentacctstmt();
            leednumber = leedsModel.getPrapplicantrelation();
            String voteridproof = cname;
            cname = leedsModel.getCoapplicantotherrelation();
            String adharproof = otherEdu;
            otherEdu = leedsModel.getPrreference1name();
            String Sstreet = caddress;
            caddress = leedsModel.getPrreference1address();
            String Sarea = permanataddress;
            permanataddress = leedsModel.getPrreferencecontactno();
            String land = officeaddress;
            officeaddress = leedsModel.getPrreferencerelationship();
            String PIN = contact;
            contact = leedsModel.getPrreference2name();
            String addressYN2 = addressYN;
            addressYN = leedsModel.getPrreference2address();
            String currentSstreet = altcontact;
            altcontact = leedsModel.getPrreference2contactno();
            String currentSarea = residencial;
            residencial = leedsModel.getPrreference2relationship();
            String currentland = birthdate;
            if (applicantYN == null) {
                currentPIN = currentPIN2;
            } else if (applicantYN.equalsIgnoreCase("Yes")) {
                currentPIN = currentPIN2;
                RcoapplicantYES.setChecked(true);
                ShowApplicant();
            } else {
                currentPIN = currentPIN2;
                if (applicantYN.equalsIgnoreCase("No")) {
                    RcoapplicantNO.setChecked(true);
                    HideApplicant();
                }
            }
            if (leednumber != null) {
                ArrayAdapter myAdap = (ArrayAdapter) CoapplicantRalationship.getAdapter();
                CoapplicantRalationship.setSelection(myAdap.getPosition(leednumber));
                if (leednumber.equalsIgnoreCase("Please specify")) {
                    showotherRelation();
                } else {
                    hideotherRelation();
                }
            }
            if (cname != null) {
                edtotherrelationship.setText(cname);
            }
            if (otherEdu != null) {
                edtreferencename.setText(otherEdu);
            }
            if (caddress != null) {
                edtreferenceaddress.setText(caddress);
            }
            if (permanataddress != null) {
                edtreferencecontactno.setText(permanataddress);
            }
            if (officeaddress != null) {
                edtreferencerelationship.setText(officeaddress);
            }
            if (contact != null) {
                edtreferencename2.setText(contact);
            }
            if (addressYN != null) {
                edtreferenceaddress2.setText(addressYN);
            }
            if (altcontact != null) {
                edtreferencecontactno2.setText(altcontact);
            }
            if (residencial != null) {
                edtreferencerelationship2.setText(residencial);
            }
            if (education != null) {
                if (education.equalsIgnoreCase("Under Graduate")) {
                    Rug.setChecked(true);
                    hideother();
                } else if (education.equalsIgnoreCase("Graduate")) {
                    Rg.setChecked(true);
                    hideother();
                } else if (education.equalsIgnoreCase("Post Graduate")) {
                    Rpg.setChecked(true);
                    hideother();
                } else if (education.equalsIgnoreCase("Professional")) {
                    Rpro.setChecked(true);
                    hideother();
                } else {
                    Rother.setChecked(true);
                    Showother();
                }
            }
            if (gender != null) {
                if (gender.equalsIgnoreCase(Constant.MALE)) {
                    Rmale.setChecked(true);
                } else {
                    Rfemale.setChecked(true);
                }
            }
            if (currentPIN != null) {
                currentpin.setText(currentPIN);
            }
            if (currentland != null) {
                leednumber = currentland;
                currentlandmark.setText(leednumber);
            } else {
                leednumber = currentland;
            }
            if (currentSarea != null) {
                currentland = leednumber;
                leednumber = currentSarea;
                currentarea.setText(leednumber);
            } else {
                leednumber = currentSarea;
            }
            if (currentSstreet != null) {
                currentSarea = leednumber;
                leednumber = currentSstreet;
                currentstreet.setText(leednumber);
            } else {
                leednumber = currentSstreet;
            }
            if (addressYN2 != null) {
                currentSstreet = leednumber;
                leednumber = addressYN2;
                if (leednumber.equalsIgnoreCase("Yes")) {
                    addressYN2 = leednumber;
                    Ryes.setChecked(true);
                    FieldInvisible();
                } else {
                    addressYN2 = leednumber;
                    Rno.setChecked(true);
                    fieldVisibility();
                }
            }
            if (Rno.isChecked()) {
                birthdate = PIN;
                PIN = cname;
                cname = Sstreet;
            } else {
                if (PIN != null) {
                    pin.setText(PIN);
                }
                if (land != null) {
                    cname = land;
                    landmark.setText(cname);
                } else {
                    cname = land;
                }
                if (Sarea != null) {
                    land = cname;
                    cname = Sarea;
                    area.setText(cname);
                } else {
                    cname = Sarea;
                }
                if (Sstreet != null) {
                    Sarea = cname;
                    cname = Sstreet;
                    street.setText(cname);
                } else {
                    cname = Sstreet;
                }
            }
            if (adharproof != null) {
                Sstreet = cname;
                chProofAdhar.setChecked(true);
            }
            if (voteridproof != null) {
                chProofVoterid.setChecked(true);
            }
            if (dlproof != null) {
                chProofdl.setChecked(true);
            }
            if (electricitybillproof != null) {
                chProofElectricitybill.setChecked(true);
            }
            if (rentagmtproof != null) {
                chProofRntagmt.setChecked(true);
            }
            if (passportproof != null) {
                chProofPassport.setChecked(true);
            }
            if (gevtidproof != null) {
                chProofGovtEmpid.setChecked(true);
            }
            if (gumastaproof != null) {
                chProofGumasta.setChecked(true);
            }
            if (currentacctprrof != null) {
                chProofCurrentacctStmt.setChecked(true);
            }
            if (voterid != null) {
                chVoterID.setChecked(true);
            }
            if (driverlicence != null) {
                chDL.setChecked(true);
            }
            if (passport != null) {
                chPassport.setChecked(true);
            }
            if (otherEdu2 != null) {
                cname = otherEdu2;
                etother.setText(cname);
            } else {
                cname = otherEdu2;
            }
            if (email != null) {
                otherEdu2 = cname;
                cname = email;
                etcEmail.setText(cname);
            } else {
                cname = email;
            }
            if (adhar != null) {
                email = cname;
                chAdhar.setChecked(true);
            }
            if (pannumber != null) {
                chPAN.setChecked(true);
                cname = pannumber;
                txtpannumber.setText(cname);
            } else {
                cname = pannumber;
            }
            if (leednumber2 != null) {
                pannumber = cname;
                cname = leednumber2;
                txtleadid.setText(cname);
            } else {
                cname = leednumber2;
            }
            if (cname2 != null) {
                leednumber2 = cname;
                cname = cname2;
                etcname.setText(cname);
            } else {
                cname = cname2;
            }
            if (caddress2 != null) {
                cname2 = cname;
                cname = caddress2;
                etaddress.setText(cname);
            } else {
                cname = caddress2;
            }
            if (permanataddress2 != null) {
                caddress2 = cname;
                cname = permanataddress2;
                etpermanantaddress.setText(cname);
            } else {
                cname = permanataddress2;
            }
            if (officeaddress2 != null) {
                permanataddress2 = cname;
                cname = officeaddress2;
                etoffaddress.setText(cname);
            } else {
                cname = officeaddress2;
            }
            if (contact2 != null) {
                officeaddress2 = cname;
                cname = contact2;
                etcontatct.setText(cname);
            } else {
                cname = contact2;
            }
            if (altcontact2 != null) {
                contact2 = cname;
                cname = altcontact2;
                etalternatecontact.setText(cname);
            } else {
                cname = altcontact2;
            }
            String residencial3;
            if (residencial2 != null) {
                ArrayAdapter myAdap2 = (ArrayAdapter) Recidential.getAdapter();
                altcontact2 = cname;
                cname = residencial2;
                ArrayAdapter residencial4 = myAdap2;
                residencial3 = cname;
                Recidential.setSelection(myAdap2.getPosition(cname));
            } else {
                residencial3 = residencial2;
            }
            if (birthdate2 != null) {
                etbirthdate.setText(birthdate2);
            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedNumber(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setCustomerName(this.cNmae);
            leedsModel.setAddress(this.cAdress);
            leedsModel.setMobileNumber(this.cContatct);
            leedsModel.setAlternetMobileNumber(this.cAltcontatct);
            leedsModel.setDateOfBirth(this.cBdate);
            leedsModel.setOfficeAdderess(this.cOffaddress);
            leedsModel.setRecidential(this.cresidencial);
            leedsModel.setPeraddress(this.cPadress);
            leedsModel.setCurrentpin(this.cCurrentPIN);
            leedsModel.setCurrentarea(this.cCurrentarea);
            leedsModel.setCurrentlandmark(this.cCurrentlandmark);
            leedsModel.setCurrentstreet(this.cCurrentstreet);
            if (this.cYesNo.equalsIgnoreCase("No")) {
                leedsModel.setPincode(this.cPIN);
                leedsModel.setArea(this.carea);
                leedsModel.setLandmark(this.clandmark);
                leedsModel.setStreet(this.cstreet);
            } else if (this.cYesNo.equalsIgnoreCase("Yes")) {
                leedsModel.setPincode(this.cCurrentPIN);
                leedsModel.setArea(this.cCurrentarea);
                leedsModel.setLandmark(this.cCurrentlandmark);
                leedsModel.setStreet(this.cCurrentstreet);
            }
            leedsModel.setEmail(this.cEmail);
            leedsModel.setAdharNo(this.cAdhar);
            leedsModel.setCheckpanCardNumber(this.cPAN);
            leedsModel.setPanCardNumber(this.cPANnumber);
            leedsModel.setOtherEducation(this.cOther);
            leedsModel.setApvoterid(this.cVoterid);
            leedsModel.setApdrivinglicence(this.cDL);
            leedsModel.setAppassport(this.cPassport);
            leedsModel.setProofadhar(this.cProofadhar);
            leedsModel.setProofvoterid(this.cProofvoterid);
            leedsModel.setProofdl(this.cProofDL);
            leedsModel.setProofelectricitybill(this.cProofelectricitybill);
            leedsModel.setProofrentagmt(this.cProofrentagmt);
            leedsModel.setProofpassport(this.cProofpassport);
            leedsModel.setProofgevtid(this.cProofgovtid);
            leedsModel.setProofgumasta(this.cProofgumasta);
            leedsModel.setProofcurrentacctstmt(this.cProofcurrentacctstmt);
            leedsModel.setPrapplicantrelation(this.sapplicantrelation);
            leedsModel.setCoapplicantotherrelation(this.sotherrelationship);
            leedsModel.setPrreference1name(this.sreference1name);
            leedsModel.setPrreference1address(this.sreference1address);
            leedsModel.setPrreferencecontactno(this.sreferencecontactno);
            leedsModel.setPrreferencerelationship(this.sreferencerelationship);
            leedsModel.setPrreference2name(this.sreference2name);
            leedsModel.setPrreference2address(this.sreference2address);
            leedsModel.setPrreference2contactno(this.sreference2contactno);
            leedsModel.setPrreference2relationship(this.sreference2relationship);
            leedsModel.setEducation(this.cEducation);
            leedsModel.setGender(this.cGender);
            leedsModel.setAddressYesNo(this.cYesNo);
            leedsModel.setCoApplicantYN(this.scoapplicantYN);
        } catch (Exception e) {
        }
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.updateLeed(leedId, leedsMap, new C09288());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        if (this.CoapplicantRalationship.getSelectedItem().toString().equalsIgnoreCase("Please specify")) {
            showotherRelation();
        } else {
            hideotherRelation();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void fieldVisibility() {
        LayoutParams params = (LayoutParams) this.layoutpin.getLayoutParams();
        LayoutParams params1 = (LayoutParams) this.layoutlandmark.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutarea.getLayoutParams();
        LayoutParams params3 = (LayoutParams) this.layoutstreet.getLayoutParams();
        params.height = -1;
        params1.height = -1;
        params2.height = -1;
        params3.height = -1;
        this.layoutpin.setLayoutParams(params);
        this.layoutlandmark.setLayoutParams(params1);
        this.layoutarea.setLayoutParams(params2);
        this.layoutstreet.setLayoutParams(params3);
    }

    public void FieldInvisible() {
        LayoutParams params = (LayoutParams) this.layoutpin.getLayoutParams();
        LayoutParams params1 = (LayoutParams) this.layoutlandmark.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutarea.getLayoutParams();
        LayoutParams params3 = (LayoutParams) this.layoutstreet.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        this.layoutpin.setLayoutParams(params);
        this.layoutlandmark.setLayoutParams(params1);
        this.layoutarea.setLayoutParams(params2);
        this.layoutstreet.setLayoutParams(params3);
    }

    public void hideother() {
        LayoutParams params = (LayoutParams) this.layoutothervalue.getLayoutParams();
        params.height = 0;
        this.layoutothervalue.setLayoutParams(params);
    }

    public void Showother() {
        LayoutParams params = (LayoutParams) this.layoutothervalue.getLayoutParams();
        params.height = -1;
        this.layoutothervalue.setLayoutParams(params);
    }

    public void ShowApplicant() {
        LayoutParams params = (LayoutParams) this.layoutrelationship.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutsavebutton.getLayoutParams();
        params.height = -1;
        params2.height = -1;
        this.layoutrelationship.setLayoutParams(params);
        this.layoutsavebutton.setLayoutParams(params2);
    }

    public void showotherRelation() {
        LayoutParams params1 = (LayoutParams) this.layoutotherrelationship.getLayoutParams();
        params1.height = -1;
        this.layoutotherrelationship.setLayoutParams(params1);
    }

    public void hideotherRelation() {
        LayoutParams params1 = (LayoutParams) this.layoutotherrelationship.getLayoutParams();
        params1.height = 0;
        this.layoutotherrelationship.setLayoutParams(params1);
    }

    public void HideApplicant() {
        LayoutParams params = (LayoutParams) this.layoutrelationship.getLayoutParams();
        LayoutParams params1 = (LayoutParams) this.layoutotherrelationship.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutsavebutton.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        this.layoutrelationship.setLayoutParams(params);
        this.layoutotherrelationship.setLayoutParams(params1);
        this.layoutsavebutton.setLayoutParams(params2);
    }

    public void Hidereference() {
        LayoutParams params1 = (LayoutParams) this.layoutref1name.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutref1address.getLayoutParams();
        LayoutParams params3 = (LayoutParams) this.layoutref1contact.getLayoutParams();
        LayoutParams params4 = (LayoutParams) this.layoutref1relationship.getLayoutParams();
        LayoutParams params5 = (LayoutParams) this.layoutref2name.getLayoutParams();
        LayoutParams params6 = (LayoutParams) this.layoutref2address.getLayoutParams();
        LayoutParams params7 = (LayoutParams) this.layoutref2contact.getLayoutParams();
        LayoutParams params8 = (LayoutParams) this.layoutref2relationship.getLayoutParams();
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        params4.height = 0;
        params5.height = 0;
        params6.height = 0;
        params7.height = 0;
        params8.height = 0;
        this.layoutref1name.setLayoutParams(params1);
        this.layoutref1address.setLayoutParams(params2);
        this.layoutref1contact.setLayoutParams(params3);
        this.layoutref1relationship.setLayoutParams(params4);
        this.layoutref2name.setLayoutParams(params5);
        this.layoutref2address.setLayoutParams(params6);
        this.layoutref2contact.setLayoutParams(params7);
        this.layoutref2relationship.setLayoutParams(params8);
    }

    public void Showreference() {
        LayoutParams params1 = (LayoutParams) this.layoutref1name.getLayoutParams();
        LayoutParams params2 = (LayoutParams) this.layoutref1address.getLayoutParams();
        LayoutParams params3 = (LayoutParams) this.layoutref1contact.getLayoutParams();
        LayoutParams params4 = (LayoutParams) this.layoutref1relationship.getLayoutParams();
        LayoutParams params5 = (LayoutParams) this.layoutref2name.getLayoutParams();
        LayoutParams params6 = (LayoutParams) this.layoutref2address.getLayoutParams();
        LayoutParams params7 = (LayoutParams) this.layoutref2contact.getLayoutParams();
        LayoutParams params8 = (LayoutParams) this.layoutref2relationship.getLayoutParams();
        params1.height = -1;
        params2.height = -1;
        params3.height = -1;
        params4.height = -1;
        params5.height = -1;
        params6.height = -1;
        params7.height = -1;
        params8.height = -1;
        this.layoutref1name.setLayoutParams(params1);
        this.layoutref1address.setLayoutParams(params2);
        this.layoutref1contact.setLayoutParams(params3);
        this.layoutref1relationship.setLayoutParams(params4);
        this.layoutref2name.setLayoutParams(params5);
        this.layoutref2address.setLayoutParams(params6);
        this.layoutref2contact.setLayoutParams(params7);
        this.layoutref2relationship.setLayoutParams(params8);
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    protected void onRestart() {
        super.onRestart();
        this.edtreferencename.requestFocus();
    }
}
