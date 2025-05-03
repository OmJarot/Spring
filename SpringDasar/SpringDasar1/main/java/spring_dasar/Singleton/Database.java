package spring_dasar.Singleton;

public class Database {
    //singleton
    //sebanyak apapun object dibuat akan mengembalikan object yang sama

    private static Database database;

    public static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

    //membuat private agar tidak bisa membuat object
    //memaksa membuat object menggunakan static method
    private Database(){

    }
}
