package by.it_academy.jd2.mk_jd2_111_25_7;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResultServlet extends HttpServlet {
    private final DataStorage dataStorage = DataStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Map<String, Integer> performers = dataStorage.getPerformers();
        Map<String, Integer> genres = dataStorage.getGenres();
        List<String> aboutTexts = dataStorage.getAboutTexts();

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang='en'>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");
        html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        html.append("<title>Результаты голосования</title>");
        html.append("</head>");
        html.append("<body>");
        html.append("<h1>Результаты голосования</h1>");

        html.append("<h2>Лучшие исполнители:</h2>");
        performers.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    html.append("<p>").append(entry.getKey()).append(": ")
                            .append(entry.getValue()).append(" голосов</p>");
                });

        // Вывод жанров
        html.append("<h2>Любимые жанры:</h2>");
        genres.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    html.append("<p>").append(entry.getKey()).append(": ")
                            .append(entry.getValue()).append(" выборов</p>");
                });

        // Вывод комментариев
        html.append("<h2>Тексты пользователей:</h2>");
        aboutTexts.forEach(text -> html.append("<p>").append(text).append("</p>"));

        html.append("</body>");
        html.append("</html>");

        resp.getWriter().write(html.toString());
    }
}
