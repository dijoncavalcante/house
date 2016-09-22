package DAO;

/**
 * Created by dijon on 14/09/2016.
 */
public class ScriptSQL {

    public static String getCreateAgenda()
    {
        StringBuilder str = new StringBuilder();
        str.append("CREATE TABLE IF NOT EXISTS CONTATO ( ");
        str.append("_id INTEGER NOT NULL ");
        str.append("                    PRIMARY KEY AUTOINCREMENT, ");
        str.append("TELEFONE            VARCHAR(14), ");
        str.append("TIPOTELEFONE        VARCHAR(1), ");
        str.append("EMAIL               VARCHAR(255), ");
        str.append("TIPOEMAIL           VARCHAR(1), ");
        str.append("ENDERECO            VARCHAR(255), ");
        str.append("TIPOENDERECO        VARCHAR(1), ");
        str.append("DATAESPECIAIS       DATE, ");
        str.append("TIPODATAESPECIAIS   DATE, ");
        str.append("GRUPOS              VARCHAR(255) ");
        str.append("); ");
        return str.toString();
    }
}
