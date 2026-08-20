package no.loopacademy;

public class MockTelemetryClient extends TelemetryClient {
    TelemetryReading reading;

    public MockTelemetryClient(TelemetryReading reading) {
        this.reading = reading;
    }

    @Override
    public TelemetryReading read() {
        return reading;
    }
}