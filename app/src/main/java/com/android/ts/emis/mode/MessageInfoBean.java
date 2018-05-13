package com.android.ts.emis.mode;

import java.io.Serializable;
import java.util.List;

/**
 * 消息中心
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageInfoBean implements Serializable {
    private int code;
    private String msg;

    private List<BodyBean> body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        private int page;
        private int size;
        private int total;
        private int totalPages;
        /**
         * createTime : 测试内容9g25
         * msgContent : 测试内容47op
         * msgId : 测试内容m280
         * msgLink : 测试内容kr7q
         * msgPic : 测试内容7kot
         * msgStat : 测试内容75f1
         * msgTitle : 测试内容5m8s
         * msgType : 测试内容059m
         */

        private List<DataBean> data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String createTime;
            private String msgContent;
            private String msgId;
            private String msgLink;
            private String msgPic;
            private String msgStat;
            private String msgTitle;
            private String msgType;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }

            public String getMsgId() {
                return msgId;
            }

            public void setMsgId(String msgId) {
                this.msgId = msgId;
            }

            public String getMsgLink() {
                return msgLink;
            }

            public void setMsgLink(String msgLink) {
                this.msgLink = msgLink;
            }

            public String getMsgPic() {
                return msgPic;
            }

            public void setMsgPic(String msgPic) {
                this.msgPic = msgPic;
            }

            public String getMsgStat() {
                return msgStat;
            }

            public void setMsgStat(String msgStat) {
                this.msgStat = msgStat;
            }

            public String getMsgTitle() {
                return msgTitle;
            }

            public void setMsgTitle(String msgTitle) {
                this.msgTitle = msgTitle;
            }

            public String getMsgType() {
                return msgType;
            }

            public void setMsgType(String msgType) {
                this.msgType = msgType;
            }
        }
    }
}
