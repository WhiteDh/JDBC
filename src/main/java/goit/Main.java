package goit;

import goit.models.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        DatabaseQueryService queryService = new DatabaseQueryService();
        RunTask runTask = new RunTask();
        runTask.task1(queryService);

        runTask.task2(queryService);
        runTask.task3(queryService);
        runTask.task4(queryService);
        runTask.task5(queryService);
        try {
            Database.getInstance().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

class RunTask{
    public void task1(DatabaseQueryService queryService){
        System.out.println("Finding the longest project:");
        List<LongestProject> longestProjects = queryService.findLongestProject();
        for (LongestProject project : longestProjects) {
            System.out.println("Project id: " + project.getClient_id() + ", Duration: " + project.getDuration() + " months");
        }
        System.out.println("******************************\n\n");

    }

    public void task2(DatabaseQueryService queryService){
        System.out.println("Finding clients with the maximum number of projects:");
        List<MaxProjectCountClient> maxProjectClients = queryService.findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectClients) {
            System.out.println("client: " + client.getName() + ", Number of projects: " + client.getProjectCount());
        }
        System.out.println("******************************\n\n");
    }

    public void task3(DatabaseQueryService queryService){
        System.out.println("Search for employees with maximum salary:");
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        for (MaxSalaryWorker worker : maxSalaryWorkers) {
            System.out.println("Worker: " + worker.getName() + ", Salary: " + worker.getSalary());
        }
        System.out.println("******************************\n\n");

    }

    public void task4(DatabaseQueryService queryService){
        System.out.println("Finding the youngest and eldest worker:");
        List<YoungestEldestWorker> workers = queryService.findYoungestEldestWorkers();
        for (YoungestEldestWorker worker : workers) {
            System.out.println("worker: " + worker.getName() + ", Age: " + worker.getType());
        }
        System.out.println("******************************\n\n");

    }

    public void task5(DatabaseQueryService queryService){
        System.out.println("Output of project costs:");
        List<ProjectPrice> projectPrices = queryService.printProjectPrices();
        for (ProjectPrice price : projectPrices) {
            System.out.println("Project id: " + price.getId() + ", Cost: " + price.getPrice());
        }
        System.out.println("******************************\n\n");

    }
}

