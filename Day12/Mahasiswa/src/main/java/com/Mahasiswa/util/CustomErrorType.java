package com.Mahasiswa.util;

public class CustomErrorType {//buat class yang digunakan untuk return response error message
    private String errorMessage;//buat variabel errormessage

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }//buat constructor

    public String getErrorMessage() {
        return errorMessage;
    }//buat method getter dari variabel errormessage
}