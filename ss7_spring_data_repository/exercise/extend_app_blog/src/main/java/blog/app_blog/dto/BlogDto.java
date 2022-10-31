package blog.app_blog.dto;

import blog.app_blog.model.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class BlogDto {
    private int id;
    private String author;
    private String content;
    private Date dateCreate;

    @ManyToOne
    @JoinColumn(name = "Category_id" , referencedColumnName = "id")
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String author, String content, Date dateCreate, Category category) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
