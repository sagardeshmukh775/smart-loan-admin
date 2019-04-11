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

import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.LEED_MODEL;

public class Tl_Updatelead_incomedetails_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinloantype;
    Button btupdate, btverify, btcancel, btnupdatenext;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;


    String leedid, sploantype, cAnual, cMonthly;
    TextView txtldate, txtleadid, txtgeneratedby;
    EditText txtCarloan, txtHomeloan, txtsocietyloan, txtpersonalloan;

    RadioGroup groupRadioEmployed;
    RadioButton Rsalaried, Rselfemployed, Remployed;
    Spinner SPcompanytype, SPsalarytype, SPEMI;
    EditText edttenure, edtexperience, edtdepartment, edtdesignation, edtgrosssalary, edtnetsalary,
            edtovertime, edtincentive, edtbonus, edtrentalincome, edtannualincome, edtrental, edtothercompany,
            edtagrreculturincom, edtotherincome, edtotheremidetails;
    CheckBox chsalarysleep, chbankstatement, chformno16, chappointmentletter, chconfermationletter,
            chexperieceletter, chvisa, chpasspoet, chemployerletter, chPOA, chNREbankstatement, chcontractletter, choverbankdetails,
            chitr, chcurrentbankstatement, chsavingacctstatement, chpartnersheepdeed, chbisunessagreement, chqualification,
            chcarloan, chhomloan, chsocietyloan, chpersonalloan, chotherloan;

    String cSalaried, cSelfEmployed, cEmployedtype, cCompanytype, cOthercompany, cSalaryType, cEMI, cTenure, cEcperience, cDept, cDesignation, cGrossslr, cNetslr,
            cOvertime, cIncentive, cBonus, cRentalincome, cAnnualincome, cRental, cSalarysleep, cBankstmt, cForm16, cAppointmentltr, cConfermationltr,
            cExperinceltr, cVisa, cPassport, cEmployerltr, cPOA, cNRAbankstmt, cContractltr, cOverbank, cITR, cCurrentbnkstmt, cSavingbnkstmt,
            cPartnerdeed, cBisunessagmt, cQulification, cAgrreIncome, cOtherincome,
            cCarloan, cHomeloan, cSocietyloan, cPersonalloan, cOtherloan, cOtherEMIdetails,
            cCarloanamt, cHomeloanamt, cSocietyloanamt, cPersonalloanamt;
    RelativeLayout layoutothercompany, layoutotheremi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_income_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"Bussiness", "Job"};
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office",
                "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};
        String[] EMI = new String[]{"Car", "Home Loan", "Sociaty Loan/Employer Loan", "Other"};

        layoutothercompany = (RelativeLayout) findViewById(R.id.layoutothercompany);
        layoutotheremi = (RelativeLayout) findViewById(R.id.layoutotheremidetails);

        groupRadioEmployed = (RadioGroup) findViewById(R.id.radioOccupation);
        Rsalaried = (RadioButton) findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) findViewById(R.id.radioselfEmployed);

        SPcompanytype = (Spinner) findViewById(R.id.spinnercompanytype);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) findViewById(R.id.sploantype1);
        //  SPEMI = (Spinner) findViewById(R.id.spemi1);

        edttenure = (EditText) findViewById(R.id.txttenure1);
        edtexperience = (EditText) findViewById(R.id.txtexperience1);
        edtdepartment = (EditText) findViewById(R.id.txtdepartment1);
        edtdesignation = (EditText) findViewById(R.id.txtdesignation1);
        edtgrosssalary = (EditText) findViewById(R.id.txtmontlygrossincome1);
        edtnetsalary = (EditText) findViewById(R.id.txtnetsalary1);
        edtovertime = (EditText) findViewById(R.id.txtovertime1);
        edtincentive = (EditText) findViewById(R.id.txtiincentive1);
        edtbonus = (EditText) findViewById(R.id.txtbonus1);
        edtrentalincome = (EditText) findViewById(R.id.txtrent1);
        edtannualincome = (EditText) findViewById(R.id.txtannualincome1);
        edtrental = (EditText) findViewById(R.id.txtrentalexpence1);
        edtothercompany = (EditText) findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (EditText) findViewById(R.id.txtagreecultureincome1);
        edtotherincome = (EditText) findViewById(R.id.txtotherincome1);
        edtotheremidetails = (EditText) findViewById(R.id.txtotheremi1);

        txtCarloan = (EditText) findViewById(R.id.txtcarloanamount);
        txtHomeloan = (EditText) findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (EditText) findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (EditText) findViewById(R.id.txtpersonalloanamount);


        chsalarysleep = (CheckBox) findViewById(R.id.checkboxsalarysleep);
        chbankstatement = (CheckBox) findViewById(R.id.checkboxbankstatement);
        chformno16 = (CheckBox) findViewById(R.id.checkboxform16);
        chappointmentletter = (CheckBox) findViewById(R.id.checkboxappointmentletter);
        chconfermationletter = (CheckBox) findViewById(R.id.checkboxconfermationletter);
        chexperieceletter = (CheckBox) findViewById(R.id.checkboxexpletter);
        chvisa = (CheckBox) findViewById(R.id.checkboxvisa);
        chpasspoet = (CheckBox) findViewById(R.id.checkboxpassport);
        chemployerletter = (CheckBox) findViewById(R.id.checkboxEmployerletter);
        chcontractletter = (CheckBox) findViewById(R.id.checkboxcontractletter);
        chPOA = (CheckBox) findViewById(R.id.checkboxPOA);
        chNREbankstatement = (CheckBox) findViewById(R.id.checkboxNREbank);
        choverbankdetails = (CheckBox) findViewById(R.id.checkboxOverseasbank);
        chitr = (CheckBox) findViewById(R.id.checkboxITR);
        chcurrentbankstatement = (CheckBox) findViewById(R.id.checkboxcurrentaccountstatement);
        chsavingacctstatement = (CheckBox) findViewById(R.id.checkboxsavingacctstatement);
        chpartnersheepdeed = (CheckBox) findViewById(R.id.checkboxpartnerdeed);
        chbisunessagreement = (CheckBox) findViewById(R.id.checkboxbusinessagreement);
        chqualification = (CheckBox) findViewById(R.id.checkboxqualification);

        chcarloan = (CheckBox) findViewById(R.id.checkboxCarloan);
        chhomloan = (CheckBox) findViewById(R.id.checkboxHomeloan);
        chsocietyloan = (CheckBox) findViewById(R.id.checkboxSocietyloan);
        chpersonalloan = (CheckBox) findViewById(R.id.checkboxPersonalloan);
        chotherloan = (CheckBox) findViewById(R.id.checkboxOtherloan);


        Setchecked();


        // btupdate = (Button) findViewById(R.id.buttonupdate);
        // btverify = (Button) findViewById(R.id.buttonverify);
        // btcancel = (Button) findViewById(R.id.buttoncancel);
        btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);


        txtleadid = (TextView) findViewById(R.id.textheader);


        //       spinloantype.setOnItemSelectedListener(this);

        groupRadioEmployed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Remployed = (RadioButton) findViewById(checkedId);
                cEmployedtype = Remployed.getText().toString();
            }
        });

        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);


        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);

        btnupdatenext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (groupRadioEmployed.getCheckedRadioButtonId() != -1) {
                    int id = groupRadioEmployed.getCheckedRadioButtonId();
                    View radioButton = groupRadioEmployed.findViewById(id);
                    int radioId = groupRadioEmployed.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) groupRadioEmployed.getChildAt(radioId);
                    cEmployedtype = btn.getText().toString();
                }

                cCompanytype = SPcompanytype.getSelectedItem().toString();
                cSalaryType = SPsalarytype.getSelectedItem().toString();
                // cEMI = SPEMI.getSelectedItem().toString();

                cOthercompany = edtothercompany.getText().toString();
                cTenure = edttenure.getText().toString();
                cEcperience = edtexperience.getText().toString();
                cDept = edtdepartment.getText().toString();
                cDesignation = edtdesignation.getText().toString();
                cGrossslr = edtgrosssalary.getText().toString();
                cNetslr = edtnetsalary.getText().toString();
                cOvertime = edtovertime.getText().toString();
                cIncentive = edtincentive.getText().toString();
                cBonus = edtbonus.getText().toString();
                cRentalincome = edtrentalincome.getText().toString();
                cAnnualincome = edtannualincome.getText().toString();
                cRental = edtrental.getText().toString();
                cAgrreIncome = edtagrreculturincom.getText().toString();
                cOtherincome = edtotherincome.getText().toString();
                cOtherEMIdetails = edtotheremidetails.getText().toString();

                cCarloanamt = txtCarloan.getText().toString();
                cHomeloanamt = txtHomeloan.getText().toString();
                cSocietyloanamt = txtsocietyloan.getText().toString();
                cPersonalloanamt = txtpersonalloan.getText().toString();

                if (chcarloan.isChecked()) {
                    cCarloan = chcarloan.getText().toString();
                }
                if (chhomloan.isChecked()) {
                    cHomeloan = chhomloan.getText().toString();
                }
                if (chsocietyloan.isChecked()) {
                    cSocietyloan = chsocietyloan.getText().toString();
                }
                if (chpersonalloan.isChecked()) {
                    cPersonalloan = chpersonalloan.getText().toString();
                }
                if (chotherloan.isChecked()) {
                    cOtherloan = chotherloan.getText().toString();
                }

                if (chsalarysleep.isChecked()) {
                    cSalarysleep = chsalarysleep.getText().toString();
                }
                if (chbankstatement.isChecked()) {
                    cBankstmt = chbankstatement.getText().toString();
                }
                if (chformno16.isChecked()) {
                    cForm16 = chformno16.getText().toString();
                }
                if (chappointmentletter.isChecked()) {
                    cAppointmentltr = chappointmentletter.getText().toString();
                }
                if (chconfermationletter.isChecked()) {
                    cConfermationltr = chconfermationletter.getText().toString();
                }
                if (chexperieceletter.isChecked()) {
                    cExperinceltr = chexperieceletter.getText().toString();
                }
                if (chvisa.isChecked()) {
                    cVisa = chvisa.getText().toString();
                }
                if (chpasspoet.isChecked()) {
                    cPassport = chpasspoet.getText().toString();
                }
                if (chemployerletter.isChecked()) {
                    cEmployerltr = chemployerletter.getText().toString();
                }
                if (chPOA.isChecked()) {
                    cPOA = chPOA.getText().toString();
                }
                if (chNREbankstatement.isChecked()) {
                    cNRAbankstmt = chNREbankstatement.getText().toString();
                }
                if (chcontractletter.isChecked()) {
                    cContractltr = chcontractletter.getText().toString();
                }
                if (choverbankdetails.isChecked()) {
                    cOverbank = choverbankdetails.getText().toString();
                }
                if (chitr.isChecked()) {
                    cITR = chitr.getText().toString();
                }
                if (chcurrentbankstatement.isChecked()) {
                    cCurrentbnkstmt = chcurrentbankstatement.getText().toString();
                }
                if (chsavingacctstatement.isChecked()) {
                    cSavingbnkstmt = chsavingacctstatement.getText().toString();
                }
                if (chpartnersheepdeed.isChecked()) {
                    cPartnerdeed = chpartnersheepdeed.getText().toString();
                }
                if (chbisunessagreement.isChecked()) {
                    cBisunessagmt = chbisunessagreement.getText().toString();
                }
                if (chqualification.isChecked()) {
                    cQulification = chqualification.getText().toString();
                }

//                if (TextUtils.isEmpty(cITR)) {
//                    Toast.makeText(getApplicationContext(), "Provide ITR!", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                updateLeadDetails(leedsModel);
                Toast.makeText(Tl_Updatelead_incomedetails_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(Tl_Updatelead_incomedetails_Activity.this, TL_Updatelead_property_Details_Activity.class);
                i.putExtra(LEED_MODEL, leedsModel);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

        getdata();
        Loanvisibility();

    }//end of oncreate

    private void Setchecked() {

        chotherloan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ShowotherEMI();
                } else {
                    hideotherEMI();
                }
            }
        });
        chcarloan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtCarloan.setVisibility(View.VISIBLE);
                } else {
                    txtCarloan.setVisibility(View.INVISIBLE);
                }
            }
        });
        chhomloan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtHomeloan.setVisibility(View.VISIBLE);
                } else {
                    txtHomeloan.setVisibility(View.INVISIBLE);
                }
            }
        });
        chsocietyloan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtsocietyloan.setVisibility(View.VISIBLE);
                } else {
                    txtsocietyloan.setVisibility(View.INVISIBLE);
                }
            }
        });
        chpersonalloan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtpersonalloan.setVisibility(View.VISIBLE);
                } else {
                    txtpersonalloan.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void Loanvisibility() {
        if (chcarloan.isChecked()) {
            txtCarloan.setVisibility(View.VISIBLE);
        } else {
            txtCarloan.setVisibility(View.INVISIBLE);
        }
        if (chpersonalloan.isChecked()) {
            txtpersonalloan.setVisibility(View.VISIBLE);
        } else {
            txtpersonalloan.setVisibility(View.INVISIBLE);
        }
        if (chsocietyloan.isChecked()) {
            txtsocietyloan.setVisibility(View.VISIBLE);
        } else {
            txtsocietyloan.setVisibility(View.INVISIBLE);
        }
        if (chhomloan.isChecked()) {
            txtHomeloan.setVisibility(View.VISIBLE);
        } else {
            txtHomeloan.setVisibility(View.INVISIBLE);
        }
//        if (chcarloan.isChecked()) {
//            txtCarloan.setVisibility(View.VISIBLE);
//        }else {
//            txtCarloan.setVisibility(View.INVISIBLE);
//        }
    }


    private void getdata() {

        try {

            String cleedid = leedsModel.getLeedNumber();

            String sEmployed = leedsModel.getEmployed();
            String sCompanytype = leedsModel.getCompanytype();
            String sSalarytype = leedsModel.getSalaytype();
            //  String sEMI = leedsModel.getEmi();
            String sEMIcar = leedsModel.getEmicar();
            String sEMIhome = leedsModel.getEmihome();
            String sEMIsociety = leedsModel.getEmisociety();
            String sEMIpersonal = leedsModel.getEmipersonal();

            String carloanamt = leedsModel.getCarLoanAmount();
            String homeloanamt = leedsModel.getHomeLoanAmount();
            String societyloanamt = leedsModel.getSocietyLoanAmount();
            String personalloanamt = leedsModel.getPersonalLoanAmount();

            String sEMIother = leedsModel.getEmiother();
            String othercompany = leedsModel.getOthercompany();
            String sTenure = leedsModel.getTenure();
            String sExperience = leedsModel.getExperience();
            String sDept = leedsModel.getDepartment();
            String sDesignation = leedsModel.getDesignation();
            String sGross = leedsModel.getGrosssalary();
            String sNet = leedsModel.getNetsalary();
            String sOvertime = leedsModel.getOvertime();
            String sInsentive = leedsModel.getIncentive();
            String sBonus = leedsModel.getBonus();
            String sRentalincom = leedsModel.getRentalincome();
            String sAnnualincome = leedsModel.getAnnualincome();
            String sRental = leedsModel.getRental();
            String sSalrysleep = leedsModel.getSalarysleep();
            String sBankstmt = leedsModel.getBankstmt();
            String sForm = leedsModel.getForm();
            String sAppointmentltr = leedsModel.getAppointmentltr();
            String sConfermationltr = leedsModel.getConformationltr();
            String sExperinceltr = leedsModel.getExperinceltr();
            String sVisa = leedsModel.getVisa();
            String sPassport = leedsModel.getPassport();
            String sEmployerltr = leedsModel.getEmploerltr();
            String sContractltr = leedsModel.getContractltr();
            String sPOA = leedsModel.getPoa();
            String sNREbank = leedsModel.getNrebankstmt();
            String sOverseasebank = leedsModel.getOverseasbankdetail();
            String sITR = leedsModel.getItr();
            String sCurrentbank = leedsModel.getCurrentbankstmt();
            String sSavingbank = leedsModel.getSavingacctstmt();
            String sPartnerdeed = leedsModel.getPartnersheepdeed();
            String sBusinessagmt = leedsModel.getBusinessagmt();
            String sQualification = leedsModel.getQualification();
            String sAgreeincome = leedsModel.getAggrecultureIncome();
            String sotherincome = leedsModel.getOtherIncome();
            String sotherEMIdetails = leedsModel.getEmiOtherDetails();


            ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            int spinnerPosition = myAdap.getPosition(sCompanytype);
            SPcompanytype.setSelection(spinnerPosition);
            if (sCompanytype.equalsIgnoreCase("Other")) {
                Showothercompany();
            } else {
                hideothercompany();
            }

            ArrayAdapter myAdap1 = (ArrayAdapter) SPsalarytype.getAdapter();
            int spinnerPosition1 = myAdap1.getPosition(sSalarytype);
            SPsalarytype.setSelection(spinnerPosition1);


            if (cleedid != null) {
                txtleadid.setText(cleedid);

            }

            if (sEmployed != null) {
                if (sEmployed.equalsIgnoreCase("Salaried")) {
                    Rsalaried.setChecked(true);

                } else if (sEmployed.equalsIgnoreCase("Self Employed")) {
                    Rselfemployed.setChecked(true);
                }
            }

            if (othercompany != null) {
                edtothercompany.setText(othercompany);
            }
            if (sotherEMIdetails != null) {
                edtotheremidetails.setText(sotherEMIdetails);
            }
            if (sTenure != null) {
                edttenure.setText(sTenure);

            }
            if (sExperience != null) {
                edtexperience.setText(sExperience);

            }
            if (sDept != null) {
                edtdepartment.setText(sDept);

            }
            if (sDesignation != null) {
                edtdesignation.setText(sDesignation);

            }
            if (sGross != null) {
                edtgrosssalary.setText(sGross);

            }
            if (sNet != null) {
                edtnetsalary.setText(sNet);

            }
            if (sOvertime != null) {
                edtovertime.setText(sOvertime);

            }
            if (sInsentive != null) {
                edtincentive.setText(sInsentive);

            }
            if (sBonus != null) {
                edtbonus.setText(sBonus);

            }
            if (sRentalincom != null) {
                edtrentalincome.setText(sRentalincom);

            }
            if (sAnnualincome != null) {
                edtannualincome.setText(sAnnualincome);

            }
            if (sAgreeincome != null) {
                edtagrreculturincom.setText(sAgreeincome);

            }
            if (sotherincome != null) {
                edtotherincome.setText(sotherincome);

            }
            if (sRental != null) {
                edtrental.setText(sRental);

            }
            if (sSalrysleep != null) {
                chsalarysleep.setChecked(true);

            }
            if (sBankstmt != null) {
                chbankstatement.setChecked(true);

            }
            if (sForm != null) {
                chformno16.setChecked(true);

            }
            if (sAppointmentltr != null) {
                chappointmentletter.setChecked(true);

            }
            if (sConfermationltr != null) {
                chconfermationletter.setChecked(true);

            }
            if (sExperinceltr != null) {
                chexperieceletter.setChecked(true);

            }
            if (sVisa != null) {
                chvisa.setChecked(true);

            }
            if (sPassport != null) {
                chpasspoet.setChecked(true);

            }
            if (sEmployerltr != null) {
                chemployerletter.setChecked(true);

            }
            if (sContractltr != null) {
                chcontractletter.setChecked(true);

            }
            if (sPOA != null) {
                chPOA.setChecked(true);

            }
            if (sNREbank != null) {
                chNREbankstatement.setChecked(true);

            }
            if (sOverseasebank != null) {
                choverbankdetails.setChecked(true);

            }
            if (sITR != null) {
                chitr.setChecked(true);

            }
            if (sCurrentbank != null) {
                chcurrentbankstatement.setChecked(true);

            }
            if (sSavingbank != null) {
                chsavingacctstatement.setChecked(true);

            }
            if (sPartnerdeed != null) {
                chpartnersheepdeed.setChecked(true);

            }
            if (sBusinessagmt != null) {
                chbisunessagreement.setChecked(true);

            }
            if (sQualification != null) {
                chqualification.setChecked(true);

            }
            if (sEMIcar != null) {
                chcarloan.setChecked(true);
                txtCarloan.setText(carloanamt);

            }
            if (sEMIhome != null) {
                chhomloan.setChecked(true);
                txtHomeloan.setText(homeloanamt);

            }
            if (sEMIsociety != null) {
                chsocietyloan.setChecked(true);
                txtsocietyloan.setText(societyloanamt);

            }
            if (sEMIpersonal != null) {
                chpersonalloan.setChecked(true);
                txtpersonalloan.setText(personalloanamt);

            }
            if (sEMIother != null) {
                chotherloan.setChecked(true);
                ShowotherEMI();
            } else {
                hideotherEMI();
            }

        } catch (Exception e) {
        }

    }


    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setEmployed(cEmployedtype);
            leedsModel.setCompanytype(cCompanytype);
            leedsModel.setSalaytype(cSalaryType);
            //   leedsModel.setEmi(cEMI);
            leedsModel.setEmicar(cCarloan);
            leedsModel.setEmihome(cHomeloan);
            leedsModel.setEmisociety(cSocietyloan);
            leedsModel.setEmipersonal(cPersonalloan);

            leedsModel.setCarLoanAmount(cCarloanamt);
            leedsModel.setHomeLoanAmount(cHomeloanamt);
            leedsModel.setSocietyLoanAmount(cSocietyloanamt);
            leedsModel.setPersonalLoanAmount(cPersonalloanamt);

            leedsModel.setEmiother(cOtherloan);
            leedsModel.setOthercompany(cOthercompany);
            leedsModel.setTenure(cTenure);
            leedsModel.setExperience(cEcperience);
            leedsModel.setDepartment(cDept);
            leedsModel.setDesignation(cDesignation);
            leedsModel.setGrosssalary(cGrossslr);
            leedsModel.setNetsalary(cNetslr);
            leedsModel.setOvertime(cOvertime);
            leedsModel.setIncentive(cIncentive);
            leedsModel.setBonus(cBonus);
            leedsModel.setRentalincome(cRentalincome);
            leedsModel.setAnnualincome(cAnnualincome);
            leedsModel.setRental(cRental);
            leedsModel.setSalarysleep(cSalarysleep);
            leedsModel.setBankstmt(cBankstmt);
            leedsModel.setForm(cForm16);
            leedsModel.setAppointmentltr(cAppointmentltr);
            leedsModel.setConformationltr(cConfermationltr);
            leedsModel.setExperinceltr(cExperinceltr);
            leedsModel.setVisa(cVisa);
            leedsModel.setPassport(cPassport);
            leedsModel.setEmploerltr(cEmployerltr);
            leedsModel.setContractltr(cContractltr);
            leedsModel.setPoa(cPOA);
            leedsModel.setNrebankstmt(cNRAbankstmt);
            leedsModel.setOverseasbankdetail(cOverbank);
            leedsModel.setItr(cITR);
            leedsModel.setCurrentbankstmt(cCurrentbnkstmt);
            leedsModel.setSavingacctstmt(cSavingbnkstmt);
            leedsModel.setPartnersheepdeed(cPartnerdeed);
            leedsModel.setBusinessagmt(cBisunessagmt);
            leedsModel.setQualification(cQulification);
            leedsModel.setAggrecultureIncome(cAgrreIncome);
            leedsModel.setOtherIncome(cOtherincome);
            leedsModel.setEmiOtherDetails(cOtherEMIdetails);

            updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
        } catch (Exception e) {

        }
    }


    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                //Toast.makeText(Tl_Updatelead_incomedetails_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(Tl_Updatelead_incomedetails_Activity.this, getString(R.string.server_error));
            }
        });
    }

    public void hideothercompany() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothercompany.getLayoutParams();
        params.height = 0;
        layoutothercompany.setLayoutParams(params);
    }

    public void Showothercompany() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothercompany.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutothercompany.setLayoutParams(params);
    }

    public void hideotherEMI() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutotheremi.getLayoutParams();
        params.height = 0;
        layoutotheremi.setLayoutParams(params);
    }

    public void ShowotherEMI() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutotheremi.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutotheremi.setLayoutParams(params);
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //     sploantype = spinloantype.getSelectedItem().toString();
        if (SPcompanytype.getSelectedItem().toString().equalsIgnoreCase("Other")) {
            Showothercompany();
        } else {
            hideothercompany();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }


}
