#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */

#include "guessobjectwidget.h"
#include "option.h"

GuessObjectWidget::GuessObjectWidget(Option* options[5], QWidget* parent) : QWidget(parent)
{
    this->options = options;
}

GuessObjectWidget::~GuessObjectWidget()
{

}

const char* GuessObjectWidget::setNewOption()
{
    /* initialize random seed: */
    srand (time(NULL));
    /* generate secret number between 1 and 10: */
    currentOption = rand() % 5 + 1;
    return options[currentOption]->getUuid();
}

void GuessObjectWidget::setNewOption(const char* uuid)
{

}
