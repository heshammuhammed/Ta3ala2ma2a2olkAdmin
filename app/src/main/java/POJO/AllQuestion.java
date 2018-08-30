package POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public class AllQuestion implements Serializable {

    private List<Question> questions = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}