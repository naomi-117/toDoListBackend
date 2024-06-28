package com.todolist.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist")
@CrossOrigin(origins = "http://localhost:4200")
public class TodolistController {
    @Autowired
    private TodolistService todolistService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> allTasks = todolistService.findAll();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    //@GetMapping("/{description}")
    // public ResponseEntity<Todolist> findByDescription(@PathVariable String description){
    //     Todolist todolist = todolistService.findByDescription(description);
    //     return ResponseEntity.ok(todolist);
    //}

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto){
        Task addedTask = todolistService.addTask(taskDto);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }
}
