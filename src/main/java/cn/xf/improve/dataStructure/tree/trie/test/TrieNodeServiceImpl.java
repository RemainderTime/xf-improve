package cn.xf.improve.dataStructure.tree.trie.test;

import cn.xf.improve.dataStructure.tree.trie.TrieService;
import cn.xf.improve.dataStructure.tree.trie.TrieServiceImpl;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 字典树操作实现类
 * @ClassName: TrieNodeServiceImpl
 * @Author: xiongfeng
 * @Date: 2023/4/25 11:35
 * @Version: 1.0
 */

@Slf4j
public class TrieNodeServiceImpl implements TrieNodeService {

	private static final TrieNode wordNodes = new TrieNode();

	@Override
	public void inset(String str, String explain) {
		TrieNode root = wordNodes;
		char[] chars = str.toCharArray();
		for (char c : chars) {
			int index = c - 'a';
			if (root.slot[index] == null) {
				root.slot[index] = new TrieNode();
			}
			root = root.slot[index];
			root.c = c;
			root.prefix++;
		}

		root.isWord = true;
		root.explain = explain;
	}

	@Override
	public List<String> searchWord(String word) {
		TrieNode root = wordNodes;
		char[] chars = word.toCharArray();
		StringBuilder queue = new StringBuilder();
		List<String> list = new ArrayList<>();
		for (char c : chars) {
			int index = c - 'a';
			if (index > root.slot.length || root.slot[index] == null || index < 0) {
				return null;
			}
			root = root.slot[index];
			queue.append(c);
		}

		for (int i = 0; i < root.slot.length; i++) {
			if (root.slot[i] == null) {
				continue;
			}
			collect(list, word + root.c, root.slot[i], 15);
		}
		return list;
	}

	protected void collect(List<String> list, String word, TrieNode root, int maxSize) {
		if (root.isWord) {
			list.add(word + root.c + "---->" + root.explain);
			root.word = word + root.c;
		}
		if (list.size() > maxSize) {
			return;
		}
		for (int i = 0; i < root.slot.length; i++) {
			if (root.slot[i] == null) {
				continue;
			}
			collect(list, word + root.c, root.slot[i], maxSize);
		}
	}

	@Test
	public void test_trie() {
		TrieService trie = new TrieServiceImpl();
		// 存入
		trie.insert("bat","大厂");
		trie.insert("batch", "批量");
		trie.insert("bitch", "彪子");
		trie.insert("battle", "战斗");
		log.info(trie.toString());
		// 检索
		List<String> trieNodes = trie.searchPrefix("ba");
		log.info("测试结果：{}", JSON.toJSONString(trieNodes));
	}
}
