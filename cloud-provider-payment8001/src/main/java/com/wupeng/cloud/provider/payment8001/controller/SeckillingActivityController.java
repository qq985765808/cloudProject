package com.wupeng.cloud.provider.payment8001.controller;

import com.wupeng.cloud.provider.payment8001.pojo.SeckillingActivity;
import com.wupeng.cloud.provider.payment8001.service.RedisService;
import com.wupeng.cloud.provider.payment8001.service.SeckillingActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "seckillingActivity")
public class SeckillingActivityController  implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SeckillingActivityController.class);


    @Autowired
    private RedisService redisService;
    @Autowired
    private SeckillingActivityService seckillingActivityService;


    @RequestMapping
    public String getSeckillingActivityView(
            @RequestParam(value = "seckillingActivityId",required = false) Long seckillingActivityId,
            Model model){
        try{
            List<SeckillingActivity> seckillingActivityList = (List<SeckillingActivity>)redisService.get("seckillingActivityALL");
            if(seckillingActivityList.isEmpty() || seckillingActivityList.size() ==0){
                redisService.set("seckillingActivityALL",seckillingActivityService.findAll());
                seckillingActivityList = (List<SeckillingActivity>)redisService.get("seckillingActivityALL");

            }
            if(seckillingActivityId!=null && !"".equals(seckillingActivityId)
                    &&  seckillingActivityId>0){
                for (SeckillingActivity seckillingActivity : seckillingActivityList) {
                    if (seckillingActivity.getSeckillingActivityId().equals(seckillingActivityId)){
                        model.addAttribute("seckillingActivityList",seckillingActivityList);
                        break;
                    }
                }
            }else{
                model.addAttribute("seckillingActivityList",seckillingActivityList);
            }
        }catch (Exception e){
            redisService.set("seckillingActivityALL",seckillingActivityService.findAll());
           log.debug("缓存限时活动信息失效",e);

        }
        return  "seckillingActivity";
    }



    @RequestMapping(value = "/updateRedisCache")
    @ResponseBody
    public   Object  updateRedisCache(Long  seckillingActivityId
    ){
        Map<String,Object> map = new HashMap<>();
        SeckillingActivity seckillingActivity = null;
        synchronized(seckillingActivityId){
            try{
                seckillingActivity = (SeckillingActivity) redisService.get("seckillingActivityId=" + seckillingActivityId);
                if (seckillingActivity != null && seckillingActivity.getSeckillingActivityProductsNum() > 0) {
                    seckillingActivity.setSeckillingActivityProductsNum(seckillingActivity.getSeckillingActivityProductsNum() - 1);
                    redisService.set("seckillingActivityId=" + seckillingActivity.getSeckillingActivityId(), seckillingActivity);
                    map.put("msg", "亲，恭喜你已经抢到了商品，静等商品发货，谢谢！");
                    map.put("status", true);
                } else {
                    map.put("msg", "亲，此秒杀活动商品库存不足，请留意最近的的秒杀活动，谢谢！");
                    map.put("status", false);
                }

            }catch (Exception e){
                map.put("msg","亲，此秒杀活动信息已失效了，请留意最近的的秒杀活动，谢谢！");
                map.put("status",false);
            }
        }
        return map;
    }



}
