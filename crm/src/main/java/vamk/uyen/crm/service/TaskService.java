package vamk.uyen.crm.service;

import org.springframework.stereotype.Service;
import vamk.uyen.crm.dto.response.TaskResponse;

@Service
public interface TaskService {
    Iterable<TaskResponse> getAllTasks();
}
