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
 */
OptionsModel::OptionsModel() {
}

/**
 * 
 * @param orig
 */
OptionsModel::OptionsModel(const OptionsModel& orig) {
}

/**
 * 
 */
OptionsModel::~OptionsModel() {
}

/**
 * 
 * @return 
 */
const Option* OptionsModel::getActiveOption() {
    return activeOption;
}

/**
 * 
 * @param optionUuid
 */
void OptionsModel::setActiveOption(std::string optionUuid) {
    std::vector<Option>::iterator it = std::find(options->begin(), options->end(), Option(optionUuid));
    if (it != options->end()) {
        activeOption = &(*it);
    } else {
        activeOption = NULL;
    }
}

/**
 * 
 * @return 
 */
const std::vector<Option>* OptionsModel::getActiveOptions() {
    return activeOptions;
}

/**
 * 
 * @param newActiveOptions
 */
void OptionsModel::setActiveOptions(std::vector<std::string> newActiveOptions) {
    // Clear original active options.
    (const_cast<std::vector<Option>*>(activeOptions))->clear();
    std::vector<std::string>::iterator it = newActiveOptions.begin();
    while (it != newActiveOptions.end()) {
        std::vector<Option>::iterator it2 = std::find(options->begin(), options->end(), Option(*it));
        if (it2 != options->end()) {
            (const_cast<std::vector<Option>*>(activeOptions))->push_back(*it2);
        }
        ++it;
    }
}

