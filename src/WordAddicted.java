

public class WordAddicted {

	private static String input = "The quick bron fox jumps over the lazy dog";

	public static void main(String[] args) {
		WordAddicted wr = new WordAddicted();

		//		System.out.println(wr.reverseString("advertisement your be could this!"));
		//		System.out.println(wr.findingWords(input, 4));
		//		System.out.println(wr.searchingAWord(input, "this"));
		//		System.out.println(wr.countingWords(input, "w�RTer"));
		//		System.out.println(wr.isAnagram("Paris", "raisp"));
		System.out.println(wr.isPangram(input));
	}

	public String reverseString(String input) {
		String[] tmpString = input.split(" ");
		String result="";
		String endMark="";


		for (int i = tmpString.length-1; i >= 0; i--) {
			//No idea if the condition can be smarter...
			if(tmpString[i].endsWith("!") || tmpString[i].endsWith("?") || tmpString[i].endsWith(".")) {
				endMark=tmpString[i].substring(tmpString[i].length()-1, tmpString[i].length());
				tmpString[i]=tmpString[i].substring(0, tmpString[i].length()-1);
			}

			result+=tmpString[i]+" ";
		}

		//Bloody space at the end
		if (result.endsWith(" ")) {
			result=result.substring(0, result.length()-1);	
		}

		//I want my punctuation mark as well as...
		result=result+endMark;
		//...the first letter to be upper case
		result=result.substring(0,1).toUpperCase()+result.substring(1);

		return result;
	}

	// Find a word in a given String on position n
	public String findingWords (String input, int n) {
		String[] tmp = input.split(" ");

		if(tmp[n-1].endsWith("!") || tmp[n-1].endsWith("?") || tmp[n-1].endsWith(".")) {
			return tmp[n-1].substring(0, tmp[n-1].length()-1);
		} 
		else {
			return tmp[n-1];	
		}				
	}

	// Checking a String whether it contains a given word
	public boolean searchingAWord(String input, String word) {
		String[] tmp = input.split(" ");

		if (tmp[0].toLowerCase().equals(word.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	// Counting all the words in a given String
	public int countingWords(String input, String word) {
		String[] tmp = input.split(" ");
		int result=0;

		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].toLowerCase().equals(word.toLowerCase())) {
				result++;
			}
		}

		return result;
	}

	// Checking a given String whether it's a Anagram
	public boolean isAnagram(String i1, String i2) {
		char[] c1 = i1.toCharArray();
		char[] c2 = i2.toCharArray();

		boolean result=false;

		if (c1.length!=c2.length) {
			return result;
		}

		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i]==c2[j]) {
					result=true;
				}
			}
		}

		return result;
	}

	// Checking a given String whether it's a Pangram
	public boolean isPangram(String input) {
		boolean[] mark = new boolean[26];
		input = input.toLowerCase();
		int index=0;

		for (int i = 0; i < input.length(); i++) {
			if('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
				index = input.charAt(i)-'a';
			} else { continue; }
			
			mark[index]=true;
		}

		for (int i = 0; i < mark.length; i++) {
			if (mark[i]==false) {
				return false;
			}
		}

		return true;

	}
}
