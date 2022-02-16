import java.lang.module.FindException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FictionBook b1 = new FictionBook("F1","Ngày tận thế", 20, "Hải Lão", "viễn tưởng 1");
        FictionBook b2 = new FictionBook("F2","Bất tử", 45, "Taylor", "viễn tưởng 1");
        FictionBook b3 = new FictionBook("F3","Xuyên không", 55, "Nguyệt Bích", "Cat3");
        ProgrammingBook b4 = new ProgrammingBook("P1","Java basic",120,"Admit","Java","Hibernate");
        ProgrammingBook b5 = new ProgrammingBook("P2","PHP basic",120,"Jonh","PHP","Zend");
        Book[] books = {b1,b2,b3,b4,b5};

        // gọi các hàm thực hiện các yêu cầu mong muốn.
        // tính tổng tiền
        System.out.print("Sum Price: ");
        int sumprice = getSumPrice(books);
        System.out.println(sumprice *1000 +" VND");
        //Đếm số sách có language là java
        System.out.println("How many Programming Book in laguage Java are there? ");
        int countJava = countBookByLanguage(books,"Java");
        System.out.println(countJava + " unit");
        // Đếm sách Fic có category là Viễn tưởng 1
        System.out.println("How many Fiction Book in category 'viễn tưởng 1' are there? ");
        int countCategory = countBookByCategory(books,"viễn tưởng 1");
        System.out.println(countCategory + " unit");
        //Đếm số sách Fiction có giá dưới 100
        System.out.println("Số sách Fiction có giá dưới 100k: ");
        int countByPrice = countFictionByprice(books);
        System.out.println(countByPrice);
        // tìm giá theo sách
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuốn sách bạn muốn tìm là: ");
        String inputName = scanner.nextLine();
        findPriceByName(books,inputName);



    }
    //Tạo các hàm thực hiện yêu cầu
    //System.out.println(books[0] instanceof ProgrammingBook); kiểm tra book có thuộc programming hay không.
    // tính tổng tiền tất cả sách đang có
    public static int getSumPrice(Book[] books){
        int sum = 0;
        for (Book b: books
        ) {
            sum += b.getPrice();
        }
       return sum;
    }

    // Tìm và đếm sách Programming có language theo tùy ý java hoặc php.
    public static int countBookByLanguage(Book[] books, String inputLanguage){
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof ProgrammingBook){
                String language = ((ProgrammingBook) books[i]).getLanguage();
                if (language.equals(inputLanguage)){
                    count ++;
                }
            }
        }
        return count;
    }
    // Đếm sách fiction có category là " viễn tưởng 1"
    public static int countBookByCategory(Book[] books, String inputCategory){
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof FictionBook){
                String category = ((FictionBook) books[i]).getCategory();
                if (category.equals(inputCategory)){
                    count ++;
                }
            }
        }
        return count;
    }
    // Đếm số sách Fiction có giá dưới 100
    public static int countFictionByprice(Book[] books){
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof FictionBook){
                int Price = books[i].getPrice();
                if (Price < 100){
                    count ++;
                }
            }
        }
        return count;
    }
    // Tìm giá của cuốn sách có tên được nhập vào từ bàn phím.
    public static int findPriceByName(Book[] books,String inputName){
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            String nameBook = books[i].getName();
            if (nameBook.equals(inputName)){
               index = i;
            }
        }
        if (index != -1){
            int price = books[index].getPrice();
            System.out.println("Sách " + inputName + " có giá " + price*1000 +" VND");
        }else{
            System.out.println("Not found");
        }
        return index;
    }

}
