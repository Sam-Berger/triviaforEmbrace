package org.launchcode.trivia.models.data;

import org.launchcode.trivia.models.OneRoundUserAnswers;
import org.launchcode.trivia.models.UserAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<UserAnswer, Integer> {
}