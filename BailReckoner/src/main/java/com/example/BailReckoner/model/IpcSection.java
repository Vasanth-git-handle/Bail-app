package com.example.BailReckoner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FIR_DATASET_1")
public class IpcSection {
    @Id
    private String id;
    private String section;
    private String bailable;

    public IpcSection() {}

    public IpcSection(String section, String bailable) {
        this.section = section;
        this.bailable = bailable;
    }

    public String getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBailable() {
        return bailable;
    }

    public void setBailable(String bailable) {
        this.bailable = bailable;
    }
}
