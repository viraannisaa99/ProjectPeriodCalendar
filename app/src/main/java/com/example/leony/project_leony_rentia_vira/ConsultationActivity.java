package com.example.leony.project_leony_rentia_vira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ConsultationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultation);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.period){
            startActivity(new Intent(this, PeriodActivity.class));
        } else if (item.getItemId() == R.id.info){
            startActivity(new Intent(this, InfoActivity.class));
        } else if (item.getItemId() == R.id.konsultasi) {
            startActivity(new Intent(this, ConsultationActivity.class));
        }
        return true;
    }
}
