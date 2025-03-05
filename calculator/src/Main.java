import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("종료를 원할시 exit를 입력해주세요");

        while (true) {
            int num1, num2;
            char operator;

            System.out.print("첫 번째 숫자를 입력하세요 : ");

            if (scanner.hasNextInt()) {
                num1 = scanner.nextInt();
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                } else {
                    System.out.println("정수를 입력하세요.");
                    continue;
                }
            }

            System.out.print("연산자(+,-,*,/)를 입력하세요 : ");
            String operatorInput = scanner.next();

            if (operatorInput.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            operator = operatorInput.charAt(0);

            System.out.print("두 번째 숫자를 입력하세요  : ");

            if (scanner.hasNextInt()) {
                num2 = scanner.nextInt();
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                } else {
                    System.out.println("정수를 입력하세요.");
                    continue;
                }
            }

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("현재 연산 기록: " + calculator.getHistory());

            System.out.print("첫번째 저장 값을 삭제하시겠습니까? (yes/no): ");
            String deleteInput = scanner.next();

            if (deleteInput.equalsIgnoreCase("yes")) {
                calculator.removeOldestResult(); // Calculator removeOldestResult
                System.out.println("첫번째 저장 값을 삭제하였습니다.");
            }

            //Setter 메서드 부분
            /*System.out.print("새로운 연산 기록을 설정하시겠습니까? (yes/no): ");
            String setInput = scanner.next();

            if (setInput.equalsIgnoreCase("yes")) {
                List<Integer> newHistory = Arrays.asList(10,20);
                calculator.setHistory(newHistory);
                System.out.println("새로운 연산 기록이 설정되었습니다.");
            }*/
            
            //Setter의 기능 구현은 가능 but 강제적인 기록된 결과값 변경으로 주석처리
            
        }
        System.out.println(" 최종결과 값: " + calculator.getHistory());
    }
}