package com.example.android.timebook;

import java.util.Date;

/**
 * Created by Mbuud on 05-May-18.
 */

public class Timeline {
    private String namaKegiatan, pembuatKegiatan, lokasiKegiatan, partisipan, waktu;
    private boolean check, mute;

    public Timeline(String waktu, String namaKegiatan, String pembuatKegiatan, String lokasiKegiatan,
                    String partisipan, boolean check, boolean mute) {
        this.waktu = waktu;
        this.namaKegiatan = namaKegiatan;
        this.pembuatKegiatan = pembuatKegiatan;
        this.lokasiKegiatan = lokasiKegiatan;
        this.partisipan = partisipan;
        this.check = check;
        this.mute = mute;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public String getPembuatKegiatan() {
        return pembuatKegiatan;
    }

    public String getLokasiKegiatan() {
        return lokasiKegiatan;
    }

    public String getPartisipan() {
        return partisipan;
    }

    public String getWaktu() {
        return waktu;
    }

    public boolean isCheck() {
        return check;
    }

    public boolean isMute() {
        return mute;
    }
}
