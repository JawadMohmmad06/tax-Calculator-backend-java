package com.controller;

import com.domain.User;
import com.domain.Variables;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/tax")
public class TaxControll {

    private static final Logger logger = Logger.getLogger(TaxControll.class);
    private TaxService taxService;
    private UserService userService;
    private AdminService adminService;

    public TaxControll(TaxService taxService, UserService userService, AdminService adminService) {
        this.taxService = taxService;
        this.userService=userService;
        this.adminService = adminService;


    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/open")
    public String form(Model model) {
        Variables variables = new Variables();
        model.addAttribute("variables", variables);
        model.addAttribute("yearTax", "");
        model.addAttribute("monthTax", "");
        return "taxCalculator";
    }


    @RequestMapping("/calculator")
    public String calculator(@Valid @ModelAttribute("variables") Variables variables, BindingResult bindingResult, Model model) {






            if(bindingResult.hasErrors())
            {
                return "taxCalculator";
            }
            else
            {
                Variables variables1= taxService.calcu(variables);






                model.addAttribute("ti", variables.getTaxble_income());
                model.addAttribute("yearTax", variables1.getTotal_tax());
                model.addAttribute("monthTax", variables1.getM_tax());
                return "taxCalculator";
            }




    }
    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllLeaveApplications() {
        logger.info("Getting users");
        List<User> variables = userService.getAll();

        return ResponseEntity.ok().body(variables);
    }
    @PostMapping("/regis")
    public ResponseEntity<User> createAuthority(@Valid @RequestBody User user) throws Exception {
        if (user.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        logger.info("Register new user");
        userService.insert(user);
        return ResponseEntity.created(new URI("/history/"+user.getId()))
                .body(user);
    }
//ssss
@CrossOrigin
    @RequestMapping("/history/{id}")
    public ResponseEntity<List<Variables>> gethistory(@PathVariable Long id) {
        logger.info("Getting history");
        List<Variables> variables = taxService.gethistory(id);
        return ResponseEntity.ok().body(variables);

    }
    @RequestMapping("/calcu")
    public ResponseEntity<Variables> createcalcu(@Valid @RequestBody Variables variables) throws Exception {
        if (variables.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        logger.info("calculating");
        taxService.calcu(variables);
        return ResponseEntity.created(new URI("/calcu/"))
                .body(variables);
    }
    @RequestMapping("/update")
    public ResponseEntity<User> updateAuthority(@Valid @RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        logger.info("Profile updating");
        userService.update(user);

        return ResponseEntity.created(new URI("/profile/"+user.getId()))
                .body(user);
    }
    @CrossOrigin
    @RequestMapping("/profile/{id}")
    public ResponseEntity<User> getAuthority(@PathVariable Long id) {
        Optional<User> user = Optional.ofNullable(userService.get(id));
        if (user.isPresent()) {
            logger.info("Getting profile");
            return ResponseEntity.ok().body(user.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @RequestMapping("/delate/{id}")
    public ResponseEntity<Variables> delete(@PathVariable Long id) {
        logger.info("dealiting history");
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
