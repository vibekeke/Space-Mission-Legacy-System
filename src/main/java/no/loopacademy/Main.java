package no.loopacademy;

public class Main {
    public static void main(String[] args) {

        SpaceMission mission = new SpaceMission();
        for (int i = 0; i < 10; i++) {
            mission.runMission();
        }
        mission.emergencyLog("oxygen leak detected");
    
    }
}