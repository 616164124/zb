package bean;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 8526186615712029705L;
    @NotNull
    private String id;
    private String name;
    private String age;
    private Object object;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=\"" + id + '\"' +
                ", name=\"" + name + '\"' +
                ", age=\"" + age + '\"' +
                ", object=" + object +
                '}';
    }
}
