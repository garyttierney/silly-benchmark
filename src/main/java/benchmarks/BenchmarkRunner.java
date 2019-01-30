package benchmarks;

import org.openjdk.jmh.annotations.Benchmark;

public class BenchmarkRunner {
    @Benchmark
    public int runConst() {
        final int operand = 50_000;
        int total = 0;

        for (int i = 0; i <= 10_000_000; i++) {
            total += i % operand;
        }

        return total;
    }

    @Benchmark
    public int runMutable() {
        int operand = 50_000;
        int total = 0;

        for (int i = 0; i <= 10_000_000; i++) {
            total += i % operand;
        }

        return total;
    }

    @Benchmark
    public int runInline() {
        int total = 0;

        for (int i = 0; i <= 10_000_000; i++) {
            total += i % 50_000;
        }

        return total;
    }

    public static void main(String[] argv) throws Exception {
        org.openjdk.jmh.Main.main(argv);
    }
}
