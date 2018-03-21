/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Trang
 */
public class SurveyQuestion {
    String question;
    String answer;
    
    public SurveyQuestion(String q, String a) {
        question = q;
        answer = a;
    }
    
    public void modifyAnswer(String answer) {
        this.answer = answer; 
    }
    
}
