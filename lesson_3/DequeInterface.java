package ru.mylife.algorithmHomeWork2;

public interface DequeInterface<T> {
    void insertLeft (T value) throws QueueFullException;
    void insertRight (T value) throws QueueFullException;
    T removeLeft() throws QueueEmptyException;
    T removeRight() throws QueueEmptyException;
}
