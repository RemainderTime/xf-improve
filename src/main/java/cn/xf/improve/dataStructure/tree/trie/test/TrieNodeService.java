package cn.xf.improve.dataStructure.tree.trie.test;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @ClassName: TrieNodeService
 * @Author: xiongfeng
 * @Date: 2023/4/25 11:32
 * @Version: 1.0
 */

@Service
public interface TrieNodeService {

	void inset(String str, String explain);

	List<String> searchWord(String word);
}
