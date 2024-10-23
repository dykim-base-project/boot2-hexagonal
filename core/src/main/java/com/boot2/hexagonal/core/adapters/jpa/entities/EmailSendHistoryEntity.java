package com.boot2.hexagonal.core.adapters.jpa.entities;

import com.boot2.hexagonal.api.data.EmailAddress;
import java.time.ZonedDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "emailSendHistoryEntity")
public class EmailSendHistoryEntity {

  @Comment("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("발신자")
  @Column(nullable = false, length = EmailAddress.MAX_LENGTH)
  private String sender;

  @Comment("수신자")
  @Column(nullable = false, length = EmailAddress.MAX_LENGTH)
  private String recipient;

  @Comment("제목")
  @Column(nullable = false, length = 100)
  private String subject;

  @Comment("내용")
  @Column(nullable = false)
  private String body;

  @Comment("발신 일시")
  @Column(nullable = false, columnDefinition = "datetime(3)")
  private ZonedDateTime sentAt;
}
