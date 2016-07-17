package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Basics extends ErowidItem {

    /** Description paragraph of this Basics page. */
    @Getter @Setter private String description;
    /** Sections of text under the description paragraph of this Basics page. */
    @Getter @Setter private String descriptionSections;
    /** Effects paragraph of this Basics page. */
    @Getter @Setter private String effects;
    /** Sections of text under the effects paragraph of this Basics page. */
    @Getter @Setter private String effectsSections;
    /** Problems paragraph of this Basics page. */
    @Getter @Setter private String problems;
    /** Sections of text under the problems paragraph of this Basics page. */
    @Getter @Setter private String problemsSections;
    /** Disclaimer of this Basics page. */
    @Getter @Setter private String disclaimer;

    public Basics(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basics{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", descriptionSections='").append(descriptionSections).append('\'');
        sb.append(", effects='").append(effects).append('\'');
        sb.append(", effectsSections='").append(effectsSections).append('\'');
        sb.append(", problems='").append(problems).append('\'');
        sb.append(", problemsSections='").append(problemsSections).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
