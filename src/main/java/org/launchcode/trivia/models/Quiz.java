package org.launchcode.trivia.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz extends AbstractEntity {

    public String name;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_answers_foreign_id", referencedColumnName = "id")
    private List<OneRoundUserAnswers> oneRoundUserAnswers = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_question_foreign_id", referencedColumnName = "id")
    private List<QuestionAnswerInfo> questions = new ArrayList<>();

    public Quiz(){}

    public Quiz(String name, ArrayList<QuestionAnswerInfo> questions, ArrayList<OneRoundUserAnswers> oneRoundUserAnswers)  {
        super();
        this.name = name;
        this.questions = questions;
        this.oneRoundUserAnswers = oneRoundUserAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionAnswerInfo> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionAnswerInfo> questions) {
        this.questions = questions;
    }

    public void addQuestions(List<QuestionAnswerInfo> questions, QuestionAnswerInfo question) {
        questions.add(question);
    }

    public List<OneRoundUserAnswers> getOneRoundUserAnswers() {
        return oneRoundUserAnswers;
    }

    public void setOneRoundUserAnswers(List<OneRoundUserAnswers> oneRoundUserAnswers) {
        this.oneRoundUserAnswers = oneRoundUserAnswers;
    }
}
