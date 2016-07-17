package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class ResearchChemical extends ErowidItem {

    /** Summary text of this ResearchChemical page. */
    @Getter @Setter private String summary;
    /** Image url of this ResearchChemical page. */
    @Getter @Setter private String imageUrl;

    public ResearchChemical(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResearchChemical{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
