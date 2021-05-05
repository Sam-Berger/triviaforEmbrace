package org.launchcode.trivia.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OneRoundUserAnswers extends AbstractEntity {

    private String teamName;

//    @OneToOne
//    @JoinColumn(name="quiz_id")
//    private Quiz quizUserAnswers;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "round_answers_foreign_id", referencedColumnName = "id")
    private List<UserAnswer> answers = new ArrayList<>();

//    @OneToMany (mappedBy = "quiz", cascade = CascadeType.ALL)
//    private List<QuestionAnswerInfo> questions = new ArrayList<>();

    public OneRoundUserAnswers(){}

    public OneRoundUserAnswers(String teamName, List<UserAnswer> answers) {
        super();
        this.teamName = teamName;
        this.answers = answers;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<UserAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UserAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(UserAnswer userAnswer) {
        answers.add(userAnswer);
    }

    @Override
    public String toString() {
        return "OneRoundUserAnswers{" +
                "answers=" + answers +
                '}';
    }
}
