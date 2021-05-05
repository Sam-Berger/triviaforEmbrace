package org.launchcode.trivia.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuestionAnswerInfo extends AbstractEntity{

    private String question;
    private String answer;
    private String questionType;
    private String additionalAnswerInfo;

//      TODO Make this bidirectional? dont forget to add parameter to the consturctor
//    @ManyToOne
//    @JoinColumn
//    private Quiz quiz;


    public QuestionAnswerInfo (){}

    public QuestionAnswerInfo(String question, String answer, String questionType, String additionalAnswerInfo) {
        super();
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.additionalAnswerInfo = additionalAnswerInfo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAdditionalAnswerInfo() {
        return additionalAnswerInfo;
    }

    public void setAdditionalAnswerInfo(String additionalAnswerInfo) {
        this.additionalAnswerInfo = additionalAnswerInfo;
    }
}
