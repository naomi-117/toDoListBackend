package com.todolist.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodolistService {
    @Autowired
    private TodolistRepository todolistRepository;

    public List<Task> findAll() {
        return todolistRepository.findAll();
    }

    // public Task findByDescription(String description) {
    //     todolist.getTask(description);
    //     todolist.getDone();
    //     return todolistRepository.findByDescription();
    // }

    public Task addTask(TaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDone(taskDto.getDone());
        return todolistRepository.save(task);
        // return task;
    }
}   
