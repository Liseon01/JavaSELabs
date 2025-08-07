package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);
        library.printLibraryStatus();

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");
        Book bookByTitle = library.findByTitle("�ڹ��� ����");
        System.out.println("�������� �˻� ���:\n" + (bookByTitle != null ? bookByTitle : "ã�� �� ����"));
        
        System.out.println("\n���ڷ� �˻� ���:");
        for (Book book : library.findByAuthor("Robert C. Martin")) {
            System.out.println(book);
        }
    }

    private static void testCheckOut(Library library) {
        System.out.println("===== ���� ���� �׽�Ʈ =====");
        boolean success = library.checkOutBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:\n" + library.findByISBN("978-89-01-14077-4"));
        }
    }

    private static void testReturn(Library library) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        boolean success = library.returnBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:\n" + library.findByISBN("978-89-01-14077-4"));
        }
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
