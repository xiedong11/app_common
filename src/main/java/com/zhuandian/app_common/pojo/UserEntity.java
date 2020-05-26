package com.zhuandian.app_common.pojo;

/**
 * @author xiedong
 * @desc
 * @date 2020/5/25.
 */
public class UserEntity {
    private String id;
    private String name;
    private String password;
    private String local;
    private String phone;
    private String createAt;
    private String updateAt;


    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public UserEntity(String id, String name, String password, String local, String phone, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.local = local;
        this.phone = phone;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UserEntity() {
    }


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", local='" + local + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
