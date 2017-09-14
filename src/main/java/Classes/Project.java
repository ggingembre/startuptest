package Classes; /**
 * Created by Guillaume Gingembre on 14/09/2017.
 */

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", updatable=false, nullable=false)
    private long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_industry") // do enum of 10 industries - done!
    private Industry projectIndustry;

    @Column(name = "project_address") // do a class address - done!
    private Address projectAddress;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_logo_link")
    private String logoLink;

    @Column(name = "project_doc_link")
    private String projectDocLink;

    @Column(name = "project_site_link")
    private String projectSiteLink;

    @Column(name = "project_expected_raise")
    private BigDecimal projectExpectedRaise;

    @Column(name = "project_amount_raised")
    private BigDecimal projectAmountRaised;

    @Column(name = "project_min_inv")
    private BigDecimal projectMinInv;

    @Column(name = "project_return")
    private double projectReturn;

    @Column(name = "project_last_change")
    private LocalDate projectLastChange;

    @Column(name = "isActive")
    private boolean isActive;

    public Project(){}

    public Project(String projectName, Industry projectIndustry, Address projectAddress, String projectDescription, String logoLink, String projectDocLink, String projectSiteLink, BigDecimal projectExpectedRaise, BigDecimal projectAmountRaised, BigDecimal projectMinInv, long projectReturn, LocalDate projectLastChange, boolean isActive) {
        this.projectName = projectName;
        this.projectIndustry = projectIndustry;
        this.projectAddress = projectAddress;
        this.projectDescription = projectDescription;
        this.logoLink = logoLink;
        this.projectDocLink = projectDocLink;
        this.projectSiteLink = projectSiteLink;
        this.projectExpectedRaise = projectExpectedRaise;
        this.projectAmountRaised = projectAmountRaised;
        this.projectMinInv = projectMinInv;
        this.projectReturn = projectReturn;
        this.projectLastChange = projectLastChange;
        this.isActive = isActive;
    }

// one start up may have many business plans, and one business plan may have many start ups: many to many

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BusinessPlan> businessPlans = new HashSet<BusinessPlan>(0);

    @JoinTable(name = "projects_businessplans", joinColumns = {
            @JoinColumn(name = "project_Id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "businessplan_id",
                    nullable = false, updatable = false) })


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Industry getProjectIndustry() {
        return projectIndustry;
    }

    public void setProjectIndustry(Industry projectIndustry) {
        this.projectIndustry = projectIndustry;
    }

    public Address getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(Address projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }

    public String getProjectDocLink() {
        return projectDocLink;
    }

    public void setProjectDocLink(String projectDocLink) {
        this.projectDocLink = projectDocLink;
    }

    public String getProjectSiteLink() {
        return projectSiteLink;
    }

    public void setProjectSiteLink(String projectSiteLink) {
        this.projectSiteLink = projectSiteLink;
    }

    public BigDecimal getProjectExpectedRaise() {
        return projectExpectedRaise;
    }

    public void setProjectExpectedRaise(BigDecimal projectExpectedRaise) {
        this.projectExpectedRaise = projectExpectedRaise;
    }

    public BigDecimal getProjectAmountRaised() {
        return projectAmountRaised;
    }

    public void setProjectAmountRaised(BigDecimal projectAmountRaised) {
        this.projectAmountRaised = projectAmountRaised;
    }

    public BigDecimal getProjectMinInv() {
        return projectMinInv;
    }

    public void setProjectMinInv(BigDecimal projectMinInv) {
        this.projectMinInv = projectMinInv;
    }

    public double getProjectReturn() {
        return projectReturn;
    }

    public void setProjectReturn(long projectReturn) {
        this.projectReturn = projectReturn;
    }

    public LocalDate getProjectLastChange() {
        return projectLastChange;
    }

    public void setProjectLastChange(LocalDate projectLastChange) {
        this.projectLastChange = projectLastChange;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<BusinessPlan> getBusinessPlans() {
        return businessPlans;
    }

    public void setBusinessPlans(Set<BusinessPlan> businessPlans) {
        this.businessPlans = businessPlans;
    }

    @Override
    public String toString() {
        return "Classes.Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectIndustry=" + projectIndustry +
                ", projectAddress=" + projectAddress +
                ", projectDescription='" + projectDescription + '\'' +
                ", logoLink='" + logoLink + '\'' +
                ", projectDocLink='" + projectDocLink + '\'' +
                ", projectSiteLink='" + projectSiteLink + '\'' +
                ", projectExpectedRaise=" + projectExpectedRaise +
                ", projectAmountRaised=" + projectAmountRaised +
                ", projectMinInv=" + projectMinInv +
                ", projectReturn=" + projectReturn +
                ", projectLastChange=" + projectLastChange +
                ", isActive=" + isActive +
                ", businessPlans=" + businessPlans +
                '}';
    }
}
