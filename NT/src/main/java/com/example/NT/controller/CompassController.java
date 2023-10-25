package com.example.NT.controller;

import com.example.NT.logic.CompassModel;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CompassController {
    private static final CompassModel compassModel = CompassModel.getInstance();



    @GetMapping(value = "/compass", consumes = "application/json", produces = "application/json")
    public Map<String, String> compass(@RequestBody Map<String, Integer> degree) {
        return compassModel.side(degree.get("degree"));

    }
}
