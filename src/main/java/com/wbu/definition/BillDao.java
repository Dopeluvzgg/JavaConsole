package com.wbu.definition;

import java.util.ArrayList;

/**
 * @author shuo.yu2@dxc.com
 * @className BillDao
 * @description
 * @date 2023/12/8
 * @version 1.0
 */
public interface BillDao<T> {
    Integer add(T element);
    boolean delete(Integer id);
    boolean update(Integer id, T element);
    T selectById(Integer id);
    ArrayList<T> selectAll();
}
