package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
//@JsonIgnorePropertieschú thích là chú giải Jackson.
// Spring Boot sử dụng Jackson để tuần tự hóa và Deserializing các đối tượng Java đến và từ JSON.
//Chú thích này được sử dụng bởi vì chúng tôi không muốn các khách hàng của api còn lại cung cấp,
// các giá trị createdAtvà updatedAtgiá trị.
// Nếu họ cung cấp các giá trị này thì chúng tôi sẽ đơn giản bỏ qua chúng.
// Tuy nhiên, chúng tôi sẽ bao gồm các giá trị này trong phản hồi JSON.
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @NotBlankchú thích được sử dụng để xác nhận rằng trường được chú thích là not nullhoặc trống.
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    //@Columnchú thích được sử dụng để xác định các thuộc tính của cột sẽ được ánh xạ tới trường được chú thích.
    // Bạn có thể xác định một số thuộc tính như tên, độ dài, nullable, updateable vv
    //Theo mặc định, một trường được đặt tên createdAtđược ánh xạ tới một cột có tên created_attrong bảng cơ sở dữ liệu.
    //Tức là tất cả các trường hợp lạc đà được thay thế bằng dấu gạch dưới.
    //Nếu bạn muốn ánh xạ trường này sang một cột khác, bạn có thể chỉ định trường đó bằng cách sử dụng -
            //@Column(name = "created_on")
            //private String createdAt;
    @Column(nullable = false, updatable = false)

    //@Temporalchú thích được sử dụng với java.util.Datevà java.util.Calendarcác lớp.
    // Nó chuyển đổi các giá trị ngày tháng và thời gian từ Java Object thành kiểu cơ sở dữ liệu tương thích và ngược lại
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Note() {
    }

    public Note(@NotBlank String title, @NotBlank String content, Date createdAt, Date updatedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
