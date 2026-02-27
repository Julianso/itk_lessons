package com_itk.lesson._1.string_builder_memento;

@SuppressWarnings("javadoc")
public interface ExtStringBuilder {

    final int DEFAULT_SIZE = 32;

    static ExtStringBuilder create() {
        final java.lang.StringBuilder builder = new java.lang.StringBuilder(DEFAULT_SIZE);
        return fromJavaStringBuilder(builder);
    }

    static ExtStringBuilder fromJavaStringBuilder(java.lang.StringBuilder strBuilder) {
        return new StringBuilderImpl(strBuilder);
    }

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    ExtStringBuilder append(String str);

    void undo();
}
