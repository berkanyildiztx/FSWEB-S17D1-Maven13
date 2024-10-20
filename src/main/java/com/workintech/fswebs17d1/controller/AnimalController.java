package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private final Map<Integer, Animal> animals = new HashMap<>();

    public AnimalController() {

        // animals.put(1, new Animal(1, "Cat"));
        // animals.put(2, new Animal(2, "Dog"));
        // animals.put(3, new Animal(3, "Horse"));
    }
    @GetMapping()
    public List<Animal> listAnimals() {

        List<Animal> animalList = new ArrayList<>(animals.values());

        return animalList;
    }

    @GetMapping("{id}")
    public Animal getAnimalById(@PathVariable("id") Integer id) {

        return animals.get(id);
    }

    @PostMapping()
    public void addAnimal(@RequestBody Animal animal) {

        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimalById(@PathVariable("id") Integer id, @RequestBody Animal animal) {

        return animals.put(id, animal);
    }

    @DeleteMapping("{id}")
    public Animal deleteAnimalById(@PathVariable("id") Integer id) {

        return animals.remove(id);
    }
}
