import java.util.*;
import java.io.*;
import java.lang.*;


class Trie 
{
	private TrieNode root;
  
	public Trie() 
	{
		root = new TrieNode();
	}

	public void insert(String s)
	{
		TrieNode current = root;
		if (s.length()>0) 
		{
			current.setWord(true); //for blank operator.
		}
		for (int i= 0; i<s.length();i++) 
		{
			char c = s.charAt(i);
			TrieNode childNode = current.getChildNode(c);
			if (childNode == null) 
			 {
				childNode = new TrieNode(c);
				current.getChildNodes().put(c, childNode);
			 }
			 //update current node.
			 current = childNode;
		}
		//update current node isWord to true.
		current.setWord(true);
		System.out.println("Inserted String:"+s+" into Trie");
	}

	public void search(String s) 
	{
		TrieNode current = root;
		if(current != null && s.length()>0) 
		{
			for (int i=0;i<s.length();i++)
			{
				char c = s.charAt(i);
				TrieNode childNode = current.getChildNode(c);
				if (childNode != null) 
				{
					current = childNode; // increment child node.
				} 
				else 
				{
					System.out.println("String:"+s+" not found.");
				return;
				}
			}
			if (current.isWord())
			System.out.println("String:"+s+" found.");
		}
	}

	public void delete(String s, TrieNode node) 
	{
		if (s.length()>0) 
		{
			if (node != null) 
			{
				char c = s.charAt(0);
				TrieNode childNode = node.getChildNode(c);
				delete(s.substring(1),childNode);
				Map<Character, TrieNode> childNodes = node.getChildNodes();
				if (childNodes == null || childNodes.keySet().size() == 0) 
				{
					//delete current node only if there is no child nodes.
					node= null; //nulling the reference.
				}
				System.out.println("Deleted"+c);
			}   
		}  
	}

	public void printWordsMatchingPrefix(String prefix, TrieNode current, String entirePrefix) 
	{
		if (prefix.length()>0) 
		{
			char c = prefix.charAt(0);
			TrieNode child = current.getChildNode(c);
			if (child != null) 
			{
				String word = entirePrefix+child.getContent();
				if (child.isWord())
					System.out.println("Found word:"+word);
					printWordsMatchingPrefix(prefix.substring(prefix.indexOf(c)+1), child, word);
			}
		} 
		else 
		{
			//denotes reaching end of prefix, begin traversing to get matching words.
			Map<Character, TrieNode> map = current.getChildNodes();
			if (map != null) 
			{
				for (char c: map.keySet()) 
				{
					TrieNode child = current.getChildNode(c);
					if (child != null) 
					{
						String word = entirePrefix+child.getContent();
						if (child.isWord())
						System.out.println("Found word:"+word);
						printWordsMatchingPrefix("", child, word);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		Trie trie = new Trie();
		trie.insert("Amrut");
		trie.insert("All");
		trie.insert("Ant");
		trie.insert("Budihal");
		trie.insert("Buddy");
		trie.insert("abudihal");
		trie.printWordsMatchingPrefix("b", trie.getRoot(), "");
		trie.search("Amrut");
	}

	public TrieNode getRoot() 
	{
		return root;
	}
}

public class TrieNode 
{
	private boolean isWord;
	private char content;
	private Map<Character,TrieNode> childNodes;

	public boolean isWord() 
	{
		return isWord;
	}

	public void setWord(boolean isWord) 
	{
		this.isWord = isWord;
	}

	public char getContent() 
	{
		return content;
	}

	public void setContent(char content) 
	{
		this.content = content;
	}

	public Map<Character, TrieNode> getChildNodes() 
	{
		return childNodes;
	}

	public void setChildNodes(Map<Character, TrieNode> childNodes) 
	{
		this.childNodes = childNodes;
	}

	public TrieNode(char _content) 
	{
		content = _content;
		isWord = false;
		childNodes = new HashMap<Character,TrieNode>();
	}

	public TrieNode() 
	{
		isWord = false;
		content = '$';
		childNodes = new HashMap<Character,TrieNode>();
	}

	public TrieNode getChildNode(char c) 
	{
		if (childNodes != null) 
		{
			return childNodes.get(c);
		}
		return null;
	}

	public boolean equals(Object o) 
	{
		if (o instanceof TrieNode) 
		{
			TrieNode node = (TrieNode)o;
			return (content == node.getContent());
		}
		return false;
	}

}