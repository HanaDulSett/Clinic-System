package com.utem.project.cas.controller;

import com.utem.project.cas.model.Appointment;
import com.utem.project.cas.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class ApiController {

    private final AppointmentService appointmentService;

    public ApiController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{icNo}")
    public ResponseEntity<?> getAppointmentByIC(@PathVariable String icNo) {
        Appointment appointment = appointmentService.getAppointmentByIC(icNo);
        if (appointment == null) {
            String message = "No appointment found for IC number: " + icNo;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else {
            return ResponseEntity.ok(appointment);
        }
    }
}
