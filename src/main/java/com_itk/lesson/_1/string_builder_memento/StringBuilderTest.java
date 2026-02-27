package com_itk.lesson._1.string_builder_memento;

public class StringBuilderTest {

    public void run() {

        ExtStringBuilder sb = ExtStringBuilder.create();
        sb.append("test\n");
        sb.append("test 2\n");
        sb.append("test 3\n");

        System.out.println(sb);

        sb.undo();

        sb.append("test 4\n");

        System.out.println(sb);

        sb.undo();

        System.out.println(sb);
    }

}
