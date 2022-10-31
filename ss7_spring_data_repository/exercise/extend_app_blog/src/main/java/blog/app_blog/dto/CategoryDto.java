package blog.app_blog.dto;

import blog.app_blog.model.Blog;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.OneToMany;
import java.util.Set;

public class CategoryDto {
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public CategoryDto() {
    }

    public CategoryDto(int id, String name, Set<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
