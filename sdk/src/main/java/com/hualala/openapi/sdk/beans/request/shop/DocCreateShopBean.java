package com.hualala.openapi.sdk.beans.request.shop;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import com.hualala.openapi.sdk.beans.request.HeaderBean;
import lombok.Data;

import java.util.List;

@Data
public class DocCreateShopBean extends BaseBean {
    private Long brandID;
    private String shopName;
    private String openingHours;
    private String tel;
    private String keywordLst;
    private String address;
    private Integer businessModel;
    private String manageMode;
    private String orgCode;
    private Integer operationMode;
    private String ACSPType;
    private String ImagePath;
    private String newCountryID;
    private String newProvinceID;
    private String newCityID;
    private String newDistrictID;
    private String newTownID;
    private Double mapLongitudeValue;
    private Double mapLatitudeValue;
    private List<ShopTime> shopTimeList;
    private List<CashierShift> cashierShiftList;
    private HeaderBean header;//暂时只放traceID

    @Data
    public static class ShopTime {
        private String timeID;
        private String timeName;
        private String startTime;
        private String endTime;
        private String isActive;
    }

    @Data
    public static class CashierShift {
        private String id;
        private String shiftName;
        private String startTime;
        private String endTime;
        private String isActive;
    }
}
