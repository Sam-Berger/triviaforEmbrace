package org.launchcode.trivia.models.data;

import org.launchcode.trivia.models.OneRoundUserAnswers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneRoundOfAnswersRepository extends CrudRepository<OneRoundUserAnswers, Integer> {
}
