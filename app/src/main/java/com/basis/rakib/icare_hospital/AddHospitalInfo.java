package com.basis.rakib.icare_hospital;

import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Mobile App Develop on 27-6-15.
 */
public class AddHospitalInfo extends ActionBarActivity
{

    private EditText etName;
    private EditText etAdress;
    private EditText etNumber;


    private Button btnsubmit;
    private Button btndelete;

    private TextView txtName;
    private TextView txtAddress;
    private TextView txtNumber;


    private String Name;
    private String Address;
    private String Number;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_hospital_profile);

        etName = (EditText) findViewById(R.id.etName);
        etAdress = (EditText) findViewById(R.id.etaddress);
        etNumber = (EditText) findViewById(R.id.etNumber);

        txtName = (TextView) findViewById(R.id.name);
        txtAddress = (TextView) findViewById(R.id.address);
        txtNumber = (TextView) findViewById(R.id.number);

        btnsubmit = (Button) findViewById(R.id.submit);
        btndelete = (Button) findViewById(R.id.delete);

        dbHelper = new DBHelper(AddHospitalInfo.this);

        informationViewMode();


}


    public void informationViewMode() {
        txtName.setVisibility(View.VISIBLE);
        txtAddress.setVisibility(View.VISIBLE);
        txtNumber.setVisibility(View.VISIBLE);

        etName.setVisibility(View.GONE);
        etAdress.setVisibility(View.GONE);
        txtNumber.setVisibility(View.GONE);

        btnsubmit.setVisibility(View.GONE);
        btndelete.setVisibility(View.VISIBLE);

    }

    public void btnSubmit(View v) {

        Name = etName.getText().toString();
        Address = etAdress.getText().toString();
        Number = etNumber.getText().toString();

        Hospital hospital = new Hospital(Name, Address, Number);
        dbHelper.insertAddHospital(hospital);
        Intent intent = new Intent(AddHospitalInfo.this, AddHospital.class);
        startActivity(intent);
    }



    public void btnDelete(View v) {
        getValue();
        dbHelper.DeleteAddHospital(Name, Address, Number);
        Intent intent = new Intent(AddHospitalInfo.this, AddHospital.class);
        startActivity(intent);
    }

    public void getValue() {
        Name = etName.getText().toString();
        Address = etAdress.getText().toString();
        Number = etNumber.getText().toString();


    }
}
