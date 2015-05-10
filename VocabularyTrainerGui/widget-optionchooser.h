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



#ifndef WIDGETOPTIONCHOOSER_H
#define WIDGETOPTIONCHOOSER_H

#include <QWidget>
#include <QPushButton>
#include <QSignalMapper>

#include "vocabularyentry.h"

class WidgetOptionChooser : public QWidget
{

    Q_OBJECT

signals:
        void optionChosen(QString optionUuid);

private:
    QSignalMapper *signalMapper = NULL;

public:
    explicit WidgetOptionChooser(QWidget* parent = 0);
    ~WidgetOptionChooser();

    void setOptions(std::vector<const VocabularyEntry*>);
};

#endif // WIDGETOPTIONCHOOSER_H
