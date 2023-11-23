public class Character {
	int wordCounter = 0;
	int characterCounter = 0;
	int wordLength = 0;
	int [] wordLengthArray = new int [99];
	int wordLengthIndex = 0;
	int [] wordPositions = new int [99];
	int positionIndex = 0;
	String [] stringArray = new String [99];
	int stringArrayIndex = 0;
	String currentWord = "";
	int [] uniqueWordCounter = new int [99];
	String simplifiedString = "";
	String uniqueWords = "Word  Count" + '\n';
	boolean unique = true;
	
	public int getCharacterCount(String s) {
		//resets variables
		wordCounter = 0;
		characterCounter = 0;
		wordLength = 0;
		for (int i = 0; i < 99; i++) {
			wordLengthArray [i] = 0;
		}
		wordLengthIndex = 0;
		for (int i = 0; i < 99; i++) {
			wordPositions [i] = 0;
		}
		positionIndex = 0;
		for (int i = 0; i < 99; i++) {
			stringArray [i] = "";
		}
		stringArrayIndex = 0;
		currentWord = "";
		for (int i = 0; i < 99; i++) {
			uniqueWordCounter [i] = 0;
		}
		simplifiedString = "";
		uniqueWords = "Word  Count" + '\n';
		unique = true;
		
		
		for (int i = 0; i < s.length(); i++) { //loops through characters
			if (i == 0) {
				if (s.charAt(i) != ' ') { //if char is blank
					wordCounter++;
					wordPositions[positionIndex] = i;
					positionIndex++;
					characterCounter++;
					wordLength++;
				}
			}
			else {
				if (i+1 == s.length()) { //scenario for last character in string
					if (s.charAt(i) != ' ' && s.charAt(i-1) != ' ') { //if char is not blank + prev char is not blank
						wordLength++;
						wordLengthArray[wordLengthIndex] = wordLength;
						characterCounter++;
					}
					else if (s.charAt(i) != ' ' && s.charAt(i-1) == ' ') { //if char is not blank + prev char is blank
						wordCounter++;
						characterCounter++;
						wordLength++;
						wordPositions[positionIndex] = i;
						positionIndex++;
					}
				}
				else {
					if (s.charAt(i) != ' ' && s.charAt(i-1) != ' ') { //if char is not blank + prev char is not blank
						wordLength++;
						characterCounter++;
					}
					if (s.charAt(i) != ' ' && s.charAt(i-1) == ' ') { //if char is not blank + prev char is blank
						wordCounter++;
						wordPositions[positionIndex] = i;
						positionIndex++;
						characterCounter++;
						wordLength++;
					}
					if (s.charAt(i) == ' ' && s.charAt(i-1) != ' ') { //if char is  blank + prev char is not blank
						wordLengthArray[wordLengthIndex] = wordLength;
						wordLength = 0;
						wordLengthIndex++;
					}
				}
				
			}
		}
		return characterCounter;
	}
	
	public int getWordCount() {
		return wordCounter;
	}
	
	public String getSimplifiedString(String s) {
		for (int i = 0; i < 99; i++) { //sets string array to empty
			stringArray[i] = "";
		}
		for (int i = 0; i < wordCounter; i++) {
			for (int j = 0; j < wordLengthArray[i]; j++) {
				if (j+1 == wordLengthArray[i] && i != 0) {
					int k = j;
					while (k < wordLengthArray[i]) {
						currentWord += s.charAt(wordPositions[i]+j); //adds word to string
						k++;
					}
				}
				else {
					currentWord += s.charAt(wordPositions[i]+j); //adds word to string
				}
			}
			for (int f = 0; f < i; f++) { //checks for duplicate words
				if (stringArray[f].equals(currentWord)) {
					uniqueWordCounter[f]++;
					unique = false;
					break;
				}
			}
			if (unique) { //adds words to string array
				stringArray[stringArrayIndex] = currentWord;
				uniqueWordCounter[stringArrayIndex] = 1;
				stringArrayIndex++;
				currentWord = "";
			}
		} 
		for (int i = 0; i < wordCounter; i++) {
			simplifiedString += stringArray[i] + " ";
		}
		return simplifiedString;
	}
	
	public String getUniqueWords() { //returns words and counts
		for (int i = 0; i < wordCounter; i++) {
			uniqueWords += stringArray[i] + "       " + uniqueWordCounter[i] + '\n';
		}
		return uniqueWords;
	}
	
}