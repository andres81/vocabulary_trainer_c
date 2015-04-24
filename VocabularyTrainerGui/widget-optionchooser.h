#ifndef WIDGETOPTIONCHOOSER_H
#define WIDGETOPTIONCHOOSER_H

#include <QWidget>
#include <QPushButton>
#include <QSignalMapper>

#include "option.h"

class WidgetOptionChooser : public QWidget
{

    Q_OBJECT

signals:
        void optionChosen(QString optionUuid);

private:
    Option** options = NULL;
    QSignalMapper *signalMapper = NULL;

public:
    explicit WidgetOptionChooser(QWidget* parent = 0);
    explicit WidgetOptionChooser(Option* options[5], QWidget* parent = 0);
    ~WidgetOptionChooser();

    void setOptions(Option* options[5]);
};

#endif // WIDGETOPTIONCHOOSER_H
