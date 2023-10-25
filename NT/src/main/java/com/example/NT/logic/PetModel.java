package com.example.NT.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel() {
        model = new HashMap<>();
    }

    public static PetModel getInstance() {
        return instance;
    }

    public void add(Pet pet, int id) {
        model.put(id, pet);
    }

    public Pet getFromList(int id) {
        return model.get(id);
    }

    public Map<Integer, Pet> getAll() {
        return model;
    }

    public void update(int id, Pet pet) {
        Pet updatedPet = model.get(id);

        updatedPet.setName(pet.getName());
        updatedPet.setAge(pet.getAge());
        updatedPet.setType(pet.getType());

        model.replace(id, updatedPet);
    }

    public void delete(int id) {
        model.remove(id);
    }
}
