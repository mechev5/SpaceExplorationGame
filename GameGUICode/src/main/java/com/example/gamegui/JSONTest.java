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
import java.util.*;
import java.util.stream.*;

public class JSONTest {

    String userName;
    String userGalaxy;
    int userO2Cap;
    int userO2Curr;
    int userHealthCap;
    int userHealthCurr;
    int userHungerCap;
    int userHungerCurr;
    int userThirstCap;
    int userThirstCurr;
    int userInventoryCap;
    int userInventoryCurr;
    String[] userInventory;

    private static ObjectMapper mapper = new ObjectMapper();

    static JsonNode getRoot() throws IOException {

        InputStream jsonFile = JSONTest.class.getClassLoader().getResourceAsStream("Test.json");

        JsonNode rootNode = mapper.readTree(jsonFile);
        return rootNode;
    }

    public JSONTest() throws IOException {
        JsonNode myNode = getRoot();
        // System.out.println(myNode);
        getNodes(myNode);
    }

    public void getNodes(JsonNode myRoot) throws IOException {
        System.out.println("in getNode function");
        // JsonNode users = myRoot.path("users");
        JsonNode name = myRoot.get("users");
        if (name.isArray()) {
            for (JsonNode arrayElem : name) {
                System.out.println(arrayElem);
                settingUserVars(arrayElem);
                JsonNode spaceship = arrayElem.get("Spaceship");
                System.out.println(spaceship);
            }
        }
        // System.out.println(users);
        // System.out.println(name);
    }

    public void settingUserVars(JsonNode userNode) {
        this.userName = userNode.get("Name").asText();
        this.userGalaxy = userNode.get("Galaxy").asText();
        this.userO2Cap = userNode.get("O2 Cap").asInt();
        this.userO2Curr = userNode.get("O2 Curr").asInt();
        this.userHealthCap = userNode.get("Health Cap").asInt();
        this.userHealthCurr = userNode.get("Health Curr").asInt();
        this.userHungerCap = userNode.get("Hunger Cap").asInt();
        this.userHungerCurr = userNode.get("Hunger Curr").asInt();
        this.userThirstCap = userNode.get("Thirst Cap").asInt();
        this.userThirstCurr = userNode.get("Thirst Curr").asInt();
        this.userInventoryCap = userNode.get("Inventory Cap").asInt();
        this.userInventoryCurr = userNode.get("Inventory Curr").asInt();
        JsonNode userInventoryList = userNode.get("Inventory List");
        int count = 0;
        this.userInventory = new String[this.userInventoryCap];
        for (JsonNode arrayElem : userInventoryList) {
            // this.userInventory[count] = arrayElem.asText();
            this.userInventory[count] = arrayElem.asText();
            count++;
        }
        // System.out.println(Arrays.toString(this.userInventory));
        testingUserVars();
    }

    public void testingUserVars() {
        System.out.println("Username: " + this.userName);
        System.out.println(this.userName + "'s Location: " + this.userGalaxy);
        System.out.println(this.userName +  "'s O2 Cap: " + this.userO2Cap);
        System.out.println(this.userName + "'s current O2 levels: " + this.userO2Curr);
        System.out.println(this.userName + "'s Health Cap: " + this.userHealthCap);
        System.out.println(this.userName + "'s current Health:" + this.userHealthCurr);
        System.out.println(this.userName + "'s Hunger Cap: " + this.userHungerCap);
        System.out.println(this.userName + "'s current Hunger: " + this.userHungerCurr);
        System.out.println(this.userName + "'s Thirst Cap: " + this.userThirstCap);
        System.out.println(this.userName + "'s current Thirst" + this.userThirstCurr);
        System.out.println(this.userName + "'s Inventory Cap: " + this.userInventoryCap);
        System.out.println(this.userName + "'s inventory slots in use: " + this.userInventoryCurr);
        System.out.println(this.userName + "'s Inventory: ");
        for (String item : this.userInventory) {
            System.out.println(item);
        }
    }
}
