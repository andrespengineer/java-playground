package oop.common;

public interface Common {
    default String name(){
        return getClass().getName();
    }
    long code();
}
