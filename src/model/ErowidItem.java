package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

/** Created by Benny on 7/15/2016. */
@AllArgsConstructor
@ToString
public class ErowidItem {

    /** Id of the erowid item. */
    @Getter protected int id;
    /** Id of the erowid item. */
    @Getter @Setter protected String name;
    /** Id of the erowid item. */
    @Getter protected String url;
    /** Id of the erowid item. */
    @Getter protected Category category;

    public static Comparator<ErowidItem> getIdComparator() { return (o1, o2) -> o1.id - o2.id; }

    public static Comparator<ErowidItem> getNameComparator() { return (o1, o2) -> o1.name.compareTo(o2.name); }
}
