package by.it_academy.jd2.mk_jd2_111_25_7.servlet;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.VoteDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.dto.VotePageDataDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.exception.InvalidGenreNumber;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.VoteRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.service.IVoteService;
import by.it_academy.jd2.mk_jd2_111_25_7.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class VoteServlet extends HttpServlet {
    IVoteService voteService;

    public VoteServlet() {
        IVoteRepository voteRepository = VoteRepository.getInstance();
        voteService = new VoteService(voteRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String singer = req.getParameter("singer");
        String[] selectedGenres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        VoteDTO voteDTO = new VoteDTO(selectedGenres, singer, about);

        try{
            voteService.addVote(voteDTO);
        } catch (InvalidGenreNumber e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
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
