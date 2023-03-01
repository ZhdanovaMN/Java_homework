public class task_hw2 {
    public static void main(String[] args) {
        makeSentence("Добрый день Как дела Все хорошо");
    }
    static void makeSentence(String text) {
        System.out.printf("Дано: \n%s\n", text);
        text = text.replaceAll("\\s{1,}([А-ЯЁ])", ". $1");
        char point = '.';
        if (text.charAt(text.length() - 1) != point) {
            text += point;
        }
        System.out.printf("Получилось: \n%s", text);
    }
}
