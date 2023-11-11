package com.example.bigkinds_hackerton;

public class Model {

    private int image;
    private String content;
    private String editor;
    private String url;

    public Model(int image, String content, String editor, String url) {
        this.image = image;
        this.content = content;
        this.editor = editor;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Model(int image, String content, String editor) {
        this.image = image;
        this.content = content;
        this.editor = editor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
