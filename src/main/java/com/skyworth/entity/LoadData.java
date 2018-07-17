/**
 * 
 */
package com.skyworth.entity;

import java.util.ArrayList;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: LoadData.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月4日 下午2:27:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月4日     Administrator           v1.0.0               修改原因
*/
public class LoadData {
    private int id;
    private String name;
    private ArrayList<tData> data;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }



    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }



    /**
     * @return the name
     */
    public String getName() {
        return name;
    }



    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }



    /**
     * @return the data
     */
    public ArrayList<tData> getData() {
        return data;
    }



    /**
     * @param data the data to set
     */
    public void setData(ArrayList<tData> data) {
        this.data = data;
    }

    /* 非静态的内部类默认的构造函数有一个参数，这个参数指向其外部类的实例,
     * 对于内部类，如果没必要访问外部类，我们可以将其定义为static的*/
    static class tData{
	private int tYear;
	private int tMonth;
	private int tWeek;
	private int tNum;
	/**
	 * @return the tYear
	 */
	public int gettYear() {
	    return tYear;
	}
	/**
	 * @param tYear the tYear to set
	 */
	public void settYear(int tYear) {
	    this.tYear = tYear;
	}
	/**
	 * @return the tMonth
	 */
	public int gettMonth() {
	    return tMonth;
	}
	/**
	 * @param tMonth the tMonth to set
	 */
	public void settMonth(int tMonth) {
	    this.tMonth = tMonth;
	}
	/**
	 * @return the tWeek
	 */
	public int gettWeek() {
	    return tWeek;
	}
	/**
	 * @param tWeek the tWeek to set
	 */
	public void settWeek(int tWeek) {
	    this.tWeek = tWeek;
	}
	/**
	 * @return the tNum
	 */
	public int gettNum() {
	    return tNum;
	}
	/**
	 * @param tNum the tNum to set
	 */
	public void settNum(int tNum) {
	    this.tNum = tNum;
	}
	
	
    }
    
    
}
