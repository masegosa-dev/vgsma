package com.masegosadev.usecase;

public interface UseCase<T extends UseCaseParams, R> {

    R execute(T t);
}
