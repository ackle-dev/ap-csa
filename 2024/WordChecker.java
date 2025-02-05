import java.util.ArrayList;
import java.util.Arrays;

/**
 * This question involves the manipulation and analysis of a list of words. The
 * following WordChecker class contains an ArrayList<String> to be analyzed and
 * methods that are used to perform the analysis. You will write two methods of
 * the WordChecker class.
 *
 * @question 3
 */
public class WordChecker {
	/** Initialized in the constructor and contains no null elements */
	@SuppressWarnings("FieldMayBeFinal")
	private ArrayList<String> wordList;

	public WordChecker() {
		wordList = new ArrayList<>();
	}

	/**
	 * Returns true if each element of wordList (except the first) contains the
	 * previous element as a substring and returns false otherwise, as described in
	 * part (a)
	 * Precondition: wordList contains at least two elements.
	 * Postcondition: wordList is unchanged.
	 *
	 * @part a
	 */
	public boolean isWordChain() {
		for (int i = 1; i < wordList.size(); i++) {
			if (!wordList.get(i).contains(wordList.get(i - 1)))
				return false;
		}
		return true;
	}

	/**
	 * Returns an ArrayList<String> based on strings from wordList that start with
	 * target, as described in part (b). Each element of the returned ArrayList has
	 * had the initial occurrence of target removed.
	 * Postconditions: wordList is unchanged.
	 * Items appear in the returned list in the same order as they appear in
	 * wordList.
	 *
	 * @part b
	 */
	public ArrayList<String> createList(String target) {
		ArrayList<String> list = new ArrayList<>();
		for (String word : wordList)
			if (word.startsWith(target))
				list.add(word.substring(target.length()));
		return list;
	}

	public static void main(String[] args) {
		WordChecker One = new WordChecker();

		// % check part A
		String[] L1 = { "an", "band", "band", "abandon" };
		One.wordList.addAll(Arrays.asList(L1));
		System.out.println(One.isWordChain()); // > true
		One.wordList.clear();
		String[] L2 = { "to", "too", "stool", "tools" };
		One.wordList.addAll(Arrays.asList(L2));
		System.out.println(One.isWordChain()); // > false

		// % check part B
		String[] L3 = { "catch", "bobcat", "catchacat", "cat", "at" };
		One.wordList.addAll(Arrays.asList(L3));
		System.out.println(One.createList("cat")); // > ["ch", "chacat", ""]
		System.out.println(One.createList("catch")); // > ["", "acat"]
		System.out.println(One.createList("dog")); // > []
	}
}
