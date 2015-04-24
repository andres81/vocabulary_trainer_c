#include "fiveoptioncontainer.h"
#include <QVBoxLayout>
#include <QHBoxLayout>

#include <iostream>

FiveOptionContainer::FiveOptionContainer(QWidget* parent)
    : QWidget(parent)
{
    signalMapper = new QSignalMapper(this);
    connect(signalMapper, SIGNAL(mapped(QString)), this, SLOT(optionChosen(QString)));
}

FiveOptionContainer::FiveOptionContainer(Option* options[5], QWidget* parent)
    : QWidget(parent)
{
    signalMapper = new QSignalMapper(this);
    connect(signalMapper, SIGNAL(mapped(QString)), this, SIGNAL(optionChosen(QString)));
    setOptions(options);
}

FiveOptionContainer::~FiveOptionContainer()
{
}

void FiveOptionContainer::setOptions(Option* options[5]) {
    this->options = options;
    QVBoxLayout* vBoxLayout = new QVBoxLayout;
    for (int i=0;i<5;i++) {
        QPushButton* button = new QPushButton(options[i]->getTitle());
        connect(button,  SIGNAL(clicked()),signalMapper, SLOT(map()));
        signalMapper->setMapping(button, options[i]->getUuid());
        vBoxLayout->addWidget(button);
    }
    vBoxLayout->addStretch();
    QHBoxLayout* hBoxLayout = new QHBoxLayout;
    hBoxLayout->addStretch();
    hBoxLayout->addLayout(vBoxLayout);
    hBoxLayout->addStretch();
    setLayout(hBoxLayout);
}
