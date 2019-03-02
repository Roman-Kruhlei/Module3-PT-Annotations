package com.test;


/*Создать аннотацию для поля, которая генерирует случайное значение в этом поле при создании объекта.
Поля могут быть с типами: int, float, double, boolean, Integer, Float, Double, Boolean, String.*/

public class AnnotationClass<T> {
    @Annotation
    public Boolean field;

    public static void main(String[] args) {
        TestAnnotation e = new TestAnnotation();
        AnnotationClass a = e.check();

        System.out.println("Class field: "+a.field);

    }


}

