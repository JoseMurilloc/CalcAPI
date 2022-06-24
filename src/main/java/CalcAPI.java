import Servers.DAO.IAdvanceOperations;
import Servers.DAO.IBasicOperations;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static spark.Spark.*;

public class CalcAPI {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        port(8001);

        String addressServerBasic = "rmi://localhost:3333";
        var basic = (IBasicOperations) Naming.lookup(addressServerBasic + "/ServerBasic");


        String addressServerAdvance = "rmi://localhost:3000";
        var advance = (IAdvanceOperations) Naming.lookup(addressServerAdvance + "/ServerAdvance");


        get("/hello", (req, res) -> "Hello World!");

        post("/sum", (req, res) -> {
            try{

                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = basic.sum(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/subtraction", (req, res) -> {
            try{

                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = basic.subtraction(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/multiplication", (req, res) -> {
            try{

                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = basic.multiplication(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/division", (req, res) -> {
            try{

                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = basic.division(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/potency", (req, res) -> {
            try{
                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = advance.potency(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/sqrt", (req, res) -> {
            try{
                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var number = (long) jsonObject.get("number");
                return advance.sqrt(number);
            }catch (Exception e){
                return e.getMessage();
            }
        });

        post("/percentage", (req, res) -> {
            try{
                String body = req.body();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(body);

                var numberOne = (long) jsonObject.get("numberOne");
                var numberTwo = (long) jsonObject.get("numberTwo");

                var total = advance.percentage(numberOne, numberTwo);

                return total;
            }catch (Exception e){
                return e.getMessage();
            }
        });

        System.out.println("API LOADING...");
    }
}