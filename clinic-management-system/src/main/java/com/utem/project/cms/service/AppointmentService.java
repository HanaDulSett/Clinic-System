package com.utem.project.cms.service;

import com.utem.project.cms.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    Appointment saveOrUpdateAppointment(Appointment appointment);

    void deleteAppointment(Long id);
}
