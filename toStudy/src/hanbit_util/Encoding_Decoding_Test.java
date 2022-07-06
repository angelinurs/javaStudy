package hanbit_util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Encoding_Decoding_Test {

	public static void main(String[] args) 
				  throws UnsupportedEncodingException {
		String text = "something text";
		
		// Encode
		String asB64 = Base64.getEncoder().encodeToString(text.getBytes("utf-8"));
		System.out.println( asB64 );

		// Decode
		byte[] asBytes = Base64.getDecoder().decode(asB64);
		System.out.println( new String( asBytes, "utf-8"));

	}

}
