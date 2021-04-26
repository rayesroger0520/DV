/*
 * News.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package entity;

import java.util.Date;

/**
 * News <br>
 * 
 * <pre>
 * Store News
 * .News()
 * .getId()
 * .setId()
 * .getTitle()
 * .setTitle()
 * .getWriter()
 * .setWriter()
 * .getShortDescription()
 * .setShortDescription()
 * .getFullDescription()
 * .setFullDescription()
 * .getPublishedDate()
 * .setPublishedDate()
 * .getImg()
 * .setImg()
 * .getShowDate()
 * .setShowDate()
 * </pre>
 * 
 * @author thinh
 */
public class News {
    /** Store the id */
    private int id;
    
    /** Store the title */
    private String title;
    
    /** Store the writer */
    private String writer;
    
    /** Store the shortDescription */
    private String shortDescription;
    
    /** Store the fullDescription */
    private String fullDescription;
    
    /** Store the publishedDate */
    private Date publishedDate;
    
    /** Store the img */
    private String img;
    
    /** Store the showDate */
    private String showDate;

    /**
     * Constructor.<br>
     */
    public News() {
    }

    /**
     * Constructor.<br>
     * 
     * @param id
     * @param title
     * @param writer
     * @param shortDescription
     * @param fullDescription 
     * @param publishedDate
     * @param img
     */
    public News(int id, String title, String writer, String shortDescription, String fullDescription, Date publishedDate, String img) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.publishedDate = publishedDate;
        this.img = img;
    }

    /**
     * Get id.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     * 
     * @param  id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get title.<br>
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     * 
     * @param  title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get writer.<br>
     * 
     * @return the writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     * Set writer.<br>
     * 
     * @param  writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * Get shortDescription.<br>
     * 
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Set shortDescription.<br>
     * 
     * @param  shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Get fullDescription.<br>
     * 
     * @return the fullDescription
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * Set fullDescription.<br>
     * 
     * @param  fullDescription
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * Get publishedDate.<br>
     * 
     * @return the publishedDate
     */
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * Set publishedDate.<br>
     * 
     * @param  publishedDate
     */
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Get img.<br>
     * 
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * Set img.<br>
     * 
     * @param  img
     */
    public void setImg(String img) {
        this.img = img;
    }
 
    /**
     * Get showDate.<br>
     * 
     * @return the showDate
     */
    public String getShowDate() {
        return showDate;
    }

    /**
     * Set showDate.<br>
     * 
     * @param  showDate
     */
    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }
}
