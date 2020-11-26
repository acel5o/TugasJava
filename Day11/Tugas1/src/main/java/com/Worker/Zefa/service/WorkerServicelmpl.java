package com.Worker.Zefa.service;

import com.Worker.Zefa.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("workerService")
public class WorkerServicelmpl implements WorkerService {

    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Long, Staff> staffs = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    public Staff findById(Long id) {
        return staffs.get(id);
    }

    public Staff findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return staffs.get(idNameHashMap.get(name));
        }
        return null;
    }

    public void saveStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getNama(), staff.getId());
        }
    }

    public void updateStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getNama(), staff.getId());
        }
    }

    public void deleteStaffById(Long id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(staffs.get(id).getNama());
            staffs.remove(id);
        }
    }

    @Override
    public List<Staff> findAllStaff() {
        return new ArrayList<>(staffs.values());
    }

    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }

    public void deleteAllStaff() {
        staffs.clear();
    }
}
