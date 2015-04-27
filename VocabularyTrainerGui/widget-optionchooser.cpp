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
 */
WidgetOptionChooser::~WidgetOptionChooser()
{
}

/**
 * 
 * @param options
 */
void WidgetOptionChooser::setOptions(std::vector<Option> options) {
    if (!signalMapper) {
        signalMapper = new QSignalMapper(this);
        connect(signalMapper, SIGNAL(mapped(QString)), this, SIGNAL(optionChosen(QString)));
    }
    this->options = options;
    QVBoxLayout* vBoxLayout = new QVBoxLayout;
    std::vector<Option>::iterator it = options.begin();
    while (it != options.end()) {
        QPushButton* button = new QPushButton(it->getTitle().c_str());
        connect(button,  SIGNAL(clicked()),signalMapper, SLOT(map()));
        signalMapper->setMapping(button, it->getUuid().c_str());
        vBoxLayout->addWidget(button);
        ++it;
    }
    vBoxLayout->addStretch();
    QHBoxLayout* hBoxLayout = new QHBoxLayout;
    hBoxLayout->addStretch();
    hBoxLayout->addLayout(vBoxLayout);
    hBoxLayout->addStretch();
    if (layout() != 0) delete layout();
    setLayout(hBoxLayout);
}
