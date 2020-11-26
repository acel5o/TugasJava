package com.Worker.Zefa.model;

public abstract class Worker{ //abstract class worker
    Long id;
    String nama;
    int absen = 20;
    int gapok = 3000000;
    int pulsa = 50000;

    //method abstract
    public abstract String getNama();
    public abstract Long getId();
    public abstract int getAbsen();
}

