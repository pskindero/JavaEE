package com.pskindero.javaee.jsop.jsonp;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class App {

	public static void main(String[] args) {
		JsonObject createdJson = buildSimpleJson();
		System.out.println("Created JSON:");
		System.out.println(createdJson);
		
		System.out.println("\n==========\n");
		
		JsonObject readJson = readJson(createdJson.toString());
		System.out.println("Read JSON from string:");
		System.out.println(readJson);
		
		System.out.println("\n==========\n");
		
		JsonObject retreivedAddress = readJson.getJsonObject("address");
		System.out.println("Retreived adress JSON: ");
		System.out.println(retreivedAddress);
		System.out.println("City: " +  retreivedAddress.getString("city"));
	}

	public static JsonObject buildSimpleJson() {
    	JsonObject created = Json.createObjectBuilder()
    		.add("name", "John")
    		.add("lastName", "Smith")
    		.add("age", 26)
    		.add("phones", 
    			Json.createArrayBuilder()
    				.add("987654321")
    				.add("890123456")
    				.build())
    		.add("address",
    			Json.createObjectBuilder()
    				.add("street", "Backstage St.")
    				.add("number", 9)
    				.add("city", "New York")
    				.build())
    		.build();
    	return created;
    }
	
	public static JsonObject readJson(String json) {
		JsonReader jsonReader = Json.createReader(
				new StringReader(json));
		JsonObject jsonObject = jsonReader.readObject();
		return jsonObject;
	}
}
