package by.it_academy.jd2.mk_jd2_111_25_7.servlet;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.VoteRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.service.IResultService;
import by.it_academy.jd2.mk_jd2_111_25_7.service.ResultService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResultServlet extends HttpServlet {
    private IResultService resultService;

    public ResultServlet() {
        IVoteRepository voteRepository = VoteRepository.getInstance();
        resultService = new ResultService(voteRepository);
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
