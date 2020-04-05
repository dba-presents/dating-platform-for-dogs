package com.dbapresents.datingplatform.breed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/breeds")
public class BreedController {

    private final BreedRepository breedRepository;

    @Autowired
    private BreedController(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Breed>> getBreeds() {
        return ResponseEntity.ok(breedRepository.findAll());
    }

}
