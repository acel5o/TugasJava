package com.Worker.Zefa.service;

import com.Worker.Zefa.model.Staff;

import java.util.List;

public interface WorkerService { //interface --> inherit to WorkerServicelmpl
    Staff findById(Long id);

    Staff findByName(String name);

    void saveStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaffById(Long id);

    List<Staff> findAllStaff();

    void deleteAllStaff();

    boolean isStaffExist(Staff staff);
}
