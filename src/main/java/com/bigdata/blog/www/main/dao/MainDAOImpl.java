/**
 * 
 */
package com.bigdata.blog.www.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bigdata.blog.www.main.domain.TestLog;

/**
 * @author 	: quickmenu
 * @Date	: 2015. 6. 21.
 * @Type	: bigdata
 * @Version	: 1.0
 */
@Repository
public class MainDAOImpl implements MainDAO {

	/* (non-Javadoc)
	 * @see com.bigdata.blog.www.main.dao.MainDAO#getCount()
	 */
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired 
	private MongoOperations mongoOperations;
	
	private final String COLLECTION = "testlog";
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("access"));
		TestLog testLog = mongoTemplate.findOne(query, TestLog.class, COLLECTION);
		return testLog.getCount();
	}

}
