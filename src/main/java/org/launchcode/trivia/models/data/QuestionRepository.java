package org.launchcode.trivia.models.data;

import org.launchcode.trivia.models.QuestionAnswerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionAnswerInfo, Integer> {
}
