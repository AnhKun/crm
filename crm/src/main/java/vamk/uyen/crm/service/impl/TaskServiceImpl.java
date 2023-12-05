package vamk.uyen.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vamk.uyen.crm.converter.Converter;
import vamk.uyen.crm.dto.response.TaskResponse;
import vamk.uyen.crm.repository.TaskRepository;
import vamk.uyen.crm.entity.TaskEntity;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;
    public Iterable<TaskResponse> getAllTasks(){
       return Converter.toList(taskRepository.findAll(), TaskResponse.class);
    }
}
