public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
//        testshowToDoList();
//        testaddToDolIst();
//        testremoveToDoList();
//        testInput();
//        testViewShowToDoList();
//        testviewAddToDoList();
//        testviewRemoveToDoList();
          viewShowTodoList();
    }

    /**
     * Menampilkan todo List
     */
    public static void showToDoList(){
        System.out.println("To Do List");
        for (var i = 0 ; i < model.length ; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testshowToDoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi ToDoList";
        showToDoList();
    }

    /**
     * Menambahkan todo ke List
     */
    public static void addToDolIst(String todo){
//        cek apakah model penuh?
        var isFull = true;
        for (int i = 0 ; i < model.length ; i++){
            if (model[i] == null){
//                model masih ada yang kosong
                isFull = false;
                break;
            }
        }

//        jika penuh kita resize ukuran array 2x lipat
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                model[i] = temp[i];
            }
        }

//        tambahkan ke posisi yang data array = null
        for (var i = 0 ; i < model.length ; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testaddToDolIst(){
        for (int i = 0 ; i < 25 ; i++){
            addToDolIst("Contoh ToDo ke." + i);
        }
        showToDoList();

    }

    /**
     * Menghapus todo dari Lis
     */
    public static boolean removeToDoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }
        else if (model[number - 1] == null){
            return false;
        }else {
            for (int i = number - 1; i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];

                }
            }
            return true;
        }
    }

    public static void testremoveToDoList(){
        addToDolIst("ciek");
        addToDolIst("duo");
        addToDolIst("tigo");
        addToDolIst("ampek");
        addToDolIst("limo");


        var result =  removeToDoList(20);
        System.out.println(result);

        result =  removeToDoList(7);
        System.out.println(result);

        result =  removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info){
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama ");
        System.out.println("Hi " + name);

        var channel = input("Apa Kabar? ");
        System.out.println(channel);
    }

    /**
     * Menampilkan view todo List
     */
    public static void viewShowTodoList(){
        while (true){
            showToDoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if(input.equals("1")){
                viewAddToDoList();
            }else if (input.equals("2")){
                viewRemoveToDoList();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    public static void testViewShowToDoList(){
        addToDolIst("Satu");
        addToDolIst("Dua");
        addToDolIst("Tiga");
        addToDolIst("Empat");
        addToDolIst("Lima");
        viewShowTodoList();

    }

    /**
     * Menampilkan view menambahkan todo List
     */
    public static void viewAddToDoList(){
        System.out.println("Menambahkan ToDoList");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")){
//            batal
        }else {
            addToDolIst(todo);
        }
    }

    public static void testviewAddToDoList(){
        viewAddToDoList();
        showToDoList();
    }

    /**
     * Menampilkan view menghapus todo List
     */
    public static void viewRemoveToDoList(){
        System.out.println("Menghapus ToDoList");

        var number = input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")){
//            batal
        }else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus ToDoList : " + number);
            }
        }

    }

    public static void testviewRemoveToDoList(){
        addToDolIst("Satu");
        addToDolIst("Dua");
        addToDolIst("Tiga");

        showToDoList();

        viewRemoveToDoList();

        showToDoList();
    }
}
