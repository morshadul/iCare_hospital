package com.basis.rakib.icare_hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


/**
 * Created by Mobile App Develop on 27-6-15.
 */
public class AddHospital extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_hospital);
    }

    public void btnEditProfile(View v) {

        Intent intent = new Intent(AddHospital.this, AddHospitalInfo.class);
        startActivity(intent);

    }

}
