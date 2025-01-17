package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.dto.UserDto;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.Appointment;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.ReachOut;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.AppointmentService;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.ReachOutService;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {


    private final AppointmentService appointmentService;
//    private final UserService userService;

     @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/appointment")
    public String appointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointments";
    }

    @PostMapping("/appointment")
    public String submitAppointmentForm(@ModelAttribute Appointment appointment) {
       appointmentService.saveAppointment(appointment);
        return "redirect:/appointment?success";
    }

    @GetMapping("/appointmentsList")
    public String showAllAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.findAllAppointments());
        return "appointmentsList";
    }

}
