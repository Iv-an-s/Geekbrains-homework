package lesson7.homework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.TreeMap;

public class Execution {

    public static void start(Class clazz) throws Exception {

        checkIsBeforeSuiteOnly(clazz);
        checkIsAfterSuiteOnly(clazz);
        doMethodWithBeforeSuiteAnnotation(clazz);
        doMethodsWithTestAnnotation(clazz);
        doMethodWithAfterSuiteAnnotation(clazz);
    }

    public static void doMethodsWithTestAnnotation(Class clazz) throws Exception{
        TreeMap< Integer, Method> treeMap = new TreeMap<>();
        for (Method method : clazz.getDeclaredMethods()){
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                treeMap.put(test.priority(), method); // сортировка автоматом
            }
        }

        for (Integer key : treeMap.keySet()) {
            System.out.println(String.format("priority: %s, method: %s is running ..", key, treeMap.get(key).getName()));
            Constructor constructor = clazz.getConstructor();
            Object test = constructor.newInstance();
            treeMap.get(key).invoke(test);
        }
    }

    public static void checkIsBeforeSuiteOnly(Class clazz){
        for (Method method : clazz.getDeclaredMethods()){
            boolean isBeforeSuiteNotOnly = false;
            for(Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof BeforeSuite) {
                    if (isBeforeSuiteNotOnly) {
                        throw new RuntimeException("Error: More than one BeforeSuite method!!!");
                    }
                    isBeforeSuiteNotOnly = true;
                }
            }
        }
    }

    public static void checkIsAfterSuiteOnly (Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            boolean isAfterSuiteNotOnly = false;
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof AfterSuite) {
                    if (isAfterSuiteNotOnly) {
                        throw new RuntimeException("Error: More than one AfterSuite method!!!");
                    }
                    isAfterSuiteNotOnly = true;
                }
            }
        }
    }

    public static void doMethodWithBeforeSuiteAnnotation(Class clazz) throws Exception{
        for (Method method : clazz.getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof BeforeSuite) {
                    method.invoke(clazz);
                }
            }
        }
    }

    public static void doMethodWithAfterSuiteAnnotation(Class clazz) throws Exception{
        for (Method method : clazz.getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof AfterSuite) {
                    method.invoke(clazz);
                }
            }
        }
    }
}
