package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("alphaDaoImplMybatis")
public class AlphaDaoImplMybatis implements AlphaDao {

    @Override
    public String select() {
        System.out.println("hello alphaDaoImplMybatis");
        return null;
    }
}
