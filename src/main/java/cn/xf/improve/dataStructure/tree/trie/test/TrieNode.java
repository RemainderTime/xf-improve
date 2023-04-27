package cn.xf.improve.dataStructure.tree.trie.test;

/**
 * @Description: 实操字典树节点对像
 * @ClassName: TrieNode
 * @Author: xiongfeng
 * @Date: 2023/4/25 11:25
 * @Version: 1.0
 */
public class TrieNode {

	public TrieNode[] slot = new TrieNode[26];

	public char c;

	public String word;

	public String explain;

	public int prefix;

	public boolean isWord;
}
