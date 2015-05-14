/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.UUID;

/**
 *
 * @author andres81
 */
public interface VocabularyExerciseController {

    public void doGuess(UUID uuid);
    
    public void setModel(VocabularyExerciseModel model);
}
