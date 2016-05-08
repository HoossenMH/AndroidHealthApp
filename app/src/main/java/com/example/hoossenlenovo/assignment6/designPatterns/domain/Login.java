package com.example.hoossenlenovo.assignment6.designPatterns.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
import java.io.Serializable;

public class Login implements Serializable{

    private Long id;
    private String userName;
    private String password;


    private static final long serialVersionUID = 1L;


    public Login(Long id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getUserName() { return userName;    }
    public String getPassword() {
        return password;
    }


    public Login(Builder builder)
    {
        this.userName = builder.userName;
        this.password = builder.password;
        this.id = builder.id;
    }

    public static class Builder
    {
        private Long id;
        private String userName;
        private String password;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userName(String value){
            this.userName = value;
            return this;
        }
        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder copy(Login value) {
            this.id = value.id;
            this.userName = value.userName;
            this.password = value.password;
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;

        Login login = (Login) o;

        if (getId() != null ? !getId().equals(login.getId()) : login.getId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(login.getUserName()) : login.getUserName() != null)
            return false;
        return getPassword() != null ? getPassword().equals(login.getPassword()) : login.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
