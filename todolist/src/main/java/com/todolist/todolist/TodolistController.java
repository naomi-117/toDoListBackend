package com.todolist.todolist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        allTasks.forEach(task -> System.out.println("Task: " + task.getDescription() + ", Priority: " + task.getPriority()));
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto){
        System.out.println("Received Task: " + taskDto.getDescription() + ", Priority: " + taskDto.getPriority());
        Task addedTask = todolistService.addTask(taskDto);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDto taskDto) {
        Task updatedTask = todolistService.updateTask(taskId, taskDto);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long taskId) {
        Task existingTask = todolistService.getTask(taskId);
        if (existingTask != null) {
            todolistService.deleteTask(taskId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
