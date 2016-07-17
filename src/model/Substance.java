package model;

import lombok.Getter;
import lombok.Setter;

/** Created by Melancoholic on 7/15/2016. */
public class Substance extends ErowidItem {

    /** Botanical Classification of the substance. */
    @Getter @Setter private String botanicalClassification;
    /** Chemical name of the substance. */
    @Getter @Setter private String chemicalName;
    /** Common/Brand names of the substance. */
    @Getter @Setter private String commonNames;
    /** Description of the substance. */
    @Getter @Setter private String description;
    /** Effects Classification of the substance. */
    @Getter @Setter private String effectsClassification;
    /** Uses of the substance. */
    @Getter @Setter private String uses;
    /** ImageURL of the substances image. */
    @Getter @Setter private String imageUrl;
    /** URL to the basics page. */
    @Getter @Setter private String basicsPageURL;
    /** URL to the effects page. */
    @Getter @Setter private String effectsPageURL;
    /** URL to the images page. */
    @Getter @Setter private String imagesPageURL;
    /** URL to the health page. */
    @Getter @Setter private String healthPageURL;
    /** URL to the law page. */
    @Getter @Setter private String lawPageURL;
    /** URL to the dose page. */
    @Getter @Setter private String dosePageURL;
    /** URL to the chemistry page. */
    @Getter @Setter private String chemistryPageURL;
    /** URL to the researchChemical page. */
    @Getter @Setter private String researchChemicalPageURL;

    /** Constructs a Substance object using only the super class parameters. */
    public Substance(int id, String name, String url, Category category) {
        super(id, name, url, category);
    }

    public String toStringBasic() {
        final StringBuilder sb = new StringBuilder("Substance{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Substance{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", botanicalClassification='").append(botanicalClassification).append('\'');
        sb.append(", chemicalName='").append(chemicalName).append('\'');
        sb.append(", commonNames='").append(commonNames).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", effectsClassification='").append(effectsClassification).append('\'');
        sb.append(", uses='").append(uses).append('\'');
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", basicsPageURL='").append(basicsPageURL).append('\'');
        sb.append(", effectsPageURL='").append(effectsPageURL).append('\'');
        sb.append(", imagesPageURL='").append(imagesPageURL).append('\'');
        sb.append(", healthPageURL='").append(healthPageURL).append('\'');
        sb.append(", lawPageURL='").append(lawPageURL).append('\'');
        sb.append(", dosePageURL='").append(dosePageURL).append('\'');
        sb.append(", chemistryPageURL='").append(chemistryPageURL).append('\'');
        sb.append(", researchChemicalPageURL='").append(researchChemicalPageURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
