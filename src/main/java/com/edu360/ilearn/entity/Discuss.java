package com.edu360.ilearn.entity;
//课程评论
public class Discuss {
    private int id;
//    评论所述课程
    private int contentId;
//    评论内容
    private String content;
//    评论发表用户id
    private int userId;
//    评论发表用户nickName
    private String userNickName;
//    评论发表时间
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", userNickName=" + userNickName +
                ", time='" + time + '\'' +
                '}';
    }
}
