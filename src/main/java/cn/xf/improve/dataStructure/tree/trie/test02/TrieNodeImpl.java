package cn.xf.improve.dataStructure.tree.trie.test02;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @ClassName: TrieNodeImpl
 * @Author: xiongfeng
 * @Date: 2023/4/27 14:04
 * @Version: 1.0
 */
@Service
public class TrieNodeImpl implements ITrieNode {


	private static TrieNode nodeWords = new TrieNode();

	@Override
	public void insert(String words, String explain) {
		if (StringUtils.isEmpty(words)) {
			throw new RuntimeException();
		}
		TrieNode root = nodeWords;
		char[] chars = words.toCharArray();
		for (char c : chars) {
			int index = c - 'a';
			if (root.slot[index] == null) {
				root.slot[index] = new TrieNode();
			}
			root.c = c;
			root = root.slot[index];
			root.prefix++;
		}
		root.isWord = true;
		root.explain = explain;
	}

	@Override
	public List<String> searchPrefix(String prefix) {
		if (StringUtils.isEmpty(prefix)) {
			throw new RuntimeException();
		}
		TrieNode root = nodeWords;
		char[] chars = prefix.toCharArray();
		StringBuilder queue = new StringBuilder();
		List<String> list = new ArrayList<>();
		for (char c : chars) {
			int index = c - 'a';
			if (index > root.slot.length && root.slot[index] == null && index > 0) {
				return Collections.emptyList();
			}
			queue.append(c);
			root = root.slot[index];
		}

		if (root.prefix > 0) {
			for (TrieNode node : root.slot) {
				if (node == null) {
					continue;
				}
				if (node.prefix > 0) {
					collect(list, queue.toString() + node.c, node, 15);
				}
				if (list.size() >= 15) {
					return list;
				}
			}
		}
		return list;
	}

	public void collect(List<String> list, String word, TrieNode root, int maxSize) {
		if (root.isWord) {
			list.add(word + "----->" + root.explain);
			root.word = word;
			if (list.size() >= maxSize) {
				return;
			}
		}
		for (TrieNode node : root.slot) {
			if (node == null) {
				continue;
			}
			if (node.prefix > 0) {
				collect(list, word + node.c, node, maxSize);
			}
		}
	}


}
