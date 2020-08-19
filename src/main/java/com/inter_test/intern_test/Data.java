package com.inter_test.intern_test;

public class Data
{

    private int id;
    private String info;
    private String email;

    public Data(int id, String content, String email)
    {
        this.id = id;
        this.info = content;
        this.email = email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setId(int i)
    {
        this.id = i;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public int getId()
    {
        return id;
    }

    public String getInfo()
    {
        return info;
    }

}
