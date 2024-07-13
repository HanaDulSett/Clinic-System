package com.utem.project.cms.controller;

import com.utem.project.cms.model.Appointment;
import com.utem.project.cms.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class WebAppointmentController {

    private final AppointmentService appointmentService;

    public WebAppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String getAllAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @GetMapping("/new")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointmentform-create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            // Handle not found case
            return "redirect:/appointments";
        }
        model.addAttribute("appointment", appointment);
        return "appointmentform-edit";
    }

    @PostMapping
    public String saveOrUpdateAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.saveOrUpdateAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
