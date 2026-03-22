package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.HealthRecordForm;
import com.example.demo.dto.TriageResult;
import com.example.demo.service.TriageService;



@Controller
public class TriageController {
	 private final TriageService triageService;

	    public TriageController(TriageService triageService) {
	        this.triageService = triageService;
	    }

	    @GetMapping("/triage")
	    public String showForm(Model model) {
	        model.addAttribute("healthRecordForm", new HealthRecordForm());
	        return "triage-form";
	    }

	    @PostMapping("/triage")
	    public String evaluate(HealthRecordForm form, Model model) {
	        TriageResult result = triageService.evaluate(form);
	        model.addAttribute("result", result);
	        return "triage-result";
	    }
}
