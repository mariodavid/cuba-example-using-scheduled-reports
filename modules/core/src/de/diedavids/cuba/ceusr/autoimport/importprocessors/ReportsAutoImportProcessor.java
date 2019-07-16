package de.diedavids.cuba.ceusr.autoimport.importprocessors;

import com.haulmont.addon.admintools.core.auto_import.processors.AutoImportProcessor;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.reports.app.service.ReportService;
import java.io.InputStream;
import javax.inject.Inject;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Component;

@Component("ceusr_ReportsAutoImportProcessor")
public class ReportsAutoImportProcessor implements AutoImportProcessor {

    @Inject
    protected ReportService reportService;
    @Inject
    protected Resources resources;

    @Override
    public void processFile(String filePath) throws Exception {
        try (InputStream inputStream = resources.getResourceAsStream(filePath)) {
            byte[] fileBytes = IOUtils.toByteArray(inputStream);
            reportService.importReports(fileBytes);
        }
    }
}