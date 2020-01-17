package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TasksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_TodoList_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.InvoicesTabFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UnderConstrationFragement;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class Home_Activity extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    TextView user_name, user_contact, user_email;
    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;
    private LeedRepository leedsRepository;
    private UserRepository userRepository;
    ArrayList<LeedsModel> leedsArraylist;
    ArrayList<Invoice> invoicesArraylist;
    ArrayList<Invoice> GeneratedinvoicesArraylist;
    ArrayList<Invoice> ApprovedinvoicesArraylist;
    ProgressDialogClass progressDialogClass;

    ArrayList<Bank> BanksArraylist;
    ArrayList<User> UserArraylist;

    private CardView cardTotalLeeds, cardBanks, cardLoanCalculator, cardActiveUsers, cardReports, cardComission, cardBills,
            cardCheckList, cardInvoices, cardTargets;
    TextView leedscount, bankscount, userscount, reportscount, txtInvoiceCount, txtgeneratedInvoiceCount, txtApprovedInvoiceCount;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.Leads);

        leedsRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getApplicationContext());
        progressDialogClass = new ProgressDialogClass(this);
        leedsArraylist = new ArrayList<>();
        BanksArraylist = new ArrayList<>();
        invoicesArraylist = new ArrayList<>();
        GeneratedinvoicesArraylist = new ArrayList<>();
        ApprovedinvoicesArraylist = new ArrayList<>();
        UserArraylist = new ArrayList<>();

        updateNavigationHeader();

        cardTotalLeeds = (CardView) findViewById(R.id.card_view_total_leeds);
        cardBanks = (CardView) findViewById(R.id.card_view_banks);
        cardLoanCalculator = (CardView) findViewById(R.id.card_view_loan_calculator);
        cardActiveUsers = (CardView) findViewById(R.id.card_view_users);
        cardReports = (CardView) findViewById(R.id.card_view_Reports);
        cardComission = (CardView) findViewById(R.id.card_view_Commission);
        cardBills = (CardView) findViewById(R.id.card_view_bills);
        cardCheckList = (CardView) findViewById(R.id.card_view_Checklist);
        cardInvoices = (CardView) findViewById(R.id.card_view_Invoice);
        cardTargets = (CardView) findViewById(R.id.card_view_Target);

        leedscount = (TextView) findViewById(R.id.total_leedcount);
        bankscount = (TextView) findViewById(R.id.banks_count);
        userscount = (TextView) findViewById(R.id.users_count);
        reportscount = (TextView) findViewById(R.id.reports_count);
        txtInvoiceCount = (TextView) findViewById(R.id.invoices_count);
        txtgeneratedInvoiceCount = (TextView) findViewById(R.id.generated_invoices_count);
        txtApprovedInvoiceCount = (TextView) findViewById(R.id.approved_invoices_count);



        new GetWeather().execute();

        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "banks");
                startActivity(intent);
            }
        });
        cardLoanCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "calc");
                startActivity(intent);
            }
        });
        cardActiveUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "user");
                startActivity(intent);
            }
        });
        cardReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "report");
                startActivity(intent);
            }
        });
        cardComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "comission");
                startActivity(intent);
            }
        });
        cardBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "bills");
                startActivity(intent);
            }
        });
        cardCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "checklist");
                startActivity(intent);
            }
        });
        cardInvoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "invoice");
                startActivity(intent);
            }
        });

        cardTargets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "target");
                startActivity(intent);
            }
        });

    }

    private class GetWeather extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress=new ProgressDialog(Home_Activity.this);
            progress.setMessage("Downloading tasks");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            getLeedsReport();
            getBanks();
            readUsers();
            readAllReports();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(progress.isShowing())
            {
                progress.dismiss();
            }

        }
    }
    private void readAllReports() {
        leedsRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }

                String repcount = String.valueOf(leedsArraylist.size());
                reportscount.setText(repcount);
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });    }

    private void getLeedsReport() {
//        progressDialogClass.showDialog(this.getString(R.string.SIGNING_IN), this.getString(R.string.PLEASE_WAIT));
        leedsRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }
                int a = leedsArraylist.size();
                leedscount.setText(String.valueOf(a));
                getInvoiceReport();
            }

            @Override
            public void onError(Object object) {

//                progressDialogClass.dismissDialog();
            }
        });
    }

    private void getInvoiceReport() {
        invoicesArraylist.clear();
        GeneratedinvoicesArraylist.clear();
        ApprovedinvoicesArraylist.clear();
        leedsRepository.readAllInvoices1(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    invoicesArraylist = (ArrayList<Invoice>) object;
                }
                String in = String.valueOf(invoicesArraylist.size());
                txtInvoiceCount.setText(in);

                for (int i = 0; i < invoicesArraylist.size(); i++) {
                    if (invoicesArraylist.get(i).getStatus().equalsIgnoreCase(Constant.STATUS_INVOICE_SENT)) {
                        GeneratedinvoicesArraylist.add(invoicesArraylist.get(i));
                    }
                }
                for (int i = 0; i < invoicesArraylist.size(); i++) {
                    if (invoicesArraylist.get(i).getStatus().equalsIgnoreCase(Constant.STATUS_INVOICE_APPROVED)) {
                        ApprovedinvoicesArraylist.add(invoicesArraylist.get(i));
                    }
                }
                String gen = String.valueOf(GeneratedinvoicesArraylist.size());
                String app = String.valueOf(ApprovedinvoicesArraylist.size());
                txtgeneratedInvoiceCount.setText(gen);
                txtApprovedInvoiceCount.setText(app);
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void getBanks() {
        leedsRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    BanksArraylist = (ArrayList<Bank>) object;
                }

                int b = BanksArraylist.size();
                bankscount.setText(String.valueOf(b));
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void readUsers() {
        userRepository.readAllusers(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    UserArraylist = (ArrayList<User>) object;
                }

                int u = UserArraylist.size();
                userscount.setText(String.valueOf(u));
            }

            @Override
            public void onError(Object object) {

            }
        });
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
//                fragment = new UserTabsFragment();
                Intent intentuser = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentuser.putExtra("value", "user");
                startActivity(intentuser);
                break;
            case R.id.Leads:
//                fragment = new LeedsTabsFragment();
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
                break;
            case R.id.Reports:
//                fragment = new ReportsTabFragment();
                Intent intentreport = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentreport.putExtra("value", "report");
                startActivity(intentreport);
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new InvoicesTabFragement();
                break;
            case R.id.Calulator:
//                fragment = new LoanCalculatorFragement();
                Intent intentcalc = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentcalc.putExtra("value", "calc");
                startActivity(intentcalc);
                break;
            case R.id.Bank:
//                fragment = new AddBankFragement();
                Intent intentbank = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentbank.putExtra("value", "banks");
                startActivity(intentbank);
                break;
            case R.id.todolist:
                Intent intenttodolist = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intenttodolist.putExtra("value", "todolist");
                startActivity(intenttodolist);
                break;
            case R.id.calander:
                Intent intentcalandert = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentcalandert.putExtra("value", "calender");
                startActivity(intentcalandert);
                break;
            case R.id.mail:
            case R.id.notification:
            case R.id.owntask:
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

    private void clearDataWithSignOut() {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut() {
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


    public void updateNavigationHeader() {
        try {
            View header = navigationView.getHeaderView(0);
            TextView textViewAgentId = header.findViewById(R.id.textView_agent_id);
            TextView textViewUserName = header.findViewById(R.id.textView_user_name);
            TextView textViewEmailId = header.findViewById(R.id.text_view_email);
            TextView textViewMobileNumber = header.findViewById(R.id.textView_contact);
            final ImageView imageViewProfile = header.findViewById(R.id.image_view_profile1);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);
            textViewUserName.setText(appSharedPreference.getUserName());
            textViewEmailId.setText(appSharedPreference.getEmaiId());
            textViewAgentId.setText(appSharedPreference.getAgeniId());
            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        ivProfileLayout.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .resize(200, 200)
                        .centerCrop()
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        imageViewProfile.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
            imageViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home_Activity.this, UpdateProfileActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            });
        } catch (Exception ex) {
            ExceptionUtil.logException(ex);
        }
    }


    public class ImageUploadReceiver extends BroadcastReceiver {
        public static final String PROCESS_RESPONSE = "com.smartloan.smtrick.smart_loan.intent.action.UPDATE_USER_DATA";

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNavigationHeader();
        }
    }
}
