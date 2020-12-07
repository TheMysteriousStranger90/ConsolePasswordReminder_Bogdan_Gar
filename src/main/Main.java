package main;

import bean.Record;
import dao.RecordDAO;
import iostream.Serialize_DeserializeRecord;
import service.AskService;

import java.util.ArrayList;
import java.util.Date;

import static constant.ConstantsQuestions.*;

public class Main {

    public static String enter;
    static ArrayList<Record> arrPR = new ArrayList();

    public static void main(String[] args) {

        while (true) {

            enter = AskService.questionFirst();

            switch (enter) {
                case "Д":
                    String adr1 = AskService.questionAddress();
                    String lgn1 = AskService.questionLogin();
                    String ps1 = AskService.questionPassword_1();
                    Record r = new Record(adr1, lgn1, ps1, new Date());
                    RecordDAO.add(r);
                    arrPR.add(r);
                    Serialize_DeserializeRecord.writeRecord(arrPR);
                    break;
                case "П":
                    AskService.questionAboutRead();
                    break;
                case "В":
                    System.exit(0);
                default:
                    System.out.println(ERR_MSG);
                    break;
            }
        }
    }
}
