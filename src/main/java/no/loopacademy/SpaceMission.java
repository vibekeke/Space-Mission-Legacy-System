package no.loopacademy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

public class SpaceMission {
    private TelemetryClient client;

    public SpaceMission() {
        this.client = createTelemetryClient();
    }

    public void runMission() {
        try (Writer fw = createWriter()) {
            for (int i = 0; i < 5; i++) {
                TelemetryReading r = client.read();

                if ("TEMP".equals(r.type)) {
                    fw.write("Temperature: " + r.value + " C at " + r.timestamp + "\n");
                } else if ("PRESSURE".equals(r.type)) {
                    fw.write("Pressure: " + r.value + " kPa at " + r.timestamp + "\n");
                } else if ("OXYGEN".equals(r.type)) {
                    fw.write("Oxygen: " + r.value + " % at " + r.timestamp + "\n");
                } else {
                    fw.write("Unknown reading " + r.type + "\n");
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Writer createWriter() throws IOException {
        return new FileWriter(Config.logFile, true);
    }

    protected TelemetryClient createTelemetryClient() {
        return new TelemetryClient();
    }

    public void emergencyLog(String message) {
        try (Writer fw = createWriter()) {
            fw.write("EMERGENCY: " + message + " at " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}