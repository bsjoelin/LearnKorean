import processing.data.*;
import java.io.*;

public class Hangul {
	JSONArray hangulChars;
	private StringDict hangulLatinPairs;

	public void loadData(String filepath) {
		File JSONfile = new File(filepath);
		Reader r;
		try {
			r = new FileReader(JSONfile);
			this.hangulChars = new JSONArray(r);
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println("Filepath doesn't contain JSON file.");
		} catch (IOException e) {
			System.out.println("File couldn't close.");
		}

		//Create the latin - hangul pairs
		this.hangulLatinPairs = createHashTable(this.hangulChars);
	}
	
	private String getHangulUnicode(String s) {
		return this.hangulLatinPairs.get(s);
	}

	public String convertToHangul(String latin) {
		char[] chars = latin.toCharArray();
		StringBuilder sb = new StringBuilder(7*latin.length());
		
		for(int i = 0; i < latin.length(); i++) {
			char c = chars[i];
			
			// Make sure, that "ss" and "jj" are translated correctly
			if(i+1 < latin.length()) {
				if(c =='s') {
					if (chars[i+1] == 's') {
						i++;
						sb.append(getHangulUnicode("ss"));
						continue;
					}
				} else if (c =='j') {
					if (chars[i+1] == 'j') {
						i++;
						sb.append(getHangulUnicode("jj"));
						continue;
					}
				}
			}
			
			sb.append(getHangulUnicode(new Character(c).toString()));
			
		}
		return sb.toString();
	}

	private StringDict createHashTable(JSONArray JArray) {
		StringDict dict = new StringDict();
		for(int i = 0; i < JArray.size(); i++) {
			dict.set(JArray.getJSONObject(i).getString("latin"), JArray.getJSONObject(i).getString("unicode"));
		}
		return dict;
	}

}