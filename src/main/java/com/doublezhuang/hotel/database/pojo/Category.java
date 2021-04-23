package com.doublezhuang.hotel.database.pojo;

import java.util.Objects;

/**
 * @program: hotel
 * @className: Category
 * @Description: 房间信息实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:51
 */

public class Category {

    public Integer id;
    public String name;
    public String code;
    public String description;
    public Float bedprice;
    public Float roomprice;

    public Category() {
    }

    public Category(Integer id, String name, String code, String description, Float bedprice, Float roomprice) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.bedprice = bedprice;
        this.roomprice = roomprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getBedprice() {
        return bedprice;
    }

    public void setBedprice(Float bedprice) {
        this.bedprice = bedprice;
    }

    public Float getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(Float roomprice) {
        this.roomprice = roomprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(code, category.code) && Objects.equals(description, category.description) && Objects.equals(bedprice, category.bedprice) && Objects.equals(roomprice, category.roomprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, description, bedprice, roomprice);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", bedprice=" + bedprice +
                ", roomprice=" + roomprice +
                '}';
    }
}
