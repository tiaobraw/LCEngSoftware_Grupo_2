package sistema;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
 
public class Import_Excel {
 
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "Bulb@2021";
 
        String excelFilePath = "Produto.xlsx";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO produto (descricao, saldo, preco) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
             
            int count = 0;
             
            rowIterator.next(); // pular a primeira linha da planilha
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String descricao = nextCell.getStringCellValue();
                        statement.setString(1, descricao);
                        break;
                    case 1:
                    	int saldo = (int) nextCell.getNumericCellValue();
                        statement.setInt(3, saldo);
                    case 2:
                    	Double preco = nextCell.getNumericCellValue();
                        statement.setDouble(2, preco);
                    }
                }
                 
                statement.addBatch();
                 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
            }
 
            workbook.close();
            
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Importação concluída em %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error ao ler arquivo excel");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
    }
}