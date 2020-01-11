package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.AddBankFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_CheckList_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_Comission_Rules_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_Target_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Bills_Tab_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Calander_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Invoices_Tab_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_TodoList_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LeedsTabsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.ReportsTabFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UserTabsFragment;

public class Activity_Home_Main extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__home__main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Calculator");

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        if (value.equalsIgnoreCase("leeds")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new LeedsTabsFragment());
//            ft.commit();
            Intent intent1 = new Intent(Activity_Home_Main.this, MainActivity_Admin_new.class);
            intent1.putExtra("value", "leeds");
            startActivity(intent1);

        } else if (value.equalsIgnoreCase("banks")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new AddBankFragement());
            ft.commit();

        } else if (value.equalsIgnoreCase("calc")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new LoanCalculatorFragement());
            ft.commit();

        } else if (value.equalsIgnoreCase("user")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new UserTabsFragment());
            ft.commit();

        } else if (value.equalsIgnoreCase("report")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new ReportsTabFragment());
            ft.commit();

        } else if (value.equalsIgnoreCase("comission")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Add_Comission_Rules_Fragement());
            ft.commit();

        } else if (value.equalsIgnoreCase("bills")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_Bills_Tab_Fragment());
            ft.commit();

        } else if (value.equalsIgnoreCase("checklist")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Add_CheckList_Fragement());
            ft.commit();

        }else if (value.equalsIgnoreCase("invoice")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_Invoices_Tab_Fragment());
            ft.commit();

        }else if (value.equalsIgnoreCase("target")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Add_Target_Fragement());
            ft.commit();

        }else if (value.equalsIgnoreCase("todolist")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_TodoList_Fragment());
            ft.commit();

        }else if (value.equalsIgnoreCase("calender")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_Calander_Fragment());
            ft.commit();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentInteraction(String title) {

    }
}
