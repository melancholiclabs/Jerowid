import com.sun.xml.internal.ws.util.StringUtils;
import lombok.Getter;
import model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Melancoholic on 7/12/2016.
 *
 * @author Melancoholic
 * @version 0.5.0
 */
public class Jerowid {

    /** Logger for logging. */
    private static final Logger LOGGER = Logger.getLogger(Jerowid.class.getSimpleName());

    /** Url to the index of all substances on erowid.org. */
    private static final String EROWID_CHART_URL = "https://www.erowid.org/general/big_chart.shtml";

    /** Counting int in order to assign unique ids. */
    private static int idIterator = 0;

    /** Big chart Jsoup document to avoid instantiating it more than once. */
    private static Document erowidChart;

    /** Array of chemical Substance objects. */
    @Getter private static ArrayList<Substance> chemIndex;
    /** Array of plant Substance objects. */
    @Getter private static ArrayList<Substance> plantIndex;
    /** Array of herb Substance objects. */
    @Getter private static ArrayList<Substance> herbIndex;
    /** Array of pharm Substance objects. */
    @Getter private static ArrayList<Substance> pharmIndex;
    /** Array of smart Substance objects. */
    @Getter private static ArrayList<Substance> smartIndex;
    /** Array of animal Substance objects. */
    @Getter private static ArrayList<Substance> animalIndex;

    /** Array of Basics pages. */
    @Getter private static ArrayList<Basics> basicsIndex;
    /** Array of Effects pages. */
    @Getter private static ArrayList<Effects> effectsIndex;
    /** Array of Images pages. */
    @Getter private static ArrayList<Images> imagesIndex;
    /** Array of Health pages. */
    @Getter private static ArrayList<Health> healthIndex;
    /** Array of Law pages. */
    @Getter private static ArrayList<Law> lawIndex;
    /** Array of Dose pages. */
    @Getter private static ArrayList<Dose> doseIndex;
    /** Array of Chemistry pages. */
    @Getter private static ArrayList<Chemistry> chemistryIndex;
    /** Array of ResearchChemical pages. */
    @Getter private static ArrayList<ResearchChemical> researchChemicalIndex;

    static {
        LOGGER.setLevel(Level.ALL);
        loadErowidChart();
    }

    private static void loadErowidChart() {
        LOGGER.info("Attempting to load erowidChart...");
        try {
            erowidChart = Jsoup.connect(EROWID_CHART_URL).get();
            LOGGER.info("ErowidChart has loaded...");
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }
    }

    public static void loadAllIndexBasic() {
        loadChemIndexBasic();
        loadPlantIndexBasic();
        loadHerbIndexBasic();
        loadPharmIndexBasic();
        loadSmartIndexBasic();
        loadAnimalIndexBasic();
    }

    public static void loadChemIndexBasic() {
        LOGGER.info("Loading chemIndexBasic...");
        Elements table = erowidChart.select("table#section-CHEMICALS td.subname");
        chemIndex = getIndex(table, Category.CHEMICAL);
    }

    public static void loadPlantIndexBasic() {
        LOGGER.info("Loading plantIndexBasic...");
        Elements table = erowidChart.select("table#section-PLANTS td.subname");
        plantIndex = getIndex(table, Category.PLANT);
    }

    public static void loadHerbIndexBasic() {
        LOGGER.info("Loading herbIndexBasic...");
        Elements table = erowidChart.select("table#section-HERBS td.subname");
        herbIndex = getIndex(table, Category.HERB);
    }

    public static void loadPharmIndexBasic() {
        LOGGER.info("Loading pharmIndexBasic...");
        Elements table = erowidChart.select("table#section-PHARMS td.subname");
        pharmIndex = getIndex(table, Category.PHARM);
    }

    public static void loadSmartIndexBasic() {
        LOGGER.info("Loading smartIndexBasic...");
        Elements table = erowidChart.select("table#section-SMARTS td.subname");
        smartIndex = getIndex(table, Category.SMART);
    }

    public static void loadAnimalIndexBasic() {
        LOGGER.info("Loading animalIndexBasic...");
        Elements table = erowidChart.select("table#section-ANIMALS td.subname");
        animalIndex = getIndex(table, Category.ANIMAL);
    }

    private static ArrayList<Substance> getIndex(Elements table, Category category) {
        ArrayList<Substance> temp = new ArrayList<>();

        for (Element td : table) {
            Element a = td.select("a").first();

            String name = (a != null) ? StringUtils.capitalize(a.text()) : td.text();
            String url = (a != null) ? a.attr("abs:href") : null;

            temp.add(new Substance(idIterator, name, url, category));
            idIterator++;
        }

        return temp;
    }

    public static void loadAllIndexDetailed() {
        loadChemIndexDetailed();
        loadPlantIndexDetailed();
        loadHerbIndexDetailed();
        loadPharmIndexDetailed();
        loadSmartIndexDetailed();
        loadAnimalIndexDetailed();
    }

    public static void loadChemIndexDetailed() {
        loadChemIndexBasic();
        LOGGER.info("Loading details for chemIndex...");
        for (Substance substance : chemIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    public static void loadPlantIndexDetailed() {
        loadPlantIndexBasic();
        LOGGER.info("Loading details for plantIndex...");
        for (Substance substance : plantIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    public static void loadHerbIndexDetailed() {
        loadHerbIndexBasic();
        LOGGER.info("Loading details for herbIndex...");
        for (Substance substance : herbIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    public static void loadPharmIndexDetailed() {
        loadPharmIndexBasic();
        LOGGER.info("Loading details for pharmIndex...");
        for (Substance substance : pharmIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    public static void loadSmartIndexDetailed() {
        loadSmartIndexBasic();
        LOGGER.info("Loading details for smartIndex...");
        for (Substance substance : smartIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    public static void loadAnimalIndexDetailed() {
        loadAnimalIndexBasic();
        LOGGER.info("Loading details for animalIndex...");
        for (Substance substance : animalIndex) {
            LOGGER.info("Loading details for " + substance.getName() + "...");
            if (substance.getUrl() != null) { loadDetails(substance); }
        }
    }

    private static void loadDetails(Substance substance) {
        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getUrl()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        // Sets a new name
        String name = doc.select("div.ts-substance-name").first().text();
        if (name != null && !name.isEmpty()) substance.setName(name);

        // Gets the summary card text
        Element sumCardText = doc.select("div.summary-card-text-surround").first();

        // Sets the botanicalClassification
        Elements botRows = sumCardText.select("div.fgs-row");
        if (!botRows.html().isEmpty()) {
            StringBuilder botClassBuilder = new StringBuilder();
            for (Element row : botRows) {
                botClassBuilder.append(row.text());
                botClassBuilder.append(", ");
            }
            substance.setBotanicalClassification(botClassBuilder.substring(0, botClassBuilder.length() - 2));
        }

        // Sets the chemicalName
        Element chemNameDiv = sumCardText.select("div.sum-chem-name").first();
        if (chemNameDiv != null) substance.setChemicalName(chemNameDiv.text());

        // Sets the commonNames
        Element sumCommonNameDiv = sumCardText.select("div.sum-common-name").first();
        if (sumCommonNameDiv != null) substance.setCommonNames(sumCommonNameDiv.text());

        // Sets the description
        Element sumDescriptionDiv = sumCardText.select("div.sum-description").first();
        if (sumDescriptionDiv != null) substance.setDescription(sumDescriptionDiv.text());

        // Sets the effectsClassification
        Element sumEffectsDiv = sumCardText.select("div.sum-effects").first();
        if (sumEffectsDiv != null) substance.setEffectsClassification(sumEffectsDiv.text());

        // Sets the uses
        Element sumUsesDiv = sumCardText.select("div.sum-uses").first();
        if (sumUsesDiv != null) substance.setUses(sumUsesDiv.text());

        // Sets the imageUrl
        Element sumImageDiv = sumCardText.select("div.summary-card-topic-image img").first();
        if (sumImageDiv != null) substance.setImageUrl(sumImageDiv.absUrl("src"));

        // Sets the summary card icon links
        for (Element a : doc.select("div.summary-card-icon-surround a[href]")) {
            if (a.attr("href").contains("basics")) {
                substance.setBasicsPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("effects")) {
                substance.setEffectsPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("images")) {
                substance.setImagesPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("health")) {
                substance.setHealthPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("law")) {
                substance.setLawPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("dose")) {
                substance.setDosePageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("chemistry")) {
                substance.setChemistryPageURL(a.absUrl("href"));
            } else if (a.attr("href").contains("research_chems")) {
                substance.setResearchChemicalPageURL(a.absUrl("href"));
            }
        }
    }

    public static void loadAllIndexFull() {
        loadChemIndexFull();
        loadPlantIndexFull();
        loadHerbIndexFull();
        loadPharmIndexFull();
        loadSmartIndexFull();
        loadAnimalIndexFull();
    }

    public static void loadChemIndexFull() {
        loadChemIndexDetailed();
        LOGGER.info("Loading pages for chemIndex...");
        chemIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadPlantIndexFull() {
        loadPlantIndexDetailed();
        LOGGER.info("Loading pages for plantIndex...");
        plantIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadHerbIndexFull() {
        loadHerbIndexDetailed();
        LOGGER.info("Loading pages for herbIndex...");
        herbIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadPharmIndexFull() {
        loadPharmIndexDetailed();
        LOGGER.info("Loading pages for pharmIndex...");
        pharmIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadSmartIndexFull() {
        loadSmartIndexDetailed();
        LOGGER.info("Loading pages for smartIndex...");
        smartIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadAnimalIndexFull() {
        loadAnimalIndexDetailed();
        LOGGER.info("Loading pages for animalIndex...");
        animalIndex.forEach(substance -> loadAllPages(substance));
    }

    public static void loadAllPages(Substance substance) {
        if (basicsIndex == null) basicsIndex = new ArrayList<>();
        if (effectsIndex == null) effectsIndex = new ArrayList<>();
        if (imagesIndex == null) imagesIndex = new ArrayList<>();
        if (healthIndex == null) healthIndex = new ArrayList<>();
        if (lawIndex == null) lawIndex = new ArrayList<>();
        if (doseIndex == null) doseIndex = new ArrayList<>();
        if (chemistryIndex == null) chemistryIndex = new ArrayList<>();
        if (researchChemicalIndex == null) researchChemicalIndex = new ArrayList<>();


//        if (substance.getBasicsPageURL() != null) basicsIndex.add(getBasicsPage(substance));
//        if (substance.getEffectsPageURL() != null) effectsIndex.add(getEffectsPage(substance));
//        if (substance.getImagesPageURL() != null) imagesIndex.add(getImagesPage(substance));
//        if (substance.getHealthPageURL() != null) healthIndex.add(getHealthPage(substance));
        if (substance.getLawPageURL() != null) lawIndex.add(getLawPage(substance));
//        if (substance.getDosePageURL() != null) doseIndex.add(getDosePage(substance));
//        if (substance.getChemistryPageURL() != null) chemistryIndex.add(getChemistryPage(substance));
//        if (substance.getResearchChemicalPageURL() != null) researchChemicalIndex.add(getResearchChemicalPage(substance));
    }

    public static Basics getBasicsPage(Substance substance) {
        LOGGER.info("Loading basicsPage for " + substance.getName());
        Basics result = new Basics(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getBasicsPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element contentSection = doc.select("div.content-section").first();

        // Gets the basics description
        Element basicsDescription = contentSection.select("div.basics-description").first();

        // Get description texts
        Element descriptionText = basicsDescription.select("div.basics-text").first();
        if (descriptionText != null) result.setDescription(descriptionText.text());

        // Gets description sections
        result.setDescriptionSections(getBasicsSections(basicsDescription));

        // Gets the basics effects
        Element basicsEffects = contentSection.select("div.basics-effects").first();

        // Get effects text
        Element effectsText = basicsEffects.select("div.basics-text").first();
        if (effectsText != null) result.setEffects(effectsText.text());

        // Get effects sections
        result.setEffectsSections(getBasicsSections(basicsEffects));

        // Gets the basics problems
        Element basicsProblems = contentSection.select("div.basics-problems").first();

        // Get problems text
        Element problemsText = basicsProblems.select("div.basics-text").first();
        if (problemsText != null) result.setProblems(problemsText.text());

        // Get problems sections
        result.setProblemsSections(getBasicsSections(basicsProblems));

        // Gets basics caution
        Element basicsCaution = contentSection.select("div.basics-caution").first();

        Element cautionText = basicsCaution.select("div.basics-text").first();
        if (cautionText != null) result.setDisclaimer(cautionText.text());

        return result;
    }

    private static String getBasicsSections(Element content) {
        Elements sections = content.select("div.basics-indent-text > *");
        if (sections.html().isEmpty()) return null;
        StringBuilder builder = new StringBuilder();
        for (Element section : sections) {
            builder.append(section.select("div.section-title2").text().trim());
            builder.append("\t");
            builder.append(section.select("div.basics-text").text());
            builder.append("\n");
        }
        return builder.toString().trim();
    }

    public static Effects getEffectsPage(Substance substance) {
        LOGGER.info("Loading effectsPage for " + substance.getName());
        Effects result = new Effects(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getEffectsPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element contentSection = doc.select("div.content-section").first();

        Element effectsDuration = contentSection.select("div.effects-duration").first();

        Elements durationTables = effectsDuration.select("table.duration-summary");
        // TODO parse tables

        // TODO this doesn't work
        Elements durationCharts = effectsDuration.select("img.duration-chart");
        if (!durationCharts.html().isEmpty()) {
            StringBuilder chartBuilder = new StringBuilder();
            for (Element chart : durationCharts) {
                chartBuilder.append(chart.absUrl("src"));
                chartBuilder.append("\t");
            }
            result.setDurationChartUrls(chartBuilder.toString().trim());
        }

        Elements effectsListPositive = contentSection.select("div.effects-list-positive > ul.effects-item > li");
        if (!effectsListPositive.html().isEmpty()) {
            StringBuilder posListBuilder = new StringBuilder();
            for (Element item : effectsListPositive) {
                posListBuilder.append(item.text());
                posListBuilder.append("\t");
            }
            result.setPositiveEffects(posListBuilder.toString().trim());
        }

        Elements effectsListNeutral = contentSection.select("div.effects-list-neutral > ul.effects-item > li");
        if (!effectsListNeutral.html().isEmpty()) {
            StringBuilder neuListBuilder = new StringBuilder();
            for (Element item : effectsListNeutral) {
                neuListBuilder.append(item.text());
                neuListBuilder.append("\t");
            }
            result.setNeutralEffects(neuListBuilder.toString().trim());
        }

        Elements effectsListNegative = contentSection.select("div.effects-list-negative > ul.effects-item > li");
        if (!effectsListNegative.html().isEmpty()) {
            StringBuilder negListBuilder = new StringBuilder();
            for (Element item : effectsListNegative) {
                negListBuilder.append(item.text());
                negListBuilder.append("\t");
            }
            result.setNegativeEffects(negListBuilder.toString().trim());
        }

        Element effectsDescription = contentSection.select("div.effects-description > div.effects-text").first();
        if (effectsDescription != null) result.setDescription(effectsDescription.text());

        Element effectsReports = contentSection.select("div.effects-exp-excerpts div.effects-exp-excerpt").first();
        if (effectsReports != null) result.setExperienceReports(effectsReports.text());

        Element effectsDisclaimer = contentSection.select("div.effects-caution > div.effects-text").first();
        if (effectsDisclaimer != null) result.setDisclaimer(effectsDisclaimer.text());

        return result;
    }

    public static Images getImagesPage(Substance substance) {
        LOGGER.info("Loading imagesPage for " + substance.getName());
        Images result = new Images(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getImagesPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Elements imageEntries = doc.select("div.image-entry");
        if (!imageEntries.html().isEmpty()) {
            StringBuilder entryBuilder = new StringBuilder();
            for (Element entry : imageEntries) {
                entryBuilder.append(entry.select("div.image > a").first().text());
                entryBuilder.append("\t");
                entryBuilder.append(entry.select("div.image > a").first().absUrl("href"));
                entryBuilder.append("\t");
                entryBuilder.append(entry.select("div.desc").text());
                entryBuilder.append("\t");
                entryBuilder.append(entry.select("div.credit").text());
                entryBuilder.append("\n");
            }
            result.setImageList(entryBuilder.toString().trim());
        }

        return result;
    }

    public static Health getHealthPage(Substance substance) {
        LOGGER.info("Loading healthPage for " + substance.getName());
        Health result = new Health(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getHealthPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element contentSection = doc.select("div.content-section").first();

        // TODO implement scraping of atypical health pages

        Element healthNotes = contentSection.select("div.health-notes").first();
        if (healthNotes != null) result.setNotes(healthNotes.text());

        Element healthDeaths = contentSection.select("div.health-deaths").first();
        if (healthDeaths != null) result.setDeaths(healthDeaths.text());

        Element healthWarnings = contentSection.select("div.health-warnings").first();
        if (healthWarnings != null) result.setWarnings(healthWarnings.text());

        Element healthCautions = contentSection.select("div.health-cautions").first();
        if (healthCautions != null) result.setCautions(healthCautions.text());

        return result;
    }

    public static Law getLawPage(Substance substance) {
        LOGGER.info("Loading healthPage for " + substance.getName());
        Law result = new Law(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getLawPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element contentSection = doc.select("div.content-section").first();

        Element lawFederal = contentSection.select("div.law-federal").first();

        Element lawTable = lawFederal.select("table.law-summary").first();
        // TODO parse table

        Element federalLaw = lawFederal.select("div.law-text").first();
        if (federalLaw != null) result.setFederalLaw(federalLaw.text());

        // TODO tab deliminate
        Element lawStates = contentSection.select("div.law-states").first();
        if (lawStates != null) result.setStateLaw(lawStates.text());

        // TODO tab deliminate
        Element lawCountries = contentSection.select("div.law-countries").first();
        if (lawCountries != null) result.setInternationalLaw(lawCountries.text());

        Element lawDisclaimer = contentSection.select("div.law-caution").first();
        if (lawDisclaimer != null) result.setDisclaimer(lawDisclaimer.text());

        return result;
    }

    public static Dose getDosePage(Substance substance) {
        LOGGER.info("Loading lawPage for " + substance.getName());
        Dose result = new Dose(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getLawPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element contentSection = doc.select("div.content-section").first();

        Element doseDescription = contentSection.select("div.dose-description").first();

        Elements doseTables = doseDescription.select("table.dose-summary");

        return result;
    }

    public static Chemistry getChemistryPage(Substance substance) {
        LOGGER.info("Loading chemistryPage for " + substance.getName());
        Chemistry result = new Chemistry(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getChemistryPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element chemTable = doc.select("table.chem-table").first();
        // TODO parse table

        Element moleculeLink = doc.select("div.content-section img").first();
        if (moleculeLink == null) moleculeLink = doc.select("div#content-body-frame img").first();
        if (moleculeLink != null) result.setMoleculeUrl(moleculeLink.absUrl("src"));

        return result;
    }

    public static ResearchChemical getResearchChemicalPage(Substance substance) {
        LOGGER.info("Loading researchChemicalPage for " + substance.getName());
        ResearchChemical result = new ResearchChemical(substance.getId(), substance.getName(), substance.getUrl(), substance.getCategory());

        Document doc = null;
        try {
            doc = Jsoup.connect(substance.getResearchChemicalPageURL()).get();
        } catch (IOException e) { LOGGER.severe(e.getMessage()); }

        Element sumTextCard = doc.select("div.summary-card-text-surround").first();

        Element sumText = sumTextCard.select("div.sum-text").first();
        if (sumText != null) result.setSummary(sumText.text());

        Element sumLink = sumTextCard.select("div.summary-card-section-image > img").first();
        if (sumLink != null) result.setImageUrl(sumLink.absUrl("src"));

        return result;
    }

    public static void main(String[] args) {
        loadAnimalIndexFull();

        for (Law page : lawIndex) { LOGGER.info(page.toString()); }
    }
}
