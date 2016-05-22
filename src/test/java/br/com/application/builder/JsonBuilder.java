package br.com.application.builder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.application.entity.AddressEvent;
import br.com.application.entity.State;
import br.com.application.entity.Users;
import br.com.application.security.PasswordManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

	public String builderUser() throws NoSuchAlgorithmException, UnsupportedEncodingException{		
		Users user = new Users("Ana Carolina", "Da Silva", "1190901020", "ana.carolina@teste.com.br", 'F');		
		user.alterPassword(PasswordManager.encrypt("admin123"));		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	   public String builderAddress(){	     
	        State state = new State();
	        state.setId(10);
	        AddressEvent address = new AddressEvent("Vila Country", "Av. Barra Funda", 35, "Terreo",
	        		"123456", "São Paulo", 1234534L, -1234534L, state);
	        	        
	        ObjectMapper mapper = new ObjectMapper();
	        String json = "";
	        try {
	            json = mapper.writeValueAsString(address);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return json;
	    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String jsonUser = new JsonBuilder().builderUser();
		String jsonAddress = new JsonBuilder().builderAddress();

		System.out.println(jsonUser);
		System.out.println(jsonAddress);
	}
}
