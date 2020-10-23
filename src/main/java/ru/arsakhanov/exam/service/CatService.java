package ru.arsakhanov.exam.service;

import org.springframework.stereotype.Service;
import ru.arsakhanov.exam.entity.Cat;

import ru.arsakhanov.exam.repository.CatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getAllCats(){
        List<Cat> users = new ArrayList<>();
        catRepository.findAll().forEach(users::add);
        return users;
    }

    public Cat getCat(Long id){
        return catRepository.findById(id).orElse(null);
    }


    public void addCat(Cat cat) {
        catRepository.save(cat);
    }


    public void updateCat(Cat cat) {
        catRepository.save(cat);
    }


    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
