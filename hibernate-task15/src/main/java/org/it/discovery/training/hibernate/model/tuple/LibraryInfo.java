package org.it.discovery.training.hibernate.model.tuple;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LibraryInfo {
    private int bookCount;

    private int publisherCount;
}
