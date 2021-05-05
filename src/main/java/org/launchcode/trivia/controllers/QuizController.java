package org.launchcode.trivia.controllers;

import org.launchcode.trivia.models.OneRoundUserAnswers;
import org.launchcode.trivia.models.QuestionAnswerInfo;
import org.launchcode.trivia.models.Quiz;
import org.launchcode.trivia.models.UserAnswer;
import org.launchcode.trivia.models.data.AnswerRepository;
import org.launchcode.trivia.models.data.OneRoundOfAnswersRepository;
import org.launchcode.trivia.models.data.QuestionRepository;
import org.launchcode.trivia.models.data.QuizRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class QuizController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    OneRoundOfAnswersRepository oneRoundOfAnswersRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizRepository quizRepository;

    @RequestMapping("create")
    public String displayCreateNewQuiz(Model model) {
        model.addAttribute(new Quiz());
        model.addAttribute("questions", new QuestionAnswerInfo());
        return "create";
    }

    @PostMapping("create")
    public String processCreateNewQuiz(@ModelAttribute Quiz newQuiz, @ModelAttribute QuestionAnswerInfo questions,
                                       Model model) {
        newQuiz.getQuestions().add(questions);
        quizRepository.save(newQuiz);
        return "index";
    }

    //TODO erase this but wait until we figure out how to collect more than one answer. takeQuiz has some potential
    // guidance
    @RequestMapping("test")
    public String takeQuiz(Model model) {
        model.addAttribute("oneAnswer", new UserAnswer());
        model.addAttribute("answers", new OneRoundUserAnswers());
        model.addAttribute("quizzes", quizRepository.findAll());
        model.addAttribute("questions", questionRepository.findAll());
        return "takeQuiz";
    }


    @RequestMapping("choose")
    public String chooseQuiz(Model model) {
        model.addAttribute("quizzes", quizRepository.findAll());
        return "choose";
    }

    @GetMapping("oneQuiz/{quizId}")
    public String displaySingleQuiz(Model model, @PathVariable int quizId) {
        Optional<Quiz> optQuiz = quizRepository.findById(quizId);
        if (optQuiz.isPresent()) {
            Quiz quiz = optQuiz.get();
            model.addAttribute("quiz", quiz);
            model.addAttribute("questions", questionRepository);
            return "oneQuiz";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("oneQuizTake/{quizId}")
    public String takeSingleQuiz(Model model, @PathVariable int quizId) {
        //TODO fill out this method,
        Optional<Quiz> optQuiz = quizRepository.findById(quizId);
        if (optQuiz.isPresent()) {
            Quiz quiz = optQuiz.get();
            model.addAttribute("quiz", quiz);
            model.addAttribute("questions", questionRepository);
            model.addAttribute("oneAnswer0", new UserAnswer());
            model.addAttribute("oneAnswer1", new UserAnswer());
            model.addAttribute("answers", new OneRoundUserAnswers());
            return "oneQuizTake";
        } else {
            return "redirect:../";
        }

    }

    @PostMapping("oneQuizTake/{quizId}")
    //TODO See section 3.2 here: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
    // @ModelAttribute("employee") Employee employee
    //Something like this might solve the problem
    public String processTakeSingleQuiz(@ModelAttribute OneRoundUserAnswers oneRoundUserAnswers,
                                        @ModelAttribute UserAnswer oneAnswer0,
                                        @ModelAttribute UserAnswer oneAnswer1, @PathVariable int quizId,
                                        Model model) {

        oneRoundUserAnswers.getAnswers().add(oneAnswer0);
        oneRoundOfAnswersRepository.save(oneRoundUserAnswers);

        Quiz quiz = quizRepository.findById(quizId).get();
        quiz.getOneRoundUserAnswers().add(oneRoundUserAnswers);
        quizRepository.save(quiz);

        return "index";
    }

    @GetMapping("grade/{quizId}/{answerId}")
    public String gradeQuiz(Model model, @PathVariable int quizId, @PathVariable int answerId) {
        Optional<Quiz> optQuiz = quizRepository.findById(quizId);
        Optional<OneRoundUserAnswers> optOneRoundUserAnswers = oneRoundOfAnswersRepository.findById(answerId);

        if (optQuiz.isPresent()) {
            Quiz quiz = optQuiz.get();
            OneRoundUserAnswers answers = optOneRoundUserAnswers.get();
            model.addAttribute("quiz", quiz);
            model.addAttribute("answers", answers);
            return "grade";
        } else {
            return "redirect:../";
        }

    }
}
