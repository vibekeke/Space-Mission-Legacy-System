package no.loopacademy;

public class MockTelemetryReading {

    private final TelemetryReading reading = new TelemetryReading();

    private MockTelemetryReading() {
        reading.type = "TEMP";
        reading.value = 0.0;
        reading.timestamp = System.currentTimeMillis();
    }

    public static MockTelemetryReading Builder() {
        return new MockTelemetryReading();
    }

    public MockTelemetryReading withType(String type) {
        reading.type = type;
        return this;
    }

    public MockTelemetryReading withValue(double value) {
        reading.value = value;
        return this;
    }

    public MockTelemetryReading withTimestamp(long timestamp) {
        reading.timestamp = timestamp;
        return this;
    }

    public TelemetryReading build() {
        return reading;
    }
}
