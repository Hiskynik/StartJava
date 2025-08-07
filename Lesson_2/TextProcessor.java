public class TextProcessor {
    public void findLongestJavaWord() {
        System.out.println(getCurrentMethodName() + 
                "() -> найти самое длинное слово в предложении из книги по Java");
    }
    
    public void countWarAndPeaceUniques() {
        System.out.println(getCurrentMethodName() + 
                "() -> подсчитать количество уникальных слов в \"Война и Мир\"");
    }
    
    public void findBookByAuthor() {
        System.out.println(getCurrentMethodName() + 
                "() -> найти книгу по имени писателя");
    }
    
    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
