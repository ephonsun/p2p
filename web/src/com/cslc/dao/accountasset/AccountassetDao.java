package com.cslc.dao.accountasset;

import java.util.List;
import java.util.Map;
import com.platform.base.MysqlBaseDao;
import org.springframework.stereotype.Service;

@Service("accountassetDao")
public class AccountassetDao extends MysqlBaseDao {

	public Accountasset selectById(Long id) {
		Object meta = queryForObject("Accountasset.selectById", id);
		if(meta != null){
			return (Accountasset) meta;
		}
		return null;
	}

	public Long insert(Accountasset meta) {
		return insert("Accountasset.insert", meta);
	}

	public boolean delete(Long id) {
		return delete("Accountasset.delete", id);
	}

	public boolean update(Accountasset meta) {
		return update("Accountasset.update", meta);
	}

	public List<Accountasset> select(Map<String, Object> map) {
		return (List<Accountasset>) queryForList("Accountasset.select", map);
	}

	public long selectCount(Map<String, Object> map) {
		Object count = queryForObject("Accountasset.selectCount", map);
		return count != null ? (Long) count : 0;
	}

	public double selectSum(Map<String, Object> map) {
		Object result = queryForObject("Accountasset.selectSum", map);
		if(result != null){
			return (Double) result;
		}
		return 0;
	}

}

