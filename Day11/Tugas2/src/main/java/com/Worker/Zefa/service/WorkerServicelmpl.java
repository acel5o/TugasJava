package com.Worker.Zefa.service;

import com.Worker.Zefa.model.Staff;
import com.Worker.Zefa.util.ConnManager;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

@Service("workerService")
public class WorkerServicelmpl implements WorkerService {

    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Long, Staff> staffs = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    public Staff findById(Long id) {
        try {
            ConnManager conn = new ConnManager();
            Connection con = conn.Conn();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE id='"+id+"'");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5) + " " +
                        rs.getString(6) + " " +
                        rs.getString(7));
        }catch (Exception e){
            System.out.println(e);
        }
        return staffs.get(id);
    }

    public Staff findByName(String name) {
        if (idNameHashMap.get(name) != null){
            try {
                ConnManager conn = new ConnManager();
                Connection con = conn.Conn();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE nama='"+name+"'");
                while (rs.next())
                    System.out.println(rs.getInt(1) + " " +
                            rs.getString(2) + " " +
                            rs.getString(3) + " " +
                            rs.getString(4) + " " +
                            rs.getString(5) + " " +
                            rs.getString(6) + " " +
                            rs.getString(7));
            }catch (Exception e){
                System.out.println(e);
            }
            return staffs.get(idNameHashMap.get(name));
        }
        return null;
    }

    public void saveStaff(Staff staff){
        staffs.put(staff.getId(), staff);
        idNameHashMap.put(staff.getNama(), staff.getId());
            try {//  Critical section synchronized
                ConnManager conn = new ConnManager();
                Connection con = conn.Conn();
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO `staff` (`id`, `nama`,`email`, `absen`, `makan`, `pulsa`, `gapok`) VALUES " +
                        "('"+staff.getId()+"', '"+staff.getNama()+"', '"+staff.getEmail()+"', '"+staff.getAbsen()+"', '"+staff.getMakan()+"', '"+staff.getPulsa()+"', '"+staff.getGapok()+"');");
                stmt.close();
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
    }

    public void updateStaff(Staff staff) {
        staffs.put(staff.getId(), staff);
        idNameHashMap.put(staff.getNama(), staff.getId());
        try {//  Critical section synchronized
            ConnManager conn = new ConnManager();
            Connection con = conn.Conn();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `staff` SET `nama` = '"+staff.getNama()+"',`email` = '"+staff.getEmail()+"', `absen` = '"+
                    staff.getAbsen()+"', `makan` = '"+staff.getMakan()+"', `pulsa` = "+staff.getPulsa()+", `gapok` " +
                    "= "+staff.getGapok()+" WHERE `id` = "+staff.getId()+"");
            stmt.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteStaffById(Long id) {
            idNameHashMap.remove(staffs.get(id).getNama());
            staffs.remove(id);
            try {//  Critical section synchronized
                ConnManager conn = new ConnManager();
                Connection con = conn.Conn();
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM staff WHERE id="+staffs.get(id)+"");
                stmt.close();
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
    }

    @Override
    public List<Staff> findAllStaff() {
        try {
            ConnManager conn = new ConnManager();
            Connection con = conn.Conn();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5) + " " +
                        rs.getString(6) + " " +
                        rs.getString(7));
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>(staffs.values());
    }

    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }

    public void deleteAllStaff() {
        staffs.clear();
        try {//  Critical section synchronized
            ConnManager conn = new ConnManager();
            Connection con = conn.Conn();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM staff");
            stmt.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
