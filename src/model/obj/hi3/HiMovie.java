package model.obj.hi3;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "hi_movies")
@CCTypeConfig(label = "Movie", uniqueKey = "title", parameter = true)
public class HiMovie extends CCEntity {

    @Column(length = 255)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String title;
    @Column(length = 255)
    @CCFieldConfig(accessible = Accessible.NORMAL, maxLength = Short.MAX_VALUE, visible = false)
    private String alternateTitle;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.DATE)
    private Date releaseDate;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String runningTime;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String episodes;
    @Column(length = 255)
    @CCFieldConfig(accessible = Accessible.MANDATORY, visible = false)
    private String link;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE, visible = false)
    private String plot;
    //
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @CCFieldConfig(visible2 = false, onDelete = OnDelete.CASCADE)
    private List<HiMovieTag> movieTags;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlternateTitle() {
        return alternateTitle;
    }

    public void setAlternateTitle(String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
//</editor-fold>

    public List<HiMovieTag> getMovieTags() {
        return movieTags;
    }

    public void setMovieTags(List<HiMovieTag> movieTags) {
        this.movieTags = movieTags;
    }
}