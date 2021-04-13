package com.example.library_system.controller;

import com.example.library_system.entity.Customer;
import com.example.library_system.entity.Library;
import com.example.library_system.service.implementation.GetServiceImpl;
import com.example.library_system.service.implementation.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    GetServiceImpl getService;

    @GetMapping("")
    public List<Library> getAllLibraries() {
        return getService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable("id") Long id) {
        return getService.getLibraryById(id).get();
    }

    @PostMapping("")
    public void addLibrary(@RequestBody Library library) {
        postService.addLibrary(library);
    }

    @PutMapping("/{id}")
    public void updateLibrary(@PathVariable Long id,
                               @RequestBody Library library) {
        library.setId(id);
        postService.updateLibrary(id, library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable("id") Long id) {
        postService.deleteLibrary(id);
    }

    @GetMapping("/book/{id}")
    public List<Library> getLibrariesByBookId(@PathVariable("id") Long id) {
        return getService.getLibrariesByBookId(id);
    }
}
