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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class Coordinator_Update_Activity extends AppCompatActivity implements OnItemSelectedListener, OnClickListener {
    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
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
    EditText etaddress;
    EditText etadharno;
    EditText etalternatecontact;
    EditText etbank;
    EditText etbirthdate;
    EditText etcEmail;
    EditText etcname;
    EditText etcontatct;
    EditText etdescription;
    EditText etexammount;
    EditText etgenerated;
    EditText etincome;
    TextView etleednumber;
    EditText etoccupation;
    EditText etoffaddress;
    EditText etother;
    EditText etpanno;
    EditText etpermanantaddress;
    EditText etpropaddress;
    String lGenby;
    EditText landmark;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    EditText pin;
    ProgressDialogClass progressDialogClass;
    Spinner spinemptype;
    Spinner spinincome;
    Spinner spinloantype;
    String sploantype;
    String spoccupation;
    EditText street;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    TextView txtleedtime;
    EditText txtpannumber;

    @Override
    public void onClick(View v) {

    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Coordinator_Update_Activity$1 */
    class C08031 implements OnClickListener {
        C08031() {
        }

        public void onClick(View v) {
            cNmae = etcname.getText().toString();
            cAdress = etaddress.getText().toString();
            cPadress = etpropaddress.getText().toString();
            cOffaddress = etoffaddress.getText().toString();
            cContatct = etcontatct.getText().toString();
            cAltcontatct = etalternatecontact.getText().toString();
            cBdate = etbirthdate.getText().toString();
            cPanno = etpanno.getText().toString();
            cAdharno = etadharno.getText().toString();
            cIncome = etincome.getText().toString();
            cExamount = etexammount.getText().toString();
            cDescreption = etdescription.getText().toString();
            cBank = etbank.getText().toString();
            updateLeadDetails(leedsModel);
            Toast.makeText(getApplicationContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Coordinator_Update_Activity$2 */
    class C08042 implements OnClickListener {
        C08042() {
        }

        public void onClick(View v) {
            setLeedStatus(leedsModel);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Coordinator_Update_Activity$3 */
    class C08053 implements OnClickListener {
        C08053() {
        }

        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), MainActivity_coordinator.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Coordinator_Update_Activity$4 */
    class C09234 extends CallBack {
        C09234() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(getApplicationContext(), "Lead Submited Successfully", Toast.LENGTH_SHORT).show();
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            progressDialogClass.dismissDialog();
            Context context = Coordinator_Update_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_updatelead_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        btupdate = (Button) findViewById(R.id.buttonupdate);
        btverify = (Button) findViewById(R.id.buttonverify);
        btcancel = (Button) findViewById(R.id.buttoncancel);
        txtleadid = (TextView) findViewById(R.id.textheader);
        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
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
        etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) findViewById(R.id.txtemail1);
        Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);
        CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
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
        etother = (EditText) findViewById(R.id.txtOthervalue);
        chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        chPAN = (CheckBox) findViewById(R.id.checkboxpan);
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
        RcoapplicantYES = (RadioButton) findViewById(R.id.radioapplicantYes);
        RcoapplicantNO = (RadioButton) findViewById(R.id.radioapplicantNo);
        Ryes = (RadioButton) findViewById(R.id.radioYes);
        Rno = (RadioButton) findViewById(R.id.radioNo);
        Rug = (RadioButton) findViewById(R.id.radioUG);
        Rg = (RadioButton) findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) findViewById(R.id.radioPG);
        Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        Rother = (RadioButton) findViewById(R.id.radioother);
        Rmale = (RadioButton) findViewById(R.id.radioMale);
        Rfemale = (RadioButton) findViewById(R.id.radioFemale);
        txtldate = (TextView) findViewById(R.id.txtdate1);
        txtleadid = (TextView) findViewById(R.id.textheader);
        etleednumber = (TextView) findViewById(R.id.txtleadidvalue);
        txtleedtime = (TextView) findViewById(R.id.txtleedtime1);
        txtgeneratedby = (TextView) findViewById(R.id.txtagentid1);
        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);
        spinloantype.setOnItemSelectedListener(this);
        getdata();
//        btupdate.setOnClickListener(this);
//        btverify.setOnClickListener(this);
//        btcancel.setOnClickListener( this);
    }

    private void getdata() {
        try {


//            String leednumber;
//            String leedid = leedsModel.getLeedId();
//            String loantype = leedsModel.getLoanType();
//            String agentname = leedsModel.getAgentName();
//            String leednumber2 = leedsModel.getLeedNumber();
//            Long ldatetime = leedsModel.getCreatedDateTimeLong();
//            String sdatetime = Long.toString(ldatetime.longValue());
//            String cname = leedsModel.getCustomerName();
//            String caddress = leedsModel.getAddress();
//            String officeaddress = leedsModel.getofficeAdderess();
//            String contact = leedsModel.getMobileNumber();
//            String altcontact = leedsModel.getAlternetMobileNumber();
//            String birthdate = leedsModel.getDateOfBirth();
//            String residencial = leedsModel.getRecidential();
//            String permanataddress = leedsModel.getPeraddress();
//            String addressYN = leedsModel.getAddressYesNo();
//            leedid = leedsModel.getOtherEducation();
//            String education = leedsModel.getEducation();
//            String birthdate2 = birthdate;
//            birthdate = leedsModel.getGender();
//            String residencial2 = residencial;
//            residencial = leedsModel.getCoApplicantYN();
//            String altcontact2 = altcontact;
//            altcontact = leedsModel.getCurrentpin();
//            String contact2 = contact;
//            contact = leedsModel.getCurrentlandmark();
//            String officeaddress2 = officeaddress;
//            officeaddress = leedsModel.getCurrentarea();
//            String permanataddress2 = permanataddress;
//            permanataddress = leedsModel.getCurrentstreet();
//            String caddress2 = caddress;
//            caddress = leedsModel.getPincode();
//            String cname2 = cname;
//            cname = leedsModel.getLandmark();
//            String otherEdu = leedid;
//            String Sarea = leedsModel.getArea();
//            String Sstreet = leedsModel.getStreet();
//            String email = leedsModel.getEmail();
//            String adhar = leedsModel.getadharNo();
//            String pan = leedsModel.getCheckpanCardNumber();
//            String pannumber = leedsModel.getPanCardNumber();
//            String voterid = leedsModel.getApvoterid();
//            String driverlicence = leedsModel.getApdrivinglicence();
//            String passport = leedsModel.getAppassport();
//            String adharproof = leedsModel.getProofadhar();
//            String voteridproof = leedsModel.getProofvoterid();
//            String dlproof = leedsModel.getProofdl();
//            String electricitybillproof = leedsModel.getProofelectricitybill();
//            String rentagmtproof = leedsModel.getProofrentagmt();
//            String passportproof = leedsModel.getProofpassport();
//            String gevtidproof = leedsModel.getProofgevtid();
//            String gumastaproof = leedsModel.getProofgumasta();
//            String currentacctprrof = leedsModel.getProofcurrentacctstmt();
//            leedid = leedsModel.getPrapplicantrelation();
//            String land = cname;
//            cname = leedsModel.getCoapplicantotherrelation();
//            String PIN = caddress;
//            caddress = leedsModel.getPrreference1name();
//            String addressYN2 = addressYN;
//            addressYN = leedsModel.getPrreference1address();
//            String currentSstreet = permanataddress;
//            permanataddress = leedsModel.getPrreferencecontactno();
//            String currentSarea = officeaddress;
//            officeaddress = leedsModel.getPrreferencerelationship();
//            String currentland = contact;
//            contact = leedsModel.getPrreference2name();
//            String currentPIN = altcontact;
//            altcontact = leedsModel.getPrreference2address();
//            String gender = birthdate;
//            birthdate = leedsModel.getPrreference2contactno();
//            String education2 = education;
//            String ref2relation = leedsModel.getPrreference2relationship();
//            String sEmployed = leedsModel.getEmployed();
//            String sCompanytype = leedsModel.getCompanytype();
//            String sSalarytype = leedsModel.getSalaytype();
//            String sEMIcar = leedsModel.getEmicar();
//            String sEMIhome = leedsModel.getEmihome();
//            String sEMIsociety = leedsModel.getEmisociety();
//            String sEMIpersonal = leedsModel.getEmipersonal();
//            String carloanamt = leedsModel.getCarLoanAmount();
//            String homeloanamt = leedsModel.getHomeLoanAmount();
//            String societyloanamt = leedsModel.getSocietyLoanAmount();
//            String personalloanamt = leedsModel.getPersonalLoanAmount();
//            String sEMIother = leedsModel.getEmiother();
//            String othercompany = leedsModel.getOthercompany();
//            String sTenure = leedsModel.getTenure();
//            String sExperience = leedsModel.getExperience();
//            String sDept = leedsModel.getDepartment();
//            String sDesignation = leedsModel.getDesignation();
//            String sGross = leedsModel.getGrosssalary();
//            String sNet = leedsModel.getNetsalary();
//            String sOvertime = leedsModel.getOvertime();
//            String sInsentive = leedsModel.getIncentive();
//            String sBonus = leedsModel.getBonus();
//            String sRentalincom = leedsModel.getRentalincome();
//            String sAnnualincome = leedsModel.getAnnualincome();
//            String sRental = leedsModel.getRental();
//            String sSalrysleep = leedsModel.getSalarysleep();
//            String sBankstmt = leedsModel.getBankstmt();
//            String sForm = leedsModel.getForm();
//            String sAppointmentltr = leedsModel.getAppointmentltr();
//            String sConfermationltr = leedsModel.getConformationltr();
//            String sExperinceltr = leedsModel.getExperinceltr();
//            String sVisa = leedsModel.getVisa();
//            String sPassport = leedsModel.getPassport();
//            String sEmployerltr = leedsModel.getEmploerltr();
//            String sContractltr = leedsModel.getContractltr();
//            String sPOA = leedsModel.getPoa();
//            String sNREbank = leedsModel.getNrebankstmt();
//            String sOverseasebank = leedsModel.getOverseasbankdetail();
//            String sITR = leedsModel.getItr();
//            String sCurrentbank = leedsModel.getCurrentbankstmt();
//            String sSavingbank = leedsModel.getSavingacctstmt();
//            String sPartnerdeed = leedsModel.getPartnersheepdeed();
//            String sBusinessagmt = leedsModel.getBusinessagmt();
//            String sQualification = leedsModel.getQualification();
//            String sAgreeincome = leedsModel.getAggrecultureIncome();
//            String sotherincome = leedsModel.getOtherIncome();
//            String sotherEMIdetails = leedsModel.getEmiOtherDetails();
//            String property = leedsModel.getPropety();
//            String YN = leedsModel.getPropetyYN();
//            String loanrequirement = leedsModel.getExpectedLoanAmount();
//            String downpayment = leedsModel.getDownpayment();
//            String propertypin = leedsModel.getPrpropertypin();
//            String propertylandmark = leedsModel.getPrpropertylandmark();
//            String propertyarea = leedsModel.getPrpropertyarea();
//            String projectname = leedsModel.getPrprojectname();
//            String description = leedsModel.getPrdescripiton();
//            String propertytype = leedsModel.getPrpropertytype();
//            ArrayAdapter myAdap = (ArrayAdapter) spinloantype.getAdapter();
//            int spinnerPosition = myAdap.getPosition(loantype);
//            spinloantype.setSelection(spinnerPosition);
//
//            if (leednumber2 != null) {
//                txtleadid.setText(leednumber2);
//                etleednumber.setText(leednumber2);
//            }
//            int i;
//            if (sdatetime != null) {
//                i = spinnerPosition;
//                leednumber = leednumber2;
//                txtldate.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), Constant.GLOBAL_DATE_FORMATE));
//                txtleedtime.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), "hh:mm a"));
//            } else {
//                leednumber = leednumber2;
//                i = spinnerPosition;
//                String str = sdatetime;
//            }
//            if (agentname != null) {
//                txtgeneratedby.setText(agentname);
//            }
//            if (residencial != null) {
//                if (residencial.equalsIgnoreCase("Yes")) {
//                    RcoapplicantYES.setChecked(true);
//                } else if (residencial.equalsIgnoreCase("No")) {
//                    RcoapplicantNO.setChecked(true);
//                }
//            }
//            if (leedid != null) {
//                CoapplicantRalationship.setSelection(((ArrayAdapter) CoapplicantRalationship.getAdapter()).getPosition(leedid));
//            }
//            if (cname != null) {
//                edtotherrelationship.setText(cname);
//            }
//            if (caddress != null) {
//                edtreferencename.setText(caddress);
//            }
//            if (addressYN != null) {
//                edtreferenceaddress.setText(addressYN);
//            }
//            if (permanataddress != null) {
//                edtreferencecontactno.setText(permanataddress);
//            }
//            if (officeaddress != null) {
//                edtreferencerelationship.setText(officeaddress);
//            }
//            if (contact != null) {
//                edtreferencename2.setText(contact);
//            }
//            if (altcontact != null) {
//                edtreferenceaddress2.setText(altcontact);
//            }
//            if (birthdate != null) {
//                edtreferencecontactno2.setText(birthdate);
//            }
//            if (ref2relation != null) {
//                edtreferencerelationship2.setText(ref2relation);
//            }
//            if (education2 != null) {
//                sdatetime = education2;
//                if (sdatetime.equalsIgnoreCase("Under Graduate")) {
//                    Rug.setChecked(true);
//                } else if (sdatetime.equalsIgnoreCase("Graduate")) {
//                    Rg.setChecked(true);
//                } else if (sdatetime.equalsIgnoreCase("Post Graduate")) {
//                    Rpg.setChecked(true);
//                } else if (sdatetime.equalsIgnoreCase("Professional")) {
//                    Rpro.setChecked(true);
//                } else {
//                    Rother.setChecked(true);
//                }
//            }
//            if (gender != null) {
//                loantype = gender;
//                if (loantype.equalsIgnoreCase(Constant.MALE)) {
//                    gender = leedid;
//                    Rmale.setChecked(true);
//                } else {
//                    gender = leedid;
//                    Rfemale.setChecked(true);
//                }
//            } else {
//                loantype = gender;
//            }
//            if (currentPIN != null) {
//                currentpin.setText(currentPIN);
//            }
//            if (currentland != null) {
//                loantype = currentland;
//                currentlandmark.setText(loantype);
//            } else {
//                loantype = currentland;
//            }
//            if (currentSarea != null) {
//                currentland = loantype;
//                loantype = currentSarea;
//                currentarea.setText(loantype);
//            } else {
//                loantype = currentSarea;
//            }
//            if (currentSstreet != null) {
//                currentSarea = loantype;
//                loantype = currentSstreet;
//                currentstreet.setText(loantype);
//            } else {
//                loantype = currentSstreet;
//            }
//            if (addressYN2 != null) {
//                currentSstreet = loantype;
//                loantype = addressYN2;
//                if (loantype.equalsIgnoreCase("Yes")) {
//                    addressYN2 = loantype;
//                    Ryes.setChecked(true);
//                } else {
//                    addressYN2 = loantype;
//                    Rno.setChecked(true);
//                }
//            }
//            if (Rno.isChecked()) {
//                loantype = Sstreet;
//            } else {
//                if (PIN != null) {
//                    loantype = PIN;
//                    pin.setText(loantype);
//                } else {
//                    loantype = PIN;
//                }
//                if (land != null) {
//                    PIN = loantype;
//                    loantype = land;
//                    landmark.setText(loantype);
//                } else {
//                    loantype = land;
//                }
//                if (Sarea != null) {
//                    land = loantype;
//                    loantype = Sarea;
//                    area.setText(loantype);
//                } else {
//                    loantype = Sarea;
//                }
//                if (Sstreet != null) {
//                    Sarea = loantype;
//                    loantype = Sstreet;
//                    street.setText(loantype);
//                } else {
//                    loantype = Sstreet;
//                }
//            }
//            if (adharproof != null) {
//                Sstreet = loantype;
//                chProofAdhar.setChecked(true);
//            }
//            if (voteridproof != null) {
//                chProofVoterid.setChecked(true);
//            }
//            if (dlproof != null) {
//                chProofdl.setChecked(true);
//            }
//            if (electricitybillproof != null) {
//                chProofElectricitybill.setChecked(true);
//            }
//            if (rentagmtproof != null) {
//                chProofRntagmt.setChecked(true);
//            }
//            if (passportproof != null) {
//                chProofPassport.setChecked(true);
//            }
//            if (gevtidproof != null) {
//                chProofGovtEmpid.setChecked(true);
//            }
//            if (gumastaproof != null) {
//                chProofGumasta.setChecked(true);
//            }
//            if (currentacctprrof != null) {
//                chProofCurrentacctStmt.setChecked(true);
//            }
//            if (voterid != null) {
//                chVoterID.setChecked(true);
//            }
//            if (driverlicence != null) {
//                chDL.setChecked(true);
//            }
//            if (passport != null) {
//                chPassport.setChecked(true);
//            }
//            if (otherEdu != null) {
//                loantype = otherEdu;
//                etother.setText(loantype);
//            } else {
//                loantype = otherEdu;
//            }
//            if (email != null) {
//                otherEdu = loantype;
//                loantype = email;
//                etcEmail.setText(loantype);
//            } else {
//                loantype = email;
//            }
//            if (adhar != null) {
//                email = loantype;
//                chAdhar.setChecked(true);
//            }
//            if (pannumber != null) {
//                chPAN.setChecked(true);
//                loantype = pannumber;
//                txtpannumber.setText(loantype);
//            } else {
//                loantype = pannumber;
//            }
//            if (leednumber != null) {
//                pannumber = loantype;
//                loantype = leednumber;
//                txtleadid.setText(loantype);
//            } else {
//                loantype = leednumber;
//            }
//            if (cname2 != null) {
//                leednumber = loantype;
//                loantype = cname2;
//                etcname.setText(loantype);
//            } else {
//                loantype = cname2;
//            }
//            if (caddress2 != null) {
//                cname2 = loantype;
//                loantype = caddress2;
//                etaddress.setText(loantype);
//            } else {
//                loantype = caddress2;
//            }
//            if (permanataddress2 != null) {
//                caddress2 = loantype;
//                loantype = permanataddress2;
//                etpermanantaddress.setText(loantype);
//            } else {
//                loantype = permanataddress2;
//            }
//            if (officeaddress2 != null) {
//                permanataddress2 = loantype;
//                loantype = officeaddress2;
//                etoffaddress.setText(loantype);
//            } else {
//                loantype = officeaddress2;
//            }
//            if (contact2 != null) {
//                officeaddress2 = loantype;
//                loantype = contact2;
//                etcontatct.setText(loantype);
//            } else {
//                loantype = contact2;
//            }
//            if (altcontact2 != null) {
//                contact2 = loantype;
//                loantype = altcontact2;
//                etalternatecontact.setText(loantype);
//            } else {
//                loantype = altcontact2;
//            }
//            if (residencial2 != null) {
//                ArrayAdapter myAdap2 = (ArrayAdapter) Recidential.getAdapter();
//                altcontact2 = loantype;
//                loantype = residencial2;
//                ArrayAdapter residencial3 = myAdap2;
//                ref2relation = loantype;
//                Recidential.setSelection(myAdap2.getPosition(loantype));
//            } else {
//                ref2relation = residencial2;
//            }
//            if (birthdate2 != null) {
//                etbirthdate.setText(birthdate2);
//            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_SALES_SUBMITED);
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
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09234());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        sploantype = this.spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}