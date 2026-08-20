package no.loopacademy;

import java.util.Random;

public class TelemetryClient implements TelemetryReader {
    public TelemetryClient() {
        connect(Config.telemetryEndpoint);
    }

    private void connect(String endpoint) {
        System.out.println("Connecting to telemetry at " + endpoint);
    }

    public TelemetryReading read() {
        Random r = new Random();
        TelemetryReading t = new TelemetryReading();
        t.type = r.nextBoolean() ? "TEMP" : "PRESSURE";
        t.value = r.nextDouble() * 100;
        t.timestamp = System.currentTimeMillis();
        return t;
    }
}