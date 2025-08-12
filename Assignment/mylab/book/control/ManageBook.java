package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void main(String[] args) {
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.printf("%d. %s%n", i + 1, publications[i].toString());
        }
        System.out.println();

        Publication target = null;
        for (Publication p : publications) {
            if ("�ۺ������ʴ´�".equals(p.getTitle())) {
                target = p; break;
            }
        }
        if (target != null) {
            System.out.println("==== ���� ���� ====");
            System.out.println(target.getTitle() + " ���� �� ����: " + target.getPrice() + "��");
            modifyPrice(target);
            System.out.println(target.getTitle() + " ���� �� ����: " + target.getPrice() + "��");
            int diff = 15120 - target.getPrice();
            System.out.println("����: " + diff + "��");
            System.out.println();
        }

        new StatisticsAnalyzer().printStatistics(publications);
    }

    public static void modifyPrice(Publication publication) {
        int cur = publication.getPrice();
        if (publication instanceof Magazine) {
            publication.setPrice((int)(cur * 0.6));
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(cur * 0.8));
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(cur * 0.9));
        }
    }
}
