package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Law extends ErowidItem {

    /** Legal table of this Law page. */
    @Getter @Setter private String legalTable;
    /** Federal law text of this Law page. */
    @Getter @Setter private String federalLaw;
    /** State law text of this Law page. */
    @Getter @Setter private String stateLaw;
    /** International law text of this Law page. */
    @Getter @Setter private String internationalLaw;
    /** Disclaimer of this Law page. */
    @Getter @Setter private String disclaimer;

    public Law(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Law{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", legalTable='").append(legalTable).append('\'');
        sb.append(", federalLaw='").append(federalLaw).append('\'');
        sb.append(", stateLaw='").append(stateLaw).append('\'');
        sb.append(", internationalLaw='").append(internationalLaw).append('\'');
        sb.append(", disclaimer='").append(disclaimer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
