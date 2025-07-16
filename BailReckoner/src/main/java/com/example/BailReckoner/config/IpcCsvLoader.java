package com.example.BailReckoner.config;

import com.example.BailReckoner.model.IpcSection;
import com.example.BailReckoner.repository.IpcSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Configuration
public class IpcCsvLoader implements CommandLineRunner {

    @Autowired
    private IpcSectionRepository repository;

    @Override
    public void run(String... args) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getResourceAsStream("/FIR_DATASET_1.csv"), StandardCharsets.UTF_8))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                if (header) { header = false; continue; }
                String[] data = line.split(",", -1);
                if (data.length >= 2) {
                    IpcSection section = new IpcSection();
                    section.setSection(data[0].trim());
                    section.setBailable(data[1].trim());
                    repository.save(section);
                }
            }
            System.out.println("✅ IPC data loaded into MongoDB.");
        }
    }
}
