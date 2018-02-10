package com.example.zhengbotao.aacpractice.data;

/**
 * Created by zhengbotao on 18-2-10.
 */

public class Girl {

    private int resId;
    private String title;
    private String subTitle;

    public Girl(int resId, String title, String subTitle) {
        this.resId = resId;
        this.title = title;
        this.subTitle = subTitle;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
