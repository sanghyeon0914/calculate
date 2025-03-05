import java.util.ArrayList;
import java.util.List;

class Calculator {
    private List<Integer> history; // 연산 결과를 저장하는 리스트

    public Calculator() {
        this.history = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        history.add(result); // 연산 결과 저장
        return result;
    }

    // Getter 메서드 (연산 기록을 가져오는 기능)
    public List<Integer> getHistory() {
        return new ArrayList<>(history); // 원본 리스트의 복사본 반환 (불변 리스트가 아님)
    }

    // Setter 메서드 (연산 기록을 외부에서 수정할 수 있도록 허용)
    public void setHistory(List<Integer> newHistory) {
        if (newHistory == null) {
            throw new IllegalArgumentException("연산 기록은 null이 될 수 없습니다.");
        }
        this.history = new ArrayList<>(newHistory); // 새로운 리스트로 변경
    }

    public void removeOldestResult() {
        if (!history.isEmpty()) {
            history.remove(0); // 리스트의 첫 번째 요소 삭제
        } else {
            System.out.println("연산 기록이 비어있어 삭제할 수 없습니다.");
        }
    }
}
