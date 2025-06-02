package by.it_academy.jd2.mk_jd2_111_25_7;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class VoteServlet extends HttpServlet {
    private final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String singer = req.getParameter("singer");
        String[] selectedGenres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        if (selectedGenres == null || selectedGenres.length < 3 || selectedGenres.length > 5) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Ошибка: выберите от 3 до 5 жанров.");
            return;
        }

        dataStorage.addVote(singer, selectedGenres, about);
        resp.sendRedirect("result");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("form.html");
    }
}
