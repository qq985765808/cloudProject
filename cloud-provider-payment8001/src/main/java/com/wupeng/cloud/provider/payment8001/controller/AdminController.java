package com.wupeng.cloud.provider.payment8001.controller;

import com.wupeng.cloud.provider.payment8001.vo.ServerThreadInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController  implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);


    /**
     * 获取服务器的线程元素信息
     * */
    @RequestMapping(value = "/getServerThreadInfo")
    public  Object getServerThreadInfo(Model model){
        List<ServerThreadInfoVO> stiVO = new ArrayList<>();
        List<ServerThreadInfoVO> elementVO = new ArrayList<>();
        for (Map.Entry<Thread,StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
            Thread thread = (Thread) stackTrace.getKey();
            ServerThreadInfoVO  vo = new ServerThreadInfoVO();
            StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
            if(thread.equals(Thread.currentThread())){
                continue;
            }
            vo.setThreadName(thread.getName()); //线程名称
            stiVO.add(vo);
            for (StackTraceElement element : stack){
                ServerThreadInfoVO  e = new ServerThreadInfoVO();
                e.setElement(element);
                elementVO.add(e);

            }
        }
        model.addAttribute("thraadNameList",stiVO);
        model.addAttribute("elementList",elementVO);
        return "/admin/serverThreadInfo";
    }


}
