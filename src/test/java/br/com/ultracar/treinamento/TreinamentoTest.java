package br.com.ultracar.treinamento;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class TreinamentoTest {

	@Test
	public void test() {
		RestAssured.baseURI = "http://localhost";
		
	}

}
