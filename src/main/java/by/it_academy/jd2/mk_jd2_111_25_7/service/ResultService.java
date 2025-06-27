package by.it_academy.jd2.mk_jd2_111_25_7.service;

import by.it_academy.jd2.mk_jd2_111_25_7.dto.ResultDTO;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IGenreRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IPerformerRepository;
import by.it_academy.jd2.mk_jd2_111_25_7.repository.IVoteRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultService implements IResultService {

    IVoteRepository voteRepository;
    IPerformerRepository performerRepository;
    IGenreRepository genreRepository;

    public ResultService(IVoteRepository voteRepository, IPerformerRepository performerRepository, IGenreRepository genreRepository) {
        this.voteRepository = voteRepository;
        this.performerRepository = performerRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public ResultDTO getResult() {
        try {
            LinkedHashMap<String, Integer> performers = performerRepository.getResult().getPerformers();
            LinkedHashMap<String, Integer> genres = genreRepository.getResult().getGenres();
            List<String> aboutText = voteRepository.getResult().getAboutTexts();

            ResultDTO resultDTO = new ResultDTO(performers, genres, aboutText);

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
