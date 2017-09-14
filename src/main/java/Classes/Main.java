package Classes;

import Database.DAOProjectImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

/**
 * Created by guillaume on 9/14/17.
 */
public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);


        DAOProjectImpl projectDAO = new DAOProjectImpl();

        System.out.println("Creating objects...");

        Address addressKherson = new Address ("Kherson", Region.Kherson, Country.UKRAINE, 1);

        BigDecimal inv = new BigDecimal(100000);
        BigDecimal raised = new BigDecimal(10000);
        BigDecimal mininv = new BigDecimal(1000);

        Project project = new Project ("Kherson Farm", Industry.Agriculture, 1,
                "Grow stuff in Kherson","logourl", "docurl", "weburl",
                inv, raised, mininv, 20, LocalDate.parse("10/09/2017", formatter), true);

        System.out.println("Saving project to DB");

        projectDAO.create(project);

        System.out.println("is it successful?");



        /*

            public Classes.Project(String projectName, Classes.Industry projectIndustry, Classes.Address projectAddress, String projectDescription, String logoLink, String projectDocLink, String projectSiteLink, BigDecimal projectExpectedRaise, BigDecimal projectAmountRaised, BigDecimal projectMinInv, long projectReturn, LocalDate projectLastChange, boolean isActive, Set<Classes.BusinessPlan> businessPlans) {
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
        this.businessPlans = businessPlans;
    }


         */


    }

}
