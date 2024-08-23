package com.todolist.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodolistRepository extends JpaRepository<Task, Long> {

}