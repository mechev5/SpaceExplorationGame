package com.example.gamegui;

import java.io.IOException;

public class EventTest {

    String saveFile;
    String planetFile;
    String galaxy;
    String planet;

    JSONTest save;
    JSONTest backup;
    JSONPlanetTest destination;

    public EventTest(String saveFile, String planetFile, String galaxy, String planet) throws IOException {
        System.out.println("Event Test Instance Created!");
        this.save = new JSONTest(saveFile);
        this.destination = new JSONPlanetTest(planetFile, galaxy, planet);
        this.saveFile = saveFile;
        this.planetFile = planetFile;
        this.galaxy = galaxy;
        this.planet = planet;
    }

    public void backupSave() throws IOException {
        this.save.saving(this.save.getRoot(this.saveFile), "BACKUP"+this.saveFile);
        this.backup = new JSONTest("BACKUP"+this.saveFile);
    }

    public void fuelUsage() throws IOException {
        double distance = this.destination.planet.get("Orbital Radius").asDouble();
        double distanceFactor = 7;
        // System.out.println("Amount of fuel used in this instance: " + (distance*distanceFactor));
        double fuelUsed = distance*distanceFactor;
        this.backup.editShipValues("fuel", "subtract", fuelUsed);
        this.backup.saving("BACKUP"+this.saveFile);
    }

    public void shipDamage() throws IOException {
        double base = 10;
        double damage = base;
        if (this.backup.listPerksContains("Spaceship", "Durable Exterior") != -1) {
            damage = base * 0.50;
        }
    }
}
