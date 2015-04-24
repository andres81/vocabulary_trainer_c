#include "option.h"

/**
 */
Option::Option(std::string uuid, std::string title)
{
    this->uuid = uuid;
    setTitle(title);
}

/**
 * 
 * @param orig
 */
Option::Option(const Option& orig)
{
    this->uuid = orig.uuid;
    this->title = orig.title;
}

/**
 * 
 */
Option::~Option()
{

}

/**
 * 
 * @return 
 */
std::string Option::getUuid() {
    return uuid;
}

/**
 * 
 * @param title
 */
void Option::setTitle(std::string title)
{
    this->title = title;
}

/**
 * 
 * @return 
 */
std::string Option::getTitle()
{
    return title;
}
