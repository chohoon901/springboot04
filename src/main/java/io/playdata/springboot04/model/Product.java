package io.playdata.springboot04.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // Spring Data JPA에 이 클래스를 통해 생성된 객체를 DTO 취급
@Table(name="products") // DB에 products 이름으로 테이블 생성 / 조회
@Data // lombok -> getter,setter
public class Product {
    // 상품 클래스, 엔터티, DTO, VO, -> 인터넷 쇼핑몰에서 검색이나 등록의 대상
    @Id // JPA에서 기본 ID로 쓰겠다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 등록될 때 마다 1씩 증가하게 하겠다
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private String description;

    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
