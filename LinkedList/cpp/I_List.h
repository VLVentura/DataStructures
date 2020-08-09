#ifndef __I_LIST_H__
#define __I_LIST_H__

template<typename T>
class I_List{
    public:
        virtual void insert(T data) = 0;
        virtual void remove(T data) = 0;
        virtual void traverseList() = 0;
        virtual int size() = 0;
        virtual bool empty() = 0;
        virtual ~I_List() = default;
};

#endif // __I_LIST_H__