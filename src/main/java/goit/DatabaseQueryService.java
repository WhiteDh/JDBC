package goit;

import goit.models.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProject() {
        List<LongestProject> projects = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                LongestProject project = new LongestProject();
                project.setClient_id(rs.getInt("CLIENT_ID"));
                project.setDuration(rs.getInt("MONTH_COUNT"));
                projects.add(project);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projects;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(rs.getString("client.NAME"));
                client.setProjectCount(rs.getInt("PROJECT_COUNT"));
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> workers = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(rs.getString("NAME"));
                worker.setSalary(rs.getInt("SALARY"));
                workers.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> workers = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                YoungestEldestWorker worker = new YoungestEldestWorker();
                worker.setName(rs.getString("NAME"));
                worker.setType(rs.getString("TYPE"));
                workers.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> prices = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = new String(Files.readAllBytes(Paths.get("sql/print_project_prices.sql")));
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ProjectPrice price = new ProjectPrice();
                price.setId(rs.getInt("NAME"));
                price.setPrice(rs.getInt("PRICE"));
                prices.add(price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prices;
    }




}


