package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.BanksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesPersonAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class View_Acct_DisbussLead_Details_Fragment extends Fragment {

    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;
    UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;

    List<String> SalesPerson;
    List<User> userlist;

    TextView txtLeedId, txtCustomerName, txtLoanRequirement, txtAgent, txtLoanType;
    EditText edtComissionAmount;

    ArrayList<Bank> leedsArraylist;
    ArrayList<User> userArraylist;
    private List<String> listmaritalstatus;
    BanksAdapter adapter;
    SalesPersonAdapter useradapter;

    Button UpdateComission;

    TextView txtApproved, txtDisbuss, txtPending,txtTDS;

    private User getUserModel(int position) {
        return userArraylist.get(userArraylist.size() - 1 - position);
    }

    private Bank getModel(int position) {
        return leedsArraylist.get(leedsArraylist.size() - 1 - position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_acct_disbuss_lead_details, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        UserRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());

        SalesPerson = new ArrayList<>();
        leedsArraylist = new ArrayList<>();
        userArraylist = new ArrayList<>();
        listmaritalstatus = new ArrayList<>();
        getSalesperson();

        txtLeedId = (TextView) view.findViewById(R.id.txt_id_value);
        txtCustomerName = (TextView) view.findViewById(R.id.txtcnamevalue);
        txtLoanRequirement = (TextView) view.findViewById(R.id.txt_loan_requirement_value);
        txtAgent = (TextView) view.findViewById(R.id.txt_bp_value);
        txtLoanType = (TextView) view.findViewById(R.id.txt_loan_type_value);
        edtComissionAmount = (EditText) view.findViewById(R.id.edtcommisionamount);
        UpdateComission = (Button) view.findViewById(R.id.buttonupdate2);

        txtApproved = (TextView) view.findViewById(R.id.txtapprovedamtvalue);
        txtDisbuss = (TextView) view.findViewById(R.id.txtdisbussedamtvalue);
        txtPending = (TextView) view.findViewById(R.id.txtpandingamtvalue);
        txtTDS = (TextView) view.findViewById(R.id.txttdsamt);

        txtLeedId.setText(leedsModel.getLeedNumber());
        txtCustomerName.setText(leedsModel.getCustomerName());
        if (leedsModel.getExpectedLoanAmount() != null) {
            txtLoanRequirement.setText(leedsModel.getExpectedLoanAmount());
        } else {
            txtLoanRequirement.setText("Null");
        }
        txtAgent.setText(leedsModel.getAgentName());
        txtLoanType.setText(leedsModel.getLoanType());

        getdata();


        UpdateComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLeadDetails(leedsModel);
            }
        });

        return view;
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setComissionamount(edtComissionAmount.getText().toString());

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Comission Updated", Toast.LENGTH_SHORT).show();
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

    private void getdata() {

        String approved = leedsModel.getApprovedLoan();
        String disbuss = leedsModel.getDisbusedLoanAmount();
        String pending = leedsModel.getPendingLoanAmount();

        if (approved != null){
            txtApproved.setText(approved);
        }else {
            txtApproved.setText("Null");
        }
        if (disbuss != null){
            txtDisbuss.setText(disbuss);
        }else {
            txtDisbuss.setText("Null");
        }
        if (pending != null){
            txtPending.setText(pending);
        }else {
            txtPending.setText("Null");
        }

        String comission = leedsModel.getComissionamount();
        if (comission != null) {
            edtComissionAmount.setText(comission);

        } else {
            int commission = Integer.parseInt(leedsModel.getDisbusedLoanAmount());
            if (commission > 1000000 && commission < 9000000) {
                double com = (commission * 0.30) / 100;
                edtComissionAmount.setText(String.valueOf(com));
            } else if (commission > 9000000 && commission < 15000000) {
                double com = (commission * 0.40) / 100;
                edtComissionAmount.setText(String.valueOf(com));
            } else if (commission > 15000000 && commission < 35000000) {
                double com = (commission * 0.55) / 100;
                edtComissionAmount.setText(String.valueOf(com));
            } else if (commission > 35000000) {
                double com = (commission * 0.65) / 100;
                edtComissionAmount.setText(String.valueOf(com));
            }
        }
    }

    private void getSalesperson() {
        UserRepository.readsalesperson(SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    userlist = (ArrayList<User>) object;
                    for (int i = 0; i < userlist.size(); i++) {
                        SalesPerson.add(userlist.get(i).getUserName());

                    }
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }


    private void HideFields(RelativeLayout layout) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}
