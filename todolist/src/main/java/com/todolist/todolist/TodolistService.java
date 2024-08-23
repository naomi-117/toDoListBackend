package com.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodolistService {
    @Autowired
    private TodolistRepository todolistRepository;

    // Retrieve all tasks sorted by ID in ascending order
    public List<Task> findAll() {
        return todolistRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // Add a new task 
    public Task addTask(TaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDone(taskDto.getDone());
        task.setPriority(taskDto.getPriority());
        task.setDeadline(taskDto.getDeadline());
        return todolistRepository.save(task);
    }

    // Retrieve a task by ID
    public Task getTask(Long taskId) {
        return todolistRepository.findById(taskId).orElse(null);
    }

    // Delete a task by ID
    public void deleteTask(Long taskId) {
        todolistRepository.deleteById(taskId);
    }

    // Update a task by ID
    public Task updateTask(Long taskId, TaskDto taskDto) {
        Task task = getTask(taskId);
        if (task != null) {
            task.setDescription(taskDto.getDescription());
            task.setDone(taskDto.getDone());
            task.setPriority(taskDto.getPriority());
            task.setDeadline(taskDto.getDeadline());
            return todolistRepository.save(task);
        }
        return null;
    }
}   
