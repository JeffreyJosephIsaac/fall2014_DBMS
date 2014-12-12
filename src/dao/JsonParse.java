package dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import dto.Transactions;

public class JsonParse {

	public static ArrayList<Transactions> getTransactionList(String movieJson) {
		InputStream stream = new ByteArrayInputStream(movieJson.getBytes(StandardCharsets.UTF_8));
		JsonReader jsonReader = new JsonReader(new InputStreamReader(stream));
		Gson myGson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonArray userArray =  jsonParser.parse(jsonReader).getAsJsonArray();
		
		ArrayList<Transactions> tranList = new ArrayList<Transactions>();
		for ( JsonElement aUser : userArray ){
			Transactions tran = myGson.fromJson(aUser, Transactions.class);
				tranList.add(tran);
		}
		
		for(Transactions trns:tranList) {
			System.out.println(trns.getTransaction_id());
			System.out.println(trns.getFrom_bank());
		}
		return tranList;
	}
	
	public static void main(String[] args){
		
		String transactions = "[{\"transaction_id\":1,\"from_account\":26456254,\"from_bank\":\"BOFA\",\"to_account\":12136778,\"to_bank\":\"CHASE\",\"amount\":52.52},"
				+ "{\"transaction_id\":2,\"from_account\":12345611,\"from_bank\":\"CHASE\",\"to_account\":34363656,\"to_bank\":\"CHASE\",\"amount\":26.26}]";
		
		getTransactionList(transactions);
	}
}
