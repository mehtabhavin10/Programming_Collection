package DS.TrieDS;

import java.util.*;

public class Trie {

	private Trie[] chars;
	private boolean eow;

	public Trie() {

		chars = new Trie[26];
		eow = false;
	}


	public void insert(String s) {

		Trie root = this;
		int i;

		for (char c : s.toCharArray()) {

			i = c - 'a';
			if (root.chars[i] == null) root.chars[i] = new Trie();
			root = root.chars[i];
		}

		root.eow = true;
	}


	public boolean search(String s) {

		Trie root = this;
		int i;

		for (char c : s.toCharArray()) {

			i = c - 'a';
			if (root.chars[i] == null) return false;
			root = root.chars[i];
		}

		return (root != null && root.eow);
	}


	public boolean prefix(String s) {

		Trie root = this;
		int i;

		for (char c : s.toCharArray()) {

			i = c - 'a';
			if (root.chars[i] == null) return false;
			root = root.chars[i];
		}

		return root != null;
	}


	public List<String> suggest(String s) {

		Trie root = this;
		int i;

		List<String> op = new ArrayList<>();

		for (char c : s.toCharArray()) {

			i = c - 'a';
			if (root.chars[i] == null) return op;
			root = root.chars[i];
		}

		if (root == null) return op;
		// if (root.eow) op.add(s);

		generate(root, op, s);

		return op;
	}


	private void generate(Trie root, List<String> op, String s) {

		boolean lastNode = true;

		for (int i = 0; i < 26; i++) {

			if (root.chars[i] != null) {

				generate(root.chars[i], op, s + ((char)(i + 'a')));
				lastNode = false;
			}
		}

		if (lastNode || root.eow) op.add(s);
	}
}