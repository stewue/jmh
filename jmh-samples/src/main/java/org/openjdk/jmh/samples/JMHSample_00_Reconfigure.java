package org.openjdk.jmh.samples;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class JMHSample_00_Reconfigure {

    @Benchmark
    @Reconfigure(value = ReconfigureMode.DIVERGENCE, covThreshold = 0.07, ciThreshold = 0.08, kldThreshold = 0.09)
    @Warmup(minIterations = 11, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    @Measurement(time = 1, timeUnit = TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.Reconfigure)
    @Fork(minWarmups = 7, minValue = 9)
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_00_Reconfigure.class.getSimpleName())
                .result("D:\\out.json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(opt).run();
    }

}
