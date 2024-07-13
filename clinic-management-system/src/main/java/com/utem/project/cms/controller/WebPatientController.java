package com.utem.project.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utem.project.cms.model.Patient;
import com.utem.project.cms.service.PatientService;

@Controller
@RequestMapping("/patients")
public class WebPatientController {

    private final PatientService patientService;

    public WebPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }

    @GetMapping("/new")
    public String createPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "create_patient";
    }

    @PostMapping
    public String savePatient(@ModelAttribute("patient") Patient patient, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (patientService.isDuplicateIcNo(patient.getIcNo())) {
            bindingResult.rejectValue("icNo", "error.patient", "IC Number already exists");
            return "create_patient";
        }
        
        patientService.savePatient(patient);
        redirectAttributes.addFlashAttribute("successMessage", "Patient added successfully");
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String editPatientForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "edit_patient";
    }

    @PostMapping("/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes) {
        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setName(patient.getName());
        existingPatient.setIcNo(patient.getIcNo());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setEmail(patient.getEmail());

        patientService.updatePatient(existingPatient);
        redirectAttributes.addFlashAttribute("successMessage", "Patient updated successfully");
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }
}
