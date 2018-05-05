package com.example.android.timebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TambahJadwalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText[] = new EditText[2];
    private LinearLayout button[] = new LinearLayout[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_jadwal_activity);
        editText[0] = findViewById(R.id.editNamaKegiatan);
        editText[1] = findViewById(R.id.editLokasiKegiatan);
        button[0] = findViewById(R.id.timelineButton);
        button[1] = findViewById(R.id.profileButton);
        button[2] = findViewById(R.id.calendarButton);
        for (int i = 0; i < editText.length; i++) {
            editText[i].setOnClickListener(this);
        }
        for (int i = 0; i < button.length; i++) {
            button[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == editText[0].getId()) {
            editText[0].setText("");
        } else if (v.getId() == editText[1].getId()) {
            editText[1].setText("");
        } else if (v.getId() == button[0].getId()) {
            Intent myIntent = new Intent(TambahJadwalActivity.this, TimelineActivity.class);
            TambahJadwalActivity.this.startActivity(myIntent);
        } else {
            Toast.makeText(getApplicationContext(), "Belum ada activitynya mamang",
                    Toast.LENGTH_SHORT).show();
        }
    }

}

