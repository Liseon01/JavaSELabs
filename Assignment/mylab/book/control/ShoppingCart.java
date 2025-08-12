package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Publication> items;

    public ShoppingCart() { this.items = new ArrayList<>(); }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication p : items) total += p.getPrice();
        return total;
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += (int)(item.getPrice() * 0.9);
            } else if (item instanceof Novel) {
                total += (int)(item.getPrice() * 0.85);
            } else if (item instanceof ReferenceBook) {
                total += (int)(item.getPrice() * 0.8);
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    public void displayCart() {
        DecimalFormat money = new DecimalFormat("#,###");
        System.out.println("====== ��ٱ��� ���� ======");
        for (int i = 0; i < items.size(); i++) {
            Publication p = items.get(i);
            System.out.printf("%d. %s - %s��%n", i + 1, p.getTitle(), money.format(p.getPrice()));
        }
        System.out.println("�� ����: " + money.format(calculateTotalPrice()) + "��");
        System.out.println("���� ���� ����: " + money.format(calculateDiscountedPrice()) + "��");
    }

    public void printStatistics() {
        int magazine = 0, novel = 0, reference = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) magazine++;
            else if (item instanceof Novel) novel++;
            else if (item instanceof ReferenceBook) reference++;
        }
        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magazine + "��");
        System.out.println("�Ҽ�: " + novel + "��");
        System.out.println("����: " + reference + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }

    public static void main(String[] args) {
        // ���� ������(ManageBook�� ����)
        Publication[] pubs = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(pubs[0]);
        cart.addItem(pubs[1]);
        cart.addItem(pubs[2]);
        cart.addItem(pubs[3]);
        cart.addItem(pubs[4]);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("���߿�");
        cart.displayCart();
    }
}
