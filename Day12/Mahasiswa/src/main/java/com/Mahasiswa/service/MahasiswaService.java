package com.Mahasiswa.service;

import com.Mahasiswa.model.Details;
import com.Mahasiswa.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

    int saveMhs(Mahasiswa mahasiswa);
    int saveDetail(Details detail, Long idmhs);
    int updateMhs(Mahasiswa mahasiswa);
    int updateDetail(Details detail);
    int tambahAbsen(Long id);
    List<Mahasiswa> findById(Long id);
    List<Mahasiswa> findAllMhs();
    List<Mahasiswa> findMhsByName(String name);
    List<Details> findAllDetail();
    List<Details> findByIdDetail(Long idmhs);
    boolean isMhsExist(Mahasiswa mahasiswa);
    boolean isDetailExist(Details detail);
}
