package org.launchcode.trivia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.lang.String;

@Entity
public class UserAnswer extends AbstractEntity{

    private String oneanswer;

//    @ManyToOne
//    //@JoinColumn(name = "round_id")
//    private OneRoundUserAnswers oneRoundUserAnswers;

    public UserAnswer(){}

    public UserAnswer(String oneanswer) {
        this.oneanswer = oneanswer;
    }

    public String getOneanswer() {
        return oneanswer;
    }

    public void setOneanswer(String oneanswer) {
        this.oneanswer = oneanswer;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "oneanswer='" + oneanswer + '\'' +
                '}';
    }
}
