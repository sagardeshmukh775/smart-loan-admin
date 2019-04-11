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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.smartloan.smtrick.smart_loan_admin.R;
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

public class Tl_Updatelead_incomedetails_Activity extends AppCompatActivity implements OnItemSelectedListener {
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

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$1 */
    class C08331 implements OnCheckedChangeListener {
        C08331() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Tl_Updatelead_incomedetails_Activity tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.Remployed = (RadioButton) tl_Updatelead_incomedetails_Activity.findViewById(checkedId);
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cEmployedtype = tl_Updatelead_incomedetails_Activity.Remployed.getText().toString();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$2 */
    class C08342 implements OnClickListener {
        C08342() {
        }

        public void onClick(View v) {
            if (Tl_Updatelead_incomedetails_Activity.this.groupRadioEmployed.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) Tl_Updatelead_incomedetails_Activity.this.groupRadioEmployed.getChildAt(Tl_Updatelead_incomedetails_Activity.this.groupRadioEmployed.indexOfChild(Tl_Updatelead_incomedetails_Activity.this.groupRadioEmployed.findViewById(Tl_Updatelead_incomedetails_Activity.this.groupRadioEmployed.getCheckedRadioButtonId())));
                Tl_Updatelead_incomedetails_Activity.this.cEmployedtype = btn.getText().toString();
            }
            Tl_Updatelead_incomedetails_Activity tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cCompanytype = tl_Updatelead_incomedetails_Activity.SPcompanytype.getSelectedItem().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cSalaryType = tl_Updatelead_incomedetails_Activity.SPsalarytype.getSelectedItem().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cOthercompany = tl_Updatelead_incomedetails_Activity.edtothercompany.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cTenure = tl_Updatelead_incomedetails_Activity.edttenure.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cEcperience = tl_Updatelead_incomedetails_Activity.edtexperience.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cDept = tl_Updatelead_incomedetails_Activity.edtdepartment.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cDesignation = tl_Updatelead_incomedetails_Activity.edtdesignation.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cGrossslr = tl_Updatelead_incomedetails_Activity.edtgrosssalary.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cNetslr = tl_Updatelead_incomedetails_Activity.edtnetsalary.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cOvertime = tl_Updatelead_incomedetails_Activity.edtovertime.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cIncentive = tl_Updatelead_incomedetails_Activity.edtincentive.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cBonus = tl_Updatelead_incomedetails_Activity.edtbonus.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cRentalincome = tl_Updatelead_incomedetails_Activity.edtrentalincome.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cAnnualincome = tl_Updatelead_incomedetails_Activity.edtannualincome.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cRental = tl_Updatelead_incomedetails_Activity.edtrental.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cAgrreIncome = tl_Updatelead_incomedetails_Activity.edtagrreculturincom.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cOtherincome = tl_Updatelead_incomedetails_Activity.edtotherincome.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cOtherEMIdetails = tl_Updatelead_incomedetails_Activity.edtotheremidetails.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cCarloanamt = tl_Updatelead_incomedetails_Activity.txtCarloan.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cHomeloanamt = tl_Updatelead_incomedetails_Activity.txtHomeloan.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cSocietyloanamt = tl_Updatelead_incomedetails_Activity.txtsocietyloan.getText().toString();
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.cPersonalloanamt = tl_Updatelead_incomedetails_Activity.txtpersonalloan.getText().toString();
            if (Tl_Updatelead_incomedetails_Activity.this.chcarloan.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cCarloan = tl_Updatelead_incomedetails_Activity.chcarloan.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chhomloan.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cHomeloan = tl_Updatelead_incomedetails_Activity.chhomloan.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chsocietyloan.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cSocietyloan = tl_Updatelead_incomedetails_Activity.chsocietyloan.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chpersonalloan.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cPersonalloan = tl_Updatelead_incomedetails_Activity.chpersonalloan.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chotherloan.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cOtherloan = tl_Updatelead_incomedetails_Activity.chotherloan.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chsalarysleep.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cSalarysleep = tl_Updatelead_incomedetails_Activity.chsalarysleep.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chbankstatement.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cBankstmt = tl_Updatelead_incomedetails_Activity.chbankstatement.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chformno16.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cForm16 = tl_Updatelead_incomedetails_Activity.chformno16.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chappointmentletter.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cAppointmentltr = tl_Updatelead_incomedetails_Activity.chappointmentletter.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chconfermationletter.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cConfermationltr = tl_Updatelead_incomedetails_Activity.chconfermationletter.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chexperieceletter.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cExperinceltr = tl_Updatelead_incomedetails_Activity.chexperieceletter.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chvisa.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cVisa = tl_Updatelead_incomedetails_Activity.chvisa.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chpasspoet.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cPassport = tl_Updatelead_incomedetails_Activity.chpasspoet.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chemployerletter.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cEmployerltr = tl_Updatelead_incomedetails_Activity.chemployerletter.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chPOA.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cPOA = tl_Updatelead_incomedetails_Activity.chPOA.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chNREbankstatement.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cNRAbankstmt = tl_Updatelead_incomedetails_Activity.chNREbankstatement.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chcontractletter.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cContractltr = tl_Updatelead_incomedetails_Activity.chcontractletter.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.choverbankdetails.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cOverbank = tl_Updatelead_incomedetails_Activity.choverbankdetails.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chitr.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cITR = tl_Updatelead_incomedetails_Activity.chitr.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chcurrentbankstatement.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cCurrentbnkstmt = tl_Updatelead_incomedetails_Activity.chcurrentbankstatement.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chsavingacctstatement.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cSavingbnkstmt = tl_Updatelead_incomedetails_Activity.chsavingacctstatement.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chpartnersheepdeed.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cPartnerdeed = tl_Updatelead_incomedetails_Activity.chpartnersheepdeed.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chbisunessagreement.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cBisunessagmt = tl_Updatelead_incomedetails_Activity.chbisunessagreement.getText().toString();
            }
            if (Tl_Updatelead_incomedetails_Activity.this.chqualification.isChecked()) {
                tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
                tl_Updatelead_incomedetails_Activity.cQulification = tl_Updatelead_incomedetails_Activity.chqualification.getText().toString();
            }
            tl_Updatelead_incomedetails_Activity = Tl_Updatelead_incomedetails_Activity.this;
            tl_Updatelead_incomedetails_Activity.updateLeadDetails(tl_Updatelead_incomedetails_Activity.leedsModel);
            Toast.makeText(Tl_Updatelead_incomedetails_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Tl_Updatelead_incomedetails_Activity.this, TL_Updatelead_property_Details_Activity.class);
            i.putExtra(Constant.LEED_MODEL, Tl_Updatelead_incomedetails_Activity.this.leedsModel);
            Tl_Updatelead_incomedetails_Activity.this.startActivity(i);
            Tl_Updatelead_incomedetails_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$3 */
    class C08353 implements CompoundButton.OnCheckedChangeListener {
        C08353() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Tl_Updatelead_incomedetails_Activity.this.ShowotherEMI();
            } else {
                Tl_Updatelead_incomedetails_Activity.this.hideotherEMI();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$4 */
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

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$5 */
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

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$6 */
    class C08386 implements CompoundButton.OnCheckedChangeListener {
        C08386() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Tl_Updatelead_incomedetails_Activity.this.txtsocietyloan.setVisibility(View.VISIBLE);
            } else {
                Tl_Updatelead_incomedetails_Activity.this.txtsocietyloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$7 */
    class C08397 implements CompoundButton.OnCheckedChangeListener {
        C08397() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Tl_Updatelead_incomedetails_Activity.this.txtpersonalloan.setVisibility(View.VISIBLE);
            } else {
                Tl_Updatelead_incomedetails_Activity.this.txtpersonalloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Tl_Updatelead_incomedetails_Activity$8 */
    class C09318 extends CallBack {
        C09318() {
        }

        public void onSuccess(Object object) {
            Tl_Updatelead_incomedetails_Activity.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Tl_Updatelead_incomedetails_Activity.this.progressDialogClass.dismissDialog();
            Context context = Tl_Updatelead_incomedetails_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_income_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        this.progressDialogClass = new ProgressDialogClass(this);
        this.leedRepository = new LeedRepositoryImpl();
        this.appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"Bussiness", "Job"};
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};
        String[] EMI = new String[]{"Car", "Home Loan", "Sociaty Loan/Employer Loan", "Other"};
        this.layoutothercompany = (RelativeLayout) findViewById(R.id.layoutothercompany);
        this.layoutotheremi = (RelativeLayout) findViewById(R.id.layoutotheremidetails);
        this.groupRadioEmployed = (RadioGroup) findViewById(R.id.radioOccupation);
        this.Rsalaried = (RadioButton) findViewById(R.id.radioSalaried);
        this.Rselfemployed = (RadioButton) findViewById(R.id.radioselfEmployed);
        this.SPcompanytype = (Spinner) findViewById(R.id.spinnercompanytype);
        this.SPcompanytype.setOnItemSelectedListener(this);
        this.SPsalarytype = (Spinner) findViewById(R.id.sploantype1);
        this.edttenure = (EditText) findViewById(R.id.txttenure1);
        this.edtexperience = (EditText) findViewById(R.id.txtexperience1);
        this.edtdepartment = (EditText) findViewById(R.id.txtdepartment1);
        this.edtdesignation = (EditText) findViewById(R.id.txtdesignation1);
        this.edtgrosssalary = (EditText) findViewById(R.id.txtmontlygrossincome1);
        this.edtnetsalary = (EditText) findViewById(R.id.txtnetsalary1);
        this.edtovertime = (EditText) findViewById(R.id.txtovertime1);
        this.edtincentive = (EditText) findViewById(R.id.txtiincentive1);
        this.edtbonus = (EditText) findViewById(R.id.txtbonus1);
        this.edtrentalincome = (EditText) findViewById(R.id.txtrent1);
        this.edtannualincome = (EditText) findViewById(R.id.txtannualincome1);
        this.edtrental = (EditText) findViewById(R.id.txtrentalexpence1);
        this.edtothercompany = (EditText) findViewById(R.id.txtothercompany1);
        this.edtagrreculturincom = (EditText) findViewById(R.id.txtagreecultureincome1);
        this.edtotherincome = (EditText) findViewById(R.id.txtotherincome1);
        this.edtotheremidetails = (EditText) findViewById(R.id.txtotheremi1);
        this.txtCarloan = (EditText) findViewById(R.id.txtcarloanamount);
        this.txtHomeloan = (EditText) findViewById(R.id.txthomeloanamount);
        this.txtsocietyloan = (EditText) findViewById(R.id.txtsocietyloanamount);
        this.txtpersonalloan = (EditText) findViewById(R.id.txtpersonalloanamount);
        this.chsalarysleep = (CheckBox) findViewById(R.id.checkboxsalarysleep);
        this.chbankstatement = (CheckBox) findViewById(R.id.checkboxbankstatement);
        this.chformno16 = (CheckBox) findViewById(R.id.checkboxform16);
        this.chappointmentletter = (CheckBox) findViewById(R.id.checkboxappointmentletter);
        this.chconfermationletter = (CheckBox) findViewById(R.id.checkboxconfermationletter);
        this.chexperieceletter = (CheckBox) findViewById(R.id.checkboxexpletter);
        this.chvisa = (CheckBox) findViewById(R.id.checkboxvisa);
        this.chpasspoet = (CheckBox) findViewById(R.id.checkboxpassport);
        this.chemployerletter = (CheckBox) findViewById(R.id.checkboxEmployerletter);
        this.chcontractletter = (CheckBox) findViewById(R.id.checkboxcontractletter);
        this.chPOA = (CheckBox) findViewById(R.id.checkboxPOA);
        this.chNREbankstatement = (CheckBox) findViewById(R.id.checkboxNREbank);
        this.choverbankdetails = (CheckBox) findViewById(R.id.checkboxOverseasbank);
        this.chitr = (CheckBox) findViewById(R.id.checkboxITR);
        this.chcurrentbankstatement = (CheckBox) findViewById(R.id.checkboxcurrentaccountstatement);
        this.chsavingacctstatement = (CheckBox) findViewById(R.id.checkboxsavingacctstatement);
        this.chpartnersheepdeed = (CheckBox) findViewById(R.id.checkboxpartnerdeed);
        this.chbisunessagreement = (CheckBox) findViewById(R.id.checkboxbusinessagreement);
        this.chqualification = (CheckBox) findViewById(R.id.checkboxqualification);
        this.chcarloan = (CheckBox) findViewById(R.id.checkboxCarloan);
        this.chhomloan = (CheckBox) findViewById(R.id.checkboxHomeloan);
        this.chsocietyloan = (CheckBox) findViewById(R.id.checkboxSocietyloan);
        this.chpersonalloan = (CheckBox) findViewById(R.id.checkboxPersonalloan);
        this.chotherloan = (CheckBox) findViewById(R.id.checkboxOtherloan);
        Setchecked();
        this.btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);
        this.txtleadid = (TextView) findViewById(R.id.textheader);
        this.groupRadioEmployed.setOnCheckedChangeListener(new C08331());
        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);
        this.btnupdatenext.setOnClickListener(new C08342());
        getdata();
        Loanvisibility();
    }

    private void Setchecked() {
        this.chotherloan.setOnCheckedChangeListener(new C08353());
        this.chcarloan.setOnCheckedChangeListener(new C08364());
        this.chhomloan.setOnCheckedChangeListener(new C08375());
        this.chsocietyloan.setOnCheckedChangeListener(new C08386());
        this.chpersonalloan.setOnCheckedChangeListener(new C08397());
    }

    private void Loanvisibility() {
        if (this.chcarloan.isChecked()) {
            this.txtCarloan.setVisibility(View.VISIBLE);
        } else {
            this.txtCarloan.setVisibility(View.INVISIBLE);
        }
        if (this.chpersonalloan.isChecked()) {
            this.txtpersonalloan.setVisibility(View.VISIBLE);
        } else {
            this.txtpersonalloan.setVisibility(View.INVISIBLE);
        }
        if (this.chsocietyloan.isChecked()) {
            this.txtsocietyloan.setVisibility(View.VISIBLE);
        } else {
            this.txtsocietyloan.setVisibility(View.INVISIBLE);
        }
        if (this.chhomloan.isChecked()) {
            this.txtHomeloan.setVisibility(View.VISIBLE);
        } else {
            this.txtHomeloan.setVisibility(View.INVISIBLE);
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
            ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            String sInsentive = sEMIhome;
            SPcompanytype.setSelection(myAdap.getPosition(sCompanytype));
            if (sCompanytype.equalsIgnoreCase("Other")) {
                Showothercompany();
            } else {
                hideothercompany();
            }
            SPsalarytype.setSelection(((ArrayAdapter) SPsalarytype.getAdapter()).getPosition(sSalarytype));
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
        }
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setEmployed(this.cEmployedtype);
            leedsModel.setCompanytype(this.cCompanytype);
            leedsModel.setSalaytype(this.cSalaryType);
            leedsModel.setEmicar(this.cCarloan);
            leedsModel.setEmihome(this.cHomeloan);
            leedsModel.setEmisociety(this.cSocietyloan);
            leedsModel.setEmipersonal(this.cPersonalloan);
            leedsModel.setCarLoanAmount(this.cCarloanamt);
            leedsModel.setHomeLoanAmount(this.cHomeloanamt);
            leedsModel.setSocietyLoanAmount(this.cSocietyloanamt);
            leedsModel.setPersonalLoanAmount(this.cPersonalloanamt);
            leedsModel.setEmiother(this.cOtherloan);
            leedsModel.setOthercompany(this.cOthercompany);
            leedsModel.setTenure(this.cTenure);
            leedsModel.setExperience(this.cEcperience);
            leedsModel.setDepartment(this.cDept);
            leedsModel.setDesignation(this.cDesignation);
            leedsModel.setGrosssalary(this.cGrossslr);
            leedsModel.setNetsalary(this.cNetslr);
            leedsModel.setOvertime(this.cOvertime);
            leedsModel.setIncentive(this.cIncentive);
            leedsModel.setBonus(this.cBonus);
            leedsModel.setRentalincome(this.cRentalincome);
            leedsModel.setAnnualincome(this.cAnnualincome);
            leedsModel.setRental(this.cRental);
            leedsModel.setSalarysleep(this.cSalarysleep);
            leedsModel.setBankstmt(this.cBankstmt);
            leedsModel.setForm(this.cForm16);
            leedsModel.setAppointmentltr(this.cAppointmentltr);
            leedsModel.setConformationltr(this.cConfermationltr);
            leedsModel.setExperinceltr(this.cExperinceltr);
            leedsModel.setVisa(this.cVisa);
            leedsModel.setPassport(this.cPassport);
            leedsModel.setEmploerltr(this.cEmployerltr);
            leedsModel.setContractltr(this.cContractltr);
            leedsModel.setPoa(this.cPOA);
            leedsModel.setNrebankstmt(this.cNRAbankstmt);
            leedsModel.setOverseasbankdetail(this.cOverbank);
            leedsModel.setItr(this.cITR);
            leedsModel.setCurrentbankstmt(this.cCurrentbnkstmt);
            leedsModel.setSavingacctstmt(this.cSavingbnkstmt);
            leedsModel.setPartnersheepdeed(this.cPartnerdeed);
            leedsModel.setBusinessagmt(this.cBisunessagmt);
            leedsModel.setQualification(this.cQulification);
            leedsModel.setAggrecultureIncome(this.cAgrreIncome);
            leedsModel.setOtherIncome(this.cOtherincome);
            leedsModel.setEmiOtherDetails(this.cOtherEMIdetails);
            updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
        } catch (Exception e) {
        }
    }

    private void updateLeed(String leedId, Map leedsMap) {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.updateLeed(leedId, leedsMap, new C09318());
    }

    public void hideothercompany() {
        LayoutParams params = (LayoutParams) this.layoutothercompany.getLayoutParams();
        params.height = 0;
        this.layoutothercompany.setLayoutParams(params);
    }

    public void Showothercompany() {
        LayoutParams params = (LayoutParams) this.layoutothercompany.getLayoutParams();
        params.height = -1;
        this.layoutothercompany.setLayoutParams(params);
    }

    public void hideotherEMI() {
        LayoutParams params = (LayoutParams) this.layoutotheremi.getLayoutParams();
        params.height = 0;
        this.layoutotheremi.setLayoutParams(params);
    }

    public void ShowotherEMI() {
        LayoutParams params = (LayoutParams) this.layoutotheremi.getLayoutParams();
        params.height = -1;
        this.layoutotheremi.setLayoutParams(params);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        if (this.SPcompanytype.getSelectedItem().toString().equalsIgnoreCase("Other")) {
            Showothercompany();
        } else {
            hideothercompany();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back press disabled!", 0).show();
    }
}
