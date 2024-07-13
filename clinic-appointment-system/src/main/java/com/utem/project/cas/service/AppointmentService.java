package com.utem.project.cas.service;

import com.utem.project.cas.model.Appointment;

public interface AppointmentService {

    Appointment getAppointmentByIC(String icNo);

}
