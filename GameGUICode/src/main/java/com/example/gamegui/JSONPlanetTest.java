package com.example.gamegui;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;
import java.util.stream.*;
public class JSONPlanetTest {

    JsonNode root;

    JsonNode galaxy;

    JsonNode planet;

    String planetType;

    double planetDistance;

    JsonNode planetDrops;

    private static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getRoot(String saveName) throws IOException {

        InputStream jsonFile = JSONTest.class.getClassLoader().getResourceAsStream(saveName);

        JsonNode rootNode = mapper.readTree(jsonFile);
        this.root = rootNode;
        return rootNode;
    }

    public JsonNode getRoot() throws IOException {
        return this.root;
    }
    //

    public JSONPlanetTest(String planetFile) throws IOException {
        JsonNode myNode = getRoot(planetFile);
        // getRoot(saveName);
    }

    public JSONPlanetTest(String planetFile, String galaxy, String planet) throws IOException {
        getRoot(planetFile);
        readingGalaxy(galaxy);
        readingPlanet(planet);
        // getRoot(saveName);
    }

    public void readingGalaxy(String galaxy) {
        // System.out.println("In readingGalaxy");
        for (JsonNode galaxyElem : this.root.get("galaxies")) {
            if (Objects.equals(galaxyElem.get("Galaxy").asText(), galaxy)) {
                this.galaxy = galaxyElem;
                // System.out.println(this.galaxy);
            }
        }
    }

    public void readingPlanet(String planet) {
        // System.out.println("In readingPlanet");
        for (JsonNode planetElem : this.galaxy.get("Planet List")) {
            if(Objects.equals(planetElem.get("Name").asText(), planet)) {
                this.planet = planetElem;
                // System.out.println(this.planet);
            }
        }
    }

    public void planetInformation() {
        this.planetDistance = this.planet.get("Orbital Radius").asDouble();
        this.planetDrops = this.planet.get("Drops");
        this.planetType = this.planet.get("Planet Type").asText();
        System.out.println("Galaxy: " + this.galaxy.get("Galaxy").asText());
        System.out.println("Planet: " + this.planet.get("Name").asText());
        System.out.println("Planet type: " + this.planetType);
        System.out.println("Planet distance in AU: " + this.planetDistance);
        System.out.println("Planet drops + drop chance: " + this.planetDrops);
    }

    public String[] drops() {
        int count = 0;
        int dropNumber = 0;
        // System.out.println(this.planet.get("Drops").size());
        String[] myDrops = new String[this.planet.get("Drops").size()];
        for (JsonNode dropElem : this.planet.get("Drops")) {
            List<String> drop = new ArrayList<>();
            Iterator<String> iterator = dropElem.fieldNames();
            iterator.forEachRemaining(e -> drop.add(e));
            // System.out.println(drop);
            // System.out.println(this.planet.get("Drops").get(count).get(drop.get(0)));
            double chance = Math.random();
            // System.out.println(chance);
            if ((this.planet.get("Drops").get(count).get(drop.get(0))).asDouble() > chance) {
                // System.out.println("Would have gotten " + drop.get(0));
                myDrops[dropNumber] = drop.get(0);
                dropNumber++;
            }
            // System.out.println(Math.random());
            count++;
        }
        // System.out.println(Arrays.toString(myDrops));
        return myDrops;
    }
}
