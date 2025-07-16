package com.example.BailReckoner.repository;

import com.example.BailReckoner.model.IpcSection;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IpcSectionRepository extends MongoRepository<IpcSection, String> {
    List<IpcSection> findBySection(String section);
}
