import java.util.*;

public class NumberExpectationGame {
    private Player[] players;
    private int[] numbers;
    Scanner scanner = new Scanner(System.in);
    Random r = new Random();

    public NumberExpectationGame() {
        System.out.print("게임에 참여할 선수들 이름>>");
        String[] names = scanner.nextLine().split(" ");

        int count = names.length;
        players = new Player[count];
        numbers = new int[15];

        for (int i = 0; i < count; i++) {
            players[i] = new Player(names[i]);
        }
    }

    // 난수 생성 후 출력
    public void randomNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(10) + 1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public void getEnterKey() {
        System.out.print("Enter키 입력>>");
        scanner.nextLine();
    }

    // 맞춘 개수 count 후 출력
    public void countMatchNumber() {
        for (Player p : players) {
            int count = 0;
            for (int num : numbers) {
                if (num == p.getNumber())
                    count++;
            }
            p.setMatchCount(count);
            System.out.println("[" + p.getName() + "] 맞춘 개수: " + p.getMatchCount());
        }
    }

    public boolean checkWinner() {
        final int minCount = findMinCount();

        // 최소값(가장 못 맞춘 사람) 제거
        int remainCount = 0;
        for (Player p : players) {
            // 최소값과 동일한 Player가 있다면 ++
            if (p.getMatchCount() == minCount) {
                remainCount++;
            }
        }

        // 패배자(들)만의 배열 재생성
        Player[] remainPlayers = new Player[remainCount];
        int idx = 0;
        for (Player p : players) {
            if (p.getMatchCount() == minCount) {
                remainPlayers[idx++] = p;
            }
        }

        players = remainPlayers;

        System.out.print("현재 패자들 : ");
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName());
            if (i < players.length - 1) System.out.print(" ");
        }
        System.out.println("\n");

        if (players.length == 1) {
            System.out.println("최종 패자는 " + players[0].getName() + "입니다.");
            return true;
        }
        return false;
    }

    // 숫자를 제일 적게 맞춘 사람이 맞춘 숫자 갯수를 리턴하는 메소드
    private int findMinCount() {
        int min = Integer.MAX_VALUE;
        for (Player p : players) {
            if (p.getMatchCount() < min) {
                min = p.getMatchCount();
            }
        }
        return min;
    }

    public void run() {
        for (Player p : players) {
            p.selectNum();
        }

        while (true) {
            getEnterKey();
            randomNumbers();
            countMatchNumber();
            if (checkWinner()) return;
        }
    }
}
