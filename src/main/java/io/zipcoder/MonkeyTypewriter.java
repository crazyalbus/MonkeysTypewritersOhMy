package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier unsafe = new UnsafeCopier(introduction);

        Thread unsafeMonkey1 = new Thread(unsafe);
        Thread unsafeMonkey2 = new Thread(unsafe);
        Thread unsafeMonkey3 = new Thread(unsafe);
        Thread unsafeMonkey4 = new Thread(unsafe);
        Thread unsafeMonkey5 = new Thread(unsafe);
        unsafeMonkey1.start();
        unsafeMonkey2.start();
        unsafeMonkey3.start();
        unsafeMonkey4.start();
        unsafeMonkey5.start();

        SafeCopier safe = new SafeCopier(introduction);

        Thread safeMonkey1 = new Thread(safe);
        Thread safeMonkey2 = new Thread(safe);
        Thread safeMonkey3 = new Thread(safe);
        Thread safeMonkey4 = new Thread(safe);
        Thread safeMonkey5 = new Thread(safe);
        safeMonkey1.start();
        safeMonkey2.start();
        safeMonkey3.start();
        safeMonkey4.start();
        safeMonkey5.start();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("Unsafe Copy:");
        System.out.println(unsafe.copied + "\n");

        System.out.println("Safe Copy:");
        System.out.println(safe.copied + "\n");

    }
}