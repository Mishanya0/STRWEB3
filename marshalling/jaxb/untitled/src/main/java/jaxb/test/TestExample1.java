package jaxb.test;

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organisation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample1 {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {
        Organisation org1 = new Organisation("Org1","IBM","USA");
        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);
        Employee emp4 = new Employee("E04","Sarah","E02");
        Employee emp5 = new Employee("E05","Nick",null);
        Employee emp6 = new Employee("E06","Sarah",null);
        Department dept = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept1 = new Department("D02","MANAGING","LOS ANGELES");
        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        List<Department> list1 = new ArrayList<Department>();
        List<Organisation> list2 = new ArrayList<Organisation>();
        list1.add(dept);
        dept.setEmployees(list);
        list.clear();
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        dept1.setEmployees(list);
        list1.add(dept1);
        list2.add(org1);
        org1.setDepartments(list1);

        try {
            JAXBContext context = JAXBContext.newInstance(Organisation.class);

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(org1, System.out);
            File outFile = new File(XML_FILE);
            m.marshal(org1, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());


            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            Organisation orgfromFIle = (Organisation) um.unmarshal(new FileReader(
                    XML_FILE));
            List<Department> emps = orgfromFIle.getDepartments();
            for (Department dep : emps) {
                System.out.println("Departments: " + dep.getDeptName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
