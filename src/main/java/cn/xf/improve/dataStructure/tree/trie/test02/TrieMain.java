package cn.xf.improve.dataStructure.tree.trie.test02;

import cn.xf.improve.dataStructure.tree.trie.TrieService;
import cn.xf.improve.dataStructure.tree.trie.TrieServiceImpl;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @ClassName: TrieMain
 * @Author: xiongfeng
 * @Date: 2023/4/27 14:38
 * @Version: 1.0
 */

@Slf4j
public class TrieMain {


	@Test
	public void test_trie() {
		TrieNodeImpl trie = new TrieNodeImpl();
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
