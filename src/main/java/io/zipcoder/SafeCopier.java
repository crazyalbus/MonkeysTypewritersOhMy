package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

ReentrantLock lock;

    public SafeCopier(String toCopy) {
        super(toCopy);
        this.lock = new ReentrantLock();
    }

    public void run() {
        lock.lock();
        while (stringIterator.hasNext())
            this.copied += (stringIterator.next() + " ");
            lock.unlock();
    }

}
