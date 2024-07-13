package com.utem.project.cas.controller;

import com.utem.project.cas.model.Appointment;
import com.utem.project.cas.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/check-appointment")
public class CheckAppointmentController {

    private final AppointmentService appointmentService;

    public CheckAppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String showCheckAppointmentForm() {
        return "checkappointmentform"; // Assuming this is the name of your Thymeleaf template for the form
    }

    @PostMapping("/check")
    public String checkAppointmentByIC(@RequestParam("icNo") String icNo, Model model) {
        Appointment appointment = appointmentService.getAppointmentByIC(icNo);
        if (appointment == null) {
            model.addAttribute("message", "No appointment found for IC number: " + icNo);
            return "checkappointmentform"; // Return to the form with the error message
        } else {
            model.addAttribute("appointment", appointment);
            return "appointmentdetails"; // Display appointment details
        }
    }
}
