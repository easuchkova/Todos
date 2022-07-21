package ru.netology.javacore;

import com.google.gson.Gson;

import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    static class Request {
        String type;
        String task;

        public Request(String type, String task) {
            this.type = type;
            this.task = task;
        }

        @Override
        public String toString() {
            return "type = " + type + ", task = " + task;
        }
    }

    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String json = in.readLine();
                    Request request = new Gson().fromJson(json, Request.class);

                    switch (request.type) {
                        case "ADD":
                            todos.addTask(request.task);
                            System.out.println("Задача " + request.task + " добавлена");
                            break;

                        case "REMOVE":
                            todos.removeTask(request.task);
                            System.out.println("Задача " + request.task + " удалена");
                            break;
                    }
                    out.println(todos.getAllTask());
                } catch (IIOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
