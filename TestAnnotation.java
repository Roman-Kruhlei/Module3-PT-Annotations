package com.test;

import java.lang.reflect.Field;

import java.util.Random;


public class TestAnnotation {

    //check type of value field

    public AnnotationClass check(){
        AnnotationClass a = new AnnotationClass();
        for (Field f : a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Annotation.class)) {
               // System.out.println( f.getGenericType().toString());
                switch (f.getGenericType().toString()){
                    case "int":
                        System.out.println("int");
                        a = set(0);
                        break;
                    case "double":
                        System.out.println("double");
                        a= set(0.1);
                        break;
                    case "boolean":
                        a = set(true);
                        System.out.println("boolean");
                        break;
                    case "class java.lang.Integer":
                        System.out.println("Integer");
                        a = set(0);
                        break;
                    case "class java.lang.String":
                        a = set("Test");
                        System.out.println("String");
                        break;
                    case "class java.lang.Double":
                        a = set(0.1);
                        System.out.println("Double");
                        break;
                    case "class java.lang.Boolean":
                        a = set(true);
                        System.out.println("Boolean");
                        break;

                }
            }
        }
        return a;
    }
   public int getMin(){
       AnnotationClass a =new AnnotationClass();
       for(Field f : a.getClass().getDeclaredFields()){
           if(f.isAnnotationPresent(Annotation.class)){
               Annotation aq = f.getAnnotation(Annotation.class);
               return aq.min();
           }
       }
       return 0;
   }
    public int getMax(){
        AnnotationClass a =new AnnotationClass();
        for(Field f : a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Annotation.class)){
                Annotation aq = f.getAnnotation(Annotation.class);
                return aq.max();
            }
        }
        return 0;
    }

    //random methods

    public int randInt(){
        Random random = new Random();
        return random.nextInt((getMax()-getMin())+1);
    }
    public double randDouble(){
        return (Math.random()*((getMax()-getMin())+1))-getMin();
    }
    public String randString(){
       String s = RandomString.generate(getMax()-getMin());
       return s;
    }
    public boolean randBool(){
        return Math.random()<0.5;
    }

    //setters

    public AnnotationClass set(int val){
        val = randInt();
       AnnotationClass a = new AnnotationClass();
       for (Field f:a.getClass().getDeclaredFields()){
           if(f.isAnnotationPresent(Annotation.class)){
              f.setAccessible(true);
              try {
                  f.set(a,val);
              }catch(Exception e){
                  System.out.println("err");
              }
           }
       }
       return a;
    }
    public AnnotationClass set(double val){
        val = randDouble();
        AnnotationClass a = new AnnotationClass();
        for (Field f:a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Annotation.class)){
                f.setAccessible(true);
                try {
                    f.set(a,val);
                }catch(Exception e){
                    System.out.println("err");
                }
            }
        }
        return a;
    }
    public AnnotationClass set (String val){
        val = randString();
        AnnotationClass a = new AnnotationClass();
        for (Field f:a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Annotation.class)){
                f.setAccessible(true);
                try {
                    f.set(a,val);
                }catch(Exception e){
                    System.out.println("err");
                }
            }
        }
        return a;
    }
    public AnnotationClass set (boolean val){
        val = randBool();
        AnnotationClass a = new AnnotationClass();
        for (Field f:a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Annotation.class)){
                f.setAccessible(true);
                try {
                    f.set(a,val);
                }catch(Exception e){
                    System.out.println("err");
                }
            }
        }
        return a;
    }



}
