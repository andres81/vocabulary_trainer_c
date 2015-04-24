#ifndef FIVEOPTIONCONTAINER_H
#define FIVEOPTIONCONTAINER_H

#include <vector>
#include <string>

#include <QWidget>
#include <QPushButton>
#include <QSignalMapper>

#include "option.h"

class FiveOptionContainer : public QWidget
{

    Q_OBJECT

signals:
        void optionChosen(QString optionUuid);

private:
    Option** options;
    QSignalMapper *signalMapper;

public:
    explicit FiveOptionContainer(QWidget* parent = 0);
    explicit FiveOptionContainer(Option* options[5], QWidget* parent = 0);
    ~FiveOptionContainer();

    void setOptions(Option* options[5]);
};

#endif // FIVEOPTIONCONTAINER_H
