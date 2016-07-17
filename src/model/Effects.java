package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Effects extends ErowidItem {

    /** Table of the duration of this substance. */
    @Getter @Setter private String durationTable;
    /** Urls of the duration charts of this substance. */
    @Getter @Setter private String durationChartUrls;
    /** List of the positive effects of this substance. */
    @Getter @Setter private String positiveEffects;
    /** List of the neutral effects of this substance. */
    @Getter @Setter private String neutralEffects;
    /** List of the negative effects of this substance. */
    @Getter @Setter private String negativeEffects;
    /** Description of this Effects page. */
    @Getter @Setter private String description;
    /** Experience report excerpts of this substance. */
    @Getter @Setter private String experienceReports;
    /** Disclaimer of this Effects page. */
    @Getter @Setter private String disclaimer;

    public Effects(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Effects{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", durationTable='").append(durationTable).append('\'');
        sb.append(", durationChartUrls='").append(durationChartUrls).append('\'');
        sb.append(", positiveEffects='").append(positiveEffects).append('\'');
        sb.append(", neutralEffects='").append(neutralEffects).append('\'');
        sb.append(", negativeEffects='").append(negativeEffects).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", experienceReports='").append(experienceReports).append('\'');
        sb.append(", disclaimer='").append(disclaimer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
