package lib_xml_resolver_api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author SteveBrown
 * @since 1.0
 **/
class API_Tests {
	private static final String ROOT =  "./src/test/resources/libraries_api"; 
	private static final String LIB = "dakar";
	private static final String VER = "1.0.0";

	@Test
	void validLibrary() {
		LibraryResolver resolver = new LibraryResolver(ROOT, LIB, VER);
		assertEquals(
				ROOT + "/" + LIB + "/v" + VER.replace(".", "_") , 
				resolver.resolveLibrary().get());
	}

	@Test
	void invalidLibrary() {
		LibraryResolver resolver = new LibraryResolver("ROOT", LIB, VER); 
		assertTrue(resolver.resolveLibrary().isEmpty());
	}
	
}
