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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.Sales_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.Telecaller_fragment_Reports;

public class MainActivity_sales extends AppCompatActivity


        //Note : OnFragmentInteractionListener of all the fragments
        implements
        //Fragment_GenerateLeads.OnFragmentInteractionListener,
        Sales_Fragment_leads.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
        Fragment_Calculator.OnFragmentInteractionListener,

        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    TextView user_name,user_contact,user_email;

    private AppSharedPreference appSharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sales);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appSharedPreference = new AppSharedPreference(getApplicationContext());

        // NOTE : Just remove the fab button

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.Leads);
        updateNavigationHeader();
        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new Sales_Fragment_leads());
        ft.commit();

    }

    public void updateNavigationHeader() {
        try {
            View header = navigationView.getHeaderView(0);

            user_name = (TextView) header.findViewById(R.id.sales_name);
            user_contact = (TextView)  header.findViewById(R.id.contact);
            user_email = (TextView)  header.findViewById(R.id.email);

            String name = appSharedPreference.getUserName();
            String mobile = appSharedPreference.getMobileNo();
            String email = appSharedPreference.getEmaiId();
            user_email.setText(email);
            user_contact.setText(mobile);
            user_name.setText(name);

        }catch (Exception e){}
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;

        if  (id == R.id.Leads) {
            fragment = new Sales_Fragment_leads();
        } else if (id == R.id.Reports) {
            fragment = new Telecaller_fragment_Reports();
        }else if (id == R.id.Calulator) {
            fragment = new Fragment_Calculator();
        }else if (id == R.id.Logout) {
            clearDataWithSignOut();
        }

        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

        //NOTE:  Closing the drawer after selecting
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //Ya you can also globalize this variable :P
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
