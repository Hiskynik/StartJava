public class Validator {
    public boolean shouldProgramContinue() {
        System.out.print(getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return true;
    }
    
    public boolean hasUniqueDigits() {
        System.out.print(getCurrentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }
    
    public boolean isLetterInput() {
        System.out.print(getCurrentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }
    
    public boolean hasEqualDigits() {
        System.out.print(getCurrentMethodName() + 
                "() -> в проверяемых числах есть равные цифры? ");
        return false;
    }
    
    public boolean hasMarioAttempts() {
        System.out.print(getCurrentMethodName() + 
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }
    
    public boolean isEmptyInput() {
        System.out.print(getCurrentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }
    
    public boolean isEvenDiceRoll() {
        System.out.print(getCurrentMethodName() + 
                "() -> на кубике выпало четное число? ");
        return true;
    }
    
    public boolean isPathValid() {
        System.out.print(getCurrentMethodName() + 
                "() -> путь до файла на ssd действительный? ");
        return false;
    }
    
    public boolean isFileExists() {
        System.out.print(getCurrentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
    
    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static void main(String[] args) {
        callTextProcessorMethods();
        callSystemManagerMethods();
        callDataCalculatorMethods();
        callValidatorMethods();
    }
    
    private static void callTextProcessorMethods() {
        TextProcessor processor = new TextProcessor();
        processor.findLongestJavaWord();
        processor.countWarAndPeaceUniques();
        processor.findBookByAuthor();
        
        System.out.println();
    }
    
    private static void callSystemManagerMethods() {
        SystemManager manager = new SystemManager();
        manager.selectMacOs MenuItem();
        manager.showErrorMessage();
        manager.resetMiVacuum();
        manager.writeToFlashDrive();
        
        System.out.println();
    }
    
    private static void callDataCalculatorMethods() {
        DataCalculator calculator = new DataCalculator();
        calculator.calculateSchoolGrades();
        calculator.syncCloudStorage();
        calculator.restoreBackupData();
        calculator.pauseAriaDownload();
        calculator.convertTemperature();
        calculator.inputMathExpression();
        calculator.determineRaceWinner();
        
        System.out.println();
    }
    
    private static void callValidatorMethods() {
        Validator validator = new Validator();
        System.out.println(validator.shouldProgramContinue());
        System.out.println(validator.hasUniqueDigits());
        System.out.println(validator.isLetterInput());
        System.out.println(validator.hasEqualDigits());
        System.out.println(validator.hasMarioAttempts());
        System.out.println(validator.isEmptyInput());
        System.out.println(validator.isEvenDiceRoll());
        System.out.println(validator.isPathValid());
        System.out.println(validator.isFileExists());
    }
}