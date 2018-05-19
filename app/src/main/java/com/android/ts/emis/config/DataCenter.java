package com.android.ts.emis.config;

import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.mode.ProjectMessageBean;
import com.android.ts.emis.mode.WorkModuleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据
 *
 * @author pujiang
 * @date 2018-5-16 13:06
 * @mail 515210530@qq.com
 * @Description:
 */
public class DataCenter {

    /**
     * 获取消息中心数据
     */
    public static ProjectMessageBean getProjectMessageModuleData() {
        ProjectMessageBean dataBean = new ProjectMessageBean();
        dataBean.setTotal(20);

        List<ProjectMessageBean.Data> list = new ArrayList<>();
        ProjectMessageBean.Data data;
        for (int i = 0; i < 6; i++) {
            data = new ProjectMessageBean.Data();
            if (i == 0) {
                data.setName("晶融汇广场");
                data.setProvince("四川");
                data.setCity("成都市");
                data.setArea("武侯区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/53/06k58PICXIH.jpg");
                data.setMsgCount(3);
            } else if (i == 1) {
                data.setName("苏悦");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("长宁区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/89/48n58PICsRS.jpg");
                data.setMsgCount(0);
            } else if (i == 2) {
                data.setName("乔布斯公馆");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("长宁区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/53/06k58PICXIH.jpg");
                data.setMsgCount(129);
            } else if (i == 3) {
                data.setName("香港美心");
                data.setProvince("香港");
                data.setCity("香港");
                data.setArea("九龙城区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/31/86g58PICUZb.jpg");
                data.setMsgCount(1);
            } else if (i == 4){
                data.setName("前滩验房缺陷统计");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("浦东新区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/37/33x58PIC7gf.jpg");
                data.setMsgCount(48);
            }else {
                data.setName("测试楼盘");
                data.setProvince("江苏");
                data.setCity("常州");
                data.setArea("新区");
                data.setImgeURL("http://pic8.nipic.com/20100727/2572038_010122214489_2.jpg");
                data.setMsgCount(0);
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 获取消息中心数据
     */
    public static MessageInfoBean getMessageModuleData() {
        List<MessageInfoBean.Data> list = new ArrayList<>();
        MessageInfoBean dataBean = new MessageInfoBean();
        dataBean.setTotal(20);

        MessageInfoBean.Data data;
        for (int i = 0; i < 20; i++) {
            data = new MessageInfoBean.Data();
            if (i < 3) {
                data.setDate("今天");
                data.setState("0");
            } else if (i < 10) {
                data.setDate("昨天");
                data.setState("1");
            } else {
                data.setDate("2018-4-30");
                data.setState("0");
            }
            data.setId("" + i);
            data.setMessage("尊敬的用户您好,巡检任务测试于2018-04-02开始，请提前准备。");
            data.setTitle("EMIS");
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 获取工作模块数据
     */
    public static WorkModuleBean getWorkModuleData() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("巡检");
        bodyBean.setCount(2);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(10001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("工单");
        bodyBean1.setCount(100);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(10002);

        WorkModuleBean.BodyBean bodyBean2 = new WorkModuleBean.BodyBean();
        bodyBean2.setName("计划性维护");
        bodyBean2.setCount(0);
        bodyBean2.setImageURL("");
        bodyBean2.setWorkCode(10003);

        WorkModuleBean.BodyBean bodyBean3 = new WorkModuleBean.BodyBean();
        bodyBean3.setName("资产");
        bodyBean3.setCount(1);
        bodyBean3.setImageURL("");
        bodyBean3.setWorkCode(10004);

        WorkModuleBean.BodyBean bodyBean4 = new WorkModuleBean.BodyBean();
        bodyBean4.setName("厂库");
        bodyBean4.setCount(0);
        bodyBean4.setImageURL("");
        bodyBean4.setWorkCode(10005);

        WorkModuleBean.BodyBean bodyBean5 = new WorkModuleBean.BodyBean();
        bodyBean5.setName("厂库2");
        bodyBean5.setCount(2);
        bodyBean5.setImageURL("");
        bodyBean5.setWorkCode(10008);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);
        mDatas.add(bodyBean2);
        mDatas.add(bodyBean3);
        mDatas.add(bodyBean4);
        mDatas.add(bodyBean5);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }
}
