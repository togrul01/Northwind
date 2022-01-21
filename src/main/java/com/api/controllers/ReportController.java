package com.api.controllers;

import com.business.concretes.ReportManager;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class ReportController {
    @Autowired
    private ReportManager reportManager;

    public ReportController(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportManager.exportReport(format);
    }
}
