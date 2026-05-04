package com.example.Task.service;

import com.example.Task.entity.Task;
import com.example.Task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;
    
    @InjectMocks
    TaskService taskService;

    @Test    
    void 存在しないIDを渡したら例外が発生する(){
        when(taskRepository.findById(999l)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.findById(999L);
        });
    }
}
