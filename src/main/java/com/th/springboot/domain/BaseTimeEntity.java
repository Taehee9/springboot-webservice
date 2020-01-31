package com.th.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate 자동으로 관리
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-26
 * Time : 오후 2:51
 * Contact : kwonth9509@gmail.com
 */
@Getter
@MappedSuperclass // Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함(의심가는 DB의 작업을 모니터링, 기록 정보를 수집 - 감시)
public class BaseTimeEntity {

    @CreatedDate // Entity 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 값 변경될 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}
