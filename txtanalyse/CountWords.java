package txtanalyse;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class CountWords {
	
	public static String fileToString(String filename) throws IOException {
		
		byte[] encoded = Files.readAllBytes(Paths.get(filename));
		return new String(encoded, Charset.defaultCharset());
		
	}
	
	public static List<String> parseWordsAsList(String text) {
		
		List<String> stringList = new ArrayList<String>();
		String[] stringArray = text.split("\\W+");
		
		for(int i = 0; i < stringArray.length; i++) {
			stringList.add(stringArray[i]);
		}
		
		return stringList;
	}
	
	public static Map<String,Integer> listToMap(List<String> words) {
		
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		
		for(int i = 0; i < words.size(); i++) {
			String key = words.get(i);
			int value;
			if(returnMap.containsKey(key)) {
				value = returnMap.get(key)+1;
			}else {
				value = 1;
			}
			returnMap.put(key, value);
		}
		
		return returnMap;
	}
}
