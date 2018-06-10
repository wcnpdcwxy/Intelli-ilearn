package com.edu360.ilearn.Vo;

import com.edu360.ilearn.entity.Content;
import org.springframework.web.multipart.MultipartFile;

public class InsContentVo {
    private String courseId;
    private MultipartFile file;
    private Content content;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InsContentVo{" +
                "courseId='" + courseId + '\'' +
                ", file=" + file +
                ", content=" + content +
                '}';
    }
}
