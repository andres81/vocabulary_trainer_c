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

#include <iostream>

WidgetVocabularyTrainer::WidgetVocabularyTrainer(Option* options[5], QWidget *parent)
    : QWidget(parent)
{
    optionChooser = new WidgetOptionChooser(options, this);
    optionQuestion = new WidgetOptionQuestion(options, this);
    
    currentOptionUuid = optionQuestion->setNewOption();
    
    QObject::connect(optionChooser, SIGNAL(optionChosen(QString)), this, SLOT(optionChosen(QString)));
    
    QVBoxLayout* vBoxLayout = new QVBoxLayout();
    vBoxLayout->addWidget(optionQuestion);
    vBoxLayout->addWidget(optionChooser);
    vBoxLayout->addStretch();
    setLayout(vBoxLayout);
}

WidgetVocabularyTrainer::~WidgetVocabularyTrainer()
{

}

void WidgetVocabularyTrainer::optionChosen(QString optionUuid) {
    if (optionUuid.compare(currentOptionUuid.c_str()) == 0) {
        currentOptionUuid = optionQuestion->setNewOption();
    }
}