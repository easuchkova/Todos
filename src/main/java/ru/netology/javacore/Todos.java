package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> list = new ArrayList<>();

    public void addTask(String task) {
        list.add(task);
    }

    public void removeTask(String task) {
        list.remove(task);
    }

    public String getAllTask() {
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}