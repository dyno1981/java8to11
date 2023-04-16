package me.whiteship.java8to11;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
@Chicken("후라이드")
public class AppAnnotation {

    static class FeelsLikeChicken<@Chicken("양념") T> {
        public static <@Chicken("마늘간장") C> void print(@Chicken("후라이드") C c) {

        };
    }
    public static void main(String[] args) {
//        Chicken[] chickens = AppAnnotation.class.getDeclaredAnnotationsByType(Chicken.class);
//        Arrays.stream(chickens).forEach(c -> {
//            System.out.println(c.value());
//        });

        ChickenContainer chickenContainer = AppAnnotation.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }
}
