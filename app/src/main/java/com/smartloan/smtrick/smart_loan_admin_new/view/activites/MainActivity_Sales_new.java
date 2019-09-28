package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Coordinator_Fragment_lead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.DisplaySettingsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_fragment_Reports;

public class MainActivity_Sales_new extends AppCompatActivity implements
        Telecaller_Fragment_leads.OnFragmentInteractionListener,
        OnFragmentInteractionListener,
        //Fragment_GenerateLeads.OnFragmentInteractionListener,
        Sales_Fragment_leads.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
        Fragment_Calculator.OnFragmentInteractionListener{

    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__coordinator_new);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new Sales_Fragment_leads())
                    .commit();
        }

        if (isTwoPane) {
            fragmentManager.beginTransaction()
                    .replace(R.id.detailContainer, new DisplaySettingsFragment())
                    .commit();
        }


    }

    @Override
    public void onFragmentInteraction(String title) {

    }


//    @Override
//    public void onOptionSelected(String option) {
//        if (isTwoPane) {
//            switch (option) {
//                case "network": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new NetworkSettingsFragment())
//                            .commit();
//                    break;
//                }
//                case "display": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new DisplaySettingsFragment())
//                            .commit();
//                    break;
//                }
//                case "storage": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new StorageSettingsFragment())
//                            .commit();
//                    break;
//                }
//            }
//        } else {
//            Intent intent = new Intent(this, SettingsDetailActivity.class);
//            intent.putExtra(SettingsDetailActivity.EXTRA_SETTING_OPTION, option);
//            startActivity(intent);
//        }
//    }
}
