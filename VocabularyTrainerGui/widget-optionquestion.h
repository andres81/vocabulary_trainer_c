#ifndef GUESSOBJECTWIDGET_H
#define GUESSOBJECTWIDGET_H

#include <QWidget>
#include <QLabel>

class Option;

class WidgetOptionQuestion : public QWidget
{
    Q_OBJECT

    Option** options = NULL;
    int currentOption;
    
    QLabel *textLabel = NULL;;

public:
    explicit WidgetOptionQuestion(Option* options[5], QWidget *parent = 0);
    ~WidgetOptionQuestion();

    void setOptions(Option* options[5]);
    std::string setNewOption();
    void setNewOption(std::string);
    void updateVisibleOption();
};

#endif // GUESSOBJECTWIDGET_H
