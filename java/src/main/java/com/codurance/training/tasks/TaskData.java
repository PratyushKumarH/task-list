package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskData {
    public Map<String, List<Task>> tasks;
    public long lastId;

    public PrintWriter out;

    public TaskData() {
        out = new PrintWriter(System.out);
        tasks = new LinkedHashMap<>();
        lastId = 0;
    }
}
