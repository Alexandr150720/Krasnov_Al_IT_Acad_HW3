package by.it_academy.jd2.mk_jd2_111_25_7.servlet;

import by.it_academy.jd2.mk_jd2_111_25_7.constant.ConnectionConstant;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.UserVoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VotePageDataDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.exception.InvalidGenreNumber;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.*;
import by.it_academy.jd2.mk_jd2_111_25_7.service.IVoteService;
import by.it_academy.jd2.mk_jd2_111_25_7.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Properties;

public class VoteServlet extends HttpServlet {
    IVoteService voteService;

    public VoteServlet() {
        Properties props = new Properties();
        props.setProperty("user", ConnectionConstant.USER);
        props.setProperty("password", ConnectionConstant.PASSWORD);
        props.setProperty("ssl", ConnectionConstant.SSL);
        IVoteRepository voteRepository = new VoteRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        IPerformerRepository performerRepository = new PerformerRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        IGenreRepository genreRepository = new GenreRepository(ConnectionConstant.URL, ConnectionConstant.DRIVER, props);
        voteService = new VoteService(voteRepository, performerRepository, genreRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String singer = req.getParameter("singer");
        String[] selectedGenres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        UserVoteDTO userVoteDTO = new UserVoteDTO(singer, selectedGenres, about);

        try{
            voteService.addVote(userVoteDTO);
        } catch (InvalidGenreNumber e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return;
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad request");
            return;
        }

        resp.sendRedirect("result");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VotePageDataDTO votePageDataDTO = voteService.getVotePageData();

        req.setAttribute("singerList", votePageDataDTO.getPerformers());
        req.setAttribute("genreList", votePageDataDTO.getGenres());

        req.getRequestDispatcher("template/form.jsp").forward(req, resp);
    }
}
