package by.it_academy.jd2.mk_jd2_111_25_7.servlet;

import by.it_academy.jd2.mk_jd2_111_25_7.constant.ConnectionConstant;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.*;
import by.it_academy.jd2.mk_jd2_111_25_7.service.IResultService;
import by.it_academy.jd2.mk_jd2_111_25_7.service.ResultService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Properties;

public class ResultServlet extends HttpServlet {
    private IResultService resultService;

    public ResultServlet() {
        Properties props = new Properties();
        props.setProperty("user", ConnectionConstant.USER);
        props.setProperty("password", ConnectionConstant.PASSWORD);
        props.setProperty("ssl", ConnectionConstant.SSL);
        IVoteRepository voteRepository = new VoteRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        IPerformerRepository performerRepository = new PerformerRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        IGenreRepository genreRepository = new GenreRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        resultService = new ResultService(voteRepository, performerRepository, genreRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ResultDTO resultDTO = resultService.getResult();

        req.setAttribute("singerList", resultDTO.getPerformers());
        req.setAttribute("genreList", resultDTO.getGenres());
        req.setAttribute("textAbout", resultDTO.getAboutTexts());

        req.getRequestDispatcher("template/result.jsp").forward(req, resp);
    }
}
