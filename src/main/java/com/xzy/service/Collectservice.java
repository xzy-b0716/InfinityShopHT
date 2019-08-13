/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Collectservice
 * Author:   李佳佳同学
 * Date:     2019/8/8 12:02
 * Description: suibain
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xzy.service;

import com.xzy.beans.Collect;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈suibain 〉
 *
 * @author 李佳佳同学
 * @create 2019/8/8
 * @since 1.0.0
 */
public interface Collectservice {


    public void delete(Collect collect);
    public void insert(Collect collect);
    public List<Integer> selectallpid(Integer userid);
    public boolean panduan(Collect collect);

}
