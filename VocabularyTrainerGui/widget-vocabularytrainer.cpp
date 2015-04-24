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