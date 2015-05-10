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
#include "vocabularyexercisemodel.h"
#include "vocabularyexercisecontroller.h"

WidgetVocabularyTrainer::WidgetVocabularyTrainer(VocabularyExerciseModel* model, QWidget *parent)
    : QWidget(parent)
{
    this->model = model;
    this->controller = new VocabularyExerciseController(model);
    optionChooser = new WidgetOptionChooser(this);
    optionQuestion = new WidgetVocabularyEntryPresenter(this);
    updateActiveOption();
    updateActiveOptions();
    QObject::connect(optionChooser, SIGNAL(optionChosen(QString)), this, SLOT(optionChosen(QString)));
    QVBoxLayout* vBoxLayout = new QVBoxLayout();
    vBoxLayout->addWidget(optionQuestion);
    vBoxLayout->addWidget(optionChooser);
    vBoxLayout->addStretch();
    setLayout(vBoxLayout);
    model->Attach(this);
}

/**
 * 
 */
WidgetVocabularyTrainer::~WidgetVocabularyTrainer()
{
    delete controller;
}

/**
 * 
 * @param optionUuid
 */
void WidgetVocabularyTrainer::optionChosen(QString optionUuid) {
    if (controller) {
        controller->makeGuess(optionUuid.toStdString());
    }
}

/**
 * 
 * @param changedSubject
 */
void WidgetVocabularyTrainer::Update(SubjectInterface* changedSubject) {
    if (changedSubject == model) {
        std::string state = model->GetState();
        if (state == "activeOption") {
            updateActiveOption();
        } else if (state == "activeOptions") {
            updateActiveOptions();
        }
   } 
}

/**
 * 
 */
void WidgetVocabularyTrainer::updateActiveOptions() {
    optionChooser->setOptions(model->getActiveOptions());
}

/**
 * 
 */
void WidgetVocabularyTrainer::updateActiveOption() {
    optionQuestion->setVocabularyEntry(*(model->getActiveOption()));
}