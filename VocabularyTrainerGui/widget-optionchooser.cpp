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
