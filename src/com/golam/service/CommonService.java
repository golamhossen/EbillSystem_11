
package com.golam.service;

import java.util.List;

/**
 *
 * @author HP
 */
public interface CommonService<T> {

    public void createTable();

    void save(T t);

    void delete(int id);

    void update(T t);

    T get(int id);

    List<T> getList();

    T getCustomerDetails(String month);
    
    T getMeterNo(int meterNo);
    
     T getUserByUsernameAndPassword(String username, String password);
}
