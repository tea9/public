package com.demo.android_ds.entity;

import java.util.List;

/**
 * created by tea9 at 2019/3/24
 */
public class TestEntity {
    /**
     * code : 200
     * data : {"current":1,"pages":10083,"records":[{"createTime":1549166814000,"equipmentID":"1111","id":1,"isshow":1,"password":"","registerCode":"96ed32fd-d66f-4c4d-b079-9438ea76be67","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550617433000,"username":""},{"createTime":1549166814000,"equipmentID":"b09e46ab97e9b532dd3aa9ff0a9b12ff","id":2,"isshow":1,"password":"","registerCode":"43681eb5-44bc-41b5-83af-a93c8560f48d","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550626175000,"username":""},{"createTime":1549166814000,"equipmentID":"07d025cad59f417ac507dd9c10a7dc8e","id":3,"isshow":1,"password":"","registerCode":"44531aeb-9e99-45ab-8049-6834e05bd668","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550626271000,"username":""},{"createTime":1549166814000,"equipmentID":"1871399b9f659ac3f635e58fb533948d","id":4,"isshow":1,"password":"","registerCode":"13560099-3597-4343-855a-6555995ecf19","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550637139000,"username":""},{"createTime":1549166814000,"equipmentID":"373d343910f2c785bfd1244b8cf7db19","id":5,"isshow":1,"password":"","registerCode":"da8afed0-2c0b-44b5-abc7-f485f42c3d65","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550637359000,"username":""},{"createTime":1549166814000,"equipmentID":"","id":6,"isshow":1,"password":"","registerCode":"427a37cd-41ca-48f3-a22a-1a5fbf5dbea9","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""},{"createTime":1549166814000,"equipmentID":"","id":7,"isshow":1,"password":"","registerCode":"80d07505-0f8b-43f0-919a-570b94464a3c","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""},{"createTime":1549166814000,"equipmentID":"e28a74d97e7ca27b961ab9d093e8e257","id":8,"isshow":1,"password":"","registerCode":"1cc82c8c-1ed9-468f-85dd-b862868ae16d","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1552062300000,"username":""},{"createTime":1549166814000,"equipmentID":"3ba7ef912be7fdd1ce7c5290ed684caa","id":9,"isshow":1,"password":"","registerCode":"6d1b9dc4-785e-473f-9931-a9aabebba4c9","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1552726689000,"username":""},{"createTime":1549166814000,"equipmentID":"","id":10,"isshow":1,"password":"","registerCode":"aad62aba-3afa-41d8-85f3-f3fb0a500d11","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""}],"size":10,"total":100830}
     * msg : success
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * current : 1
         * pages : 10083
         * records : [{"createTime":1549166814000,"equipmentID":"1111","id":1,"isshow":1,"password":"","registerCode":"96ed32fd-d66f-4c4d-b079-9438ea76be67","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550617433000,"username":""},{"createTime":1549166814000,"equipmentID":"b09e46ab97e9b532dd3aa9ff0a9b12ff","id":2,"isshow":1,"password":"","registerCode":"43681eb5-44bc-41b5-83af-a93c8560f48d","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550626175000,"username":""},{"createTime":1549166814000,"equipmentID":"07d025cad59f417ac507dd9c10a7dc8e","id":3,"isshow":1,"password":"","registerCode":"44531aeb-9e99-45ab-8049-6834e05bd668","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550626271000,"username":""},{"createTime":1549166814000,"equipmentID":"1871399b9f659ac3f635e58fb533948d","id":4,"isshow":1,"password":"","registerCode":"13560099-3597-4343-855a-6555995ecf19","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550637139000,"username":""},{"createTime":1549166814000,"equipmentID":"373d343910f2c785bfd1244b8cf7db19","id":5,"isshow":1,"password":"","registerCode":"da8afed0-2c0b-44b5-abc7-f485f42c3d65","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1550637359000,"username":""},{"createTime":1549166814000,"equipmentID":"","id":6,"isshow":1,"password":"","registerCode":"427a37cd-41ca-48f3-a22a-1a5fbf5dbea9","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""},{"createTime":1549166814000,"equipmentID":"","id":7,"isshow":1,"password":"","registerCode":"80d07505-0f8b-43f0-919a-570b94464a3c","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""},{"createTime":1549166814000,"equipmentID":"e28a74d97e7ca27b961ab9d093e8e257","id":8,"isshow":1,"password":"","registerCode":"1cc82c8c-1ed9-468f-85dd-b862868ae16d","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1552062300000,"username":""},{"createTime":1549166814000,"equipmentID":"3ba7ef912be7fdd1ce7c5290ed684caa","id":9,"isshow":1,"password":"","registerCode":"6d1b9dc4-785e-473f-9931-a9aabebba4c9","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":1552726689000,"username":""},{"createTime":1549166814000,"equipmentID":"","id":10,"isshow":1,"password":"","registerCode":"aad62aba-3afa-41d8-85f3-f3fb0a500d11","startTime":1549166791000,"stopTime":1580702791000,"type":1,"updateTime":null,"username":""}]
         * size : 10
         * total : 100830
         */

        private int current;
        private int pages;
        private int size;
        private int total;
        private List<RecordsBean> records;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
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

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * createTime : 1549166814000
             * equipmentID : 1111
             * id : 1
             * isshow : 1
             * password :
             * registerCode : 96ed32fd-d66f-4c4d-b079-9438ea76be67
             * startTime : 1549166791000
             * stopTime : 1580702791000
             * type : 1
             * updateTime : 1550617433000
             * username :
             */

            private long createTime;
            private String equipmentID;
            private int id;
            private int isshow;
            private String password;
            private String registerCode;
            private long startTime;
            private long stopTime;
            private int type;
            private long updateTime;
            private String username;

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getEquipmentID() {
                return equipmentID;
            }

            public void setEquipmentID(String equipmentID) {
                this.equipmentID = equipmentID;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsshow() {
                return isshow;
            }

            public void setIsshow(int isshow) {
                this.isshow = isshow;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRegisterCode() {
                return registerCode;
            }

            public void setRegisterCode(String registerCode) {
                this.registerCode = registerCode;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public long getStopTime() {
                return stopTime;
            }

            public void setStopTime(long stopTime) {
                this.stopTime = stopTime;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
