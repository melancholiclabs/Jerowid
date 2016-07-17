package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Images extends ErowidItem {

    /** List if images of this Images page. */
    @Getter @Setter private String imageList;

    public Images(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Images{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", imageList='").append(imageList).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
