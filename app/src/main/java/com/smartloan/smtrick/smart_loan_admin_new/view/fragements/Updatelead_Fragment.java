package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
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
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_BALANCE_TRANSFER;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_HL;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_LAP;

public class
Updatelead_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    AppSharedPreference appSharedPreference;
    Button btcancel, btnupdatenext, btupdate, btverify;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner spinloantype, spinloansubtype, spinloanbttype;
    String sploantype;
    TextView txtgeneratedby, txtldate, txtleadid, txtleadidtop, txttime;
    TextView txtLeedId, txtCustomerName, txtLoanRequirement, txtAgent, txtLoanType;
    AppSingleton appSingleton;
    RelativeLayout layoutHLType, layoutBTType;

    @Override
    public void onClick(View view) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.updatelead_activity, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }
        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());
        appSingleton = AppSingleton.getInstance(getActivity());

        String[] loanType = appSingleton.getLoanType();
        String[] HomeloanType = appSingleton.getHomeLoanType();
        String[] balanceTransferType = appSingleton.getBalanceTransferType();

        btupdate = (Button) view.findViewById(R.id.buttonupdate);
        btverify = (Button) view.findViewById(R.id.buttonverify);
        btcancel = (Button) view.findViewById(R.id.buttoncancel);
        btnupdatenext = (Button) view.findViewById(R.id.buttonupdatenext);
        txtldate = (TextView) view.findViewById(R.id.txtdate1);
        txttime = (TextView) view.findViewById(R.id.txtleedtime1);
        txtleadid = (TextView) view.findViewById(R.id.txtleadidvalue);
        spinloantype = (Spinner) view.findViewById(R.id.sploantype1);
        spinloansubtype = (Spinner) view.findViewById(R.id.sploansubtype1);
        spinloanbttype = (Spinner) view.findViewById(R.id.sploanbttype1);
        txtgeneratedby = (TextView) view.findViewById(R.id.txtagentid1);
        txtleadidtop = (TextView) view.findViewById(R.id.textheader);

        txtLeedId = (TextView) view.findViewById(R.id.txt_id_value);
        txtCustomerName = (TextView) view.findViewById(R.id.txtcnamevalue);
        txtLoanRequirement = (TextView) view.findViewById(R.id.txt_loan_requirement_value);
        txtAgent = (TextView) view.findViewById(R.id.txt_bp_value);
        txtLoanType = (TextView) view.findViewById(R.id.txt_loan_type_value);

        layoutHLType = (RelativeLayout) view.findViewById(R.id.layoutLoansubtype);
        layoutBTType = (RelativeLayout) view.findViewById(R.id.layoutLoanbttype);

        txtLeedId.setText(leedsModel.getLeedNumber());
        txtCustomerName.setText(leedsModel.getCustomerName());
        if (leedsModel.getLoanrequirement() != null) {
            txtLoanRequirement.setText(leedsModel.getLoanrequirement());
        } else {
            txtLoanRequirement.setText("Null");
        }
        txtAgent.setText(leedsModel.getAgentName());
        txtLoanType.setText(leedsModel.getLoanType());


        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);
        spinloantype.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapterHLloantype = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, HomeloanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        ArrayAdapter<String> spinnerAdapterBalanceTransferType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, balanceTransferType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);


        spinloansubtype.setAdapter(spinnerArrayAdapterHLloantype);
        spinloanbttype.setAdapter(spinnerAdapterBalanceTransferType);

        if (spinloantype.getSelectedItem().toString().equalsIgnoreCase(LOAN_TYPE_LAP)) {
            hideBTLoanDetails();
            hidehomeLoanDetails();
        } else if (spinloantype.getSelectedItem().toString().equalsIgnoreCase(LOAN_TYPE_HL)) {
            showchomeLoanDetails();
            hideBTLoanDetails();
        } else if (spinloantype.getSelectedItem().toString().equalsIgnoreCase(LOAN_TYPE_BALANCE_TRANSFER)) {
            hidehomeLoanDetails();
            showBTLoanDetails();
        }

        spinloantype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String loantype = spinloantype.getSelectedItem().toString();
                if (loantype.equalsIgnoreCase(Constant.LOAN_TYPE_HL)) {
                    showchomeLoanDetails();
                    hideBTLoanDetails();

                    if (leedsModel.getHomeLoanType() != null) {
                        String HLType = leedsModel.getHomeLoanType();
                        spinloansubtype.setSelection(((ArrayAdapter) spinloansubtype.getAdapter()).getPosition(HLType));
                    }

                } else if (loantype.equalsIgnoreCase(Constant.LOAN_TYPE_BALANCE_TRANSFER)) {
                    hidehomeLoanDetails();
                    showBTLoanDetails();

                    if (leedsModel.getBalanceTransferLoanType() != null) {
                        String BTType = leedsModel.getBalanceTransferLoanType();
                        spinloanbttype.setSelection(((ArrayAdapter) spinloanbttype.getAdapter()).getPosition(BTType));
                    }

                } else {
                    hideBTLoanDetails();
                    hidehomeLoanDetails();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getdata();

        btverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLeedStatus(leedsModel);
            }
        });
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity_telecaller.class));
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        btnupdatenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLeadDetails(leedsModel);
                Toast.makeText(getContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

                TL_Updatelead_C_Details_Fragment fragment2 = new TL_Updatelead_C_Details_Fragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer, fragment2);
                ft.commit();
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        return view;
    }

    private void getdata() {
        try {
            String leedid = leedsModel.getLeedNumber();
            String agentname = leedsModel.getAgentName();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            Long time = leedsModel.getCreatedDateTimeLong();
            String loantype = leedsModel.getLoanType();

            spinloantype.setSelection(((ArrayAdapter) spinloantype.getAdapter()).getPosition(loantype));

            if (ldatetime != null) {
                txtldate.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), Constant.GLOBAL_DATE_FORMATE));
            }
            if (time != null) {
                txttime.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), "hh:mm a"));
            }
            if (leedid != null) {
                txtleadid.setText(leedid);
                txtleadidtop.setText(leedid);
            }
            if (agentname != null) {
                txtgeneratedby.setText(agentname);
            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setLoanType(spinloantype.getSelectedItem().toString());

        if (spinloantype.getSelectedItem().toString().equalsIgnoreCase(LOAN_TYPE_HL)) {
            leedsModel.setHomeLoanType(spinloansubtype.getSelectedItem().toString());
        } else if (spinloantype.getSelectedItem().toString().equalsIgnoreCase(LOAN_TYPE_BALANCE_TRANSFER)) {
            leedsModel.setBalanceTransferLoanType(spinloanbttype.getSelectedItem().toString());
        }
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Context context = getContext();
                Utility.showLongMessage(context, context.getString(R.string.server_error));

            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }


    public void showchomeLoanDetails() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutHLType.getLayoutParams();
        params1.height = -1;
        layoutHLType.setLayoutParams(params1);

    }

    public void hidehomeLoanDetails() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutHLType.getLayoutParams();
        params1.height = 0;
        layoutHLType.setLayoutParams(params1);

    }

    public void showBTLoanDetails() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutBTType.getLayoutParams();
        params1.height = -1;
        layoutBTType.setLayoutParams(params1);

    }

    public void hideBTLoanDetails() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutBTType.getLayoutParams();
        params1.height = 0;
        layoutBTType.setLayoutParams(params1);

    }
}
