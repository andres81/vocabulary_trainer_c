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



#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <iostream>

#include "widget-optionquestion.h"
#include "option.h"

#include <QHBoxLayout>

/**
 * 
 * @param options
 * @param parent
 */
WidgetOptionQuestion::WidgetOptionQuestion(Option* options[5], QWidget* parent) : QWidget(parent)
{
    textLabel = new QLabel();
    QHBoxLayout* hBoxLayout = new QHBoxLayout();
    hBoxLayout->addStretch();
    hBoxLayout->addWidget(textLabel);
    hBoxLayout->addStretch();
    setLayout(hBoxLayout);
    
    setOptions(options);
}

/**
 * 
 */
WidgetOptionQuestion::~WidgetOptionQuestion()
{
    delete[] options;
}

/**
 * 
 * @return 
 */
std::string WidgetOptionQuestion::setNewOption()
{
    /* initialize random seed: */
    srand (time(NULL));
    /* generate secret number between 1 and 5: */
    int newOption = rand() % 5;
    while(currentOption == newOption) {
        newOption = rand() % 5;
    }
    currentOption = newOption;
    updateVisibleOption();
    return options[currentOption]->getUuid();
}

/**
 * 
 * @param uuid
 */
void WidgetOptionQuestion::setNewOption(std::string uuid)
{
    int found = -1;
    for (int i=0;i<5;i++) {
        if (options[i]->getUuid().compare(uuid)==0) {
            found = i;
            break;
        }
    }
    if (found > -1) {
        this->currentOption = found;
        updateVisibleOption();
    }
    else {
        std::cerr << "Could not set a new option with uuid: " + uuid << std::endl;
    }
}

/**
 * 
 * @return 
 */
void WidgetOptionQuestion::updateVisibleOption() {
    textLabel->setText(options[currentOption]->getTitle().c_str());
}

/**
 * 
 * @param options
 */
void WidgetOptionQuestion::setOptions(Option* options[5]) {
    
    delete[] this->options;
    this->options = new Option*[5];
    for (int i=0;i<5;i++) {
        this->options[i] = new Option(*options[i]);
    }
    setNewOption();
}