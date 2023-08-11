package com.luv2code.pmo.dao;

import com.luv2code.pmo.domain.Project;
import com.luv2code.pmo.util.FileManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ProjectDaoImpl implements ProjectDao {

    @Autowired()
    @Qualifier(value = "local")
    FileManager fileManager;
    
    @Autowired()
    @Qualifier(value = "box")
    FileManager boxFileManager;

    @Override
    public Project create() {
        return null;
    }

    @Override
    public void delete(Project project) {

    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project readProjectById(String addressId) {
        return null;
    }

    @Override
    public ArrayList<Project> listAllProject() {
        ArrayList<Project> projectList = new ArrayList<>();


        return projectList;
    }

    @Override
    public List<Project> updateMasterList(Map<String, Project> masterList, Map<String, Project> fromCsv) {
        for (String id : fromCsv.keySet()) {
            if (masterList.containsKey(id)) {//record exists in masterlist, update it
                Project toModify = masterList.get(id);
                Project newP = fromCsv.get(id);
                toModify.setStatus(newP.getStatus());
                toModify.setRevision(newP.getRevision());
                toModify.setName(newP.getName());
                toModify.setStartDate(newP.getStartDate());
                toModify.setEndDate(newP.getEndDate());
                System.out.println("M: " + toModify.getId());
                masterList.put(id, toModify);
            } else {//record is not in masterlist, we add it
                Project newP = fromCsv.get(id);
                System.out.println("U: " + newP.getId());
                masterList.put(id, newP);
            }
        }
        return new ArrayList<>(masterList.values());
        //save the updated masterlist to excel file
    }

    @Override
    public Map<String, Project> getProjectListFromCsvFile() {
        ByteArrayInputStream baos = boxFileManager.readBaos("pay_terms.supplier.list(10).csv");
        HashMap<String, Project> projectsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(baos))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals("Status")) continue;
                if (values.length >= 9) {
                    Project project = new Project();
                    project.setStatus(values[0]);
                    String id = values[1];
                    project.setId(id);
                    project.setRevision(Double.valueOf(values[2]));
                    project.setName(values[3]);
                    project.setStartDate(values[5]);
                    project.setEndDate(values[6]);

                    projectsMap.put(id, project);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return projectsMap;
    }

    @Override
    public Map<String, Project> getProjectListFromMasterFile() {
        File file = fileManager.readFile("2023_07Jul_SOW-Object-Tracker-Master-List.xlsx");
        HashMap<String, Project> projectsMap = new HashMap<>();
        try {
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            for (Row currentRow : datatypeSheet) {
                if (currentRow.getCell(0).getStringCellValue().equals("Status")) {
                    continue; //we don't need the first row
                }
                String status = currentRow.getCell(0) == null ? "" : currentRow.getCell(0).getStringCellValue();
                String id = currentRow.getCell(1) == null ? "" : currentRow.getCell(1).getStringCellValue();
                Double revision = currentRow.getCell(2) == null ? 0 : currentRow.getCell(2).getNumericCellValue();
                String name = currentRow.getCell(3) == null ? "" : currentRow.getCell(3).getStringCellValue();
                String cwccr = currentRow.getCell(4) == null ? "" : currentRow.getCell(4).getStringCellValue();
                String start = sdf.format(currentRow.getCell(5).getDateCellValue());
                String end = sdf.format(currentRow.getCell(6).getDateCellValue());
                String owner = currentRow.getCell(7) == null ? "" : currentRow.getCell(7).getStringCellValue();
                String firstName = currentRow.getCell(8) == null ? "" : currentRow.getCell(8).getStringCellValue();
                String programConsultant = currentRow.getCell(9) == null ? "" : currentRow.getCell(9).getStringCellValue();
                String withActiveWorkers = currentRow.getCell(10) == null ? "" : currentRow.getCell(10).getStringCellValue();
                String acctId = currentRow.getCell(11) == null ? "" : currentRow.getCell(11).getStringCellValue();
                String dataExtract = (currentRow.getCell(12) == null ? "" : currentRow.getCell(12).getStringCellValue());
                String manualUpdate = (currentRow.getCell(13) == null ? "" : currentRow.getCell(13).getStringCellValue());

                Project project = new Project(status, id, revision, name, cwccr, start, end, owner, firstName, programConsultant, withActiveWorkers, acctId, dataExtract, manualUpdate);

                projectsMap.put(id, project);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectsMap;
    }
}
