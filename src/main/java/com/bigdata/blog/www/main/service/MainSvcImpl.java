/**
 * 
 */
package com.bigdata.blog.www.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata.blog.www.main.dao.MainDAO;

/**
 * @author 	: quickmenu
 * @Date	: 2015. 6. 21.
 * @Type	: bigdata
 * @Version	: 1.0 
 */
@Service
public class MainSvcImpl implements MainSvc {

	@Autowired
	MainDAO mainDAO;
	/* (non-Javadoc)
	 * @see com.bigdata.blog.www.main.service.MainSvc#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mainDAO.getCount();
	}

}
