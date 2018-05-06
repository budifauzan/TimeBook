package com.example.android.timebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TambahJadwalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText[] = new EditText[2];
    private LinearLayout mainButton[] = new LinearLayout[3];
    private TextView popUpButton[] = new TextView[3];
    private Button okButton[] = new Button[3];
    private Button cancelButton[] = new Button[3];
    private RelativeLayout popUpLayout[] = new RelativeLayout[3];
    private Point p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_jadwal_activity);
        editText[0] = findViewById(R.id.editNamaKegiatan);
        editText[1] = findViewById(R.id.editLokasiKegiatan);
        mainButton[0] = findViewById(R.id.timelineButton);
        mainButton[1] = findViewById(R.id.profileButton);
        mainButton[2] = findViewById(R.id.calendarButton);
        popUpButton[0] = findViewById(R.id.editPribadi);
        popUpButton[1] = findViewById(R.id.editPemberitahuan);
        popUpButton[2] = findViewById(R.id.editUlangi);
        for (int i = 0; i < editText.length; i++) {
            editText[i].setOnClickListener(this);
        }
        for (int i = 0; i < mainButton.length; i++) {
            mainButton[i].setOnClickListener(this);
            popUpButton[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == editText[0].getId()) {
            editText[0].setText("");
        } else if (v.getId() == editText[1].getId()) {
            editText[1].setText("");
        } else if (v.getId() == mainButton[0].getId()) {
            Intent myIntent = new Intent(TambahJadwalActivity.this, TimelineActivity.class);
            TambahJadwalActivity.this.startActivity(myIntent);
        } else if (v.getId() == popUpButton[0].getId()) {
            showPopup(TambahJadwalActivity.this, p, 0);
        } else if (v.getId() == popUpButton[1].getId()) {
            showPopup(TambahJadwalActivity.this, p, 1);
        } else if (v.getId() == popUpButton[2].getId()) {
            showPopup(TambahJadwalActivity.this, p, 2);
        } else {
            Toast.makeText(getApplicationContext(), "Belum ada activitynya mamang",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        int[] location = new int[2];
        TextView editUlangi = findViewById(R.id.editUlangi);

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        editUlangi.getLocationOnScreen(location);

        //Initialize the Point with x, and y positions
        p = new Point();
        p.x = location[0];
        p.y = location[1];
    }

    // The method that displays the popup.
    private void showPopup(final Activity context, Point p, int i) {
        popUpLayout[0] = context.findViewById(R.id.pribadiPopUp);
        popUpLayout[1] = context.findViewById(R.id.pemberitahuanPopUp);
        popUpLayout[2] = context.findViewById(R.id.ulangiPopUp);
        int popupWidth = 400;
        int popupHeight = 600;


        // Inflate the popup_layout.xml
        RelativeLayout viewGroup = popUpLayout[i];
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.pribadi_pop_up, viewGroup);
        switch (i) {
            case 0:
                layout = layoutInflater.inflate(R.layout.pribadi_pop_up, viewGroup);
                break;
            case 1:
                layout = layoutInflater.inflate(R.layout.pemberitahuan_pop_up, viewGroup);
                break;
            case 2:
                layout = layoutInflater.inflate(R.layout.ulangi_pop_up, viewGroup);
                break;
        }

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
//        int OFFSET_X = 30;
//        int OFFSET_Y = 30;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.CENTER, 0, 0);

        // Getting a reference to Close button, and close the popup when clicked.
        okButton[0] = layout.findViewById(R.id.okPribadi);
        okButton[1] = layout.findViewById(R.id.okPemberitahuan);
        okButton[2] = layout.findViewById(R.id.okUlangi);
        cancelButton[0] = layout.findViewById(R.id.cancelPribadi);
        cancelButton[1] = layout.findViewById(R.id.cancelPemberitahuan);
        cancelButton[2] = layout.findViewById(R.id.cancelUlangi);
        okButton[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        cancelButton[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
    }
}