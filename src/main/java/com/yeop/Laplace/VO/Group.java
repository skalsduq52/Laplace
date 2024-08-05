package com.yeop.Laplace.VO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "\"GROUP\"")

public class Group {
    @Id
    @Column(name = "GROUPID")
    private String groupID;

    @Column(name = "GROUPNAME", nullable = false)
    private String groupName;
}
