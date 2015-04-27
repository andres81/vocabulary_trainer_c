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

#include <vector>
#include <cstdlib>
#include <ctime>

OptionController::OptionController(OptionsModel model)
: model(model)
{
}

OptionController::OptionController(const OptionController& orig) {
}

OptionController::~OptionController() {
}

void OptionController::setModel(OptionsModel model) {
    this->model = model;
}

OptionsModel OptionController::getModel() {
    return model;
}

void OptionController::makeGuess(std::string uuid) {
    const Option* activeOption = model.getActiveOption();
    if (!activeOption) return;
    if (activeOption->getUuid() == uuid) {
        std::vector<const Option*> activeOptions = model.getActiveOptions();
        srand(time(NULL));
        int randomIndex = rand() % 5;
        // Prevent setting the former active option again as active option!
        if (activeOption->getUuid() == activeOptions[randomIndex]->getUuid()) {
            ++randomIndex %= 5;
        }
        model.setActiveOption(activeOptions[randomIndex]->getUuid());
    }
}
