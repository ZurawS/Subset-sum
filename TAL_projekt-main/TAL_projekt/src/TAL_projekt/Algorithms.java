package TAL_projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Algorithms {
    long timeStart, timeStop;
    long memoryStart = 0L;
    long memoryStop = 0L;
    HashMap<String, ArrayList<Integer>> wynik = new HashMap();
    HashSet<String> set = new HashSet();
    int check;

    public Algorithms() {
    }

    public boolean divSubset(int[] tab, int n, int sum) {
        if (sum == 0) {
            this.memoryStop = Runtime.getRuntime().totalMemory();
            return true;
        } else if (n == 0 && sum != 0) {
            this.memoryStop = Runtime.getRuntime().totalMemory();
            return false;
        } else if (tab[n - 1] > sum) {
            return this.divSubset(tab, n - 1, sum);
        } else {
            return this.divSubset(tab, n - 1, sum) || this.divSubset(tab, n - 1, sum - tab[n - 1]);
        }
    }

    public void algHeurystyczny(ArrayList<Integer> inputSet, int sumH) {
        int[] tab = new int[inputSet.size()];

        for (int i = 0; i < inputSet.size(); i++) {
            tab[i] = inputSet.get(i);
        }

        System.gc();
        System.runFinalization();
        Runtime.getRuntime().gc();
        this.memoryStart = Runtime.getRuntime().freeMemory();
        this.timeStart = System.nanoTime();
        boolean result = this.divSubset(tab, tab.length, sumH);
        this.timeStop = System.nanoTime();
        new ResultsFrame(this.timeStop - this.timeStart, this.memoryStop - this.memoryStart, result);
        this.memoryStop = 0L;
        this.memoryStart = 0L;
    }

    public void findAll(ArrayList<Integer> inputSet, int sum) {
        if (inputSet.size() > 1) {
            for (int i = 0; i < inputSet.size(); i++) {
                ArrayList<Integer> subset = (ArrayList) inputSet.clone();
                subset.remove(i);
                if (!this.set.contains(subset.toString())) {
                    this.set.add(subset.toString());
                    this.findAll(subset, sum);
                }
            }
        }
        this.check = 0;
        Integer i;
        for (Iterator it = inputSet.iterator(); it.hasNext(); this.check += i) {
            i = (Integer) it.next();
        }
        if (this.check == sum && !this.wynik.containsValue(inputSet.toString())) {
            this.wynik.put(inputSet.toString(), inputSet);
        }
//        System.out.println(this.set);
    }

    public void algDokladny(ArrayList<Integer> inputSet, int sumD) {
        System.gc();
        System.runFinalization();
        Runtime.getRuntime().gc();
        this.memoryStart = Runtime.getRuntime().freeMemory();
        this.timeStart = System.nanoTime();
        this.findAll(inputSet, sumD);
        this.timeStop = System.nanoTime();
        this.memoryStop = Runtime.getRuntime().totalMemory();
        new ResultsFrame(this.timeStop - this.timeStart, this.memoryStop - this.memoryStart, this.result(), this.wynik);
        this.wynik.clear();
        this.set.clear();
        this.memoryStop = 0L;
        this.memoryStart = 0L;
    }

    private boolean result() {
        return this.wynik.size() > 0;
    }
}
