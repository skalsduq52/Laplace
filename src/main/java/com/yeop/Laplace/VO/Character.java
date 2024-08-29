package com.yeop.Laplace.VO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    String CharacterImage;
    String CharacterName;
    String CharacterClassName;
    int CharacterLevel;
    String ExpeditionLevel;
    int TotalSkillPoint;
    String ItemMaxLevel;
}
