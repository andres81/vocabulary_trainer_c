/**
 * VocabularyTrainer  Copyright (C) 2015  André Schepers
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



#include "widget-vocabularytrainer.h"
#include "options-model.h"
#include "option-controller.h"
#include <QApplication>

#include <iostream>
#include <vector>

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

    std::vector<Option> optionVec;
    optionVec.push_back(*option1);
    optionVec.push_back(*option2);
    optionVec.push_back(*option3);
    optionVec.push_back(*option4);
    optionVec.push_back(*option5);
    
    OptionsModel *model = new OptionsModel;
    model->setOptions(optionVec);
    std::vector<std::string> activeOptions;
    activeOptions.push_back("1111");
    activeOptions.push_back("2222");
    activeOptions.push_back("3333");
    activeOptions.push_back("4444");
    activeOptions.push_back("5555");
    model->setActiveOptions(activeOptions);
    model->setActiveOption("1111");
    
    OptionController *controller = new OptionController;
    controller->setModel(model);
    
    WidgetVocabularyTrainer vocTrainer(model, controller);
    
    model->Notify();
    std::cout << "after notify" << std::endl;
//    QObject::connect(optionContainer, SIGNAL(optionChosen(QString)), w, SLOT(optionChosen(QString)));

    vocTrainer.show();
    
    return app.exec();
}
