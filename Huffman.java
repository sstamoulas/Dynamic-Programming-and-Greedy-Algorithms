package dynamicProgramming;


import java.util.*;

public class Huffman {
	
	private String input;
	private Node huffmanTree; //the huffman tree
	private Map<Character, String> mapping; //maps characters to binary strings
	
	
	/**
	 * The Huffman constructor
	 * 
	 */
	public Huffman(String input) {
		
		this.input = input;
		mapping = new HashMap<>();
		
		//first, we create a map from the letters in our string to their frequencies
		Map<Character, Integer> freqMap = getFreqs(input);
		
		//we'll be using a priority queue to store each node with its frequency,
		//as we need to continually find and merge the nodes with smallest frequency
		PriorityQueue<Node> huffman = new PriorityQueue<>();
		
		/*
		 * TODO:
		 * 1) add all nodes to the priority queue
		 * 2) continually merge the two lowest-frequency nodes until only one tree remains in the queue
		 * 3) Use this tree to create a mapping from characters (the leaves)
		 *    to their binary strings (the path along the tree to that leaf)
		 *    
		 * Remember to store the final tree as a global variable, as you will need it
		 * to decode your encrypted string
		 */
		
		//add all nodes to the priority queue
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet())
		{
			huffman.add(new Node(entry.getKey(), entry.getValue(), null, null));
		}
		
		//continually merge the two lowest-frequency nodes until only one tree remains in the queue
		while(huffman.size() > 1) {
			Node left = huffman.poll();
			Node right = huffman.poll();
			Node newNode = new Node(null, left.freq + right.freq, left, right);
			huffman.add(newNode);
		}
		
		//Remember to store the final tree as a global variable, as you will need it
		//to decode your encrypted string
		huffmanTree = huffman.poll();
		
		if(huffmanTree.isLeaf()) {
			huffmanTree.freq = input.length();
		}
		
		//Use this tree to create a mapping from characters (the leaves) 
		//to their binary strings (the path along the tree to that leaf)
		constructBinary(huffmanTree, "");
	}
	
	private void constructBinary(Node el, String bin) {
		
		if(el.isLeaf()) {
			mapping.put(el.letter, bin);
		}
		else {
			if(el.left != null) {
				constructBinary(el.left, bin + "0");
			}
			if(el.right != null) {
				constructBinary(el.right, bin + "1");
			}
		}
	}
	
	/**
	 * Use the global mapping to convert your input string into a binary string
	 */
	public String encode() {
		String result = "";
		for(int i = 0; i < input.length(); i++) {
			result += mapping.get(input.charAt(i));
		}
		return result;
	}
	
	/**
	 * Use the huffmanTree to decrypt the encoding back into the original input
	 * 
	 * You should convert each prefix-free group of binary numbers in the
	 * encoding to a character
	 * 
	 * @param encoding - the encoded string that needs to be decrypted
	 * @return the original string (should be the same as "input")
	 */
	public String decode(String encoding) {
		String result = "";
		Node el = huffmanTree;
		if(!encoding.isEmpty()) {
			for(int i = 0; i < encoding.length(); i++) {
				if(el.isLeaf()) {
					result += el.letter.toString();
					el = huffmanTree;
					i--;
				}
				else if(encoding.charAt(i) == '0') {
					el = el.left;
				}
				else if(encoding.charAt(i) == '1') {
					el = el.right;
				}
			}
		}
		else {
			for(int i = 1; i < huffmanTree.freq; i++) {
				result += huffmanTree.letter.toString();
			}
		}
		return result + el.letter.toString();
	}
	
	/**
	 * This function tells us how well the compression algorithm worked
	 * 
	 * note that a char is represented internal using 8 bits
	 * 
	 * ex. if the string "aabc" maps to "0 0 10 11", we would have
	 * a compression ratio of (6) / (8 * 4) = 0.1875
	 */
	public static double compressionRatio(String input) {
		Huffman h = new Huffman(input);
		String encoding = h.encode();
		int encodingLength = encoding.length();
		int originalLength = 8 * input.length();
		return encodingLength / (double) originalLength;
	}
	
	/**
	 * We've given you this function, which helps you create
	 * a frequency map from the input string
	 */
	private Map<Character, Integer> getFreqs(String input) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (freqMap.containsKey(c)) {
				freqMap.put(c, freqMap.get(c) + 1);
			} else {
				freqMap.put(c, 1);
			}
		}
		return freqMap;
	}


	/**
	 * An inner Node class to build your huffman tree
	 * 
	 * Each node has:
	 * a frequency - the sum of the frequencies of all the node's leaves
	 * a letter - the character that this node represents (only for leaves)
	 * left and right children
	 */
	private class Node implements Comparable<Node> {
		private Character letter; //the letter of this node (only for leaves)
		private int freq; //frequency of this node
		private Node left; //add a 0 to you string
		private Node right; //add a 1 to your string
		
		public Node(Character letter, int freq, Node left, Node right) {
			this.letter = letter;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}
	}

}
