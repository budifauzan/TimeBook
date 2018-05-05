package com.example.android.timebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity {
    private List<Timeline> timelineList = new ArrayList<>();
    private RecyclerView recyclerViewToday, recyclerViewTomorrow, recyclerViewAfterTomorrow;
    private TimelineAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);
        recyclerViewToday = findViewById(R.id.recycler_view_today);
        recyclerViewTomorrow = findViewById(R.id.recycler_view_tomorrow);
        recyclerViewAfterTomorrow = findViewById(R.id.recycler_view_after_tomorrow);
        mAdapter = new TimelineAdapter(timelineList);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getApplicationContext());
        recyclerViewToday.setLayoutManager(mLayoutManager1);
        recyclerViewToday.setItemAnimator(new DefaultItemAnimator());
        recyclerViewToday.setAdapter(mAdapter);
        recyclerViewTomorrow.setLayoutManager(mLayoutManager2);
        recyclerViewTomorrow.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTomorrow.setAdapter(mAdapter);
        recyclerViewAfterTomorrow.setLayoutManager(mLayoutManager3);
        recyclerViewAfterTomorrow.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAfterTomorrow.setAdapter(mAdapter);
        getTimelineData();
    }

    public void getTimelineData() {
        Timeline timeline = new Timeline("16:30", "Apel",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineList.add(timeline);
        timeline = new Timeline("16:30", "Apel",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineList.add(timeline);
        timeline = new Timeline("16:30", "Apel",
                "Mbuud", "Filkom",
                "Mbuud and Friends", true, true);
        timelineList.add(timeline);
        mAdapter.notifyDataSetChanged();
    }
}
