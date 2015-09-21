package com.cslc.dao.analysedayplatform;

import java.util.List;
import java.util.Map;
import com.platform.base.MysqlBaseDao;
import org.springframework.stereotype.Service;

@Service("analysedayDao")
public class AnalysedayplatformDao extends MysqlBaseDao {

	public Long insert(Analysedayplatform meta) {
		return insert("Analyseday.insert", meta);
	}

	public boolean delete(Long id) {
		return delete("Analyseday.delete", id);
	}

	public boolean update(Analysedayplatform meta) {
		return update("Analyseday.update", meta);
	}

	public List<Analysedayplatform> select(Map<String, Object> map) {
		return (List<Analysedayplatform>) queryForList("Analyseday.select", map);
	}

	public long selectCount(Map<String, Object> map) {
		return (Long) queryForObject("Analyseday.selectCount", map);
	}

	public double selectSum(Map<String, Object> map) {
		Object result = queryForObject("Analyseday.selectSum", map);
		if(result != null){
			return (Double) result;
		}
		return 0;
	}

}

