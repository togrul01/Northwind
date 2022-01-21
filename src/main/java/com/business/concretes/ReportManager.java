package com.business.concretes;

import com.dataAccess.abstracts.ProductDao;
import com.entities.concretes.Product;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportManager {

    private final ProductDao dao;

    @Autowired
    public ReportManager(ProductDao dao) {
        this.dao = dao;
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\Togrul\\Desktop\\Report";
        List<Product> products = dao.findAll();
        File file = ResourceUtils.getFile("classpath:product.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Product");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if ((reportFormat.equalsIgnoreCase("html"))) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\product.html");
        }
        if ((reportFormat.equalsIgnoreCase("pdf"))) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\product.pdf");
        }
        return "report generated in path :" + path;
    }
}
