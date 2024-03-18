package com.pragma.edwinmarrugo.unittestingtutorial.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Technology {
    private String id;
    private String name;
    private String description;
}
