/**
 * <h3>API to expose library_xml_resolver<h3>
 * <p> 	
 * 	Get the verified path from library_xml_resolver.PathVerifier.
 * </p>
 */
package lib_xml_resolver_api;

import java.util.Optional;

import library_xml_resolver.LibraryData;
import library_xml_resolver.PathVerifier;
import library_xml_resolver.result.LibraryResult;

/**
 * @author SteveBrown
 * @since 1.0 
 */
public class LibraryResolver {
	private final String ROOT;
	private final String LIBRARY;
	private final String VERSION;

	/**
	 * Root, library and version are required.
	 * 
	 * @param root    the directory(s) above the library, i.e, where are the libraries.
	 * @param library the name of a specific library.
	 * @param version the library version.  
	 */	
	public LibraryResolver(String root, String library, String version) {
		this.ROOT = root;
		this.LIBRARY = library;
		this.VERSION = version;
	}

	/** 
	 * Verify that the file exists and get Optional of the path to it.
	 *  
	 * @return an {@code Optional@code<String>} of the path. 
	 */
	public Optional<String> resolveLibrary(){
		PathVerifier data = 
				new LibraryData()
					.setRoot(ROOT) 
					.setLibrary(LIBRARY)
					.setVersion(VERSION);
		
		LibraryResult result = data.getVerifiedPath();
		
		return result.getPath();
	}
}
