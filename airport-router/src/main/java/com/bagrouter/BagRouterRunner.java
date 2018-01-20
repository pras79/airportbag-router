package com.bagrouter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.bagrouter.parser.RoutingInput;
import com.bagrouter.route.exception.RoutingException;


/**
 * This is the main runner class.
 */
/**
 * @author Pras
 *
 */
public class BagRouterRunner {

	public static void main( String [] args ) {
		String inputFile = ( args.length < 1 ) ? "routing-input.txt" : args[0];

		try {
			InputStream fis1;
			File file = new File( inputFile );
			fis1 = file.exists() ? new FileInputStream( file ) : BagRouterRunner.class.getResourceAsStream( "/" + inputFile );
			

			if ( fis1 == null ) {
				throw new FileNotFoundException( inputFile );
			}

			
			System.out.println();
			System.out.println();
			System.out.println( "[*] Routing Table" );
			System.out.println( "[*] -------------------------------------------------------------" );
			RoutingInput input = new RoutingInput( fis1 );
			RoutingEngine engine = new RoutingEngine();
			engine.executeSearch( input);
			System.out.println( "[*] -------------------------------------------------------------" );

			engine.cleanup();
		}
		catch ( RoutingException  e ) {
			System.err.println( "Error routing. " + e.getMessage() );
		}
		catch ( FileNotFoundException e ) {
			System.err.println( "Could not find file. " + e.getMessage() );
		}

	}

}
