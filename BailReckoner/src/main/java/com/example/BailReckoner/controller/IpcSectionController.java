package com.example.BailReckoner.controller;

import com.example.BailReckoner.model.IpcSection;
import com.example.BailReckoner.repository.IpcSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ipc")
@CrossOrigin(origins = "http://localhost:3000")
public class IpcSectionController {

    @Autowired
    private IpcSectionRepository repository;

    @GetMapping("/{section}")
    public String getBailableStatus(@PathVariable String section) {
        List<IpcSection> results = repository.findBySection(section);
        if (results.isEmpty()) {
            return "❌ Section not found or server error.";
        }
        // Assuming you only care about the first match
        return "✅ Section " + section + " is " + results.get(0).getBailable();
    }
}
