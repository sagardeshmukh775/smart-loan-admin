package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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

import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.STATUS_VERIFIED;

public class TL_Updatelead_C_Details_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinloantype, spinemptype, spinincome;
    Button btupdate, btverify, btcancel, btnnext, btnsave;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;

    ArrayList<LeedsModel> leedsModelArrayList;
    EditText etother, eparents, eresidencial, etpermanantaddress, etcname, etaddress, etoffaddress, etcontatct, etalternatecontact, etbirthdate;
    String padress, cresidencial, cparents, cNmae, cAdress, cPadress, cOffaddress, cContatct, cAltcontatct, cBdate, cOther;
    TextView txtldate, txtleadid;
    RadioGroup groupRadio, groupRadioEducation, groupRadioGender,
            groupRadiocoapplicant;
    EditText pin, landmark, area, street,
            currentpin, currentlandmark, currentarea, currentstreet,
            txtpannumber;
    TextView pin1, landmark1, area1, street1;
    RelativeLayout layoutpin, layoutlandmark, layoutarea, layoutstreet, layoutothervalue;
    EditText etcEmail, edtotherrelationship,
            edtreferencename, edtreferenceaddress, edtreferencecontactno, edtreferencerelationship,
            edtreferencename2, edtreferenceaddress2, edtreferencecontactno2, edtreferencerelationship2;
    CheckBox chAdhar, chPAN, chVoterID, chDL, chPassport, chProofAdhar, chProofVoterid, chProofdl, chProofElectricitybill,
            chProofRntagmt, chProofPassport, chProofGovtEmpid, chProofGumasta, chProofCurrentacctStmt;
    String cYesNo, cCurrentPIN, cCurrentlandmark, cCurrentarea, cCurrentstreet, cPIN, clandmark, carea, cstreet, cEducation, cGender, cEmail, cAdhar, cPAN, cVoterid, cDL, cPassport,
            cProofadhar, cProofvoterid, cProofDL, cProofelectricitybill, cProofrentagmt, cProofpassport, cProofgovtid, cProofgumasta,
            cProofcurrentacctstmt, cPANnumber,
            scoapplicantYN, sapplicantrelation, sotherrelationship,
            sreference1name, sreference1address, sreferencecontactno, sreferencerelationship,
            sreference2name, sreference2address, sreference2contactno, sreference2relationship;
    RadioButton REducation, Rgender, RYN, Ryes, Rno, Rug, Rg, Rpg, Rpro, Rother, Rmale, Rfemale,
            RcoapplicantYES, RcoapplicantNO, Rcoapplicant;

    Spinner Recidential, CoapplicantRalationship;
    RelativeLayout layoutrelationship, layoutotherrelationship, layoutsavebutton,
            layoutref1name, layoutref1address, layoutref1contact, layoutref1relationship,
            layoutref2name, layoutref2address, layoutref2contact, layoutref2relationship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tl_updatelead_cdetails_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        layoutpin = (RelativeLayout) findViewById(R.id.layoutpin);
        layoutlandmark = (RelativeLayout) findViewById(R.id.layoutland);
        layoutarea = (RelativeLayout) findViewById(R.id.layoutArea);
        layoutstreet = (RelativeLayout) findViewById(R.id.layoutstreet);
        layoutothervalue = (RelativeLayout) findViewById(R.id.layoutothervalue);

        layoutrelationship = (RelativeLayout) findViewById(R.id.layoutcoapplicantrelation);
        layoutotherrelationship = (RelativeLayout) findViewById(R.id.layoutotherrelationship);
        layoutsavebutton = (RelativeLayout) findViewById(R.id.layoutbuttonsave);

        layoutref1name = (RelativeLayout) findViewById(R.id.layoutreferencefullname);
        layoutref1address = (RelativeLayout) findViewById(R.id.layoutreferenceaddress);
        layoutref1contact = (RelativeLayout) findViewById(R.id.layoutreferencecontactno);
        layoutref1relationship = (RelativeLayout) findViewById(R.id.layoutreferencerelationhsip);
        layoutref2name = (RelativeLayout) findViewById(R.id.layoutreference2fullname);
        layoutref2address = (RelativeLayout) findViewById(R.id.layoutreference2address);
        layoutref2contact = (RelativeLayout) findViewById(R.id.layoutreference2contactno);
        layoutref2relationship = (RelativeLayout) findViewById(R.id.layoutreference2relationhsip);


        setSupportActionBar(toolbar);
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};

        btnnext = (Button) findViewById(R.id.buttonupdatenext);
        btnsave = (Button) findViewById(R.id.buttonsave);

        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        groupRadio = (RadioGroup) findViewById(R.id.radioGYN);

        currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);

        pin = (EditText) findViewById(R.id.txtpin1);
        landmark = (EditText) findViewById(R.id.txtlandmark1);
        area = (EditText) findViewById(R.id.txtarea1);
        street = (EditText) findViewById(R.id.txtstreet1);
        etoffaddress = (EditText) findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (EditText) findViewById(R.id.txtbirthdatevalue);
        groupRadioEducation = (RadioGroup) findViewById(R.id.radioeducation);
        groupRadioGender = (RadioGroup) findViewById(R.id.radioSex);
        etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) findViewById(R.id.txtemail1);
        Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);

        CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
        CoapplicantRalationship.setOnItemSelectedListener(this);
        edtotherrelationship = (EditText) findViewById(R.id.txtotherrelationship1);

        edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
        edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
        edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
        edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
        edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
        edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
        edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
        edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);

        txtpannumber = (EditText) findViewById(R.id.txtpannumber);

        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);
        //eresidencial = (EditText) findViewById(R.id.txtrecidencialvalue);

        // eparents = (EditText) findViewById(R.id.txtparentsvalue);
        etother = (EditText) findViewById(R.id.txtOthervalue);

        chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        chPAN = (CheckBox) findViewById(R.id.checkboxpan);
        if (chPAN.isChecked()) {
            txtpannumber.setVisibility(View.VISIBLE);
        }else {
            txtpannumber.setVisibility(View.INVISIBLE);
        }
        chPAN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtpannumber.setVisibility(View.VISIBLE);
                } else {
                    txtpannumber.setVisibility(View.INVISIBLE);
                }
            }
        });

        chVoterID = (CheckBox) findViewById(R.id.checkboxvoterid);
        chDL = (CheckBox) findViewById(R.id.checkboxdrivinglicence);
        chPassport = (CheckBox) findViewById(R.id.checkboxpassport);

        chProofAdhar = (CheckBox) findViewById(R.id.checkboxproofAdhar);
        chProofVoterid = (CheckBox) findViewById(R.id.checkboxproofVoterid);
        chProofdl = (CheckBox) findViewById(R.id.checkboxproofDL);
        chProofElectricitybill = (CheckBox) findViewById(R.id.checkboxproofElectricitybill);
        chProofRntagmt = (CheckBox) findViewById(R.id.checkboxpeoofRentAgmt);
        chProofPassport = (CheckBox) findViewById(R.id.checkboxproofPassport);
        chProofGovtEmpid = (CheckBox) findViewById(R.id.checkboxproofGevtEmpID);
        chProofGumasta = (CheckBox) findViewById(R.id.checkboxproofGumasta);
        chProofCurrentacctStmt = (CheckBox) findViewById(R.id.checkboxproofCurrentAcctStmt);

        txtleadid = (TextView) findViewById(R.id.textheader);

        RcoapplicantYES = (RadioButton) findViewById(R.id.radioapplicantYes);
        RcoapplicantNO = (RadioButton) findViewById(R.id.radioapplicantNo);

        groupRadiocoapplicant = (RadioGroup) findViewById(R.id.radiocoapplicantYN);

        groupRadiocoapplicant.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Rcoapplicant = (RadioButton) findViewById(checkedId);
                scoapplicantYN = Rcoapplicant.getText().toString();
                if (Rcoapplicant.getText().toString().equalsIgnoreCase("Yes")) {
                    ShowApplicant();
                } else {
                    HideApplicant();
                }
            }
        });

        groupRadioEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                REducation = (RadioButton) findViewById(checkedId);
                if (REducation.getText().toString().equalsIgnoreCase("Other")) {
                    Showother();
                } else {
                    hideother();
                }
            }
        });

        groupRadioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Rgender = (RadioButton) findViewById(checkedId);
                cGender = Rgender.getText().toString();
            }
        });

        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RYN = (RadioButton) findViewById(checkedId);
                cYesNo = RYN.getText().toString();
                if (RYN.getText().toString().equalsIgnoreCase("No")) {
                    fieldVisibility();
                } else {
                    FieldInvisible();
                }
            }
        });


        if (groupRadioGender.getCheckedRadioButtonId() != -1) {
            int id = groupRadioGender.getCheckedRadioButtonId();
            View radioButton = groupRadioGender.findViewById(id);
            int radioId = groupRadioGender.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadioGender.getChildAt(radioId);
            cGender = btn.getText().toString();
        }
        if (groupRadio.getCheckedRadioButtonId() != -1) {
            int id = groupRadio.getCheckedRadioButtonId();
            View radioButton = groupRadio.findViewById(id);
            int radioId = groupRadio.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadio.getChildAt(radioId);
            cYesNo = btn.getText().toString();

            if (cYesNo.equalsIgnoreCase("No")) {
                fieldVisibility();
            } else {
                FieldInvisible();
            }
        }
        if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
            int id = groupRadioEducation.getCheckedRadioButtonId();
            View radioButton = groupRadioEducation.findViewById(id);
            int radioId = groupRadioEducation.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadioEducation.getChildAt(radioId);
            cEducation = btn.getText().toString();

            if (cEducation.equalsIgnoreCase("Other")) {
                Showother();
            } else {
                hideother();
            }
        }
        if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
            int id = groupRadiocoapplicant.getCheckedRadioButtonId();
            View radioButton = groupRadiocoapplicant.findViewById(id);
            int radioId = groupRadiocoapplicant.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadiocoapplicant.getChildAt(radioId);
            scoapplicantYN = btn.getText().toString();

            if (scoapplicantYN.equalsIgnoreCase("Yes")) {
                ShowApplicant();
            } else {
                HideApplicant();
            }
        }

        Ryes = (RadioButton) findViewById(R.id.radioYes);
        Rno = (RadioButton) findViewById(R.id.radioNo);
        Rug = (RadioButton) findViewById(R.id.radioUG);
        Rg = (RadioButton) findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) findViewById(R.id.radioPG);
        Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        Rother = (RadioButton) findViewById(R.id.radioother);
        Rmale = (RadioButton) findViewById(R.id.radioMale);
        Rfemale = (RadioButton) findViewById(R.id.radioFemale);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cNmae = etcname.getText().toString();
                cAdress = etaddress.getText().toString();

                cCurrentPIN = currentpin.getText().toString();
                cCurrentlandmark = currentlandmark.getText().toString();
                cCurrentarea = currentarea.getText().toString();
                cCurrentstreet = currentstreet.getText().toString();

                cPadress = etpermanantaddress.getText().toString();
                cPIN = pin.getText().toString();
                clandmark = landmark.getText().toString();
                carea = area.getText().toString();
                cstreet = street.getText().toString();
                cOffaddress = etoffaddress.getText().toString();
                cBdate = etbirthdate.getText().toString();

                cContatct = etcontatct.getText().toString();
                cAltcontatct = etalternatecontact.getText().toString();
                cEmail = etcEmail.getText().toString();

                cPANnumber = txtpannumber.getText().toString();

                String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!cEmail.matches(emialpattern)) {
                    etcEmail.setError("Invalid Email");
                }

                cresidencial = Recidential.getSelectedItem().toString();
                sapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
                sotherrelationship = edtotherrelationship.getText().toString();

                cOther = etother.getText().toString();

                if (chAdhar.isChecked()) {
                    cAdhar = chAdhar.getText().toString();
                }
                if (chPAN.isChecked()) {
                    cPAN = chPAN.getText().toString();
                }
                if (chVoterID.isChecked()) {
                    cVoterid = chVoterID.getText().toString();
                }
                if (chDL.isChecked()) {
                    cDL = chDL.getText().toString();
                }
                if (chPassport.isChecked()) {
                    cPassport = chPassport.getText().toString();
                }

                if (chProofAdhar.isChecked()) {
                    cProofadhar = chProofAdhar.getText().toString();
                }
                if (chProofVoterid.isChecked()) {
                    cProofvoterid = chProofVoterid.getText().toString();
                }
                if (chProofdl.isChecked()) {
                    cProofDL = chProofdl.getText().toString();
                }
                if (chProofElectricitybill.isChecked()) {
                    cProofelectricitybill = chProofElectricitybill.getText().toString();
                }
                if (chProofRntagmt.isChecked()) {
                    cProofrentagmt = chProofRntagmt.getText().toString();
                }
                if (chProofPassport.isChecked()) {
                    cProofpassport = chProofPassport.getText().toString();
                }
                if (chProofGovtEmpid.isChecked()) {
                    cProofgovtid = chProofGovtEmpid.getText().toString();
                }
                if (chProofGumasta.isChecked()) {
                    cProofgumasta = chProofGumasta.getText().toString();
                }
                if (chProofCurrentacctStmt.isChecked()) {
                    cProofcurrentacctstmt = chProofCurrentacctStmt.getText().toString();
                }


                if (TextUtils.isEmpty(cNmae)) {
                    etcname.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cBdate)) {
                    etbirthdate.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cContatct)) {
                    etcontatct.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAltcontatct)) {
                    etalternatecontact.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cEmail)) {
                    etcEmail.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cOffaddress)) {
                    etoffaddress.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAdhar)) {
                    Toast.makeText(getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cPAN)) {
                    Toast.makeText(getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                    return;
                }

                updateLeadDetails(leedsModel);
                //   Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(TL_Updatelead_C_Details_Activity.this, TL_Updatelead_Coapplicant_Detail_Activity.class);
                i.putExtra(LEED_MODEL, leedsModel);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                cNmae = etcname.getText().toString();
                cAdress = etaddress.getText().toString();

                cCurrentPIN = currentpin.getText().toString();
                cCurrentlandmark = currentlandmark.getText().toString();
                cCurrentarea = currentarea.getText().toString();
                cCurrentstreet = currentstreet.getText().toString();

                cPadress = etpermanantaddress.getText().toString();
                cPIN = pin.getText().toString();
                clandmark = landmark.getText().toString();
                carea = area.getText().toString();
                cstreet = street.getText().toString();
                cOffaddress = etoffaddress.getText().toString();
                cBdate = etbirthdate.getText().toString();

                cPANnumber = txtpannumber.getText().toString();

                if (groupRadioGender.getCheckedRadioButtonId() != -1) {
                    int id = groupRadioGender.getCheckedRadioButtonId();
                    View radioButton = groupRadioGender.findViewById(id);
                    int radioId = groupRadioGender.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) groupRadioGender.getChildAt(radioId);
                    cGender = btn.getText().toString();
                }
                if (groupRadio.getCheckedRadioButtonId() != -1) {
                    int id = groupRadio.getCheckedRadioButtonId();
                    View radioButton = groupRadio.findViewById(id);
                    int radioId = groupRadio.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) groupRadio.getChildAt(radioId);
                    cYesNo = btn.getText().toString();
                }
                if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
                    int id = groupRadioEducation.getCheckedRadioButtonId();
                    View radioButton = groupRadioEducation.findViewById(id);
                    int radioId = groupRadioEducation.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) groupRadioEducation.getChildAt(radioId);
                    cEducation = btn.getText().toString();
                }
                if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
                    int id = groupRadiocoapplicant.getCheckedRadioButtonId();
                    View radioButton = groupRadiocoapplicant.findViewById(id);
                    int radioId = groupRadiocoapplicant.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) groupRadiocoapplicant.getChildAt(radioId);
                    scoapplicantYN = btn.getText().toString();
                }

                cContatct = etcontatct.getText().toString();
                cAltcontatct = etalternatecontact.getText().toString();
                cEmail = etcEmail.getText().toString();

                cresidencial = Recidential.getSelectedItem().toString();


                cOther = etother.getText().toString();

                if (chAdhar.isChecked()) {
                    cAdhar = chAdhar.getText().toString();
                }
                if (chPAN.isChecked()) {
                    cPAN = chPAN.getText().toString();
                }
                if (chVoterID.isChecked()) {
                    cVoterid = chVoterID.getText().toString();
                }
                if (chDL.isChecked()) {
                    cDL = chDL.getText().toString();
                }
                if (chPassport.isChecked()) {
                    cPassport = chPassport.getText().toString();
                }

                if (chProofAdhar.isChecked()) {
                    cProofadhar = chProofAdhar.getText().toString();
                }
                if (chProofVoterid.isChecked()) {
                    cProofvoterid = chProofVoterid.getText().toString();
                }
                if (chProofdl.isChecked()) {
                    cProofDL = chProofdl.getText().toString();
                }
                if (chProofElectricitybill.isChecked()) {
                    cProofelectricitybill = chProofElectricitybill.getText().toString();
                }
                if (chProofRntagmt.isChecked()) {
                    cProofrentagmt = chProofRntagmt.getText().toString();
                }
                if (chProofPassport.isChecked()) {
                    cProofpassport = chProofPassport.getText().toString();
                }
                if (chProofGovtEmpid.isChecked()) {
                    cProofgovtid = chProofGovtEmpid.getText().toString();
                }
                if (chProofGumasta.isChecked()) {
                    cProofgumasta = chProofGumasta.getText().toString();
                }
                if (chProofCurrentacctStmt.isChecked()) {
                    cProofcurrentacctstmt = chProofCurrentacctStmt.getText().toString();
                }

                sapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
                sotherrelationship = edtotherrelationship.getText().toString();
                sreference1name = edtreferencename.getText().toString();
                sreference1address = edtreferenceaddress.getText().toString();
                sreferencecontactno = edtreferencecontactno.getText().toString();
                sreferencerelationship = edtreferencerelationship.getText().toString();
                sreference2name = edtreferencename2.getText().toString();
                sreference2address = edtreferenceaddress2.getText().toString();
                sreference2contactno = edtreferencecontactno2.getText().toString();
                sreference2relationship = edtreferencerelationship2.getText().toString();

                if (TextUtils.isEmpty(cNmae)) {
                    etcname.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cBdate)) {
                    etbirthdate.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cContatct)) {
                    etcontatct.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAltcontatct)) {
                    etalternatecontact.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Alternete Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty(cEmail)) {
                    etcEmail.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Email Address!", Toast.LENGTH_SHORT).show();

                    return;
                } else if (!cEmail.matches(emialpattern)) {
                    etcEmail.setError("Invalid Email");
                    Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cOffaddress)) {
                    Toast.makeText(getApplicationContext(), "Enter Office Address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAdhar)) {
                    Toast.makeText(getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cPAN)) {
                    Toast.makeText(getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                    return;
                }

                updateLeadDetails(leedsModel);
                //   Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(TL_Updatelead_C_Details_Activity.this, Tl_Updatelead_incomedetails_Activity.class);
                i.putExtra(LEED_MODEL, leedsModel);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        getdata();

    }//end of oncreate


    private void getdata() {

        try {


            String leednumber = leedsModel.getLeedNumber();
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

            String currentPIN = leedsModel.getCurrentpin();
            String currentland = leedsModel.getCurrentlandmark();
            String currentSarea = leedsModel.getCurrentarea();
            String currentSstreet = leedsModel.getCurrentstreet();

            String PIN = leedsModel.getPincode();
            String land = leedsModel.getLandmark();
            String Sarea = leedsModel.getArea();
            String Sstreet = leedsModel.getStreet();

            String email = leedsModel.getEmail();
            String adhar = leedsModel.getadharNo();
            String pan = leedsModel.getCheckpanCardNumber();
            String pannumber = leedsModel.getPanCardNumber();
            String voterid = leedsModel.getApvoterid();
            String driverlicence = leedsModel.getApdrivinglicence();
            String passport = leedsModel.getAppassport();

            String adharproof = leedsModel.getProofadhar();
            String voteridproof = leedsModel.getProofvoterid();
            String dlproof = leedsModel.getProofdl();
            String electricitybillproof = leedsModel.getProofelectricitybill();
            String rentagmtproof = leedsModel.getProofrentagmt();
            String passportproof = leedsModel.getProofpassport();
            String gevtidproof = leedsModel.getProofgevtid();
            String gumastaproof = leedsModel.getProofgumasta();
            String currentacctprrof = leedsModel.getProofcurrentacctstmt();

            String relatioship = leedsModel.getPrapplicantrelation();
            String otherrelationship = leedsModel.getCoapplicantotherrelation();
            String ref1name = leedsModel.getPrreference1name();
            String ref1address = leedsModel.getPrreference1address();
            String ref1contact = leedsModel.getPrreferencecontactno();
            String ref1relation = leedsModel.getPrreferencerelationship();
            String ref2name = leedsModel.getPrreference2name();
            String ref2address = leedsModel.getPrreference2address();
            String ref2contact = leedsModel.getPrreference2contactno();
            String ref2relation = leedsModel.getPrreference2relationship();

            if (applicantYN != null) {
                if (applicantYN.equalsIgnoreCase("Yes")) {
                    RcoapplicantYES.setChecked(true);
                    ShowApplicant();
                } else if (applicantYN.equalsIgnoreCase("No")) {
                    RcoapplicantNO.setChecked(true);
                    HideApplicant();
                }
            }
            if (relatioship != null) {

                ArrayAdapter myAdap = (ArrayAdapter) CoapplicantRalationship.getAdapter();
                int spinnerPosition = myAdap.getPosition(relatioship);
                CoapplicantRalationship.setSelection(spinnerPosition);
                if (relatioship.equalsIgnoreCase("Please specify")) {
                    showotherRelation();
                } else {
                    hideotherRelation();
                }
            }
            if (otherrelationship != null) {
                edtotherrelationship.setText(otherrelationship);

            }
            if (ref1name != null) {
                edtreferencename.setText(ref1name);

            }
            if (ref1address != null) {
                edtreferenceaddress.setText(ref1address);

            }
            if (ref1contact != null) {
                edtreferencecontactno.setText(ref1contact);

            }
            if (ref1relation != null) {
                edtreferencerelationship.setText(ref1relation);

            }
            if (ref2name != null) {
                edtreferencename2.setText(ref2name);

            }
            if (ref2address != null) {
                edtreferenceaddress2.setText(ref2address);

            }
            if (ref2contact != null) {
                edtreferencecontactno2.setText(ref2contact);

            }
            if (ref2relation != null) {
                edtreferencerelationship2.setText(ref2relation);

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
                if (gender.equalsIgnoreCase("Male")) {
                    Rmale.setChecked(true);
                } else {
                    Rfemale.setChecked(true);
                }
            }

            if (currentPIN != null) {
                currentpin.setText(currentPIN);

            }
            if (currentland != null) {
                currentlandmark.setText(currentland);

            }
            if (currentSarea != null) {
                currentarea.setText(currentSarea);

            }
            if (currentSstreet != null) {
                currentstreet.setText(currentSstreet);

            }
            if (addressYN != null) {
                if (addressYN.equalsIgnoreCase("Yes")) {
                    Ryes.setChecked(true);
                    FieldInvisible();

                } else {
                    Rno.setChecked(true);
                    fieldVisibility();

                }
            }

            if (Rno.isChecked()) {


            } else {
                if (PIN != null) {
                    pin.setText(PIN);

                }
                if (land != null) {
                    landmark.setText(land);

                }
                if (Sarea != null) {
                    area.setText(Sarea);

                }
                if (Sstreet != null) {
                    street.setText(Sstreet);

                }
            }

            if (adharproof != null) {
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
            if (otherEdu != null) {
                etother.setText(otherEdu);

            }
            if (email != null) {
                etcEmail.setText(email);

            }
            if (adhar != null) {
                chAdhar.setChecked(true);

            }
            if (pannumber != null) {
                chPAN.setChecked(true);
                txtpannumber.setText(pannumber);

            }


            if (leednumber != null) {
                txtleadid.setText(leednumber);

            }
            if (cname != null) {
                etcname.setText(cname);

            }
            if (caddress != null) {
                etaddress.setText(caddress);

            }
            if (permanataddress != null) {
                etpermanantaddress.setText(permanataddress);

            }
            if (officeaddress != null) {
                etoffaddress.setText(officeaddress);
            }

            if (contact != null) {
                etcontatct.setText(contact);

            }
            if (altcontact != null) {
                etalternatecontact.setText(altcontact);
            }
            if (residencial != null) {

                ArrayAdapter myAdap = (ArrayAdapter) Recidential.getAdapter();
                int spinnerPosition = myAdap.getPosition(residencial);
                Recidential.setSelection(spinnerPosition);
            }

            if (birthdate != null) {
                etbirthdate.setText(birthdate);
            }


        } catch (Exception e) {
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedNumber(), leedsModel.getLeedStatusMap1());
    }


    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setCustomerName(cNmae);
            leedsModel.setAddress(cAdress);
            leedsModel.setMobileNumber(cContatct);
            leedsModel.setAlternetMobileNumber(cAltcontatct);
            leedsModel.setDateOfBirth(cBdate);
            leedsModel.setOfficeAdderess(cOffaddress);

            leedsModel.setRecidential(cresidencial);
            leedsModel.setPeraddress(cPadress);

            leedsModel.setCurrentpin(cCurrentPIN);
            leedsModel.setCurrentarea(cCurrentarea);
            leedsModel.setCurrentlandmark(cCurrentlandmark);
            leedsModel.setCurrentstreet(cCurrentstreet);

            if (cYesNo.equalsIgnoreCase("No")) {
                leedsModel.setPincode(cPIN);
                leedsModel.setArea(carea);
                leedsModel.setLandmark(clandmark);
                leedsModel.setStreet(cstreet);
            } else if (cYesNo.equalsIgnoreCase("Yes")) {
                leedsModel.setPincode(cCurrentPIN);
                leedsModel.setArea(cCurrentarea);
                leedsModel.setLandmark(cCurrentlandmark);
                leedsModel.setStreet(cCurrentstreet);
            }

            leedsModel.setEmail(cEmail);
            leedsModel.setAdharNo(cAdhar);
            leedsModel.setCheckpanCardNumber(cPAN);
            leedsModel.setPanCardNumber(cPANnumber);
            leedsModel.setOtherEducation(cOther);
            leedsModel.setApvoterid(cVoterid);
            leedsModel.setApdrivinglicence(cDL);
            leedsModel.setAppassport(cPassport);

            leedsModel.setProofadhar(cProofadhar);
            leedsModel.setProofvoterid(cProofvoterid);
            leedsModel.setProofdl(cProofDL);
            leedsModel.setProofelectricitybill(cProofelectricitybill);
            leedsModel.setProofrentagmt(cProofrentagmt);
            leedsModel.setProofpassport(cProofpassport);
            leedsModel.setProofgevtid(cProofgovtid);
            leedsModel.setProofgumasta(cProofgumasta);
            leedsModel.setProofcurrentacctstmt(cProofcurrentacctstmt);


            leedsModel.setPrapplicantrelation(sapplicantrelation);
            leedsModel.setCoapplicantotherrelation(sotherrelationship);
            leedsModel.setPrreference1name(sreference1name);
            leedsModel.setPrreference1address(sreference1address);
            leedsModel.setPrreferencecontactno(sreferencecontactno);
            leedsModel.setPrreferencerelationship(sreferencerelationship);
            leedsModel.setPrreference2name(sreference2name);
            leedsModel.setPrreference2address(sreference2address);
            leedsModel.setPrreference2contactno(sreference2contactno);
            leedsModel.setPrreference2relationship(sreference2relationship);

            leedsModel.setEducation(cEducation);
            leedsModel.setGender(cGender);
            leedsModel.setAddressYesNo(cYesNo);
            leedsModel.setCoApplicantYN(scoapplicantYN);

        } catch (Exception e) {

        }

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }


    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(TL_Updatelead_C_Details_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                // progressDialogClass.dismissDialog();
                Utility.showLongMessage(TL_Updatelead_C_Details_Activity.this, getString(R.string.server_error));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        // sploantype = spinloantype.getSelectedItem().toString();
        // spoccupation = spinemptype.getSelectedItem().toString();
        String relation = CoapplicantRalationship.getSelectedItem().toString();
        if (relation.equalsIgnoreCase("Please specify")) {
            showotherRelation();
        } else {
            hideotherRelation();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void fieldVisibility() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        params1.height = ActionBar.LayoutParams.FILL_PARENT;
        params2.height = ActionBar.LayoutParams.FILL_PARENT;
        params3.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);

    }

    public void FieldInvisible() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);
    }

    public void hideother() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothervalue.getLayoutParams();
        params.height = 0;
        layoutothervalue.setLayoutParams(params);
    }

    public void Showother() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothervalue.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        layoutothervalue.setLayoutParams(params);
    }


    public void ShowApplicant() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutsavebutton.getLayoutParams();

        params.height = ActionBar.LayoutParams.FILL_PARENT;
        params2.height = ActionBar.LayoutParams.FILL_PARENT;

        layoutrelationship.setLayoutParams(params);
        layoutsavebutton.setLayoutParams(params2);


    }

    public void showotherRelation() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void hideotherRelation() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = 0;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void HideApplicant() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutsavebutton.getLayoutParams();

        params.height = 0;
        params1.height = 0;
        params2.height = 0;

        layoutrelationship.setLayoutParams(params);
        layoutotherrelationship.setLayoutParams(params1);
        layoutsavebutton.setLayoutParams(params2);

    }

    public void Hidereference() {

        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutref1name.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutref1address.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutref1contact.getLayoutParams();
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutref1relationship.getLayoutParams();
        RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) layoutref2name.getLayoutParams();
        RelativeLayout.LayoutParams params6 = (RelativeLayout.LayoutParams) layoutref2address.getLayoutParams();
        RelativeLayout.LayoutParams params7 = (RelativeLayout.LayoutParams) layoutref2contact.getLayoutParams();
        RelativeLayout.LayoutParams params8 = (RelativeLayout.LayoutParams) layoutref2relationship.getLayoutParams();

        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        params4.height = 0;
        params5.height = 0;
        params6.height = 0;
        params7.height = 0;
        params8.height = 0;

        layoutref1name.setLayoutParams(params1);
        layoutref1address.setLayoutParams(params2);
        layoutref1contact.setLayoutParams(params3);
        layoutref1relationship.setLayoutParams(params4);
        layoutref2name.setLayoutParams(params5);
        layoutref2address.setLayoutParams(params6);
        layoutref2contact.setLayoutParams(params7);
        layoutref2relationship.setLayoutParams(params8);


    }

    public void Showreference() {

        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutref1name.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutref1address.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutref1contact.getLayoutParams();
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutref1relationship.getLayoutParams();
        RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) layoutref2name.getLayoutParams();
        RelativeLayout.LayoutParams params6 = (RelativeLayout.LayoutParams) layoutref2address.getLayoutParams();
        RelativeLayout.LayoutParams params7 = (RelativeLayout.LayoutParams) layoutref2contact.getLayoutParams();
        RelativeLayout.LayoutParams params8 = (RelativeLayout.LayoutParams) layoutref2relationship.getLayoutParams();

        params1.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params2.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params3.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params4.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params5.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params6.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params7.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        params8.height = ActionBar.LayoutParams.FILL_PARENT;
        ;

        layoutref1name.setLayoutParams(params1);
        layoutref1address.setLayoutParams(params2);
        layoutref1contact.setLayoutParams(params3);
        layoutref1relationship.setLayoutParams(params4);
        layoutref2name.setLayoutParams(params5);
        layoutref2address.setLayoutParams(params6);
        layoutref2contact.setLayoutParams(params7);
        layoutref2relationship.setLayoutParams(params8);


    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        edtreferencename.requestFocus();
        Log.d("lifecycle", "onResume invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        edtreferencename.requestFocus();
    }
}