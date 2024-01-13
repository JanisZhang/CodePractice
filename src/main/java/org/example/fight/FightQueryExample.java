package org.example.fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FightQueryExample {

    private static final List<String> fightCompany = Arrays.asList("航空公司AA",
            "航空公司BB","航空公司CC" );

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");
        System.out.println("Please find results as following:");

        results.forEach(System.out::println);
    }

    private static List<String> search(String sh, String bj) {
        List<FightQueryTask> threads = fightCompany.stream().map(f->new FightQueryTask(f
                ,sh,bj)).collect(Collectors.toList());

        threads.forEach(Thread::start);

        threads.forEach(
                t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        List<String> results = new ArrayList<>();

        threads.stream().map(FightQuery::get).forEach(results::addAll);

        return results;

    }
}
