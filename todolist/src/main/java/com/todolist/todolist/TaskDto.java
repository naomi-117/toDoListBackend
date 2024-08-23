package com.todolist.todolist;

import java.util.Date;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskDto {
    private String description;
    private boolean done;
    private String priority;
    private Date deadline;

    public boolean getDone() {
        return done;
    }
}
