package com.wupeng.cloud.provider.payment8001.support.wechat;

import com.wupeng.cloud.provider.payment8001.utils.AesException;
import com.wupeng.cloud.provider.payment8001.utils.WXPublicUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2020-04-14
 */
@RestController
@RequestMapping(value = "wechat")
public class WeChatController {

    @RequestMapping("/verify_wx_token")
    public String verifyWXToken(HttpServletRequest request) throws AesException {
        String msgSignature = request.getParameter("signature");
        String msgTimestamp = request.getParameter("timestamp");
        String msgNonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
            return echostr;
        }
        return null;
    }

}
