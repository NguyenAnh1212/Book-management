public class Main {
    public static void main(String[] args) {
        FictionBook b1 = new FictionBook("F1","Ngày tận thế", 20, "Hải Lão", "Cat1");
        FictionBook b2 = new FictionBook("F2","Bất tử", 45, "Taylor", "Cat2");
        FictionBook b3 = new FictionBook("F3","Xuyên không", 55, "Nguyệt Bích", "Cat3");
        ProgrammingBook b4 = new ProgrammingBook("P1","Java basic",120,"Admit","Java","Hibernate");
        ProgrammingBook b5 = new ProgrammingBook("P2","PHP basic",120,"Jonh","PHP","Zend");
        Book[] books = {b1,b2,b3,b4,b5};
        System.out.println(books[0] instanceof ProgrammingBook);
        // tính tổng tiền tất cả sách đang có
        int sum = 0;
        for (Book b: books
             ) {
            sum += b.getPrice();
        }
        System.out.println(sum);
    }
}
