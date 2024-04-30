package preach;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "preach")
public class Preach {
    @DynamoDBHashKey
    private String date;
    @DynamoDBAttribute
    private String title;
    @DynamoDBAttribute
    private String autor;
    @DynamoDBIndexRangeKey
    private String serie;
    @DynamoDBAttribute
    private String url;
    
    public Preach() {
    }

    public Preach(String date, String title, String autor, String serie, String url) {
        this.date = date;
        this.title = title;
        this.autor = autor;
        this.serie = serie;
        this.url = url;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{ date="+ date +", title=" + title + ", autor=" + autor + ", serie=" + serie + ", url=" + url + "}";
    }

    

}