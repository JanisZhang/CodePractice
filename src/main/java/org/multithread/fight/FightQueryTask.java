package org.multithread.fight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends Thread implements FightQuery{

    private final String original;
    private final String distination;
    private List<String> resultList = new ArrayList<>();

    public FightQueryTask(String airline, String original, String distination) {
        super("["+airline+"]");
        this.original = original;
        this.distination = distination;
    }


    @Override
    public void run() {

        System.out.printf("Query-- %s from %s to %s \n", getName(),original, distination);

        int randomVal = ThreadLocalRandom.current().nextInt(10);

        try {
            TimeUnit.SECONDS.sleep(randomVal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.resultList.add(getName()+" --- "+randomVal);

        System.out.printf("The flight %s list query successfully!!\n",
                getName());
    }

    @Override
    public List<String> get() {
        return this.resultList;
    }
}
