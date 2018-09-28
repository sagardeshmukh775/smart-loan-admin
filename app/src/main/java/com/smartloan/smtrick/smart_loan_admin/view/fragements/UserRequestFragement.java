package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.UserModel;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.UsersAdapter;

import java.util.ArrayList;

public class UserRequestFragement extends Fragment implements AdapterView.OnItemSelectedListener {

    public UserRequestFragement() {
    }

    ArrayList<UserModel> searchResults = GetSearchResults();
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_fragement, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new UsersAdapter(getActivity(), searchResults,true));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Object o = listView.getItemAtPosition(position);
                        final Dialog dialog = new Dialog(getActivity());
                        dialog.setContentView(R.layout.dialog_user_details);
                        dialog.setTitle("Title...");

                        TextView txtDoj = (TextView) dialog.findViewById(R.id.txtDateOfJoining);
                        TextView txtDojValue = (TextView) dialog.findViewById(R.id.txt_joining_date_value);
                        txtDojValue.setVisibility(View.GONE);
                        txtDoj.setVisibility(View.GONE);
                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonreject);
                        dialogButton.setText("Accept");
                        dialogButton2.setText("Reject");
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });
            }
        });
        return view;
    }

    private ArrayList<UserModel> GetSearchResults() {
        ArrayList<UserModel> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                UserModel sr = new UserModel();
                sr.setName("Mr Pratik Patel");
                sr.setType("Accountant");
                sr.setMobileNumber("7030648899");
                sr.setUserStatus("Active");
                results.add(sr);
            } else {
                UserModel sr = new UserModel();
                sr.setName("Mr Sagar Mule");
                sr.setType("TelleCaller");
                sr.setMobileNumber("7030648899");
                sr.setUserStatus("Deactive");
                results.add(sr);
            }
        }

        return results;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
