package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/watchCars")
public class WatchingCars extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        try {
            CarManager.showCars(writer);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
