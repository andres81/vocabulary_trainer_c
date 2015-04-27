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

#include "options-model.h"

#include <algorithm>

/**
 * 
 * @param orig
 */
OptionsModel::OptionsModel(const OptionsModel& orig) 
: options(orig.options)
{
}

/**
 * 
 */
OptionsModel::~OptionsModel() {
 //TODO when this Subject is destroyed, notify all observers of being destroyed!!!   
}

/**
 * 
 * @return 
 */
const Option* OptionsModel::getActiveOption() {
    return activeOptionView;
}

/**
 * 
 * @param optionUuid
 */
void OptionsModel::setActiveOption(std::string optionUuid) {
    std::vector<Option>::iterator it = std::find(options.begin(), options.end(), Option(optionUuid));
    if (it != options.end()) {
        activeOptionView = &(*it);
        state = "activeOption";
        Notify();
    } else {
        activeOptionView = NULL;
    }
}

/**
 * 
 * @return 
 */
std::vector<const Option*> OptionsModel::getActiveOptions() {
    return activeOptionsView;
}

/**
 * 
 * @param newActiveOptions
 */
void OptionsModel::setActiveOptions(std::vector<std::string> optionsUuids) {
    std::vector<const Option*> activeOptions;
    std::vector<std::string>::iterator uuidsIterator = optionsUuids.begin();
    while (uuidsIterator != optionsUuids.end()) {
        std::vector<Option>::iterator optionsIt = std::find(options.begin(), options.end(), Option(*uuidsIterator));
        if (optionsIt != options.end()) {
            activeOptions.push_back(&(*optionsIt));
        }
        ++uuidsIterator;
    }
    this->activeOptionsView = activeOptions;
}

std::vector<Option> OptionsModel::getOptions() {
    return options;
}

void OptionsModel::setOptions(std::vector<Option> options) {
    this->options = options;
    activeOptionView = NULL;
    activeOptionsView.clear();
}

void OptionsModel::Attach(ObserverInterface* o) {
    observers.push_back(o);
}

void OptionsModel::Detach(ObserverInterface* o) {
    observers.erase(std::remove(observers.begin(), observers.end(), o), observers.end());
}

void OptionsModel::Notify() {
    std::vector<ObserverInterface*>::iterator it = observers.begin();
    while (it != observers.end()) {
        (*it)->Update(this);
        ++it;
    }
}

std::string OptionsModel::GetState() {
    return state;
}