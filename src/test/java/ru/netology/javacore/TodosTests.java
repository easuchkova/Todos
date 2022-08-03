package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {

    // ваши тесты для класса Todos
    Todos todos = new Todos();
    Todos todosGetAll = new Todos();

    @Test
    public void testAddTask() {
        todos.addTask("Поработать");

        boolean actual = todos.getAllTask().contains("Поработать");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testRemoveTask2() {
        todos.addTask("Поучиться");
        todos.removeTask("Поучиться");

        boolean actual = todos.getAllTask().contains("Поучиться");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testGetAllTask() {
        todosGetAll.addTask("Отдохнуть");
        todosGetAll.addTask("Поучиться");
        todosGetAll.addTask("Поучиться");
        todosGetAll.addTask("Сходить в поход");

        String expected = "Отдохнуть" + " " + "Поучиться" + " " + "Поучиться" + " " + "Сходить в поход" + " ";
    }
}