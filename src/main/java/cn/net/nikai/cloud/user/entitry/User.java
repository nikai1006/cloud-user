package cn.net.nikai.cloud.user.entitry;

/**
 * User dto
 * @author nikai
 */
public class User {

    /**
     * id primary key
     */
    private long id;
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    private Integer age;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}