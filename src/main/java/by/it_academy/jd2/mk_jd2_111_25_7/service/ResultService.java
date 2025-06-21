package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultService implements IResultService {

    IVoteRepository voteRepository;

    public ResultService(IVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public ResultDTO getResult() {
        ResultDTO resultDTO = voteRepository.getResult();

        List<Map.Entry<String, Integer>> sortedPerformers = resultDTO.getPerformers().entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        LinkedHashMap<String, Integer> sortedPerformersMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> performer: sortedPerformers){
            sortedPerformersMap.put(performer.getKey(), performer.getValue());
        }

        List<Map.Entry<String, Integer>> sortedGenres = resultDTO.getGenres().entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        LinkedHashMap<String, Integer> sortedGenresMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> genre: sortedGenres){
            sortedGenresMap.put(genre.getKey(), genre.getValue());
        }

        return new ResultDTO(sortedPerformersMap, sortedGenresMap, resultDTO.getAboutTexts());
    }
}
