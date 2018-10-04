package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.UserModel;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.UsersAdapter;

import java.util.ArrayList;

public class UsersFragement extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    public UsersFragement() {
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
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Users");
        }
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new UsersAdapter(getActivity(), searchResults,false));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Object o = listView.getItemAtPosition(position);
                        // custom dialog
                        final Dialog dialog = new Dialog(getActivity());
                        dialog.setContentView(R.layout.dialog_user_details);
                        dialog.setTitle("Title...");
                        // set the custom dialog components - text, image and button
                        //  TextView text = (TextView) dialog.findViewById(R.id.text);
                        // text.setText("Android custom dialog example!");
                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonreject);
                        // if button is clicked, close the custom dialog
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // NOTE: This is the part that usually gives you the error
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}