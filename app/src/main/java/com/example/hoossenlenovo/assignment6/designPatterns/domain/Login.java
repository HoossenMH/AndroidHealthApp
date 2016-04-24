package com.example.hoossenlenovo.assignment6.designPatterns.domain;

/**
 * Created by Toshiba on 2016/04/07.
 */
import java.io.Serializable;

public class Login implements Serializable{

    private String userName;
    private String password;


    private static final long serialVersionUID = 1L;


    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() { return userName;    }
    public String getPassword() {
        return password;
    }


    public Login(Builder builder)
    {
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public static class Builder
    {
        private String userName;
        private String password;


        public Builder userName(String value){
            this.userName = value;
            return this;
        }
        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder copy(Login value) {
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

        if (getUserName() != null ? !getUserName().equals(login.getUserName()) : login.getUserName() != null)
            return false;
        return !(getPassword() != null ? !getPassword().equals(login.getPassword()) : login.getPassword() != null);

    }

    @Override
    public int hashCode() {
        int result = getUserName() != null ? getUserName().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
