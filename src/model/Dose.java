package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Dose extends ErowidItem {

    /** Table of the dosing guides */
    @Getter @Setter private String doseTable;
    /** Text of the dosing section. */
    @Getter @Setter private String doseText;
    /** Paragraphs of notes on dose information. */
    @Getter @Setter private String notes;
    /** Disclaimer of this Dose page. */
    @Getter @Setter private String disclaimer;

    public Dose(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dose{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", doseText='").append(doseText).append('\'');
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", disclaimer='").append(disclaimer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
