#ifndef OPTION_H
#define OPTION_H


class Option
{

    const char* uuid;
    const char* title;

public:
    Option(const char*, const char*);
    ~Option();

    const char* getUuid();
    const char* getTitle();
    void setTitle(const char*);
};

#endif // OPTION_H
