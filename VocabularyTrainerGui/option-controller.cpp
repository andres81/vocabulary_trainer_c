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

#include "option-controller.h"

#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "options-model.h"

OptionController::OptionController() {
    
}

OptionController::OptionController(const OptionController& orig) {
}

OptionController::~OptionController() {
}

void OptionController::makeGuess(std::string uuid) {
    int result = uuid.compare(model->getActiveOption()->getUuid());
    if (result == 0) {
        const Option* activeOption = model->getActiveOption();
        const std::vector<Option>* activeOptions = model->getActiveOptions();
        srand(time(NULL));
        int randomIndex = rand() % 5;
        // Prevent setting the former active option again as active option!
        if (activeOption->getUuid() == activeOptions->at(randomIndex).getUuid()) {
            ++randomIndex %= 5;
        }
        model->setActiveOption(activeOptions->at(randomIndex).getUuid());
    }
}
