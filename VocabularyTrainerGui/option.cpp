#include "option.h"

Option::Option(const char* uuid, const char* title)
{
    this->uuid = uuid;
    setTitle(title);
}

Option::~Option()
{

}

const char* Option::getUuid() {
    return uuid;
}

void Option::setTitle(const char* title)
{
    this->title = title;
}

const char* Option::getTitle()
{
    return this->title;
}
