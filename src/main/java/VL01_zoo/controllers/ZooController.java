package VL01_zoo.controllers;

import VL01_zoo.RandomAnimalClient;
import VL01_zoo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {
    @Autowired
    private RandomAnimalClient randomAnimalClient;

    @GetMapping("/animals/any")
    ResponseEntity<Animal> seeAnyAnimal(){
//        return new ResponseEntity<Animal>(new Animal("vl test"), HttpStatus.OK);
        return randomAnimalClient.random();
    }
}
