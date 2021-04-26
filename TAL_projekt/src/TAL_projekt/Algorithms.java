package TAL_projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Algorithms {
    long timeStart;
    long timeStop;
    long memoryStart = 0L;
    long memoryStop = 0L;
    boolean contains;
    HashMap<String, ArrayList<Integer>> wynik = new HashMap();
    HashSet<String> set = new HashSet();
    int check;

    public Algorithms() {
    }

    public boolean divSubset(int[] tab, int n, int sum) {
        if (sum == 0) {
            this.memoryStop = Runtime.getRuntime().freeMemory();
            return true;
        } else if (n == 0 && sum != 0) {
            this.memoryStop = Runtime.getRuntime().freeMemory();
            return false;
        } else if (tab[n - 1] > sum) {
            return this.divSubset(tab, n - 1, sum);
        } else {
            return this.divSubset(tab, n - 1, sum) || this.divSubset(tab, n - 1, sum - tab[n - 1]);
        }
    }

    public void algHeurystyczny(ArrayList<Integer> zbior, int numer) {
        int[] tab = new int[zbior.size()];

        for (int i = 0; i < zbior.size(); i++) {
            tab[i] = zbior.get(i);
        }

        System.gc();
        System.runFinalization();
        Runtime.getRuntime().gc();
        this.memoryStart = Runtime.getRuntime().freeMemory();
        this.timeStart = System.nanoTime();
        boolean result = this.divSubset(tab, tab.length, numer);
        this.timeStop = System.nanoTime();
        new ResultsFrame(this.timeStop - this.timeStart, this.memoryStart - this.memoryStop, result);
        this.memoryStop = 0L;
        this.memoryStart = 0L;
    }

    public void findAll(ArrayList<Integer> zbior, int numer) {
        if (zbior.size() > 1) {
            for (int i = 0; i < zbior.size(); i++) {
                ArrayList<Integer> podzbior = (ArrayList) zbior.clone();
                podzbior.remove(i);
                if (!this.set.contains(podzbior.toString())) {
                    this.set.add(podzbior.toString());
                    this.findAll(podzbior, numer);
                }
            }
        }

        this.check = 0;

        Integer i;
        for (Iterator var6 = zbior.iterator(); var6.hasNext(); this.check += i) {
            i = (Integer) var6.next();
        }

        if (this.check == numer && !this.wynik.containsValue(zbior.toString())) {
            this.wynik.put(zbior.toString(), zbior);
        }

    }

    public void algDokladny(ArrayList<Integer> zbior, int numer) {
        System.gc();
        System.runFinalization();
        Runtime.getRuntime().gc();
        this.memoryStart = Runtime.getRuntime().freeMemory();
        this.timeStart = System.nanoTime();
        this.findAll(zbior, numer);
        this.timeStop = System.nanoTime();
        this.memoryStop = Runtime.getRuntime().freeMemory();
        new ResultsFrame(this.timeStop - this.timeStart, this.memoryStart - this.memoryStop, this.result(), this.wynik);
        this.wynik.clear();
        this.set.clear();
        this.memoryStop = 0L;
        this.memoryStart = 0L;
    }

    private boolean result() {
        return this.wynik.size() > 0;
    }
}
