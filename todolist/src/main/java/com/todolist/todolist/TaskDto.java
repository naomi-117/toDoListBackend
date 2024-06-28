package com.todolist.todolist;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskDto {
    private String description;
    private boolean done;

    public boolean getDone() {
        return done;
    }
}
