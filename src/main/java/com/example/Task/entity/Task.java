package com.example.Task.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private String status; //"未着手"”進行中””完了”
    private LocalDate dueDate;//締切日

    // -- getter / setter --

    public Long getId(){ return id;}
    public void setId(Long id){ this.id = id;}

    public String getTitle(){ return title;}
    public void setTitle(String title){ this.title = title;}

    public String getDescription(){return description; }
    public void setDescription(String description){this.description = description;}

    public String getStatus(){ return status;}
    public void setStatus(String status){ this.status = status;}

    public LocalDate getDueDate(){return dueDate;}
    public void setDueDate(LocalDate dueDate){this.dueDate = dueDate;}
}
