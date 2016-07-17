package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Chemistry extends ErowidItem {

    /** Table of the chemical properties. */
    @Getter @Setter private String chemTable;
    /** Url of the molecule image. */
    @Getter @Setter private String moleculeUrl;

    public Chemistry(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chemistry{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", chemTable='").append(chemTable).append('\'');
        sb.append(", moleculeUrl='").append(moleculeUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
