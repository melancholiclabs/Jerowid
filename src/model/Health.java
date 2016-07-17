package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Health extends ErowidItem {

    /** Text from the notes section of this Health page. */
    @Getter @Setter private String notes;
    /** Text from the notes section of this Health page. */
    @Getter @Setter private String deaths;
    /** Text from the notes section of this Health page. */
    @Getter @Setter private String warnings;
    /** Text from the notes section of this Health page. */
    @Getter @Setter private String cautions;
    /** Text from the notes section of this Health page. */
    @Getter @Setter private String benefits;

    public Health(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Health{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", deaths='").append(deaths).append('\'');
        sb.append(", warnings='").append(warnings).append('\'');
        sb.append(", cautions='").append(cautions).append('\'');
        sb.append(", benefits='").append(benefits).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
