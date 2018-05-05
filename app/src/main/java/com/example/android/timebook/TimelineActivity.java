package com.example.android.timebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Timeline> timelineListToday = new ArrayList<>();
    private List<Timeline> timelineListTomorrow = new ArrayList<>();
    private List<Timeline> timelineListAfterTomorrow = new ArrayList<>();
    private RecyclerView recyclerViewToday, recyclerViewTomorrow, recyclerViewAfterTomorrow;
    private TimelineAdapter mAdapterToday, mAdapterTomorrow, mAdapterAfterTomorrow;
    private LinearLayout button[] = new LinearLayout[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //RecyclerView
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);
        //Recycler untuk timeline hari ini
        recyclerViewToday = findViewById(R.id.recycler_view_today);
        mAdapterToday = new TimelineAdapter(timelineListToday);
        RecyclerView.LayoutManager mLayoutManagerToday = new LinearLayoutManager(getApplicationContext());
        recyclerViewToday.setLayoutManager(mLayoutManagerToday);
        recyclerViewToday.setItemAnimator(new DefaultItemAnimator());
        recyclerViewToday.setAdapter(mAdapterToday);
        //Recycler untuk timeline besok
        recyclerViewTomorrow = findViewById(R.id.recycler_view_tomorrow);
        mAdapterTomorrow = new TimelineAdapter(timelineListTomorrow);
        RecyclerView.LayoutManager mLayoutManagerTomorrow = new LinearLayoutManager(getApplicationContext());
        recyclerViewTomorrow.setLayoutManager(mLayoutManagerTomorrow);
        recyclerViewTomorrow.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTomorrow.setAdapter(mAdapterTomorrow);
        //Recycler untuk timeline lusa
        recyclerViewAfterTomorrow = findViewById(R.id.recycler_view_after_tomorrow);
        mAdapterAfterTomorrow = new TimelineAdapter(timelineListAfterTomorrow);
        RecyclerView.LayoutManager mLayoutManagerAfterTomorrow = new LinearLayoutManager(getApplicationContext());
        recyclerViewAfterTomorrow.setLayoutManager(mLayoutManagerAfterTomorrow);
        recyclerViewAfterTomorrow.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAfterTomorrow.setAdapter(mAdapterAfterTomorrow);
        getTimelineData();
        //Intent
        button[0] = findViewById(R.id.timelineButton);
        button[1] = findViewById(R.id.profileButton);
        button[2] = findViewById(R.id.calendarButton);
        for (int i = 0; i < button.length; i++) {
            button[i].setOnClickListener(this);
        }
    }

    //Mengambil semua data
    public void getTimelineData() {
        getTodayTimelineData();
        getTomorrowTimelineData();
        getAfterTomorrowTimelineData();
    }

    //Mengambil data untuk hari ini
    public void getTodayTimelineData() {
        Timeline timeline = new Timeline("16:30", "Apel",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListToday.add(timeline);
        timeline = new Timeline("11:30", "PUBG",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListToday.add(timeline);
        mAdapterToday.notifyDataSetChanged();

    }

    //Mengambil data untuk besok
    public void getTomorrowTimelineData() {
        Timeline timeline = new Timeline("15:30", "Futsal",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListTomorrow.add(timeline);
        timeline = new Timeline("12:30", "Lari",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListTomorrow.add(timeline);
        mAdapterTomorrow.notifyDataSetChanged();
    }

    //Mengambil data untuk lusa
    public void getAfterTomorrowTimelineData() {
        Timeline timeline = new Timeline("09:30", "Renang",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListAfterTomorrow.add(timeline);
        timeline = new Timeline("13:30", "Dota",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineListAfterTomorrow.add(timeline);
        mAdapterAfterTomorrow.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == button[1].getId() || v.getId() == button[1].getId()) {
            Toast.makeText(getApplicationContext(), "Belum ada activitynya mamang",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
