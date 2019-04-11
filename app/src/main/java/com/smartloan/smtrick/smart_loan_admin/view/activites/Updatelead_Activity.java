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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

public class Updatelead_Activity extends AppCompatActivity implements OnItemSelectedListener {
    AppSharedPreference appSharedPreference;
    Button btcancel;
    Button btnupdatenext;
    Button btupdate;
    Button btverify;
    String cPartner;
    String lGenby;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ArrayList<LeedsModel> leedsModelArrayList;
    ProgressDialogClass progressDialogClass;
    SimpleDateFormat sfd;
    Spinner spinloantype;
    String sploantype;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    TextView txtleadidtop;
    TextView txttime;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity$1 */
    class C08401 implements OnClickListener {
        C08401() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity$2 */
    class C08412 implements OnClickListener {
        C08412() {
        }

        public void onClick(View v) {
            Updatelead_Activity updatelead_Activity = Updatelead_Activity.this;
            updatelead_Activity.setLeedStatus(updatelead_Activity.leedsModel);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity$3 */
    class C08423 implements OnClickListener {
        C08423() {
        }

        public void onClick(View v) {
            Updatelead_Activity.this.startActivity(new Intent(Updatelead_Activity.this, MainActivity_telecaller.class));
            Updatelead_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity$4 */
    class C08434 implements OnClickListener {
        C08434() {
        }

        public void onClick(View v) {
            Updatelead_Activity updatelead_Activity = Updatelead_Activity.this;
            updatelead_Activity.updateLeadDetails(updatelead_Activity.leedsModel);
            Toast.makeText(Updatelead_Activity.this, "Lead Update Successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Updatelead_Activity.this, TL_Updatelead_C_Details_Activity.class);
            i.putExtra(Constant.LEED_MODEL, Updatelead_Activity.this.leedsModel);
            Updatelead_Activity.this.startActivity(i);
            Updatelead_Activity.this.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity$5 */
    class C09325 extends CallBack {
        C09325() {
        }

        public void onSuccess(Object object) {
            Updatelead_Activity.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Updatelead_Activity.this.progressDialogClass.dismissDialog();
            Context context = Updatelead_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        this.progressDialogClass = new ProgressDialogClass(this);
        this.leedRepository = new LeedRepositoryImpl();
        this.appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        this.btupdate = (Button) findViewById(R.id.buttonupdate);
        this.btverify = (Button) findViewById(R.id.buttonverify);
        this.btcancel = (Button) findViewById(R.id.buttoncancel);
        this.btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);
        this.txtldate = (TextView) findViewById(R.id.txtdate1);
        this.txttime = (TextView) findViewById(R.id.txtleedtime1);
        this.txtleadid = (TextView) findViewById(R.id.txtleadidvalue);
        this.spinloantype = (Spinner) findViewById(R.id.sploantype1);
        this.txtgeneratedby = (TextView) findViewById(R.id.txtagentid1);
        this.txtleadidtop = (TextView) findViewById(R.id.textheader);
        this.spinloantype.setOnItemSelectedListener(this);
        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinloantype.setAdapter(spinnerArrayAdapterloantype);
        getdata();
        this.btupdate.setOnClickListener(new C08401());
        this.btverify.setOnClickListener(new C08412());
        this.btcancel.setOnClickListener(new C08423());
        this.btnupdatenext.setOnClickListener(new C08434());
    }

    private void getdata() {
        try {
            String leedid = this.leedsModel.getLeedNumber();
            String agentname = this.leedsModel.getAgentName();
            Long ldatetime = this.leedsModel.getCreatedDateTimeLong();
            Long time = this.leedsModel.getCreatedDateTimeLong();
            this.spinloantype.setSelection(((ArrayAdapter) this.spinloantype.getAdapter()).getPosition(this.leedsModel.getLoanType()));
            if (ldatetime != null) {
                this.txtldate.setText(Utility.convertMilliSecondsToFormatedDate(this.leedsModel.getCreatedDateTimeLong().longValue(), Constant.GLOBAL_DATE_FORMATE));
            }
            if (time != null) {
                this.txttime.setText(Utility.convertMilliSecondsToFormatedDate(this.leedsModel.getCreatedDateTimeLong().longValue(), "hh:mm a"));
            }
            if (leedid != null) {
                this.txtleadid.setText(leedid);
                this.txtleadidtop.setText(leedid);
            }
            if (agentname != null) {
                this.txtgeneratedby.setText(agentname);
            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setLoanType(this.sploantype);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.updateLeed(leedId, leedsMap, new C09325());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        this.sploantype = this.spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
