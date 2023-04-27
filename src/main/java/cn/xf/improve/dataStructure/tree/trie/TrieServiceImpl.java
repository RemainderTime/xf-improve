package cn.xf.improve.dataStructure.tree.trie;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @ClassName: TrieServiceImpl
 * @Author: xiongfeng
 * @Date: 2023/4/25 10:11
 * @Version: 1.0
 */

@Slf4j
public class TrieServiceImpl implements  TrieService{

	public final static TrieNode wordsTree = new TrieNode();

	@Override
	public void insert(String words, String explain) {
		TrieNode root = wordsTree;
		char[] chars = words.toCharArray();
		for (char c : chars) {
			int idx = c - 'a'; // - a 从 0 开始，参考 ASCII 码表
			if (root.slot[idx] == null) {
				root.slot[idx] = new TrieNode();
			}
			root = root.slot[idx];
			root.c = c;
			root.prefix++;
		}
		root.explain = explain; // 单词的注释说明信息
		root.isWord = true;     // 循环拆解单词后标记
	}

	@Override
	public List<String> searchPrefix(String prefix) {
		TrieNode root = wordsTree;
		char[] chars = prefix.toCharArray();
		StringBuilder cache = new StringBuilder();
		// 精准匹配：根据前置精准查找
		for (char c : chars) {
			int idx = c - 'a';
			// 匹配为空
			if (idx > root.slot.length || idx < 0 || root.slot[idx] == null) {
				return Collections.emptyList();
			}
			cache.append(c);
			root = root.slot[idx];
		}
		// 模糊匹配：根据前缀的最后一个单词，递归遍历所有的单词
		ArrayList<String> list = new ArrayList<>();
		if (root.prefix != 0) {
			for (int i = 0; i < root.slot.length; i++) {
				if (root.slot[i] != null) {
//					char c = (char) (i + 'a');
					char c = root.slot[i].c;
					collect(root.slot[i], String.valueOf(cache) + c, list, 15);
					if (list.size() >= 15) {
						return list;
					}
				}
			}
		}
		return list;
	}

	protected void collect(TrieNode trieNode, String pre, List<String> queue, int resultLimit) {
		// 找到单词
		if (trieNode.isWord) {
			trieNode.word = pre;
			// 保存检索到的单词到 queue
			queue.add(trieNode.word + " -> " + trieNode.explain);
			if (queue.size() >= resultLimit) {
				return;
			}
		}
		// 递归调用，查找单词
		for (int i = 0; i < trieNode.slot.length; i++) {
			char c = (char) ('a' + i);
			if (trieNode.slot[i] != null) {
				collect(trieNode.slot[i], pre + c, queue, resultLimit);
			}
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
