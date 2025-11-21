package Servicios;

public class Stats {
    public long tiempoNs;
    public long comparisons;
    public long swaps;

    public Stats(long t, long c, long s) {
        this.tiempoNs = t;
        this.comparisons = c;
        this.swaps = s;
    }
}
