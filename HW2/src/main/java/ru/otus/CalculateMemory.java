package ru.otus;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static ru.otus.Main.SIZE;

public class CalculateMemory {

    public static <T> Object printUsage(@NotNull Supplier<T> supplier, @NotNull String comment){
        final Object[] objects = new Object[SIZE];
        Runtime runtime = Runtime.getRuntime();

        runtime.gc();
        // измеряем используемую память а не свободную, так как JVM может сам увеличить totalMemory
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        for(int i = 0; i < SIZE; i++){
            objects[i] = supplier.get();
        }

        // подчистить от объектов с паралельных потоков
        runtime.gc();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.print(String.format("\n%-30s\tSIZEOF(): %d bytes\n", comment, Math.round((double) (memAfter - memBefore)/SIZE)));

        // если вернуть null gc() удалит objects при последнем использовании
        return objects;

    }
}
