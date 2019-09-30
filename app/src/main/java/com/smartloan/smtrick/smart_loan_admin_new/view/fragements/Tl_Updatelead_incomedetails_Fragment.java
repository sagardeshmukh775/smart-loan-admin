package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_property_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

public class Tl_Updatelead_incomedetails_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    RadioButton Remployed;
    RadioButton Rsalaried;
    RadioButton Rselfemployed;
    Spinner SPEMI;
    Spinner SPcompanytype;
    Spinner SPsalarytype;
    AppSharedPreference appSharedPreference;
    Button btcancel;
    Button btnupdatenext;
    Button btupdate;
    Button btverify;
    String cAgrreIncome;
    String cAnnualincome;
    String cAnual;
    String cAppointmentltr;
    String cBankstmt;
    String cBisunessagmt;
    String cBonus;
    String cCarloan;
    String cCarloanamt;
    String cCompanytype;
    String cConfermationltr;
    String cContractltr;
    String cCurrentbnkstmt;
    String cDept;
    String cDesignation;
    String cEMI;
    String cEcperience;
    String cEmployedtype;
    String cEmployerltr;
    String cExperinceltr;
    String cForm16;
    String cGrossslr;
    String cHomeloan;
    String cHomeloanamt;
    String cITR;
    String cIncentive;
    String cMonthly;
    String cNRAbankstmt;
    String cNetslr;
    String cOtherEMIdetails;
    String cOthercompany;
    String cOtherincome;
    String cOtherloan;
    String cOverbank;
    String cOvertime;
    String cPOA;
    String cPartnerdeed;
    String cPassport;
    String cPersonalloan;
    String cPersonalloanamt;
    String cQulification;
    String cRental;
    String cRentalincome;
    String cSalaried;
    String cSalaryType;
    String cSalarysleep;
    String cSavingbnkstmt;
    String cSelfEmployed;
    String cSocietyloan;
    String cSocietyloanamt;
    String cTenure;
    String cVisa;
    CheckBox chNREbankstatement;
    CheckBox chPOA;
    CheckBox chappointmentletter;
    CheckBox chbankstatement;
    CheckBox chbisunessagreement;
    CheckBox chcarloan;
    CheckBox chconfermationletter;
    CheckBox chcontractletter;
    CheckBox chcurrentbankstatement;
    CheckBox chemployerletter;
    CheckBox chexperieceletter;
    CheckBox chformno16;
    CheckBox chhomloan;
    CheckBox chitr;
    CheckBox chotherloan;
    CheckBox choverbankdetails;
    CheckBox chpartnersheepdeed;
    CheckBox chpasspoet;
    CheckBox chpersonalloan;
    CheckBox chqualification;
    CheckBox chsalarysleep;
    CheckBox chsavingacctstatement;
    CheckBox chsocietyloan;
    CheckBox chvisa;
    EditText edtagrreculturincom;
    EditText edtannualincome;
    EditText edtbonus;
    EditText edtdepartment;
    EditText edtdesignation;
    EditText edtexperience;
    EditText edtgrosssalary;
    EditText edtincentive;
    EditText edtnetsalary;
    EditText edtothercompany;
    EditText edtotheremidetails;
    EditText edtotherincome;
    EditText edtovertime;
    EditText edtrental;
    EditText edtrentalincome;
    EditText edttenure;
    RadioGroup groupRadioEmployed;
    RelativeLayout layoutothercompany;
    RelativeLayout layoutotheremi;
    LeedRepository leedRepository;
    String leedid;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner spinloantype;
    String sploantype;
    EditText txtCarloan;
    EditText txtHomeloan;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    EditText txtpersonalloan;
    EditText txtsocietyloan;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$1 */
    class C08331 implements RadioGroup.OnCheckedChangeListener {
        C08331() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Remployed = (RadioButton) getView().findViewById(checkedId);
            cEmployedtype = Remployed.getText().toString();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$2 */
    class C08342 implements View.OnClickListener {
        C08342() {
        }

        public void onClick(View v) {
            if (groupRadioEmployed.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioEmployed.getChildAt(groupRadioEmployed.indexOfChild(groupRadioEmployed.findViewById(groupRadioEmployed.getCheckedRadioButtonId())));
                cEmployedtype = btn.getText().toString();
            }
            cCompanytype = SPcompanytype.getSelectedItem().toString();
            cSalaryType = SPsalarytype.getSelectedItem().toString();
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

            updateLeadDetails(leedsModel);
            Toast.makeText(getContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(getContext(), TL_Updatelead_property_Details_Activity.class);
//            i.putExtra(Constant.LEED_MODEL, leedsModel);
//            startActivity(i);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

            TL_Updatelead_property_Details_Fragment fragment2 = new TL_Updatelead_property_Details_Fragment();
            fragment2.setArguments(bundle);

            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detailContainer, fragment2);
            ft.commit();
            getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$3 */
    class C08353 implements CompoundButton.OnCheckedChangeListener {
        C08353() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ShowotherEMI();
            } else {
                hideotherEMI();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$4 */
    class C08364 implements CompoundButton.OnCheckedChangeListener {
        C08364() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtCarloan.setVisibility(View.VISIBLE);
            } else {
                txtCarloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$5 */
    class C08375 implements CompoundButton.OnCheckedChangeListener {
        C08375() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtHomeloan.setVisibility(View.VISIBLE);
            } else {
                txtHomeloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$6 */
    class C08386 implements CompoundButton.OnCheckedChangeListener {
        C08386() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtsocietyloan.setVisibility(View.VISIBLE);
            } else {
                txtsocietyloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$7 */
    class C08397 implements CompoundButton.OnCheckedChangeListener {
        C08397() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtpersonalloan.setVisibility(View.VISIBLE);
            } else {
                txtpersonalloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$8 */
    class C09318 extends CallBack {
        C09318() {
        }

        public void onSuccess(Object object) {
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            progressDialogClass.dismissDialog();
            Context context = getContext();
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.updatelead_income_activity, container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
//        leedsModel = (LeedsModel) getActivity().getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());
        String[] loanType = new String[]{"Bussiness", "Job"};
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};
        String[] EMI = new String[]{"Car", "Home Loan", "Sociaty Loan/Employer Loan", "Other"};
        layoutothercompany = (RelativeLayout) view.findViewById(R.id.layoutothercompany);
        layoutotheremi = (RelativeLayout) view.findViewById(R.id.layoutotheremidetails);
        groupRadioEmployed = (RadioGroup) view.findViewById(R.id.radioOccupation);
        Rsalaried = (RadioButton) view.findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) view.findViewById(R.id.radioselfEmployed);
        SPcompanytype = (Spinner) view.findViewById(R.id.spinnercompanytype);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) view.findViewById(R.id.sploantype1);
        edttenure = (EditText) view.findViewById(R.id.txttenure1);
        edtexperience = (EditText) view.findViewById(R.id.txtexperience1);
        edtdepartment = (EditText) view.findViewById(R.id.txtdepartment1);
        edtdesignation = (EditText) view.findViewById(R.id.txtdesignation1);
        edtgrosssalary = (EditText) view.findViewById(R.id.txtmontlygrossincome1);
        edtnetsalary = (EditText) view.findViewById(R.id.txtnetsalary1);
        edtovertime = (EditText) view.findViewById(R.id.txtovertime1);
        edtincentive = (EditText) view.findViewById(R.id.txtiincentive1);
        edtbonus = (EditText) view.findViewById(R.id.txtbonus1);
        edtrentalincome = (EditText) view.findViewById(R.id.txtrent1);
        edtannualincome = (EditText) view.findViewById(R.id.txtannualincome1);
        edtrental = (EditText) view.findViewById(R.id.txtrentalexpence1);
        edtothercompany = (EditText) view.findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (EditText) view.findViewById(R.id.txtagreecultureincome1);
        edtotherincome = (EditText) view.findViewById(R.id.txtotherincome1);
        edtotheremidetails = (EditText) view.findViewById(R.id.txtotheremi1);
        txtCarloan = (EditText) view.findViewById(R.id.txtcarloanamount);
        txtHomeloan = (EditText) view.findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (EditText) view.findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (EditText) view.findViewById(R.id.txtpersonalloanamount);
        chsalarysleep = (CheckBox) view.findViewById(R.id.checkboxsalarysleep);
        chbankstatement = (CheckBox) view.findViewById(R.id.checkboxbankstatement);
        chformno16 = (CheckBox) view.findViewById(R.id.checkboxform16);
        chappointmentletter = (CheckBox) view.findViewById(R.id.checkboxappointmentletter);
        chconfermationletter = (CheckBox) view.findViewById(R.id.checkboxconfermationletter);
        chexperieceletter = (CheckBox) view.findViewById(R.id.checkboxexpletter);
        chvisa = (CheckBox) view.findViewById(R.id.checkboxvisa);
        chpasspoet = (CheckBox) view.findViewById(R.id.checkboxpassport);
        chemployerletter = (CheckBox) view.findViewById(R.id.checkboxEmployerletter);
        chcontractletter = (CheckBox) view.findViewById(R.id.checkboxcontractletter);
        chPOA = (CheckBox) view.findViewById(R.id.checkboxPOA);
        chNREbankstatement = (CheckBox) view.findViewById(R.id.checkboxNREbank);
        choverbankdetails = (CheckBox) view.findViewById(R.id.checkboxOverseasbank);
        chitr = (CheckBox) view.findViewById(R.id.checkboxITR);
        chcurrentbankstatement = (CheckBox) view.findViewById(R.id.checkboxcurrentaccountstatement);
        chsavingacctstatement = (CheckBox) view.findViewById(R.id.checkboxsavingacctstatement);
        chpartnersheepdeed = (CheckBox) view.findViewById(R.id.checkboxpartnerdeed);
        chbisunessagreement = (CheckBox) view.findViewById(R.id.checkboxbusinessagreement);
        chqualification = (CheckBox) view.findViewById(R.id.checkboxqualification);
        chcarloan = (CheckBox) view.findViewById(R.id.checkboxCarloan);
        chhomloan = (CheckBox) view.findViewById(R.id.checkboxHomeloan);
        chsocietyloan = (CheckBox) view.findViewById(R.id.checkboxSocietyloan);
        chpersonalloan = (CheckBox) view.findViewById(R.id.checkboxPersonalloan);
        chotherloan = (CheckBox) view.findViewById(R.id.checkboxOtherloan);
        Setchecked();
        btnupdatenext = (Button) view.findViewById(R.id.buttonupdatenext);
        txtleadid = (TextView) view.findViewById(R.id.textheader);
        groupRadioEmployed.setOnCheckedChangeListener(new C08331());
        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);
        btnupdatenext.setOnClickListener(new C08342());
        getdata();
        Loanvisibility();
        return view;
    }

    private void Setchecked() {
        chotherloan.setOnCheckedChangeListener(new C08353());
        chcarloan.setOnCheckedChangeListener(new C08364());
        chhomloan.setOnCheckedChangeListener(new C08375());
        chsocietyloan.setOnCheckedChangeListener(new C08386());
        chpersonalloan.setOnCheckedChangeListener(new C08397());
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
    }

    private void getdata() {
        try {
            String cleedid = leedsModel.getLeedNumber();
            String sEmployed = leedsModel.getEmployed();
            String sCompanytype = leedsModel.getCompanytype();
            String sSalarytype = leedsModel.getSalaytype();
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
            String sEMIother2 = sEMIother;
            sEMIother = leedsModel.getExperience();
            String personalloanamt2 = personalloanamt;
            personalloanamt = leedsModel.getDepartment();
            String sEMIpersonal2 = sEMIpersonal;
            sEMIpersonal = leedsModel.getDesignation();
            String societyloanamt2 = societyloanamt;
            societyloanamt = leedsModel.getGrosssalary();
            String sEMIsociety2 = sEMIsociety;
            sEMIsociety = leedsModel.getNetsalary();
            String homeloanamt2 = homeloanamt;
            homeloanamt = leedsModel.getOvertime();
            String sEMIhome2 = sEMIhome;
            sEMIhome = leedsModel.getIncentive();
            String carloanamt2 = carloanamt;
            carloanamt = leedsModel.getBonus();
            String sEMIcar2 = sEMIcar;
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
            sEMIcar = leedsModel.getEmiOtherDetails();
            String sBonus = carloanamt;
            String sInsentive = sEMIhome;
            ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            if (sCompanytype != null) {
                SPcompanytype.setSelection(myAdap.getPosition(sCompanytype));
                if (sCompanytype.equalsIgnoreCase("Other")) {
                    Showothercompany();
                } else {
                    hideothercompany();
                }
            }

            if (sSalarytype != null) {
                SPsalarytype.setSelection(((ArrayAdapter) SPsalarytype.getAdapter()).getPosition(sSalarytype));
            }
            if (cleedid != null) {
                txtleadid.setText(cleedid);
            }
            if (sEmployed == null) {
            } else if (sEmployed.equalsIgnoreCase("Salaried")) {
                Rsalaried.setChecked(true);
            } else {
                if (sEmployed.equalsIgnoreCase("Self Employed")) {
                    Rselfemployed.setChecked(true);
                }
            }
            if (othercompany != null) {
                edtothercompany.setText(othercompany);
            }
            if (sEMIcar != null) {
                edtotheremidetails.setText(sEMIcar);
            }
            if (sTenure != null) {
                edttenure.setText(sTenure);
            }
            if (sEMIother != null) {
                edtexperience.setText(sEMIother);
            }
            if (personalloanamt != null) {
                edtdepartment.setText(personalloanamt);
            }
            if (sEMIpersonal != null) {
                edtdesignation.setText(sEMIpersonal);
            }
            if (societyloanamt != null) {
                edtgrosssalary.setText(societyloanamt);
            }
            if (sEMIsociety != null) {
                edtnetsalary.setText(sEMIsociety);
            }
            if (homeloanamt != null) {
                edtovertime.setText(homeloanamt);
            }
            if (sInsentive != null) {
                edtincentive.setText(sInsentive);
            }
            if (sBonus != null) {
                sEmployed = sBonus;
                edtbonus.setText(sEmployed);
            } else {
                sEmployed = sBonus;
            }
            if (sRentalincom != null) {
                sBonus = sEmployed;
                sEmployed = sRentalincom;
                edtrentalincome.setText(sEmployed);
            } else {
                sEmployed = sRentalincom;
            }
            if (sAnnualincome != null) {
                sRentalincom = sEmployed;
                sEmployed = sAnnualincome;
                edtannualincome.setText(sEmployed);
            } else {
                sEmployed = sAnnualincome;
            }
            if (sAgreeincome != null) {
                sAnnualincome = sEmployed;
                sEmployed = sAgreeincome;
                edtagrreculturincom.setText(sEmployed);
            } else {
                sEmployed = sAgreeincome;
            }
            if (sotherincome != null) {
                sAgreeincome = sEmployed;
                sEmployed = sotherincome;
                edtotherincome.setText(sEmployed);
            } else {
                sEmployed = sotherincome;
            }
            if (sRental != null) {
                sotherincome = sEmployed;
                sEmployed = sRental;
                edtrental.setText(sEmployed);
            } else {
                sEmployed = sRental;
            }
            if (sSalrysleep != null) {
                sRental = sEmployed;
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
            if (sEMIcar2 != null) {
                chcarloan.setChecked(true);
                sEmployed = carloanamt2;
                txtCarloan.setText(sEmployed);
            } else {
                sEmployed = carloanamt2;
            }
            if (sEMIhome2 != null) {
                carloanamt2 = sEmployed;
                chhomloan.setChecked(true);
                sEmployed = homeloanamt2;
                txtHomeloan.setText(sEmployed);
            } else {
                sEmployed = homeloanamt2;
            }
            if (sEMIsociety2 != null) {
                homeloanamt2 = sEmployed;
                chsocietyloan.setChecked(true);
                sEmployed = societyloanamt2;
                txtsocietyloan.setText(sEmployed);
            } else {
                sEmployed = societyloanamt2;
            }
            if (sEMIpersonal2 != null) {
                societyloanamt2 = sEmployed;
                chpersonalloan.setChecked(true);
                txtpersonalloan.setText(personalloanamt2);
            }
            if (sEMIother2 != null) {
                chotherloan.setChecked(true);
                ShowotherEMI();
            } else {
                hideotherEMI();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setEmployed(cEmployedtype);
            leedsModel.setCompanytype(cCompanytype);
            leedsModel.setSalaytype(cSalaryType);
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
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09318());
    }

    public void hideothercompany() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothercompany.getLayoutParams();
        params.height = 0;
        layoutothercompany.setLayoutParams(params);
    }

    public void Showothercompany() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothercompany.getLayoutParams();
        params.height = -1;
        layoutothercompany.setLayoutParams(params);
    }

    public void hideotherEMI() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutotheremi.getLayoutParams();
        params.height = 0;
        layoutotheremi.setLayoutParams(params);
    }

    public void ShowotherEMI() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutotheremi.getLayoutParams();
        params.height = -1;
        layoutotheremi.setLayoutParams(params);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        if (SPcompanytype.getSelectedItem().toString().equalsIgnoreCase("Other")) {
            Showothercompany();
        } else {
            hideothercompany();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onBackPressed() {
        Toast.makeText(getContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

    }


}