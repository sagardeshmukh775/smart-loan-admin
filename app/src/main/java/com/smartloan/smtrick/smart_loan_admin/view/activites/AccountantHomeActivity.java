package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.AccountantApprovedLeedsFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.AccountantInvoicesTabFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.AccountantUsersFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.ReportsTabFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.UnderConstrationFragement;

public class AccountantHomeActivity extends AppCompatActivity implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {
    private AppSharedPreference appSharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountant_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // get our list view
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new AccountantApprovedLeedsFragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.Users:
                fragment = new AccountantUsersFragment();
                break;
            case R.id.Leads:
                fragment = new AccountantApprovedLeedsFragment();
                break;
            case R.id.Reports:
                fragment = new ReportsTabFragment();
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new AccountantInvoicesTabFragment();
                break;
            case R.id.Calulator:
                fragment = new LoanCalculatorFragement();
                break;
            case R.id.Logout:
                clearDataWithSignOut();
                break;
        }



        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearDataWithSignOut()
    {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut()
    {
        Intent intent = new Intent(this, LoginScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }
}
