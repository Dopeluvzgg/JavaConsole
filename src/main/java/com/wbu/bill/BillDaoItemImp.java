package com.wbu.bill;

import com.wbu.definition.BillDao;

import java.util.ArrayList;

/**
 * @author shuo.yu2@dxc.com
 * @className BillDaoItemImp
 * @description
 * @date 2023/12/9
 * @version 1.0
 */
public class BillDaoItemImp implements BillDao<BillItem> {
    @Override
    public Integer add(BillItem element) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(Integer id, BillItem element) {
        return false;
    }

    @Override
    public BillItem selectById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<BillItem> selectAll() {
        return null;
    }
}
