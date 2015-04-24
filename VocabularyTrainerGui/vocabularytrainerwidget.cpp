#include "vocabularytrainerwidget.h"

VocabularyTrainerWidget::VocabularyTrainerWidget(QWidget *parent)
    : QWidget(parent)
{
    button1 = new QPushButton("button1");
    button2 = new QPushButton("button2");
    button3 = new QPushButton("button3");
    button4 = new QPushButton("button4");
    button5 = new QPushButton("button5");

    QVBoxLayout* vBoxLayout = new QVBoxLayout();
    vBoxLayout->addWidget(button1);
    vBoxLayout->addWidget(button2);
    vBoxLayout->addWidget(button3);
    vBoxLayout->addWidget(button4);
    vBoxLayout->addWidget(button5);

    setLayout(vBoxLayout);
}

VocabularyTrainerWidget::~VocabularyTrainerWidget()
{

}

