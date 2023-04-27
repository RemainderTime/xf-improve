package cn.xf.improve.dataStructure.tree.trie.test02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: TrieNode
 * @Author: xiongfeng
 * @Date: 2023/4/27 14:01
 * @Version: 1.0
 */
public class TrieNode {

	public TrieNode[] slot = new TrieNode[26];

	public char c;

	public String word;

	public boolean isWord;

	public int prefix;

	public String explain;
}
