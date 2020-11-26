package com.Worker.Zefa.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Staff extends Worker{
    private static AtomicLong counter = new AtomicLong();
    private String email;
    private int makan= 100000;

    public Staff() {
        this.id = counter.incrementAndGet();
    }//AutoIncrement ID
    //getter setter...
    public Long getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String name) {
        this.nama = name;
    }

    public int getAbsen() {
        return this.absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }

    public int getGapok() {
        return gapok;
    }

    public void setGapok(int gapok) {
        this.gapok = gapok;
    }

    public int getPulsa() {
        return pulsa;
    }

    public void setPulsa(int pulsa) {
        this.pulsa = pulsa;
    }

    public int getMakan() {
        return makan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void Makan(Long id) {
        if (id == this.id){
            this.makan = makan * this.absen;
        }
    }

    //for logger
    @Override
    public String toString() {
        return "Staff [id=" + this.id + ", nama=" + this.nama + ", absen=" + this.absen
                + ", tunjangan_pulsa=" + this.pulsa + ", tunjangan_makan="
                + this.makan + ", gaji_pokok=" + this.gapok + "]";
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Staff other = (Staff) obj;
//        if (this.id != other.id)
//            return false;
//        return true;
//    }
//
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (int) (this.id ^ (this.id >>> 32));
//        return result;
//    }
}