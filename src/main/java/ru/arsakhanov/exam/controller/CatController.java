package ru.arsakhanov.exam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.arsakhanov.exam.entity.Cat;
import ru.arsakhanov.exam.service.CatService;

import java.util.List;

@RestController
@RequestMapping("api/exam/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService userService) {
        this.catService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cat> getCats() {
        return catService.getAllCats();
    }

    @RequestMapping(method = RequestMethod.GET, value = {"{id}"})
    @PreAuthorize("hasAuthority('users:read')")
    public Cat getCat(@PathVariable Long id) {
        return catService.getCat(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    @PreAuthorize("hasAuthority('users:write')")
    public void addCat(@RequestBody Cat cat) {
        catService.addCat(cat);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    @PreAuthorize("hasAuthority('users:write')")
    public void updateCat(@RequestBody Cat cat) {
        catService.updateCat(cat);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"{id}"})
    @PreAuthorize("hasAuthority('users:write')")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }
}
