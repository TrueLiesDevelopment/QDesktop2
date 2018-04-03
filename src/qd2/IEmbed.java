/*
 * All work contained within is subject to copyright.
 * (c)2018 - MrScabby, Phil C. 
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

import java.awt.Image;
import java.time.Instant;

/**
 *
 * @author idiot
 */
public class IEmbed {
    
    private String author = "";
    private String description = "";
    private Image image = null;
    private Image thumbnail = null;
    private Instant timestamp = null;
    private String title = "";
    private String type = "";
    private String url = "";
    private IEmbedVideo video = null;
    
    public IEmbed(String anAuthor, String aDescription, Image anImage, Image aThumbnail,
            Instant aTimestamp, String aTitle, String aType, String aUrl, IEmbedVideo aVideo){
        
        this.author = anAuthor;
        this.description = aDescription;
        this.image = anImage;
        this.thumbnail = aThumbnail;
        this.timestamp = aTimestamp;
        this.title = aTitle;
        this.type = aType;
        this.url = aUrl;
        this.video = null;
    }
    
    public IEmbed(){
        this.author = "";
        this.description = "";
        this.image = null;
        this.thumbnail = null;
        this.timestamp = null;
        this.title = "";
        this.type = "";
        this.url = "";
        this.video = null;
    }
    
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String anAuthor){
        this.author = anAuthor;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String aDescription){
        this.description = aDescription;
    }
    public Image getImage(){
        return this.image;
    }
    public void setImage(Image anImage){
        this.image = anImage;
    }
    public Image getThumbnail(){
        return this.thumbnail;
    }
    public void setThumbnail(Image aThumbnail){
        this.thumbnail = aThumbnail;
    }
    public Instant getTimestamp(){
        return this.timestamp;
    }
    public void setTimestamp(Instant aTimestamp){
        this.timestamp = aTimestamp;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String aTitle){
        this.title = aTitle;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String aType){
        this.type = aType;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String aUrl){
        this.url = aUrl;
    }
    public IEmbedVideo getVideo(){
        return this.video;
    }
    public void setVideo(IEmbedVideo aVideo){
        this.video = aVideo;
    }
    
    
}
