package com.cslc.dao.analysedayaccount;

import java.util.List;
import java.util.Map;
import com.platform.base.MysqlBaseDao;
import org.springframework.stereotype.Service;

@Service("analysedayaccountDao")
public class AnalysedayaccountDao extends MysqlBaseDao {

	public Long insert(Analysedayaccount meta) {
		return insert("Analysedayaccount.insert", meta);
	}

	public boolean delete(Long id) {
		return delete("Analysedayaccount.delete", id);
	}

	public boolean update(Analysedayaccount meta) {
		return update("Analysedayaccount.update", meta);
	}

	public List<Analysedayaccount> select(Map<String, Object> map) {
		return (List<Analysedayaccount>) queryForList("Analysedayaccount.select", map);
	}

	public long selectCount(Map<String, Object> map) {
		return (Long) queryForObject("Analysedayaccount.selectCount", map);
	}

	public double selectSum(Map<String, Object> map) {
		Object result = queryForObject("Analysedayaccount.selectSum", map);
		if(result != null){
			return (Double) result;
		}
		return 0;
	}

}

