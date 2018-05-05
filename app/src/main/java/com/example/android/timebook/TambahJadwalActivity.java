package com.example.android.timebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TambahJadwalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText[] = new EditText[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_jadwal_activity);
        editText[0] = findViewById(R.id.editNamaKegiatan);
        editText[1] = findViewById(R.id.editLokasiKegiatan);
        editText[1].setOnClickListener(this);
        editText[0].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == editText[0].getId()) {
            editText[0].setText("");
        } else if (v.getId() == editText[1].getId()) {
            editText[1].setText("");
        }
    }

}
