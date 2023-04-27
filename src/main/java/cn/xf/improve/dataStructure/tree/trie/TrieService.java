package cn.xf.improve.dataStructure.tree.trie;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @ClassName: TrieService
 * @Author: xiongfeng
 * @Date: 2023/4/25 10:10
 * @Version: 1.0
 */

@Service
public interface TrieService {

	void insert(String words, String explain);

	List<String> searchPrefix(String prefix);

}
