package com.example.android.timebook;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mbuud on 05-May-18.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.MyViewHolder> {

    private List<Timeline> timelineList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKegiatan, pembuatKegiatan, lokasiKegiatan, partisipan, waktu;

        public MyViewHolder(View view) {
            super(view);
            namaKegiatan = (TextView) view.findViewById(R.id.namaKegiatan);
            pembuatKegiatan = (TextView) view.findViewById(R.id.pembuatKegiatan);
            lokasiKegiatan = (TextView) view.findViewById(R.id.lokasiKegiatan);
            partisipan = (TextView) view.findViewById(R.id.partisipan);
            waktu = (TextView) view.findViewById(R.id.waktu);
        }

    }

    public TimelineAdapter(List<Timeline> timelineList) {
        this.timelineList = timelineList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timeline_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Timeline timeline = timelineList.get(position);
        holder.namaKegiatan.setText(timeline.getNamaKegiatan());
        holder.lokasiKegiatan.setText(timeline.getLokasiKegiatan());
        holder.partisipan.setText(timeline.getPartisipan());
        holder.pembuatKegiatan.setText(timeline.getPembuatKegiatan());
        holder.waktu.setText(timeline.getWaktu());
    }

    @Override
    public int getItemCount() {
        return timelineList.size();
    }
}