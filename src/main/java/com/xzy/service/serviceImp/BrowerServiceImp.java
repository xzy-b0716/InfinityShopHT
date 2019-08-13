package com.xzy.service.serviceImp;

import com.xzy.beans.Browse;
import com.xzy.mapper.BrowseMapper;
import com.xzy.service.BrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Shuai on 2019/8/13 11:33
 */
@Service
public class BrowerServiceImp implements BrowerService {
    @Autowired
    private BrowseMapper browseMapper;
    //   根据用户id查询商品浏览记录表
    @Override
    public List<Browse> getHistoryByUserId(Integer userId) {
        List<Browse> userHistories=browseMapper.selectHistoryByUserId(userId);
        return userHistories;
    }
    //   根据用户id和商品id查询浏览记录
    @Override
    public Browse getHistoryByUserIdAndProductId(Browse userHistory) {
        return browseMapper.selectHistoryByUserIdAndProductId(userHistory);
    }
    //   更新商品浏览历史
    @Override
    public void updateHistory(Browse userHistory) {
        browseMapper.updateByupdateHistory(userHistory);
    }
    //   插入商品到浏览历史表
    @Override
    public void insertProductHistory(Browse userHistory) {
        browseMapper.insertHistory(userHistory);

    }
    //  删除一条浏览记录
    @Override
    public void delete(Integer userId, Integer productId) {
        browseMapper.deleteHistory(userId,productId);
    }
}
