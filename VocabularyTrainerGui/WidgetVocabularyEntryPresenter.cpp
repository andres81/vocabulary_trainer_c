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

#include "WidgetVocabularyEntryPresenter.h"
#include "option.h"

#include <QHBoxLayout>

/**
 * 
 * @param options
 * @param parent
 */
WidgetVocabularyEntryPresenter::WidgetVocabularyEntryPresenter(QWidget* parent) : QWidget(parent)
{
    textLabel = new QLabel();
    QHBoxLayout* hBoxLayout = new QHBoxLayout();
    hBoxLayout->addStretch();
    hBoxLayout->addWidget(textLabel);
    hBoxLayout->addStretch();
    setLayout(hBoxLayout);
}

/**
 * 
 */
WidgetVocabularyEntryPresenter::~WidgetVocabularyEntryPresenter()
{
}

void WidgetVocabularyEntryPresenter::setVocabularyEntry(Option entry) {
    this->entry = entry;
    textLabel->setText(entry.getTitle().c_str());
}
