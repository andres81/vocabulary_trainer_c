#include "widget-optionchooser.h"
#include <QVBoxLayout>
#include <QHBoxLayout>

#include <iostream>

/**
 * 
 * @param parent
 */
WidgetOptionChooser::WidgetOptionChooser(QWidget* parent)
    : QWidget(parent)
{
}

/**
 * 
 * @param options
 * @param parent
 */
WidgetOptionChooser::WidgetOptionChooser(Option* options[5], QWidget* parent)
    : QWidget(parent)
{
    setOptions(options);
}

/**
 * 
 */
WidgetOptionChooser::~WidgetOptionChooser()
{
    delete[] this->options;
}

/**
 * 
 * @param options
 */
void WidgetOptionChooser::setOptions(Option* options[5]) {
    
    if (!signalMapper) {
        signalMapper = new QSignalMapper(this);
        connect(signalMapper, SIGNAL(mapped(QString)), this, SIGNAL(optionChosen(QString)));
    }
    
    delete[] this->options;
    this->options = new Option*[5];
    for (int i=0;i<5;i++) {
        this->options[i] = new Option(*options[i]);
    }
    
    QVBoxLayout* vBoxLayout = new QVBoxLayout;
    for (int i=0;i<5;i++) {
        QPushButton* button = new QPushButton(options[i]->getTitle().c_str());
        connect(button,  SIGNAL(clicked()),signalMapper, SLOT(map()));
        signalMapper->setMapping(button, options[i]->getUuid().c_str());
        vBoxLayout->addWidget(button);
    }
    vBoxLayout->addStretch();
    QHBoxLayout* hBoxLayout = new QHBoxLayout;
    hBoxLayout->addStretch();
    hBoxLayout->addLayout(vBoxLayout);
    hBoxLayout->addStretch();
    setLayout(hBoxLayout);
}
