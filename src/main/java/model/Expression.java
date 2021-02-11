package model;

public class Expression {
    private int id;
    private String expression;
    private String translation;
    private String transcription;
    private String description;
    private String example;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Expression(int id, String expression, String translation, String transcription, String description, String example, int categoryId) {
        this.id = id;
        this.expression = expression;
        this.translation = translation;
        this.transcription = transcription;
        this.description = description;
        this.example = example;
        this.categoryId = categoryId;
    }
}
