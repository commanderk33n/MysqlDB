
public class main {
    public static void main(String[] args) throws Exception{
        DBConnect dao = new DBConnect();
        String hrappSQL = "CREATE DATABASE hrapp";
        dao.update(hrappSQL);

    }
}
