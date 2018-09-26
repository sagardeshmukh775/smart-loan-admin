package com.smartloan.smtrick.smart_loan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registeractivity extends AppCompatActivity implements
	AdapterView.OnItemSelectedListener{
	TextView txtlogin;
	Button btlogin;
	String[] usertypes = {"Accountant", "Tellecaller"};
	EditText etname,etaddress,etmobile,etusername,etpassword,emailid,etreenterpassword;
	Spinner spin;
	RadioButton Rdmale,RdFemale;


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.registeractivity);

		String[] Userstype = new String[]{
				"Accountant",
				"Telecaller"};

		txtlogin = (TextView) findViewById(R.id.txtRegister);
		btlogin = (Button) findViewById(R.id.buttonsubmit);

		etname = (EditText) findViewById(R.id.edittextname);
		etaddress = (EditText) findViewById(R.id.edittextaddress);
		etmobile = (EditText) findViewById(R.id.edittextmobile);
		etusername = (EditText) findViewById(R.id.edittextusername);
		etpassword = (EditText) findViewById(R.id.edittextpassword);
		emailid = (EditText) findViewById(R.id.edittextemailid);
		etreenterpassword = (EditText) findViewById(R.id.edittextreenterpassword);

		Rdmale = (RadioButton) findViewById(R.id.radiomale);
		RdFemale = (RadioButton) findViewById(R.id.radiofemale);

		spin = (Spinner) findViewById(R.id.spinnerselectusertype);
		spin.setOnItemSelectedListener(this);




		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				this,R.layout.sppinner_layout_listitem,Userstype
		);
		spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
		spin.setAdapter(spinnerArrayAdapter);





		Rdmale.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				Rdmale.startAnimation(zoomOutAnimation);
				return false;
			}
		});

		RdFemale.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				RdFemale.startAnimation(zoomOutAnimation);
				return false;
			}
		});




		spin.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				spin.startAnimation(zoomOutAnimation);
				return false;
			}
		});

		txtlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent i = new Intent(Registeractivity.this, LoginScreen.class);
				startActivity(i);
				overridePendingTransition(R.anim.backslide_in, R.anim.backslide_out);

			}
		});

		btlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Toast.makeText(Registeractivity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(Registeractivity.this, LoginScreen.class);
				startActivity(i);
				overridePendingTransition(R.anim.backslide_in, R.anim.backslide_out);

			}
		});

		etname.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etname.startAnimation(zoomOutAnimation);
				return false;
			}
		});
		etaddress.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etaddress.startAnimation(zoomOutAnimation);
				return false;
			}
		});
		etmobile.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etmobile.startAnimation(zoomOutAnimation);
				return false;
			}
		});
		etusername.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etusername.startAnimation(zoomOutAnimation);
				return false;
			}
		});
		etpassword.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etpassword.startAnimation(zoomOutAnimation);
				return false;
			}
		});

		emailid.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				emailid.startAnimation(zoomOutAnimation);
				return false;
			}
		});

		etreenterpassword.setOnTouchListener(new View.OnTouchListener()
		{
			public boolean onTouch(View arg0, MotionEvent arg1)
			{
				Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
				etreenterpassword.startAnimation(zoomOutAnimation);
				return false;
			}
		});

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

}
