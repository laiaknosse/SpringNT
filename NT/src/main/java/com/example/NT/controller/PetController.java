package com.example.NT.controller;


import com.example.NT.logic.Pet;
import com.example.NT.logic.PetModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class PetController {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);


    @PostMapping(value = "/createPet", consumes = "application/json;charset=utf-8")
    public String createCat(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        return "Pet named " + pet.getName() + " successfully created";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet pet) {
        petModel.update(id, pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping(value = "/deletePet/{id}", consumes = "application/json")
    public void deletePet(@PathVariable int id) {
        petModel.delete(id);
    }




}
