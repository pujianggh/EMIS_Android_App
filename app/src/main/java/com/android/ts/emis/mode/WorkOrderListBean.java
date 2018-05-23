package com.android.ts.emis.mode;

import java.io.Serializable;
import java.util.List;

/**
 * 工单列表（根据不同类型）
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListBean extends BaseStateBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<WorkOrderListBean.Data> getData() {
        return Data;
    }

    public void setData(List<WorkOrderListBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable{
        private String id;
        private String orderCode;
        private String pfmCode;
        private String createTime;
        private String state;
        private String orderDescribe;//
        private String orderStatus;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getPfmCode() {
            return pfmCode;
        }

        public void setPfmCode(String pfmCode) {
            this.pfmCode = pfmCode;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getOrderDescribe() {
            return orderDescribe;
        }

        public void setOrderDescribe(String orderDescribe) {
            this.orderDescribe = orderDescribe;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
    }
}
