package cn.xf.improve.dataStructure.tree.trie.test02;

import java.util.List;

/**
 * @Description:
 * @ClassName: ITrieNode
 * @Author: xiongfeng
 * @Date: 2023/4/27 14:03
 * @Version: 1.0
 */
public interface ITrieNode {

	void insert(String words, String explain);

	List<String> searchPrefix(String prefix);
}
