package me.whiteship.java8to11;

import lombok.Data;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppOptional {

    @Data
    static class OnlineClass {
        private Integer id;
        private String title;
        private boolean closed;
        public Progress progress;

        public Optional<Progress> getProgress() {
            return Optional.ofNullable(progress);
        }

        public void setProgress(Progress progress) {
            this.progress = progress;
        }

        public OnlineClass(Integer id, String title, boolean closed) {
            this.id = id;
            this.title = title;
            this.closed = closed;
        }
    }

    @Data
    static class Progress {
        private Duration studyDuration;
        private boolean finished;
    }

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

//        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

//        OnlineClass onlineClass = optional.orElse(createNewClass());
//        System.out.println(onlineClass.getTitle());

//        OnlineClass onlineClass1 = optional.orElseGet(AppOptional::createNewClass);
//        System.out.println(onlineClass1.getTitle());

//        OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new);
//        System.out.println(onlineClass2.getTitle());

//        Optional<OnlineClass> onlineClass3 = optional
//                .filter(OnlineClass::isClosed);
//        System.out.println(onlineClass3.isPresent());

//        Optional<Integer> onlineClass4 = optional
//                .map(OnlineClass::getId);
//        System.out.println(onlineClass4.isPresent());

        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElse(Optional.empty());

        Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("AppOptional.createNewClass");
        return new OnlineClass(10, "New Class", false);
    }
}
