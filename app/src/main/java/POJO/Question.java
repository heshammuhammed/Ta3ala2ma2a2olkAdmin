package POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public class Question implements Serializable{
    private Integer questionId;
    private String title;
    private Integer numOfAns;
    private Integer verified;
    private String questionDate;
    private String body;
    private String image;
    private Object audio;
    private Object video;
    private Integer rate;
    private Integer isdeleted;
    private Object notifi;
    private Object closed;
    private Object personId;
    private List<Answers> answersCollection = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumOfAns() {
        return numOfAns;
    }

    public void setNumOfAns(Integer numOfAns) {
        this.numOfAns = numOfAns;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public String getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(String questionDate) {
        this.questionDate = questionDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getAudio() {
        return audio;
    }

    public void setAudio(Object audio) {
        this.audio = audio;
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Object getNotifi() {
        return notifi;
    }

    public void setNotifi(Object notifi) {
        this.notifi = notifi;
    }

    public Object getClosed() {
        return closed;
    }

    public void setClosed(Object closed) {
        this.closed = closed;
    }

    public Object getPersonId() {
        return personId;
    }

    public void setPersonId(Object personId) {
        this.personId = personId;
    }

    public List<Answers> getAnswersCollection() {
        return answersCollection;
    }

    public void setAnswersCollection(List<Answers> answersCollection) {
        this.answersCollection = answersCollection;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}