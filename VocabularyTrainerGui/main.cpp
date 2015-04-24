/*
 * File:   main.cpp
 * Author: andre
 *
 * Created on April 24, 2015, 2:16 PM
 */

#include "widget-vocabularytrainer.h"
#include <QApplication>

#include <iostream>


int main(int argc, char *argv[]) {
    // initialize resources, if needed
    // Q_INIT_RESOURCE(resfile);

    QApplication app(argc, argv);

    // create and show your widgets here

//    MainWindow *w = new MainWindow;


    Option *option1 = new Option("1111", "Ik heb vandaag vijf appels moeten kopen!");
    Option *option2 = new Option("2222", "Option 2");
    Option *option3 = new Option("3333", "Option 3");
    Option *option4 = new Option("4444", "Option 4");
    Option *option5 = new Option("5555", "Option 5");

    Option* options[5] = {option1,
                         option2,
                         option3,
                         option4,
                         option5};
//    WidgetOptionChooser *optionContainer = new WidgetOptionChooser(options, w);
//    w->setCentralWidget(optionContainer);
    
    WidgetVocabularyTrainer vocTrainer(options);
    
//    QObject::connect(optionContainer, SIGNAL(optionChosen(QString)), w, SLOT(optionChosen(QString)));

    vocTrainer.show();
    
    return app.exec();
}
