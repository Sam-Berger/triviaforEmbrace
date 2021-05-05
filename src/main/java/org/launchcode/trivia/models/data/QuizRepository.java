package org.launchcode.trivia.models.data;

import org.launchcode.trivia.models.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository <Quiz, Integer> {

}
