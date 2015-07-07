/**
 * 
 */
package com.bigdata.blog.www.main.domain;

/**
 * @author 	: quickmenu
 * @Date	: 2015. 6. 21.
 * @Type	: bigdata
 * @Version	: 1.0
 */
public class TestLog {
	private int idx;		// 0. 식별자(index)
	private String type;
	private int count;
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
