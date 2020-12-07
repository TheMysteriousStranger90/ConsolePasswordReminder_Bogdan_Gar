package service;

import constant.ConstantsQuestions;
import dao.RecordDAO;
import iostream.Serialize_DeserializeRecord;
import random.RandomService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static constant.ConstantsQuestions.*;

public class AskService {
    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static String questionFirst() {
        System.out.println(ConstantsQuestions.Q_RU0);
        System.out.println(ConstantsQuestions.Q_RU1);
        return getScanner().nextLine();
    }

    public static String questionAddress() {
        System.out.println(ConstantsQuestions.Q_RU2);
        return getScanner().nextLine();
    }

    public static String questionLogin() {
        System.out.println(ConstantsQuestions.Q_RU3);
        return getScanner().nextLine();
    }

    public static String questionPassword_1() {
        System.out.println(ConstantsQuestions.Q_RU4);
        String tmp = getScanner().nextLine();
        if ("С".equalsIgnoreCase(tmp)) {
            System.out.println(ConstantsQuestions.Q_RU4_1);
        } else if ("Р".equalsIgnoreCase(tmp)) {
            System.out.println(ConstantsQuestions.Q_RU4_2);
            int quantity = new Scanner(System.in).nextInt();
            StringBuffer sb = new StringBuffer(quantity);
            for (int i = 0; i < quantity; i ++) {
               sb.append(RandomService.getRandomSymbol());
            }
            String s = new String(sb);
            return s;
        } else {
            System.out.println(ERR_MSG);
            System.exit(0);
        }
        return getScanner().nextLine();
    }

    public static void questionAboutRead() {
        System.out.println(ConstantsQuestions.Q_RU4_3);
        String tmp = getScanner().nextLine();
        if ("Б".equalsIgnoreCase(tmp)) {
            RecordDAO.printResultRecord();
        } else if ("Ф".equalsIgnoreCase(tmp)) {
            Serialize_DeserializeRecord.readRecord();
        } else {
            System.out.println(ERR_MSG);
            System.exit(0);
        }
    }
}