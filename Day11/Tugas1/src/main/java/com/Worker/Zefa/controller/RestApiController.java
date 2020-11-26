package com.Worker.Zefa.controller;

import com.Worker.Zefa.model.Staff;
import com.Worker.Zefa.service.WorkerService;
import com.Worker.Zefa.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestAPI --> Route to WorketService
//or Mapping
//to access must include /api
@RestController
@RequestMapping("/api")
public class RestApiController {
    //Instance logger
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired //autoroute to WorkerService
    WorkerService staffService; //staffService as WorkerService

    //Do Action With Mapping... Use /worker/

    // -------------------Retrieve All Staff--------------------------------------------
    @RequestMapping(value = "/worker/", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> listAllStaff() {
        List<Staff> staff = staffService.findAllStaff();
        if (staff.isEmpty()) {
            return new ResponseEntity<>(staff, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    // -------------------Retrieve Single Staff------------------------------------------
    @RequestMapping(value = "/worker/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStaff(@PathVariable("id") Long id) {
        logger.info("Fetching Staff with id {}", id);
        Staff staff = staffService.findById(id);
        if (staff == null) {
            logger.error("Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Staff with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    // -------------------Create a Staff-------------------------------------------
    @RequestMapping(value = "/worker/", method = RequestMethod.POST)
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        logger.info("Creating Staff : {}", staff);
        if (staffService.isStaffExist(staff)) {
            logger.error("Unable to create. A Staff with name {} already exist", staff.getNama());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Staff with name " +
                    staff.getNama() + " already exist."), HttpStatus.CONFLICT);
        }
        staffService.saveStaff(staff);

        return new ResponseEntity<>(staff, HttpStatus.CREATED);
    }

    // ------------------- Update a Staff ------------------------------------------------
    @RequestMapping(value = "/worker/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff) {
        logger.info("Updating Staff with id {}", id);

        Staff currentStaff = staffService.findById(id);

        if (currentStaff == null) {
            logger.error("Unable to update. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentStaff.setNama(staff.getNama());

        staffService.updateStaff(currentStaff);
        return new ResponseEntity<>(currentStaff, HttpStatus.OK);
    }

    // ------------------- Delete a Staff-----------------------------------------
    @RequestMapping(value = "/worker/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStaff(@PathVariable("id") Long id) {
        logger.info("Fetching & Deleting Staff with id {}", id);

        Staff staff = staffService.findById(id);
        if (staff == null) {
            logger.error("Unable to delete. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        staffService.deleteStaffById(id);
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Staff-----------------------------
    @RequestMapping(value = "/worker/", method = RequestMethod.DELETE)
    public ResponseEntity<Staff> deleteAllStaff() {
        logger.info("Deleting All Staff");
        staffService.deleteAllStaff();
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }
}
