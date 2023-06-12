package com.controller;
import com.domain.TaxRate;
import com.domain.User;
import com.domain.Variables;
import com.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminControll {
    private static final Logger logger = Logger.getLogger(AdminControll.class);
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    AdminService adminService;
    private UserService userService;
    private TaxService taxService;
    public AdminControll(AdminService adminService, TaxService taxService, UserService userService) {
        this.adminService = adminService;
        this.taxService = taxService;
        this.userService=userService;

    }
    @RequestMapping("/get")
    public ResponseEntity<List<Variables>> getall() {
        List<Variables> variables = adminService.get();
        logger.info("Getting All calculation");

        return ResponseEntity.ok().body(variables);
    }
    @RequestMapping("/update")
    public ResponseEntity<Variables> updateVariables(@Valid @RequestBody Variables variables) throws Exception {
        if (variables.getId() == null) {

        }
        logger.info("updating calculations");
        adminService.update(variables);
        return ResponseEntity.created(new URI("/get/"))
                .body(variables);
    }
    @RequestMapping("/delate/{id}")
    public ResponseEntity<Variables> delete(@PathVariable Long id) {
        adminService.delete(id);
        logger.info("Delating calculation");
        return ResponseEntity.noContent().build();
    }
    @RequestMapping("/get/{id}")
    public ResponseEntity<Variables> getid(@PathVariable Long id) {
        Optional<Variables> variables = Optional.ofNullable(adminService.getid(id));
        logger.info("Getting  calculation by id");
            return ResponseEntity.ok().body(variables.get());


    }
    @RequestMapping("/getrate")
    public ResponseEntity<TaxRate> getrate() {
        Optional<TaxRate> taxRate = Optional.ofNullable(taxService.gettaxrate());
        logger.info("Getting Tax rate");
        return ResponseEntity.ok().body(taxRate.get());


    }
    @RequestMapping("/updatet")
    public ResponseEntity<TaxRate> updaterate(@Valid @RequestBody TaxRate taxRate) throws Exception {
        if (taxRate.getId() == null) {

        }
        logger.info("updating tax rate");
        taxService.updatet(taxRate);
        return ResponseEntity.created(new URI("/get/"))
                .body(taxRate);
    }
    @RequestMapping("/users")
    public ResponseEntity<List<User>> users() {
        List<User> users = userService.getAll();
        logger.info("Getting All users");

        return ResponseEntity.ok().body(users);
    }



}
