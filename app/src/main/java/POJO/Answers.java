package POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 6/10/2018.
 */

public class Answers implements Serializable {

    private Integer answersId;
    private String answer;
    private Object rate;
    private Object isdeleted;
    private Object image;
    private Object audio;
    private Object video;
    private Object notifi;
    private Object answersDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private User personId;
    private Question questionId;

    public Integer getAnswersId() {
        return answersId;
    }

    public void setAnswersId(Integer answersId) {
        this.answersId = answersId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public Object getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Object isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
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

    public Object getNotifi() {
        return notifi;
    }

    public void setNotifi(Object notifi) {
        this.notifi = notifi;
    }

    public Object getAnswersDate() {
        return answersDate;
    }

    public void setAnswersDate(Object answersDate) {
        this.answersDate = answersDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public User getPersonId() {
        return personId;
    }

    public void setPersonId(User personId) {
        this.personId = personId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }
}
