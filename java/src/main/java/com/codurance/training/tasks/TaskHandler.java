package com.codurance.training.tasks;

import com.codurance.training.tasks.service.TaskInfoService;
import com.codurance.training.tasks.service.TaskService;
import com.codurance.training.tasks.service.impl.TaskInfoServiceImpl;
import com.codurance.training.tasks.service.impl.TaskServiceImpl;

import java.io.PrintWriter;

class TaskHandler {


    private final TaskService taskService;
    private final TaskInfoService taskInfoService;

    public TaskHandler() {
        this.taskService = new TaskServiceImpl();
        this.taskInfoService = new TaskInfoServiceImpl();
    }
    public void execute(String commandLine, PrintWriter out) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case TaskConstant.SHOW:
                taskInfoService.show(out);
                break;
            case TaskConstant.ADD:
                taskService.add(out, commandRest[1]);
                break;
            case TaskConstant.CHECK:
                taskService.check(out, commandRest[1]);
                break;
            case TaskConstant.UNCHECK:
                taskService.uncheck(out, commandRest[1]);
                break;
            case TaskConstant.HELP:
                taskInfoService.help(out);
                break;
            case TaskConstant.DEADLINE:
                taskService.addDeadline(out, commandRest[1]);
                break;
            case TaskConstant.TODAY:
                taskInfoService.showDueToday(out);
                break;
            case TaskConstant.DELETE:
                taskService.delete(out, commandRest[1]);
                break;
            case TaskConstant.VIEW:
                taskInfoService.view(out, commandRest[1]);
                break;
            default:
                taskInfoService.error(out, command);
                break;
        }
    }
}
