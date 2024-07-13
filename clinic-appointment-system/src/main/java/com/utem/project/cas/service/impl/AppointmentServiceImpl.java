package com.utem.project.cas.service.impl;

import com.utem.project.cas.model.Appointment;
import com.utem.project.cas.repository.AppointmentRepository;
import com.utem.project.cas.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment getAppointmentByIC(String icNo) {
        return appointmentRepository.findByIcNo(icNo);
    }
}
