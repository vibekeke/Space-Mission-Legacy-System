package no.loopacademy;

import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSpaceMission {

    @Test
    public void testRunMission_telemetryReadingTypeTemp_hasCorrectStringOutput () {
        //ARRANGE
        Writer writer = new MockWriter();
        TelemetryReading reading = MockTelemetryReading.Builder()
                                        .withType("TEMP")
                                        .build();
        TelemetryClient client = new MockTelemetryClient(reading);

        SpaceMission mission = new SpaceMission() {
            @Override
            protected Writer createWriter() throws IOException {
                return writer;
            }

            @Override
            protected TelemetryClient createTelemetryClient() {
                return client;
            }

            @Override
            protected void pause(long millis) { }; 
        };

        String expectedLine = "Temperature: " + reading.value + " C at " + reading.timestamp + "\n";
        String expectedOutput = expectedLine.repeat(5);

        //ACT
        mission.runMission();
        MockWriter output = (MockWriter)writer;
        String actualOutput = (output.getContent());

        assertEquals(expectedOutput, actualOutput);
    }

        @Test
    public void testRunMission_telemetryReadingTypePressure_hasCorrectStringOutput () {
        //ARRANGE
        Writer writer = new MockWriter();
        TelemetryReading reading = MockTelemetryReading.Builder()
                                        .withType("PRESSURE")
                                        .build();
        TelemetryClient client = new MockTelemetryClient(reading);

        SpaceMission mission = new SpaceMission() {
            @Override
            protected Writer createWriter() throws IOException {
                return writer;
            }

            @Override
            protected TelemetryClient createTelemetryClient() {
                return client;
            }

            @Override
            protected void pause(long millis) { }; 
        };

        String expectedLine = "Pressure: " + reading.value + " kPa at " + reading.timestamp + "\n";
        String expectedOutput = expectedLine.repeat(5);

        //ACT
        mission.runMission();
        MockWriter output = (MockWriter)writer;
        String actualOutput = (output.getContent());

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRunMission_telemetryReadingTypeOxygen_hasCorrectStringOutput () {
        //ARRANGE
        Writer writer = new MockWriter();
        TelemetryReading reading = MockTelemetryReading.Builder()
                                        .withType("OXYGEN")
                                        .build();
        TelemetryClient client = new MockTelemetryClient(reading);

        SpaceMission mission = new SpaceMission() {
            @Override
            protected Writer createWriter() throws IOException {
                return writer;
            }

            @Override
            protected TelemetryClient createTelemetryClient() {
                return client;
            }

            @Override
            protected void pause(long millis) { }; 
        };

        String expectedLine = "Oxygen: " + reading.value + " % at " + reading.timestamp + "\n";
        String expectedOutput = expectedLine.repeat(5);

        //ACT
        mission.runMission();
        MockWriter output = (MockWriter)writer;
        String actualOutput = (output.getContent());

        assertEquals(expectedOutput, actualOutput);
    }
}
