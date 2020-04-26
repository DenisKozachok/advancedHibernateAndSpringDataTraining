package org.it.discovery.training.hibernate.model.tuple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BookInfo {
    private int id;

    private String name;
}
