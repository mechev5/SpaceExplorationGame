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

public class JSONTest {

    /*
    For anyone looking at this and just wanting the important stuff, just refer to
    editingUserVars, editingSpaceshipVars, and saving. In particular, refer to the
    saving(String saveName), since the other one requires you to input the saveFile,
    which for 99% of the cases it's not necessary unless you want to make a copy of
    a file that's not in use, mostly useful for making backups of test jsons.

    function editingUser/ShipVars(String field, String command, double val)

    for editingUserVars and editingShipVars, there's three operations/commands:
    - ADD
    - SUBTRACT
    - SET

    Self-explanatory, but add adds the val to whatever var you want to modify,
    substract subtracts the value from whatever var you want to modify, and
    set sets the value of whatever you want to modify.

    The vars you can modify are (for User):
    - O2
    - HEALTH
    - HUNGER
    - THIRST

    The vars you can modify are (for Spaceship):
    - O2
    - DURABILITY
    - FUEL

    More can be added in the future if needed.

    And if you ever want to see what each value of User or Spaceship are, call:
    - testingUserVars()
    - testingShipVars()
     */

    // JsonNode root;
    JsonNode root;

    static int maxPerks = 20;

    // User Vars
    String userName;
    String userGalaxy;
    double userO2Cap;
    double userO2Curr;
    double userHealthCap;
    double userHealthCurr;
    double userHungerCap;
    double userHungerCurr;
    double userThirstCap;
    double userThirstCurr;
    int userInventoryCap;
    int userInventoryCurr;
    String[] userInventory;
    String[] userPerks;

    // Spaceship vars

    String spaceshipName;
    double spaceshipO2Cap;
    double spaceshipO2Curr;
    double spaceshipDurabilityCap;
    double spaceshipDurabilityCurr;
    double spaceshipFuelCap;
    double spaceshipFuelCurr;
    int spaceshipInventoryCap;
    int spaceshipInventoryCurr;
    String[] spaceshipInventory;
    String[] spaceshipPerks;


    private static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getRoot(String saveName) throws IOException {

        InputStream jsonFile = JSONTest.class.getClassLoader().getResourceAsStream(saveName);

        JsonNode rootNode = mapper.readTree(jsonFile);
        this.root = rootNode;
        return rootNode;
    }

    //
    public JsonNode getRoot() throws IOException {
        return this.root;
    }
     //

    public JSONTest(String saveName) throws IOException {
        JsonNode myNode = getRoot(saveName);
        // System.out.println(myNode);
        getNodes(myNode);
    }

    public void getNodes(JsonNode myRoot) throws IOException {
        // System.out.println("in getNode function");
        // JsonNode users = myRoot.path("users");
        JsonNode name = myRoot.get("users");
        if (name.isArray()) {
            for (JsonNode arrayElem : name) {
                // System.out.println(arrayElem);
                settingUserVars(arrayElem);
                JsonNode spaceship = arrayElem.get("Spaceship");
                settingSpaceshipVars(spaceship);
                // System.out.println(spaceship);
            }
        }
        // System.out.println(users);
        // System.out.println(name);
    }

    public void settingUserVars(JsonNode userNode) {
        System.out.println(userNode);
        this.userName = userNode.get("Name").asText();
        this.userGalaxy = userNode.get("Galaxy").asText();
        this.userO2Cap = userNode.get("O2 Cap").asDouble();
        this.userO2Curr = userNode.get("O2 Curr").asDouble();
        this.userHealthCap = userNode.get("Health Cap").asDouble();
        this.userHealthCurr = userNode.get("Health Curr").asDouble();
        this.userHungerCap = userNode.get("Hunger Cap").asDouble();
        this.userHungerCurr = userNode.get("Hunger Curr").asDouble();
        this.userThirstCap = userNode.get("Thirst Cap").asDouble();
        this.userThirstCurr = userNode.get("Thirst Curr").asDouble();
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
        JsonNode userPerkList = userNode.get("Player Perks");
        count = 0;
        this.userPerks = new String[maxPerks];
        for (JsonNode arrayElem : userPerkList) {
            this.userPerks[count] = arrayElem.asText();
            count++;
        }
        // System.out.println(Arrays.toString(this.userInventory));
        // testingUserVars();
    }

    public void settingSpaceshipVars(JsonNode spaceshipNode) {
        System.out.println(spaceshipNode);
        this.spaceshipName = spaceshipNode.get("Name").asText();
        this.spaceshipO2Cap = spaceshipNode.get("O2 Cap").asDouble();
        this.spaceshipO2Curr = spaceshipNode.get("O2 Curr").asDouble();
        this.spaceshipDurabilityCap = spaceshipNode.get("Durability Cap").asDouble();
        this.spaceshipDurabilityCurr = spaceshipNode.get("Durability Curr").asDouble();
        this.spaceshipFuelCap = spaceshipNode.get("Fuel Cap").asDouble();
        this.spaceshipFuelCurr = spaceshipNode.get("Fuel Curr").asDouble();
        this.spaceshipInventoryCap = spaceshipNode.get("Inventory Cap").asInt();
        this.spaceshipInventoryCurr = spaceshipNode.get("Inventory Curr").asInt();
        JsonNode spaceshipInventoryList = spaceshipNode.get("Inventory List");
        int count = 0;
        this.spaceshipInventory = new String[this.spaceshipInventoryCap];
        for (JsonNode arrayElem : spaceshipInventoryList) {
            this.spaceshipInventory[count] = arrayElem.asText();
            count++;
        }
        JsonNode spaceshipPerkList = spaceshipNode.get("Ship Perks");
        count = 0;
        this.spaceshipPerks = new String[maxPerks];
        for (JsonNode arrayElem : spaceshipPerkList) {
            this.spaceshipPerks[count] = arrayElem.asText();
            count++;
        }
        // testingShipVars();
    }

    public void saving(JsonNode mySave, String saveName) throws IOException {
        String savePath = "src/main/resources/" + saveName;
        ObjectMapper mapper = new ObjectMapper();
        // String save = mapper.writeValueAsString(mySave);
        mapper.writeValue(new FileOutputStream(savePath), mySave);
    }

    public void saving(String saveName) throws IOException {
        String savePath = "src/main/resources/" + saveName;
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileOutputStream(savePath), this.root);
    }

    //
    public void editUserValues(String field, String command, double val) throws IOException {
        String operation = command.toUpperCase();
        String data = field.toUpperCase();
        JsonNode root = this.getRoot();
        JsonNode user = root.get("users");
        for (JsonNode arrayElem : user) {
            // System.out.println("in editValues");
            ObjectNode elemNode = ((ObjectNode) arrayElem);
            // System.out.println(elemNode);
            switch (operation) {
                case "ADD":
                    switch (data) {
                        case "O2":
                            // System.out.println("in ADD O2");
                            double O2 = this.userO2Curr + val;
                            // System.out.println(arrayElem.get("O2 Curr"));
                            // System.out.println(O2);
                            elemNode.put("O2 Curr", O2);
                            this.userO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "HEALTH":
                            double HEALTH  = this.userHealthCurr + val;
                            elemNode.put("Health Curr", HEALTH);
                            this.userO2Curr = elemNode.get("Health Curr").asDouble();
                            break;
                        case "HUNGER":
                            double HUNGER  = this.userHungerCurr + val;
                            elemNode.put("Hunger Curr", HUNGER);
                            this.userO2Curr = elemNode.get("Hunger Curr").asDouble();
                            break;
                        case "THIRST":
                            double THIRST  = this.userThirstCurr + val;
                            elemNode.put("Thirst Curr", THIRST);
                            this.userO2Curr = elemNode.get("Thirst Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                break;
                case "SUBTRACT":
                    switch (data) {
                        case "O2":
                            // System.out.println("in SUBTRACT O2");
                            // System.out.println(arrayElem.get("O2 Curr"));
                            // System.out.println(this.userO2Curr);
                            double O2 = this.userO2Curr - val;
                            // System.out.println(O2);
                            // ObjectNode newNode = ((ObjectNode) this.root);
                            // ObjectNode elemNode = ((ObjectNode) arrayElem);
                            elemNode.put("O2 Curr", O2);
                            // System.out.println(elemNode.get("O2 Curr"));
                            // System.out.println(newNode.getNodeType());
                            // System.out.println(this.root);
                            this.userO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "HEALTH":
                            double HEALTH  = this.userHealthCurr - val;
                            elemNode.put("Health Curr", HEALTH);
                            this.userO2Curr = elemNode.get("Health Curr").asDouble();
                            break;
                        case "HUNGER":
                            double HUNGER  = this.userHungerCurr - val;
                            elemNode.put("Hunger Curr", HUNGER);
                            this.userO2Curr = elemNode.get("Hunger Curr").asDouble();
                            break;
                        case "THIRST":
                            double THIRST  = this.userThirstCurr - val;
                            elemNode.put("Thirst Curr", THIRST);
                            this.userO2Curr = elemNode.get("Thirst Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                break;
                case "SET":
                    switch (data) {
                        case "O2":
                            double O2 = val;
                            elemNode.put("O2 Curr", O2);
                            this.userO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "HEALTH":
                            double HEALTH  = val;
                            elemNode.put("Health Curr", HEALTH);
                            this.userO2Curr = elemNode.get("Health Curr").asDouble();
                            break;
                        case "HUNGER":
                            double HUNGER  = val;
                            elemNode.put("Hunger Curr", HUNGER);
                            this.userO2Curr = elemNode.get("Hunger Curr").asDouble();
                            break;
                        case "THIRST":
                            double THIRST  = val;
                            elemNode.put("Thirst Curr", THIRST);
                            this.userO2Curr = elemNode.get("Thirst Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                break;
                default:
                    System.out.println("Couldn't find matching operation.");
            }
        }
    }

    public void editShipValues(String field, String command, double val) throws IOException {
        String operation = command.toUpperCase();
        String data = field.toUpperCase();
        JsonNode root = this.getRoot();
        JsonNode user = root.get("users");
        for (JsonNode arrayElem : user) {
            JsonNode spaceship = arrayElem.get("Spaceship");
            ObjectNode elemNode = ((ObjectNode) spaceship);
            // System.out.println(elemNode);
            switch (operation) {
                case "ADD":
                    switch (data) {
                        case "O2":
                            double O2 = this.spaceshipO2Curr + val;
                            elemNode.put("O2 Curr", O2);
                            this.spaceshipO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "DURABILITY":
                            double HEALTH  = this.spaceshipDurabilityCurr + val;
                            elemNode.put("Durability Curr", HEALTH);
                            this.spaceshipDurabilityCurr = elemNode.get("Durability Curr").asDouble();
                            break;
                        case "FUEL":
                            double HUNGER  = this.spaceshipFuelCurr + val;
                            elemNode.put("Fuel Curr", HUNGER);
                            this.spaceshipFuelCurr = elemNode.get("Fuel Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                    break;
                case "SUBTRACT":
                    switch (data) {
                        case "O2":
                            double O2 = this.spaceshipO2Curr - val;
                            elemNode.put("O2 Curr", O2);
                            this.spaceshipO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "DURABILITY":
                            double HEALTH  = this.spaceshipDurabilityCurr - val;
                            elemNode.put("Durability Curr", HEALTH);
                            this.spaceshipDurabilityCurr = elemNode.get("Durability Curr").asDouble();
                            break;
                        case "FUEL":
                            double HUNGER  = this.spaceshipFuelCurr - val;
                            elemNode.put("Fuel Curr", HUNGER);
                            this.spaceshipFuelCurr = elemNode.get("Fuel Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                    break;
                case "SET":
                    switch (data) {
                        case "O2":
                            double O2 = val;
                            elemNode.put("O2 Curr", O2);
                            this.spaceshipO2Curr = elemNode.get("O2 Curr").asDouble();
                            break;
                        case "DURABILITY":
                            double HEALTH  = val;
                            elemNode.put("Durability Curr", HEALTH);
                            this.spaceshipDurabilityCurr = elemNode.get("Durability Curr").asDouble();
                            break;
                        case "FUEL":
                            double HUNGER  = val;
                            elemNode.put("Fuel Curr", HUNGER);
                            this.spaceshipFuelCurr = elemNode.get("Fuel Curr").asDouble();
                            break;
                        default:
                            System.out.println("Couldn't find matching data field.");
                    }
                    break;
                default:
                    System.out.println("Couldn't find matching operation.");
            }
        }
    }
     //

    public void editUserItems(String field, String command, int val) throws IOException {
        String operation = command.toUpperCase();
        String data = field.toUpperCase();
        JsonNode root = this.getRoot();
        // System.out.println(root.get("users"));
        JsonNode user = root.get("users");
        for (JsonNode arrayElem : user) {
            // System.out.println("in editUserItems");
            ObjectNode elemNode = ((ObjectNode) arrayElem);
            ArrayNode userItemList = ((ArrayNode) arrayElem.get("Inventory List"));
            // System.out.println(userItemList);

            // Little testing section

            /*

            System.out.println(userItemList);
            userItemList.add("ItemType100");
            elemNode.put("Inventory List", userItemList);
            System.out.println(userItemList);
            userItemList.get("ItemType1");
            System.out.println(userItemList.get(0));
            userItemList.remove(0);
            System.out.println(userItemList);
            ObjectMapper mapping = new ObjectMapper();
            // String myItem = "{\"Item\": \"ItemType1\"}";
            // JsonNode itemNode = mapping.readTree(myItem);
            ObjectNode itemNode = mapping.createObjectNode();
            itemNode.put("Item", "ItemType1");
            System.out.println(itemNode.get("Item"));
            userItemList.set(2, itemNode.get("Item"));
            System.out.println(userItemList);

             */

            // ObjectNode elemNodeTest = ((ObjectNode) arrayElem.get("Inventory List"));
            // System.out.println(elemNode);
            // System.out.println(elemNodeTest);
            switch (operation) {
                case "ADD":
                    // Remember to add to:
                    // userItemList
                    // this.userInventory
                    // Remember to update:
                    // json user Inventory Curr
                    userItemList.add(field);
                    // System.out.println(this.userInventoryCurr);
                    // System.out.println(Arrays.toString(this.userInventory));
                    this.userInventory[this.userInventoryCurr] = field;
                    this.userInventoryCurr = (this.userInventoryCurr+1);
                    // System.out.println(Arrays.toString(this.userInventory));
                    // System.out.println(this.userInventoryCurr);
                    elemNode.put("Inventory Curr", (this.userInventoryCurr));
                    break;
                case "REMOVE":
                    if (val == -1) {
                        System.out.println("Item not found");
                        break;
                    }
                    userItemList.remove(val);
                    // this.userInventoryCurr = (this.userInventoryCurr - 1);
                    // elemNode.put("Inventory Curr", (this.userInventoryCurr));
                    for (int i = val; i < this.userInventoryCap-1; i++) {
                        this.userInventory[i] = this.userInventory[i+1];
                    }
                    this.userInventory[this.userInventoryCap-1] = null;
                    this.userInventoryCurr = (this.userInventoryCurr - 1);
                    elemNode.put("Inventory Curr", (this.userInventoryCurr));
                    break;
                case "SET":
                    ObjectMapper itemMap = new ObjectMapper();
                    ObjectNode item = itemMap.createObjectNode();
                    item.put("Item", field);
                    userItemList.set(val, item);
                    this.userInventory[val] = field;
                    break;
                default:
                    System.out.println("Couldn't find matching operation.");
            }
        }
    }

    public void editShipItems(String field, String command, int val) throws IOException {
        String operation = command.toUpperCase();
        String data = field.toUpperCase();
        JsonNode root = this.getRoot();
        JsonNode user = root.get("users");
        // JsonNode firstUser = user.get(0);
        // JsonNode firstUserItems = user.get(0).get("Inventory List");
        // System.out.println(firstUser);
        // System.out.println(firstUserItems);
        JsonNode firstSpaceshipItems = user.get(0).get("Spaceship").get("Inventory List");
        ObjectNode spaceshipNode = ((ObjectNode) user.get(0).get("Spaceship"));
        // System.out.println(firstSpaceshipItems);
        ArrayNode spaceshipItemList = ((ArrayNode) firstSpaceshipItems);
        switch (operation) {
            case "ADD":
                spaceshipItemList.add(field);
                this.spaceshipInventory[this.spaceshipInventoryCurr] = field;
                this.spaceshipInventoryCurr = (this.spaceshipInventoryCurr+1);
                spaceshipNode.put("Inventory Curr", (this.spaceshipInventoryCurr));
                break;
            case "REMOVE":
                if (val == -1) {
                    System.out.println("Item not found");
                    break;
                }
                spaceshipItemList.remove(val);
                for (int i = val; i < this.spaceshipInventoryCap-1; i++) {
                    this.spaceshipInventory[i] = this.spaceshipInventory[i+1];
                }
                this.spaceshipInventory[this.spaceshipInventoryCap-1] = null;
                this.spaceshipInventoryCurr = (this.spaceshipInventoryCurr - 1);
                spaceshipNode.put("Inventory Curr", (this.spaceshipInventoryCurr));
                break;
            case "SET":
                ObjectMapper itemMap = new ObjectMapper();
                ObjectNode item = itemMap.createObjectNode();
                item.put("Item", field);
                spaceshipItemList.set(val, item);
                this.spaceshipInventory[val] = field;
                break;
            default:
                System.out.println("Couldn't find matching operation.");
        }
    }

    public int listItemsContains(String list, String input) throws IOException {
        String itemList = list.toUpperCase();
        JsonNode root = this.getRoot();
        JsonNode user = root.get("users");
        switch(itemList) {
            case "USER":
                JsonNode userItems = user.get(0).get("Inventory List");
                int curr = this.userInventoryCurr;
                for (int i = 0; i < curr-1; i++) {
                    if (Objects.equals(userItems.get(i).asText(), input)) {
                        return i;
                    }
                }
                break;
            case "SPACESHIP":
                JsonNode spaceshipItems = user.get(0).get("Spaceship").get("Inventory List");
                int curr2 = this.spaceshipInventoryCurr;
                for (int i = 0; i < curr2-1; i++) {
                    if (Objects.equals(spaceshipItems.get(i).asText(), input)) {
                        return i;
                    }
                }
                break;
            default:
                System.out.println("Error, unknown list");
                return (-1);
        }
        System.out.println("Item not found");
        return (-1);
    }

    public int listPerksContains(String list, String input) throws IOException {
        String perkList = list.toUpperCase();
        JsonNode root = this.getRoot();
        JsonNode user = root.get("users");
        switch(perkList) {
            case "USER":
                JsonNode userPerks = user.get(0).get("Player Perks");
                int curr = maxPerks;
                for (int i = 0; i < curr-1; i++) {
                    if (userPerks.get(i) == null) {
                        System.out.println("Perk not found");
                        return -1;
                        // break;
                    }
                    if (Objects.equals(userPerks.get(i).asText(), input)) {
                        return i;
                    }
                }
                break;
            case "SPACESHIP":
                JsonNode spaceshipPerks = user.get(0).get("Spaceship").get("Ship Perks");
                int curr2 = maxPerks;
                for (int i = 0; i < curr2-1; i++) {
                    if (spaceshipPerks.get(i) == null) {
                        System.out.println("Perk not found");
                        return -1;
                        // break;
                    }
                    if (Objects.equals(spaceshipPerks.get(i).asText(), input)) {
                        return i;
                    }
                }
                break;
            default:
                System.out.println("Error, unknown list");
                return (-1);
        }
        System.out.println("Perk not found");
        return (-1);
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
        System.out.println(this.userName + "'s current Thirst: " + this.userThirstCurr);
        System.out.println(this.userName + "'s Inventory Cap: " + this.userInventoryCap);
        System.out.println(this.userName + "'s inventory slots in use: " + this.userInventoryCurr);
        System.out.println(this.userName + "'s Inventory: ");
        for (String item : this.userInventory) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println(this.userName + "'s Perks: ");
        for (String perk :this.userPerks) {
            if (perk != null) {
                System.out.println(perk);
            }
        }
    }

    public void testingShipVars() {
        String name = this.spaceshipName;
        System.out.println("Ship name: " + name);
        System.out.println(name + "'s O2 Cap: " + this.spaceshipO2Cap);
        System.out.println(name + "'s O2 Curr: " + this.spaceshipO2Curr);
        System.out.println(name + "'s Durability Cap: " + this.spaceshipDurabilityCap);
        System.out.println(name + "'s Durability Curr: " + this.spaceshipDurabilityCurr);
        System.out.println(name + "'s Fuel Cap: " + this.spaceshipFuelCap);
        System.out.println(name + "'s Fuel Curr: " + this.spaceshipFuelCurr);
        System.out.println(name + "'s Inventory Cap: " + this.spaceshipInventoryCap);
        System.out.println(name + "'s Inventory slots in use: " + this.spaceshipInventoryCurr);
        System.out.println(name + "'s Inventory: ");
        for (String item : this.spaceshipInventory) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println(name + "'s Perks: ");
        for (String perk : this.spaceshipPerks) {
            if (perk != null) {
                System.out.println(perk);
            }
        }
    }
}
