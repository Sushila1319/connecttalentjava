package com.connecttalent.connecttalentsession.user.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

   // @Column(nullable = false)
  //  private Long income;

  //  @ManyToOne
   // @JoinColumn(name = "user_id")
 //   private User user;

}
