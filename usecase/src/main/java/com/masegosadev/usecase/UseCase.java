package com.masegosadev.usecase;

public interface UseCase<T> {

    Object execute(T t);
}
