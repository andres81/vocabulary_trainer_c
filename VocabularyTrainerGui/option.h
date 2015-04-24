#ifndef OPTION_H
#define OPTION_H

#include <string>

class Option
{
    std::string uuid;
    std::string title;
    
public:
    Option(std::string uuid, std::string title);
    Option(const Option& orig);
    ~Option();
    std::string getUuid();
    std::string getTitle();
    void setTitle(std::string);
};

#endif // OPTION_H
