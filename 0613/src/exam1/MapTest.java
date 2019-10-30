package exam1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap<String, Integer> map = new HashMap<String, Integer>();
		//LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("ÀåÀºÁö", 23);
		map.put("¾ÈÀçÈñ", 24);
		map.put("Ãµ¼®ÈÆ", 29);
		map.put("±è½½Áö", 29);
		map.put("±èÇØ¸®", 25);
		map.put("ÀÌÀç¿ì", 31);
		
		System.out.println(map);
	}

}
