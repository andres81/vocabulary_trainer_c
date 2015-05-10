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

#include "vocabularyexercisemodel.h"

#include <algorithm>

/**
 * 
 * @param orig
 */
VocabularyExerciseModel::VocabularyExerciseModel(const VocabularyExerciseModel& orig) 
: options(orig.options)
{
}

/**
 * 
 */
VocabularyExerciseModel::~VocabularyExerciseModel() {
 //TODO when this Subject is destroyed, notify all observers of being destroyed!!!   
}

/**
 * 
 * @return 
 */
const VocabularyEntry* VocabularyExerciseModel::getActiveOption() {
    return activeOptionView;
}

/**
 * 
 * @param optionUuid
 */
void VocabularyExerciseModel::setActiveOption(std::string optionUuid) {
    std::vector<VocabularyEntry>::iterator it = std::find(options.begin(), options.end(), VocabularyEntry(optionUuid));
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
std::vector<const VocabularyEntry*> VocabularyExerciseModel::getActiveOptions() {
    return activeOptionsView;
}

/**
 * 
 * @param newActiveOptions
 */
void VocabularyExerciseModel::setActiveOptions(std::vector<std::string> optionsUuids) {
    std::vector<const VocabularyEntry*> activeOptions;
    std::vector<std::string>::iterator uuidsIterator = optionsUuids.begin();
    while (uuidsIterator != optionsUuids.end()) {
        std::vector<VocabularyEntry>::iterator optionsIt = std::find(options.begin(), options.end(), VocabularyEntry(*uuidsIterator));
        if (optionsIt != options.end()) {
            activeOptions.push_back(&(*optionsIt));
        }
        ++uuidsIterator;
    }
    this->activeOptionsView = activeOptions;
}

std::vector<VocabularyEntry> VocabularyExerciseModel::getOptions() {
    return options;
}

void VocabularyExerciseModel::setOptions(std::vector<VocabularyEntry> options) {
    this->options = options;
    activeOptionView = NULL;
    activeOptionsView.clear();
}

void VocabularyExerciseModel::Attach(ObserverInterface* o) {
    observers.push_back(o);
}

void VocabularyExerciseModel::Detach(ObserverInterface* o) {
    observers.erase(std::remove(observers.begin(), observers.end(), o), observers.end());
}

void VocabularyExerciseModel::Notify() {
    std::vector<ObserverInterface*>::iterator it = observers.begin();
    while (it != observers.end()) {
        (*it)->Update(this);
        ++it;
    }
}

std::string VocabularyExerciseModel::GetState() {
    return state;
}