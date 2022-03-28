package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

import java.util.List;

/**
 * @ Description：支付
 */
@Data
public class WechatPayoutBean extends BaseBean {
    private OrderCommonBean header;
    private Long orderKey;
    private WechatUserInfoBean userInfo;
    private List<PaymentDetailBean> payment;
    private Integer orderSubType;
    private Integer isThirdPay;
    private String bankCode;
    private Integer isPay;
    private Long chargeType;
    private Integer checkoutType;
    private Integer stalls;
    private Integer isSentMsg;
    private Integer isPubPay;
    private Integer msgType;
    private Integer orderStatus;
    private String paidTotalAmount;
    private String channelKey;

    private String loginToken; //微信接口返回的登录票据  公众号：填写access_token   小程序：填写：session_key
    private String orderEntry;//公众号：页面完整URL   小程序：path路径
    private VerifyInfoVo verifyInfo;//具体要核销的券信息

    @Data
    public class VerifyInfoVo {
        private String preConsumeNo; //支付需要的token,查询时返回的
        private List<VerifyVoucherInfo> verifyVoucher;//
    }

    @Data
    public class VerifyVoucherInfo {
        private String voucherCode; // 券码
        private String voucherType;  // 券类型:CASH:代金券，FOOD:菜品券
    }
}
   
    