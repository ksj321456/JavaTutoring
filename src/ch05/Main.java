package ch05;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("그래픽 에디더 Beauty Graphic Editor를 실행합니다.");

        Scanner scanner = new Scanner(System.in);

        Shape[] shapes = new Shape[9999];
        int cnt = 0;

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            int input = scanner.nextInt();

            if (input == 1) {
                System.out.print("Line(1), Rect(2), Circle(3) >> ");
                int x = scanner.nextInt();

                if (x == 1) {
                    shapes[cnt] = new Line();
                    cnt++;
                }
                else if (x == 2) {
                    shapes[cnt] = new Rect();
                    cnt++;
                }
                else if (x == 3) {
                    shapes[cnt] = new Circle();
                    cnt++;
                }
            }

            else if (input == 2) {
                System.out.print("삭제할 도형의 위치 >> ");
                int index = scanner.nextInt();
                if (shapes[index] == null) {
                    System.out.println("삭제할 수 없습니다.");
                }
                else {
                    shapes[index] = null;
                }
            }

            else if (input == 3) {
                for (int i = 0; i < shapes.length; i++) {
                    if (shapes[i] != null) {
                        shapes[i].draw();
                    }
                }
            }

            else if (input == 4) {
                scanner.close();
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                //
            }
        }
    }
}
