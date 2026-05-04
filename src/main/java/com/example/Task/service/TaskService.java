package com.example.Task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.repository.TaskRepository;
import com.example.Task.entity.Task;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //一覧取得
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    //id取得
    public Task findById(Long id){
        return taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("タスクが見つかりません" + id));
    }

    //保存
    public void save(Task task){
        taskRepository.save(task);
    }

    //削除
    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
